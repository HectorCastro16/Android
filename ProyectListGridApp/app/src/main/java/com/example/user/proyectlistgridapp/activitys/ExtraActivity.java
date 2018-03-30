package com.example.user.proyectlistgridapp.activitys;

import android.support.v7.app.AppCompatActivity;
import com.example.user.proyectlistgridapp.R;
import com.example.user.proyectlistgridapp.models.Fruta;

import android.os.Bundle;
import android.widget.Toast;
import java.io.Serializable;
import java.util.List;

public class ExtraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null ){
            List<Fruta> list = ( List<Fruta>)bundle.get("frutas");
            Toast.makeText(ExtraActivity.this,"Existen "+list.size()+" Elementos",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(ExtraActivity.this,"ERRORRR",Toast.LENGTH_LONG);
        }
    }
}
