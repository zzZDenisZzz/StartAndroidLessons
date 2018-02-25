package com.startandroid.lesson23_lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity23 extends AppCompatActivity {

    final String TAG = "lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main23);
        Log.d(TAG,"Activity создан");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"Activity становиться видимым");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"Activity получает фокус");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"Activity приостановлен");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"Activity остановлен");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"Activity уничтожен");
    }
}
