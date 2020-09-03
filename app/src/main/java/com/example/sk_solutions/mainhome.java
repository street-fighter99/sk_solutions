package com.example.sk_solutions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class mainhome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
private DrawerLayout drawerLayout;
private ActionBarDrawerToggle toggle;
private NavigationView navigationView;
CardView medical,notifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainhome);

        medical=findViewById(R.id.medical);
        notifi=findViewById(R.id.notify);

        //id passing.....(navigation)

        drawerLayout=findViewById(R.id.drawablelayout);
        navigationView=findViewById(R.id.naviationView);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.start,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);



        //medical card view

        medical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),medical.class);
                startActivity(intent);
            }
        });
    }

    //code to make work the menu button
    //when we can only acccess menu by sliding from left


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            Toast.makeText(this, "Menu", Toast.LENGTH_SHORT).show();
            return true;

        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.settings:
                Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.proffile:
                Toast.makeText(this, "pro-file hmm.. hmm... ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.aboutus:
                Toast.makeText(this, "annonymous", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home:
                Toast.makeText(this, "veettil poda", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}