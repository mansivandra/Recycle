package com.example.mansi.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

class Base_Adapter extends BaseAdapter{
    List<movie>movieList;
    Context context;
    LayoutInflater inflater;

    public Base_Adapter(Context context, List<movie> movieList) {
        this.context=context;
        this.movieList=movieList;
        inflater=LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.movielist,null);
        TextView txt1=(TextView)convertView.findViewById(R.id.genre);
       // TextView txt2=(TextView)convertView.findViewById(R.id.title);
        TextView txt3=(TextView)convertView.findViewById(R.id.year);

        movie m=movieList.get(position);
        txt1.setText(m.getGenre());
        txt3.setText(m.getYear());


        return convertView;
    }
}
