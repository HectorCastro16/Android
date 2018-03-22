package com.example.liz.huaweiapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class TerceroActivity extends AppCompatActivity {

    EditText etPhone,etUrl;
    ImageButton btnPhone,btnUrl,btnCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercero);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etPhone=(EditText)findViewById(R.id.editTextPhone);
        etUrl=(EditText)findViewById(R.id.editTextBuscador);
        btnPhone=(ImageButton)findViewById(R.id.imageButtonPhone);
        btnUrl=(ImageButton)findViewById(R.id.imageButtonUrl);
        btnCamera=(ImageButton)findViewById(R.id.imageButtonCamera);

        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numPhone =etPhone.getText().toString();
                if(numPhone!=null && !numPhone.isEmpty()){
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+numPhone));
                    startActivity(intent);
                }else{
                    Toast.makeText(TerceroActivity.this,"Porfavor Ingrese Phone", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = etUrl.getText().toString();
                if(url!=null && !url.isEmpty()){
                    Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+url));

                    //contactos
                    Intent inteContactos = new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people"));
                    //Email rapido
                    Intent inteEmail = new Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:hectorcs464@gmail.com"));
                    //Email completo
                    Intent intentMail = new Intent(Intent.ACTION_SEND,Uri.parse("asdgdsgsd@gmail.com"));
                    intentMail.setType("plain/text");
                    intentMail.putExtra(Intent.EXTRA_SUBJECT,"Titulo De Mi Email");
                    intentMail.putExtra(Intent.EXTRA_TEXT,"Este es el mensaje de email");
                    intentMail.putExtra(Intent.EXTRA_EMAIL,new String[]{"rhfhfd@gmail.com","sdggwetg@outlook.com"});
                    startActivity(Intent.createChooser(intentMail,"Eleige cliente de correo"));
                    //startActivity(intentMail);}
                }else{
                    Toast.makeText(TerceroActivity.this,"Ingrese Url",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCamera = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intentCamera);
            }
        });
    }
}
