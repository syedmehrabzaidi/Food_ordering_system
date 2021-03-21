package com.example.splash.Adopters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.splash.MainModel;
import com.example.splash.detail;
import com.example.splash.R;

import java.util.ArrayList;

public class MainAdopter extends RecyclerView.Adapter<MainAdopter.viewholder>{

    ArrayList<MainModel> list;
    Context context;

    public MainAdopter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.sample_mainfood, parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final MainModel model=list.get(position);

      holder.foodimage.setImageResource(model.getImage());
      holder.name.setText(model.getName());
        holder.price.setText(model.getPrice());
        holder.desc.setText(model.getDesc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context,detail.class);

                intent.putExtra("name",model.getName());
                intent.putExtra("image",model.getImage());
                intent.putExtra("desc",model.getDesc());
                intent.putExtra("price",model.getPrice());
                context.startActivity(intent);}
        });
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {


        ImageView foodimage;
        TextView name, price, desc;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            foodimage = itemView.findViewById(R.id.foodimage);
            name = itemView.findViewById(R.id.foodname);
            price = itemView.findViewById(R.id.foodprice);
            desc = itemView.findViewById(R.id.fooddesc);
        }
    }
}
