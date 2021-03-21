package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class detail extends AppCompatActivity {

    ImageView Dimage;
    TextView Dname, Ddesc, Dprice;
    ImageView imageIV;
    EditText Dnickname,table;
        TextView rupees;
        TextView quantity;
    int count=0;

    int price;
    int value;
    int counter;
    String nick,Dtable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Dimage = (ImageView)findViewById(R.id.Dimage);
        Dname = (TextView)findViewById(R.id.Dname);
        Ddesc = (TextView)findViewById(R.id.Ddesc);
        Dprice = (TextView)findViewById(R.id.Dprice);
        Dnickname = (EditText) findViewById(R.id.Dnickname);
        table = (EditText) findViewById(R.id.table);


        Bundle bundle=getIntent().getExtras();


        String name=bundle.getString("name");
        String detail=bundle.getString("desc");
        String priceP=bundle.getString("price");
        int image=bundle.getInt("image");
//        String nick=bundle.getString("nick");
//        String table1=bundle.getString("table");

        Dname.setText(name);
        Ddesc.setText(detail);
        Dprice.setText(priceP);
        Dimage.setImageResource(image);
//        Dnickname.setText(nick);
//        table.setText(table1);

       // int image = getIntent().getInExtra("image",defaultValue:0);
        int price1 = Integer.parseInt(getIntent().getStringExtra("price"));
//        String name = getIntent().getStringExtra("name");
//        String description = getIntent().getStringExtra("desc");

     final int rate = price1;



    quantity = (TextView) findViewById(R.id.quantity);

        rupees = (TextView) findViewById(R.id.Dprice);




    TextWatcher textwatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (quantity.getText().toString().equals("0")){rupees.setText(String.valueOf(0));}
            if (!quantity.getText().toString().equals("0")) {
                value = Integer.parseInt(quantity.getText().toString());
                price=value*rate;
                rupees.setText(String.valueOf(value * rate));

            }

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
        quantity.addTextChangedListener(textwatcher);



}


    public void inc(View view) {
        count++;
        quantity.setText("" + count);
    }

    public void dec(View view) {

        if(count <= 0) {count = 0;}
        else count--;
        quantity.setText("" + count);
    }






    public void orderbtn(View view) {
        nick=Dnickname.getText().toString();
        Dtable=table.getText().toString();
        int a =Integer.parseInt(Dtable);

        Intent intent=new Intent(detail.this,bill.class);
        intent.putExtra("price",price);
        intent.putExtra("quantity",value);
        intent.putExtra("counter",count);
        intent.putExtra("nick",nick);
        intent.putExtra("table", a);
        startActivity(intent);
    }

}
