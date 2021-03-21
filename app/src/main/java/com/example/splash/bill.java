package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class bill extends AppCompatActivity {


    TextView total_price;
    TextView counter;
    TextView name, D_table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        total_price=findViewById(R.id.Bbill);
        counter=findViewById(R.id.Bquantity);
       name=findViewById(R.id.Bname);
        D_table=findViewById(R.id.table);

        Bundle bundle=getIntent().getExtras();
        int price =bundle.getInt("price");
        int count =bundle.getInt("counter");
       String nick =bundle.getString("nick");
        int table_num =bundle.getInt("table");

        total_price.setText(String.valueOf(price));
        counter.setText(String.valueOf(count));
        name.setText(String.valueOf(nick));
  //    D_table.setText(String.valueOf(table_num));

    }
}
