package com.example.nahim.eva3_practica_fibonacci;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Secundaria extends AppCompatActivity {
    TextView mostrarSerie;
    Button btnDetener;
    int valorresultado = 0, valor1, valor2, sumatoria, valorinicial, vfinal;
    MiClaseSumatoria objSumatoria = new MiClaseSumatoria();


    public void clickDetener(View view) {
        objSumatoria.cancel(true);
        vfinal = valorinicial + sumatoria;
        Intent iresultado = new Intent();
        iresultado.putExtra("Resultado", vfinal);
        setResult(RESULT_OK, iresultado);
        objSumatoria.cancel(true);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);

        mostrarSerie = (TextView) findViewById(R.id.mostrarSerie);
        btnDetener = (Button) findViewById(R.id.btnDetener);

        //leer los datos del bundle
        Bundle bDatos = getIntent().getExtras();
        if (bDatos != null) {
            valor1 = bDatos.getInt("Valor1");
            valor2 = bDatos.getInt("Valor2");
            mostrarSerie.setText(" " + valor1);
            mostrarSerie.append(" " + valor2);
            valorinicial = valor1 + valor2;
           objSumatoria.execute(1000);
        }

    }

    class MiClaseSumatoria extends AsyncTask<Integer, Integer, Void> {
        @Override
        protected Void doInBackground(Integer... params) {
            int iDemora = params[0];

            while (true) {
                try {
                    valorresultado = valor1 + valor2;
                    valor1 = valor2;
                    valor2 = valorresultado;
                    sumatoria = sumatoria + valorresultado;
                    publishProgress(valorresultado);
                    Thread.sleep(iDemora);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            mostrarSerie.append(" " + values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
