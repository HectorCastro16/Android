package com.example.liz.listviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView list;
    List<String> names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=(ListView)findViewById(R.id.listviewNames);

        names=new ArrayList<String>();
        names.add("Pedro");
        names.add("Manuel");
        names.add("Felipe");
        names.add("Santos");
        names.add("Juan");
        names.add("Pepe");
        names.add("Jose");
        names.add("Manuel");
        names.add("Sergio");
        names.add("Tomas");
        names.add("Jhoel");
        names.add("Santos");
        names.add("Juan");
        names.add("Pepe");
        names.add("Jose");
        names.add("Manuel");
        names.add("Sergio");

        //ArrayAdapter<String> adapter= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,names);
        //list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {
                Toast.makeText(MainActivity.this,"Seleccionado: "+names.get(posicion),Toast.LENGTH_SHORT).show();
            }
        });

        MyAdapter myAdapter = new MyAdapter(MainActivity.this,R.layout.list_item,names);
        list.setAdapter(myAdapter);
    }
}

