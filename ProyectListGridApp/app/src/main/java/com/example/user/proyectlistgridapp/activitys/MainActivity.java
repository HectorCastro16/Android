package com.example.user.proyectlistgridapp.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.proyectlistgridapp.R;
import com.example.user.proyectlistgridapp.adapters.MyAdapterList;
import com.example.user.proyectlistgridapp.models.Fruta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gridFrutas;
    ListView listFrutas;
    List<Fruta> frutas;
    MyAdapterList myAdapter;
    MenuItem vistaList,vistaGrid;
    Menu menuBar;

    int cuentaNuevos=0;
    /*MenuItem mList;
    MenuItem mGrid;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFrutas = (ListView) findViewById(R.id.lvFrutas);
        gridFrutas=(GridView) findViewById(R.id.gvFrutas);
        frutas = new ArrayList<Fruta>();
        Fruta f1 = new Fruta();
        f1.setId(1);
        f1.setNombre("Manzana");
        f1.setCiudad("New York");
        f1.setImage(R.mipmap.ic_manzana);
        frutas.add(f1);
        Fruta f2 = new Fruta();
        f2.setId(2);
        f2.setNombre("Pera");
        f2.setCiudad("Tumbes");
        f2.setImage(R.mipmap.ic_pera);
        frutas.add(f2);
        Fruta f3 = new Fruta();
        f3.setId(3);
        f3.setNombre("Uva");
        f3.setCiudad("Ica");
        f3.setImage(R.mipmap.ic_uva);
        frutas.add(f3);

        listFrutas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {
                Toast.makeText(MainActivity.this, "Selecccionado: " + (frutas.get(posicion)).getNombre() + " ID: " + (frutas.get(posicion)).getId(), Toast.LENGTH_SHORT).show();
            }
        });
        gridFrutas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {
                Toast.makeText(MainActivity.this, "Selecccionado: " + (frutas.get(posicion)).getNombre() + " ID: " + (frutas.get(posicion)).getId(), Toast.LENGTH_SHORT).show();
            }
        });

        cargaListGrid();

        registerForContextMenu(listFrutas);
        registerForContextMenu(gridFrutas);
    }

    //Para Action Bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menuBar=menu;
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        MenuItem mList=menuBar.findItem(R.id.action_vista_list);
        MenuItem mGrid=menuBar.findItem(R.id.action_vista_grid);
        switch (item.getItemId()) {
            case R.id.action_add_item:
                try {
                    cuentaNuevos++;
                    Fruta f= new Fruta();
                    f.setId(frutas.size()+1);
                    f.setNombre("Fruta "+cuentaNuevos);
                    f.setCiudad("New");
                    f.setImage(R.mipmap.ic_new_fruit);
                    frutas.add(f);
                    this.myAdapter.notifyDataSetChanged();
                    //cargaListGrid();
                    //Toast.makeText(MainActivity.this,"Se agrego Correctamente",Toast.LENGTH_SHORT).show();
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case R.id.action_vista_list:
                mList.setVisible(false);
                mGrid.setVisible(true);
                gridFrutas.setVisibility(View.INVISIBLE);
                listFrutas.setVisibility(View.VISIBLE);
                return true;
            case R.id.action_vista_grid:
                mGrid.setVisible(false);
                mList.setVisible(true);
                listFrutas.setVisibility(View.INVISIBLE);
                gridFrutas.setVisibility(View.VISIBLE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //Para menu contextual
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();

        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)menuInfo;
        menu.setHeaderTitle(frutas.get(info.position).getNombre());
        menuInflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.cm_action_delete:
                frutas.remove(info.position);
                myAdapter.notifyDataSetChanged();
                cargaListGrid();
                return true;
            case R.id.cm_action_extra:
                Intent intent = new Intent(MainActivity.this,ExtraActivity.class);
                intent.putExtra("frutas",(Serializable) frutas);
                startActivity(intent);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void cargaListGrid(){
        myAdapter = new MyAdapterList(MainActivity.this, R.layout.list_item, frutas);
        listFrutas.setAdapter(myAdapter);

        myAdapter = new MyAdapterList(MainActivity.this, R.layout.grid_item, frutas);
        gridFrutas.setAdapter(myAdapter);
    }
}
