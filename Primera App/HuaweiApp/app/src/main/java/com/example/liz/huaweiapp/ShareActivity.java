package com.example.liz.huaweiapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class ShareActivity extends AppCompatActivity {

    ImageButton ibShare,ibOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        //Activa flecha ir atras(activity principal)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ibShare=(ImageButton)findViewById(R.id.imageButtonShare);
        ibOk=(ImageButton)findViewById(R.id.imageButtonOk);

        ibShare.setVisibility(View.INVISIBLE);
        final Bundle bundle= getIntent().getExtras();
        if(bundle!=null){
            Toast.makeText(ShareActivity.this,bundle.getString("edad"),Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(ShareActivity.this,"",Toast.LENGTH_SHORT).show();
        }
        ibOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bundle.getString("accion").equals("Saludo")){
                    Toast.makeText(ShareActivity.this,"Hola "+bundle.getString("nombre")+", ¿Como llevas esos "+bundle.getString("edad")+" años? #MyForm",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ShareActivity.this,"Espero verte pronto "+bundle.getString("nombre")+", antes que cumplas mas de"+bundle.getString("edad")+". #MyForm",Toast.LENGTH_SHORT).show();
                }
                ibShare.setVisibility(View.VISIBLE);
                ibOk.setVisibility(View.INVISIBLE);
            }
        });
        ibShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent Implicito
                Intent intent= new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,""+(bundle.getString("nombre"))+" "+(bundle.getString("edad"))+" "+(bundle.getString("accion")));
                startActivity(intent);
            }
        });
    }
}
