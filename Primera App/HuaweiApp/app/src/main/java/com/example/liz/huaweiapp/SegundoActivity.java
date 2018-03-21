package com.example.liz.huaweiapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class SegundoActivity extends AppCompatActivity {

    TextView textview,tvEdad ;
    Button btnSeg;
    SeekBar sbEdad;
    RadioButton rbSaludo,rbResult;
    RadioGroup rgAccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        //Activa flecha ir atras(activity principal)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textview=(TextView)findViewById(R.id.textViewSegundo);
        btnSeg=(Button)findViewById(R.id.buttonSeg);
        sbEdad=(SeekBar)findViewById(R.id.seekBarEdad);
        tvEdad=(TextView)findViewById(R.id.textViewEdad);
        rgAccion=(RadioGroup)findViewById(R.id.radioGroupAccion);

        //rbSaludo.setChecked(true);
        sbEdad.setMax(80);

        final Bundle bundle= getIntent().getExtras();
        if(bundle!=null){
            String msj = bundle.getString("msjKey");
            textview.setText(msj);
        }else{
            Toast.makeText(SegundoActivity.this,"Error: NULL",Toast.LENGTH_LONG).show();
        }

        btnSeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent =new Intent(SegundoActivity.this,TerceroActivity.class);
                startActivity(intent);*/
                Intent intent = new Intent(SegundoActivity.this,ShareActivity.class);
                intent.putExtra("nombre",bundle.getString("msjKey"));
                intent.putExtra("edad",tvEdad.getText().toString());
                int rbId=rgAccion.getCheckedRadioButtonId();
                rbResult=findViewById(rbId);
                intent.putExtra("accion",rbResult.getText().toString());
                startActivity(intent);
            }
        });

        sbEdad.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar sbEdad, int progress, boolean fromUser) {
                tvEdad.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar sbEdad) {
                if(sbEdad.getProgress()<16 || sbEdad.getProgress()>60){
                    btnSeg.setVisibility(View.INVISIBLE);
                    Toast.makeText(SegundoActivity.this,"Edad no valida!",Toast.LENGTH_SHORT).show();
                }else {
                    btnSeg.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
