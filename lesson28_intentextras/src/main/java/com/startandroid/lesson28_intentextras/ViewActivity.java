package com.startandroid.lesson28_intentextras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        tv = findViewById(R.id.tv);

        //Получаем Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        //Полученый результат записываем в TextView
        tv.setText(name);
    }
}
