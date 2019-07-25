package com.edu.senac.ferramentas;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class CadastroActivity extends AppCompatActivity {
ImageView imagem;
Spinner spinnerTempo;
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;  // Declare this integer globally

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        imagem=findViewById(R.id.imvFoto);
        spinnerTempo=findViewById(R.id.spinnerTempo);



        spinnerTempo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        String selecaoTempo = String.valueOf(spinnerTempo.getSelectedItem());

    }

    public  void cancelar(View v){

    }
    public  void salvarTrilheiro(View v){

    }

    public void capturarFoto(View v) {

        if (checkAndRequestPermissions()) {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, 100);
        }

        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imagem.setImageBitmap(imageBitmap);
        }
    }

    private boolean permissions(List<String> listPermissionsNeeded) {

        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray
                    (new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }
    public boolean checkAndRequestPermissions() {

        int camera = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA);
            List<String> listPermissionsNeeded = new ArrayList<>();

        if (camera != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.CAMERA);
        }


        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray
                    (new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }




}
