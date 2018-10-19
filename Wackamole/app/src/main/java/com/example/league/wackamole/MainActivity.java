package com.example.league.wackamole;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity{

    ArrayList<Button> moles = new ArrayList<>();
    Timer posTimer = new Timer();
    Random rand = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addMoles();
        Button start = findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startGame();

            }
        });


    }

    private void addMoles(){
        moles.add((Button) findViewById(R.id.mole1));
    }

    private void addClickListner(){
        for(final Button m: moles){
            m.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeMolePos(m);
                }
            });
        }
    }

    private void hideMoles(){
        for(Button m: moles){
            m.setVisibility(View.INVISIBLE);
        }
    }

    private void showMoles(){
        for(Button m: moles){
            m.setVisibility(View.VISIBLE);
        }
    }

    private void startGame(){
        Button start = findViewById(R.id.start);
        posTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                changeMolePos();
            }
        }, 500l);
        start.setVisibility(View.INVISIBLE);
    }

    private void changeMolePos() {
        changeMolePos(moles.get(rand.nextInt(moles.size())));
    }

    private void changeMolePos(Button m) {
        RelativeLayout.LayoutParams p = (RelativeLayout.LayoutParams) m.getLayoutParams();
        p.setMargins(rand.nextInt(findViewById(R.id.rl).getWidth()), rand.nextInt(findViewById(R.id.rl).getHeight()),0,0);
        m.setLayoutParams(p);
    }


}

