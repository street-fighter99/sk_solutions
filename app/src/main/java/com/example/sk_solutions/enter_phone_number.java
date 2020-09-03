package com.example.sk_solutions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class enter_phone_number extends AppCompatActivity {
Button otpbttn;
EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_phone_number);
        getSupportActionBar().hide();


        otpbttn=findViewById(R.id.generatebttn);
        phone=findViewById(R.id.phonenumber);


        otpbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


        String phoneno=phone.getText().toString();
        if(phoneno.isEmpty()){
            phone.setError("You didn't enter your Number");
            phone.requestFocus();
        }
        else if(phoneno.length()!=10){
            phone.setError("Check your number");
            phone.requestFocus();
        }
        else{
            Intent intent=new Intent(getApplicationContext(),verifyotp.class);
            intent.putExtra("phoneno",phoneno);
            startActivity(intent);
        }
            }
        });
    }
}