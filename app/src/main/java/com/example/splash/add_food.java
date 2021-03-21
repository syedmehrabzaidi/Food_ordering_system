package com.example.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add_food extends AppCompatActivity {
     EditText namef, pricef, descf;
     FirebaseDatabase database;
     DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        init();
    }

    private void init() {
        namef = findViewById(R.id.add_name);
        pricef = findViewById(R.id.add_price);
        descf = findViewById(R.id.add_desc);
        database = FirebaseDatabase.getInstance();
        reference=database.getReference();


    }

    public void addonList(View view) {
        String name =namef.getText().toString();
        String price =pricef.getText().toString();
        String desc =descf.getText().toString();

        MainModel foods =new MainModel(R.drawable.qorma,name,price,desc);

        String key=reference.push().getKey();
        reference.child(key).setValue(foods).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Intent listIntent = new Intent(add_food.this, Menu.class);
                    startActivity(listIntent);
                }
            }
        });

    }
}
