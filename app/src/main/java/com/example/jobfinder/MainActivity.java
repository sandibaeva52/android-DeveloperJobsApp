package com.example.jobfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jobs.github.com/positions.json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyRetrofit myRetrofit= retrofit.create(MyRetrofit.class);
Call<List<DataSet>> listCall=myRetrofit.getDataSet();

listCall.enqueue(new Callback<List<DataSet>>() {
    @Override
    public void onResponse(Call<List<DataSet>> call, Response<List<DataSet>> response) {
        ShowIt(response.body());
    }

    private void ShowIt(List<DataSet> response) {
DataAdapter dataAdapter=new DataAdapter(response, getApplicationContext());
recyclerView.setAdapter(dataAdapter);
    }

    @Override
    public void onFailure(Call<List<DataSet>> call, Throwable t) {

    }
});


        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.jobs);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.jobs:
                        return true;
                    case  R.id.liked:
                        startActivity(new Intent(getApplicationContext(),Liked.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.more:
                        startActivity(new Intent(getApplicationContext(),More.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }
}
