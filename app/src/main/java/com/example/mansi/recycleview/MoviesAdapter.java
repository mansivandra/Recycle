package com.example.mansi.recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<movie> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title, year, genre;

        public MyViewHolder(View view){
            super(view);
            title=(TextView) view.findViewById(R.id.title);
            year=(TextView) view.findViewById(R.id.year);
            genre=(TextView) view.findViewById(R.id.genre);

        }

    }
    public MoviesAdapter(List<movie> movieList)
    {
     this.moviesList=movieList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movielist,parent,false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        movie Movie=moviesList.get(position);
        holder.title.setText(Movie.getTitle());
        holder.genre.setText(Movie.getGenre());
        holder.year.setText(Movie.getYear());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
