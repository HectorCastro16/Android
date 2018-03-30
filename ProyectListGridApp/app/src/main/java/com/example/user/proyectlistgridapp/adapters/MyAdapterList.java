package com.example.user.proyectlistgridapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.proyectlistgridapp.R;
import com.example.user.proyectlistgridapp.models.Fruta;

import java.util.List;

/**
 * Created by USER on 26/03/2018.
 */

public class MyAdapterList extends BaseAdapter {

    Context context;
    int layout;
    List<Fruta> frutas;

    public MyAdapterList(Context context, int layout, List<Fruta> frutas){
        this.context=context;
        this.layout=layout;
        this.frutas=frutas;
    }

    @Override
    public int getCount() {
        return frutas.size();
    }

    @Override
    public Object getItem(int position) {return frutas.get(position);}

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder holder;
        if(convertView==null){
            LayoutInflater layoutInflater= LayoutInflater.from(this.context);
            convertView=layoutInflater.inflate(this.layout,null);
            holder= new ViewHolder();
            holder.nombre_tv=(TextView)convertView.findViewById(R.id.tvNombreFruta);
            holder.ciudad_tv=(TextView)convertView.findViewById(R.id.tvCiudadFruta);
            holder.image_iv=(ImageView) convertView.findViewById(R.id.ivFruta);
            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();
        }
        Fruta currentFruta=frutas.get(position);
        holder.nombre_tv.setText(currentFruta.getNombre());
        holder.ciudad_tv.setText(currentFruta.getCiudad());
        holder.image_iv.setImageResource(currentFruta.getImage());
        return convertView;
    }

    static class ViewHolder{
        private TextView nombre_tv;
        private TextView ciudad_tv;
        private ImageView image_iv;
    }
}
