package com.example.liz.huaweiapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.liz.huaweiapp.Entity.Test;
import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;

public class MainActivity extends AppCompatActivity {

    Button btnSig ;
    EditText et_dato;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Oblica y carga un icono a lado del nombre de la app en el activity principal
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_myicon);

        btnSig=(Button)findViewById(R.id.buttonSigEdad);
        et_dato=(EditText)findViewById(R.id.et_dato);
        btnSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //Toast.makeText(MainActivity.this, "Desde Coidgo",Toast.LENGTH_LONG).show();
            String texto=et_dato.getText().toString();
            if(texto!=null && !texto.isEmpty()){
                Intent inte = new Intent(MainActivity.this,SegundoActivity.class);
                inte.putExtra("msjKey",texto);
                startActivity(inte);
            }else{
                Toast.makeText(MainActivity.this,"Porvafor ingrese texto",Toast.LENGTH_SHORT).show();
            }
            }
        });
    }
}
