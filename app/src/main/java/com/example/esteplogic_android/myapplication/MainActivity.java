package com.example.esteplogic_android.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity  {
    Button b1,b2;
    EditText ed1,ed2;

    TextView tx1;
    int counter = 3;

    String uname,pwd;

   Movie movieList;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.button);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);

        b2 = (Button)findViewById(R.id.button2);
        tx1 = (TextView)findViewById(R.id.textView3);
        tx1.setVisibility(View.GONE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uname=ed1.getText().toString();
                pwd=ed2.getText().toString();

                callApi(uname,pwd);


               /* if(ed1.getText().toString().equals("") &&
                        ed2.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();


                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

                            tx1.setVisibility(View.VISIBLE);
                    tx1.setBackgroundColor(Color.RED);
                    counter--;
                    tx1.setText(Integer.toString(counter));

                    if (counter == 0) {
                        b1.setEnabled(false);
                    }


                }*/



            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


public void callApi(String Uname,String Pwd)
{

    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
    Call<Movie> call = apiService.getMovies();

        call.enqueue(new Callback<Movie>()
    {
        @Override
        public void onResponse(Call<Movie> call, Response<Movie> response)
        {
            movieList = response.body();


String resp=new Gson().toJson(response).toString();

            try {
                JSONObject jsonObject=new JSONObject(resp);

                Log.d("++126++","getJSONObject"+jsonObject.getJSONObject("body"));

           JSONObject jsonObject1=     jsonObject.getJSONObject("body");

            String   salary=  jsonObject1.optString("salary").toString();
                Log.d("++131++","salary"+salary);

            } catch (JSONException e) {
                e.printStackTrace();
            }


            Log.d("TAGLOG","Response = "+movieList);
            Log.d("TAGLOG","RESPONSE ==="+response.raw().toString());
            Log.d("TAGLOG in gson => ",new Gson().toJson(response));

        //    recyclerAdapter.setMovieList(movieList);
        }

        @Override
        public void onFailure(Call<Movie> call, Throwable t)
        {
            Log.d("TAG","Response = "+t.toString());
        }
    });
}



}