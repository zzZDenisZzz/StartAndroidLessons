package com.startandroid.lesson26_intentfilter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity26 extends AppCompatActivity implements View.OnClickListener {

    Button btnTime;
    Button btnDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main26);

        btnTime = findViewById(R.id.btn_time);
        btnDate = findViewById(R.id.btn_date);

        btnTime.setOnClickListener(this);
        btnDate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()){
            case R.id.btn_time:
                intent = new Intent("android.intent.action.time");
                startActivity(intent);
                break;

                case R.id.btn_date:
                intent = new Intent("android.intent.action.date");
                startActivity(intent);
                break;

        }

    }
}
