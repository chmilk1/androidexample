package com.example.league.adventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    Button start;
    EditText nameFeild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start);
        nameFeild = findViewById(R.id.nameFeild);

        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if("".equals(nameFeild.getText())){

                } else {
                    Log.v("fun", "start was hit");
                    Intent startPathA = new Intent(MainActivity.this, PathA.class);
                    startPathA.putExtra("name", nameFeild.getText());
                    MainActivity.this.startActivity(startPathA);
                }
            }
        });

    }
}
