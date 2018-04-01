package com.example.user.recyclerview.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.recyclerview.Models.Movie;
import com.example.user.recyclerview.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by USER on 30/03/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Movie> movies;
    private int layout;
    private onItemClickListener itemClickListener;

    private Context context;

    public MyAdapter(List<Movie> movies,int layout,onItemClickListener itemClickListener){
        this.movies=movies;
        this.layout=layout;
        this.itemClickListener=itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        context=parent.getContext();
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(movies.get(position),itemClickListener);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewName;
        public ImageView imageViewPoster;

        public ViewHolder(View itemView){
            super(itemView);
            textViewName=(TextView) itemView.findViewById(R.id.tvName);
            imageViewPoster=(ImageView)itemView.findViewById(R.id.ivPoster);
        }

        public void bind(final Movie movie , final onItemClickListener listener){
            //this.textViewName.setText(name);

            textViewName.setText(movie.getName());
            Picasso.with(context).load(movie.getPoster()).fit().into(imageViewPoster);
            //imageViewPoster.setImageResource(movie.getPoster());


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(movie,getAdapterPosition());
                }
            });
        }
    }

    public interface onItemClickListener{
        void onItemClick(Movie movie,int position);
    }

}
