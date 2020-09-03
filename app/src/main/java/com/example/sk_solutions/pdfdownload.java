package com.example.sk_solutions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class pdfdownload extends AppCompatActivity {

 //add variables for floating action bar and Textview we give to the float buttons
FloatingActionButton mainactionbttn,addactionbttn,searchactionbttn;
TextView searchtxt,additemtxt;
private boolean isOpen;
private Animation openAnime,closeAnime,rotation,backrotation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfdownload);

        //linking the FAB with variables

        mainactionbttn=findViewById(R.id.mainaction);
        addactionbttn=findViewById(R.id.addaction);
        searchactionbttn=findViewById(R.id.searchaction);

        //linking variables with textview of FAB

        searchtxt=findViewById(R.id.searchtxt);
        additemtxt=findViewById(R.id.adddatatxt);

        //setting isOpen variable

        isOpen=false;

        //connection of animation
        openAnime= AnimationUtils.loadAnimation(pdfdownload.this,R.anim.open_action_fab);
        closeAnime=AnimationUtils.loadAnimation(pdfdownload.this,R.anim.close_action_fab);
        rotation=AnimationUtils.loadAnimation(pdfdownload.this,R.anim.rotation);
        backrotation=AnimationUtils.loadAnimation(pdfdownload.this,R.anim.back_rotation);


        //set actions to the main FAB button

        mainactionbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //checking the FAB is open or not
                //if it's then this code close it
                //or if it closed then this code will open it


                if(isOpen){
                    searchactionbttn.setAnimation(closeAnime);
                    addactionbttn.setAnimation(closeAnime);
                    mainactionbttn.setAnimation(rotation);
                    additemtxt.setVisibility(view.INVISIBLE);
                    searchtxt.setVisibility(view.INVISIBLE);

                    isOpen=false;



                }else{
                    searchactionbttn.setAnimation(openAnime);
                    addactionbttn.setAnimation(openAnime);
                    mainactionbttn.setAnimation(backrotation);
                    additemtxt.setVisibility(view.VISIBLE);
                    searchtxt.setVisibility(view.VISIBLE);
                    isOpen=true;



                }

            }
        });





    }
}