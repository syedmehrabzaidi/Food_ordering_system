package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.example.splash.Adopters.MainAdopter;

import java.util.ArrayList;
import com.example.splash.MainModel;


public class Menu extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<MainModel> list;
    MainAdopter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        recyclerView=findViewById(R.id.bookRecycleList);

        list=new ArrayList<>();
        list.add(new MainModel(R.drawable.biryani,"Biryani","450","tasty"));
        list.add(new MainModel(R.drawable.b1,"chicken","100","tasty"));
        list.add(new MainModel(R.drawable.b2,"b1","1","tasty"));
        list.add(new MainModel(R.drawable.qorma,"Qorma","350","tasty"));
        list.add(new MainModel(R.drawable.biryani,"Biryani2","800","tasty"));
        list.add(new MainModel(R.drawable.qorma,"Qorma2","399","tasty"));
        list.add(new MainModel(R.drawable.biryani,"b1","1","tasty"));
        list.add(new MainModel(R.drawable.biryani,"b1","1","tasty"));



        adapter=new MainAdopter(list,Menu.this);

        LinearLayoutManager layoutManager=new LinearLayoutManager(Menu.this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

//        GridLayoutManager layoutManager=new GridLayoutManager(MainActivity.this,2);
//        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);




    }
}
