package com.example.user.recyclerview.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.user.recyclerview.R;

import java.util.List;

/**
 * Created by USER on 30/03/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> names;
    private int layout;
    private onItemClickListener itemClickListener;

    public MyAdapter(List<String> names,int layout,onItemClickListener itemClickListener){
        this.names=names;
        this.layout=layout;
        this.itemClickListener=itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(names.get(position),itemClickListener);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewName;

        public ViewHolder(View itemView){
            super(itemView);
            this.textViewName=(TextView) itemView.findViewById(R.id.tvRecyclerView);
        }

        public void bind(final String name , final onItemClickListener listener){
            this.textViewName.setText(name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(name,getAdapterPosition());
                }
            });
        }
    }

    public interface onItemClickListener{
        void onItemClick(String name,int position);
    }

}
