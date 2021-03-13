package com.example.splash.Adopters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.splash.Models.MainModel;
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
       View view = LayoutInflater.from(context).inflate(R.layout.sample_mainfood, parent,false)
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
      final MainModel model=list.get(position);
      holder.foodimage.setImageResource(model.getImage());
      holder.foodname.setText(model.getName());
        holder.foodprice.setText(model.getPrice());
        holder.fooddesc.setText(model.getDesc());
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
