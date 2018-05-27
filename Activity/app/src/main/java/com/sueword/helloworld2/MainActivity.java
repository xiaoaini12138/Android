package com.sueword.helloworld2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("message","ON CREATE");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("message","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("message","onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("message","OnPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("message","onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("message","onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("message","onStop");
    }
}
