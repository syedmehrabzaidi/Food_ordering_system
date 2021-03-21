package com.example.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.example.splash.Adopters.MainAdopter;

import java.util.ArrayList;
import com.example.splash.MainModel;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.Nullable;


public class Menu extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<MainModel> list;
    MainAdopter adapter;
    DatabaseReference reference;
    FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        recyclerView=findViewById(R.id.bookRecycleList);
        database=FirebaseDatabase.getInstance();
        reference=database.getReference("MainModel");

        list=new ArrayList<>();


        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                MainModel food=snapshot.getValue(MainModel.class);
                list.add(food);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        list.add(new MainModel(R.drawable.biryani,"Biryani","450","Biryani is the primary dish in a meal, while the pulao is usually a secondary accompaniment to a larger meal"));
        list.add(new MainModel(R.drawable.karachi,"Chicken_Karahi","700","kadai chicken, is a dish from the Indian subcontinent noted for its spicy taste; it is notable in North Indian and Pakistani cuisine."));
        list.add(new MainModel(R.drawable.qorma,"Qorma","350","The flavour of a korma is based on a mixture of spices, including ground coriander and cumin, combined with yogurt kept below curdling temperature and incorporated slowly and carefully with the meat juices."));
        list.add(new MainModel(R.drawable.biryani,"Biryani","800","Biryani is the primary dish in a meal, while the pulao is usually a secondary accompaniment to a larger meal"));
        list.add(new MainModel(R.drawable.daal_chawal,"Daal_chawal","180","Daal chawal is a Pakistani dish that is also quite popular in Nepal and India. It consists of lentils and rice, and it is recommended to use both red lentils (masoor) and yellow lentils (moong). The lentils are cooked until mushy"));
        list.add(new MainModel(R.drawable.pilao,"Pilao","250","a dish originating from the East, consisting of rice flavoured with spices and cooked in stock, to which meat, poultry, or fish may be added"));
        list.add(new MainModel(R.drawable.kawab,"Kawab","120","kebab is any of a wide variety of grilled meat dishes. Some dishes ultimately derived from Middle Eastern kebab may have different names in their local languages"));
//repeat Menu

        list.add(new MainModel(R.drawable.biryani,"Biryani","450","Biryani is the primary dish in a meal, while the pulao is usually a secondary accompaniment to a larger meal"));
        list.add(new MainModel(R.drawable.karachi,"Chicken_Karahi","700","kadai chicken, is a dish from the Indian subcontinent noted for its spicy taste; it is notable in North Indian and Pakistani cuisine."));
        list.add(new MainModel(R.drawable.qorma,"Qorma","350","The flavour of a korma is based on a mixture of spices, including ground coriander and cumin, combined with yogurt kept below curdling temperature and incorporated slowly and carefully with the meat juices."));
        list.add(new MainModel(R.drawable.biryani,"Biryani","800","Biryani is the primary dish in a meal, while the pulao is usually a secondary accompaniment to a larger meal"));
        list.add(new MainModel(R.drawable.daal_chawal,"Daal_chawal","180","Daal chawal is a Pakistani dish that is also quite popular in Nepal and India. It consists of lentils and rice, and it is recommended to use both red lentils (masoor) and yellow lentils (moong). The lentils are cooked until mushy"));
        list.add(new MainModel(R.drawable.pilao,"Pilao","250","a dish originating from the East, consisting of rice flavoured with spices and cooked in stock, to which meat, poultry, or fish may be added"));
        list.add(new MainModel(R.drawable.kawab,"Kawab","120","kebab is any of a wide variety of grilled meat dishes. Some dishes ultimately derived from Middle Eastern kebab may have different names in their local languages"));



        adapter=new MainAdopter(list,Menu.this);

        LinearLayoutManager layoutManager=new LinearLayoutManager(Menu.this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

//        GridLayoutManager layoutManager=new GridLayoutManager(MainActivity.this,2);
//        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);




    }
}
