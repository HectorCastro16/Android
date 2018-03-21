package com.example.liz.huaweiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class SegundoActivity extends AppCompatActivity {

    TextView textview ;
    Button btnSeg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        //Activa flecha ir atras(activity principal)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textview=(TextView)findViewById(R.id.textViewSegundo);
        btnSeg=(Button)findViewById(R.id.buttonSeg);
        Bundle bundle= getIntent().getExtras();
        if(bundle!=null){
            String msj = bundle.getString("msjKey");
            textview.setText(msj);
        }else{
            Toast.makeText(SegundoActivity.this,"Error: NULL",Toast.LENGTH_LONG).show();
        }

        btnSeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(SegundoActivity.this,TerceroActivity.class);
                startActivity(intent);
            }
        });
    }
}
