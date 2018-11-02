package com.example.league.wackamole;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity{

    ArrayList<Button> moles = new ArrayList<>();
    Timer posTimer = new Timer();
    Timer gameTimer = new Timer();
    Random rand = new Random();
    int score = 0;
    int secondsLeft = 20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addMoles();
        hideMoles();;
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
        moles.add((Button) findViewById(R.id.mole2));
        moles.add((Button) findViewById(R.id.mole3));
    }

    private void addClickListner(){
        for(final Button m: moles){
            m.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeMolePos(m);
                    addScore();
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
        addClickListner();
        showMoles();
        posTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                changeMolePos();
            }
        }, 500, 500);

        final TextView timerText = findViewById(R.id.timetext);
        timerText.setVisibility(View.VISIBLE);
        gameTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(secondsLeft > 0){
                    secondsLeft -= 1;
                    timerText.setText(getString(R.string.timer) + secondsLeft);
                } else {
                    endGame();
                }
            }
        }, 1000, 1000);
        start.setVisibility(View.INVISIBLE);
    }

    private void endGame(){
        hideMoles();
        posTimer.cancel();
        gameTimer.cancel();

        findViewById(R.id.timetext).setVisibility(View.INVISIBLE);

        score = 0;
        secondsLeft = 20;

        //findViewById(R.id.start).setVisibility(View.VISIBLE);
    }

    private void changeMolePos() {
        changeMolePos(moles.get(rand.nextInt(moles.size())));
    }

    private void changeMolePos(final Button m) {
        RelativeLayout.LayoutParams p = (RelativeLayout.LayoutParams) m.getLayoutParams();
        p.setMargins(rand.nextInt(findViewById(R.id.rl).getWidth()-m.getWidth()), rand.nextInt(findViewById(R.id.rl).getHeight()-m.getHeight()),0,0);
        final RelativeLayout.LayoutParams pfinal = p;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                m.setLayoutParams(pfinal);
            }
        });

    }

    private void addScore(){
        score++;
        TextView start = findViewById(R.id.text);
        start.setText(getString(R.string.score) + score);
    }
}

