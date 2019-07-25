package com.edu.senac.ferramentas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ImcActivity extends AppCompatActivity {

    EditText edtPeso,edtAltura;
    TextView txtResusltado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        edtPeso=findViewById(R.id.edtPeso);
        edtAltura=findViewById(R.id.edtAltura);

        txtResusltado=findViewById(R.id.textResultado);

    }


    public void calcular(View v){
        Float altura=Float.parseFloat(edtAltura.getText().toString());
        Float peso=Float.parseFloat(edtPeso.getText().toString());


       Float resultado=peso/(float)Math.pow(altura,2);
       String apresentacao="";

       if(resultado<18.5){
           apresentacao="Abaixo do peso";
       }else if(resultado>18.5 && resultado<=24.9){
           apresentacao="Normal";

       }else if(resultado>25 && resultado<30){
           apresentacao="Acima do peso";

       }else{
           apresentacao="Obesidade";
       }

       txtResusltado.setText(apresentacao);



    }
}
