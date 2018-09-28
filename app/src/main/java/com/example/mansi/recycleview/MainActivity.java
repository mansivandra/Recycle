package com.example.mansi.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<movie> movieList = new ArrayList<>();
    RecyclerView recyclerView;
    ListView lv;
    String id, name, mobile;
    private MoviesAdapter mAdapter;
    String url = "https://api.androidhive.info/contacts/";
    String t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //   lv=(ListView)findViewById(R.id.lv);
       recyclerView = (RecyclerView) findViewById(R.id.rec);
        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONObject object=new JSONObject(response);
                    JSONArray array=object.getJSONArray("contacts");

                    for (int i=0;i<array.length();i++)
                    {
                        JSONObject object1=array.getJSONObject(i);

                        id=object1.getString("id");
                        name=object1.getString("name");

                        JSONObject phone=object1.getJSONObject("phone");
                        mobile=phone.getString("mobile");

                        Log.e("Res",">>>>>>"+id+name+mobile);
                        movie m=new movie();
                        m.setTitle(id);
                        m.setGenre(name);
                        m.setYear(mobile);
                        movieList.add(m);


                       /* Base_Adapter adapter=new Base_Adapter(MainActivity.this,movieList);
                        lv.setAdapter(adapter);
*/
                    }
                    mAdapter = new MoviesAdapter(movieList);
                    recyclerView.setHasFixedSize(true);
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL));
                    recyclerView.setAdapter(mAdapter);




                } catch (JSONException e) {
                    e.printStackTrace();
                }









            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue queue= Volley.newRequestQueue(MainActivity.this);
        queue.add(request);


        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Toast.makeText(MainActivity.this, "Title=" + movieList.get(position).getTitle(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

      //  prepareMovieData();
    }


    private void prepareMovieData() {
    /*    final StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONObject object=new JSONObject(response);
                    JSONArray array=object.getJSONArray("contacts");

                    for (int i=0;i<array.length();i++)
                    {
                        JSONObject object1=array.getJSONObject(i);

                       id=object1.getString("id");
                         name=object1.getString("name");

                        JSONObject phone=object1.getJSONObject("phone");
                       mobile=phone.getString("mobile");

                        Log.e("Res",">>>>>>"+id+name+mobile);



                    }
                    movie m=new movie();
                    m.setTitle(id);
                    m.setGenre(name);
                    m.setYear(mobile);
                    movieList.add(m);



                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue queue= Volley.newRequestQueue(MainActivity.this);
        queue.add(request);
    }*/


        movie Movie = new movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(Movie);


        Movie = new movie("Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(Movie);

        Movie = new movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(Movie);

        Movie = new movie("Shaun the Sheep", "Animation", "2015");
        movieList.add(Movie);

        Movie = new movie("The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(Movie);

        Movie = new movie("Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(Movie);

        Movie = new movie("Up", "Animation", "2009");
        movieList.add(Movie);

        Movie = new movie("Star Trek", "Science Fiction", "2009");
        movieList.add(Movie);

        Movie = new movie("The LEGO Movie", "Animation", "2014");
        movieList.add(Movie);

        Movie = new movie("Iron Man", "Action & Adventure", "2008");
        movieList.add(Movie);

        Movie = new movie("Aliens", "Science Fiction", "1986");
        movieList.add(Movie);

        Movie = new movie("Chicken Run", "Animation", "2000");
        movieList.add(Movie);

        Movie = new movie("Back to the Future", "Science Fiction", "1985");
        movieList.add(Movie);

        Movie = new movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        movieList.add(Movie);

        Movie = new movie("Goldfinger", "Action & Adventure", "1965");
        movieList.add(Movie);

        Movie = new movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        movieList.add(Movie);

        mAdapter.notifyDataSetChanged();
    }
}

