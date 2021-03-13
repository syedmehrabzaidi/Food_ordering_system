package com.example.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {
    EditText emailEt;
    EditText passEt;
    EditText nameEt;
    EditText contactEt;
    FirebaseAuth auth;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        init();
    }

    private void init() {
        nameEt = findViewById(R.id.names);
        emailEt = findViewById(R.id.emails);
        passEt = findViewById(R.id.pass1);
       // contactEt = findViewById(R.id.contactEt);

        auth = FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        reference=database.getReference("User");
    }

    public void signup(View view) {

        String name = nameEt.getText().toString();
        String email = emailEt.getText().toString();
        String pass = passEt.getText().toString();

        //String contact = contactEt.getText().toString();

        if (email.isEmpty()) {
            emailEt.setError("Email required");
        } else if (pass.isEmpty()) {
            passEt.setError("Password required");
        } else {

            signupUser(name, email, pass);

        }}

        private void signupUser(final String name, final String email, final String pass) {

            auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {
                        //String key=reference.push().getKey();
                        String key=auth.getCurrentUser().getUid();
                        User user=new User(name,email,pass);
                        reference.child(key).setValue(user);


                        Intent intent = new Intent(Signup.this, Dashboard.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Signup.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }







}
