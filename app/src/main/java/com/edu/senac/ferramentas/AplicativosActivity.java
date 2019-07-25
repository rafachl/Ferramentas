package com.edu.senac.ferramentas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AplicativosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplicativos);
    }

    public void calculoImc(View v){
            startActivity(new Intent(this,ImcActivity.class));
    }
}
