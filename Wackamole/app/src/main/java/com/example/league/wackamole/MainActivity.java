package com.example.league.wackamole;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mole = findViewById(R.id.mole1);
        mole.setVisibility(View.INVISIBLE);
        mole.setOnClickListener();
    }
}
