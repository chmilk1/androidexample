package com.example.league.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("warn","created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("warn","starting");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("warn","distroyed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("warn","paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("warn","resumeed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("warn","stoped");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("warn","restarted");
    }
}
