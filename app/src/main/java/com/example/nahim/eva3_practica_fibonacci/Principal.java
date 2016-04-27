package com.example.nahim.eva3_practica_fibonacci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity implements View.OnClickListener {
    EditText edtTxValor1, edtTxValor2;
    TextView txtSumatoria;
    Button btnLanzar;
    int valor1, valor2;
    Bundle bnValores; //AQUI SE VAN A GUARDAR LOS VALORES INICIALES
    Intent inDatos;
    public static final int REQUEST_CODE=10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        edtTxValor1 = (EditText) findViewById(R.id.edtTxValor1);
        edtTxValor2 = (EditText) findViewById(R.id.edtTxValor2);
        btnLanzar = (Button) findViewById(R.id.btnLanzar);
        btnLanzar.setOnClickListener(this);
        txtSumatoria = (TextView) findViewById(R.id.txtSumatoria);


    }

    @Override
    public void onClick(View v) {
       valor1 = Integer.parseInt(edtTxValor1.getText().toString());
       valor2 = Integer.parseInt(edtTxValor2.getText().toString());
        inDatos = new Intent(this,Secundaria.class);
        bnValores = new Bundle();
        bnValores.putInt("Valor1",valor1);
        bnValores.putInt("Valor2",valor2);
        inDatos.putExtras(bnValores);
        startActivityForResult(inDatos,REQUEST_CODE);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       super.onActivityResult(requestCode, resultCode, data);
      if (resultCode == RESULT_OK && requestCode == REQUEST_CODE){
        int dato = data.getIntExtra("Resultado",0);
           txtSumatoria.setText(""+dato);

            }
        }
   }

