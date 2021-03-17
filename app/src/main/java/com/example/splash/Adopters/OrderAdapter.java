package com.example.splash.Adopters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.splash.MainModel;
import com.example.splash.Models.OrdersModel;
import com.example.splash.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewholder> {

    public OrderAdapter(ArrayList<OrdersModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    ArrayList<OrdersModel> list;
    Context context;

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_order, parent,false);
        return new viewholder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final OrdersModel model=list.get(position);

        holder.oimage.setImageResource(model.getOrderimage());
        holder.oname.setText(model.getOrdername());
        holder.oprice.setText(model.getOrderprice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{

        ImageView oimage;
        TextView oname,oprice;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            oimage =itemView.findViewById(R.id.orderimage);
            oname =itemView.findViewById(R.id.ordername);
            oprice =itemView.findViewById(R.id.orderprice);
        }
    }
}
