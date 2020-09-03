package com.example.sk_solutions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class medical extends AppCompatActivity {
    CardView updates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);
        getSupportActionBar().hide();

        updates=findViewById(R.id.coronaupdates);

        updates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),covidupdates.class);
                startActivity(intent);
            }
        });

    }
}