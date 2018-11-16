package com.example.league.adventure;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class PathA extends AppCompatActivity {

    Button option1;
    Button option2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        String name = getIntent().getExtras().getString("name");
        Log.v("story","name: "+ name);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path_a);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("story","option 1 on path A was chosen");
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("story","option 2 on path A was chosen");
            }
        });

    }
}
