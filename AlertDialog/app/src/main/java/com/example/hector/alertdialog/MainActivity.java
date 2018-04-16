package com.example.hector.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btnAlert);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog("aaa","dddd");
            }
        });

    }

    private void showAlertDialog(String title, String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        if(title!= null)builder.setTitle(title);
        if(message!= null)builder.setMessage(message);

        View viewInflated = LayoutInflater.from(this).inflate(R.layout.first_alert_dialog,null);
        builder.setView(viewInflated);

        final EditText input =(EditText)viewInflated.findViewById(R.id.etAlerte);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String dato = input.getText().toString().trim();
                if(dato.length()>0){
                    Toast.makeText(MainActivity.this,"Correcto",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Incorrecto",Toast.LENGTH_SHORT).show();
                }
            }
        });

        AlertDialog dialog =builder.create();
        dialog.show();
    }
}
