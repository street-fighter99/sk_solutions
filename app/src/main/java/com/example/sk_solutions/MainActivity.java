package com.example.sk_solutions;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        auth=FirebaseAuth.getInstance();

                if(auth.getCurrentUser()!=null) {
                   new Handler().postDelayed(new Runnable() {
                       @Override
                       public void run() {
                           startActivity(new Intent(getApplicationContext(),mainhome.class));
                      finish();
                       }
                   },4000);
                }else{

        startActivity(new Intent(getApplicationContext(), verifyotp.class));
        finish();
        }

    }}



