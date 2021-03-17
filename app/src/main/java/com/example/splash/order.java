package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.splash.Adopters.MainAdopter;
import com.example.splash.Adopters.OrderAdapter;
import com.example.splash.Models.OrdersModel;

import java.util.ArrayList;

public class order extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<OrdersModel> list;
    OrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        recyclerView=findViewById(R.id.orderRecylerView);

        list=new ArrayList<>();
        list.add(new OrdersModel(R.drawable.biryani,"Biryani","450"));
        list.add(new OrdersModel(R.drawable.b1,"chicken","100"));
        list.add(new OrdersModel(R.drawable.b2,"b1","1"));
        list.add(new OrdersModel(R.drawable.qorma,"Qorma","350"));
        list.add(new OrdersModel(R.drawable.biryani,"Biryani2","800"));
        list.add(new OrdersModel(R.drawable.qorma,"Qorma2","399"));

        adapter=new OrderAdapter(list,order.this);

        LinearLayoutManager layoutManager=new LinearLayoutManager(order.this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

//        GridLayoutManager layoutManager=new GridLayoutManager(MainActivity.this,2);
//        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
