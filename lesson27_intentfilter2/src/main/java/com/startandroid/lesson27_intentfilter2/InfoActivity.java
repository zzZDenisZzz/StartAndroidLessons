package com.startandroid.lesson27_intentfilter2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        String action = intent.getAction();

        String format = "", textInfo = "";

        if (action.equals("android.intent.action.time")){
            format = "HH:mm:ss";
            textInfo = "Time: ";
        }else if (action.equals("android.intent.action.date")){
            format = "dd:MM:yyyy";
            textInfo = "Date: ";
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String dateTime = simpleDateFormat.format(new Date(System.currentTimeMillis()));

        TextView tvDate = findViewById(R.id.text_view);
        tvDate.setText(textInfo + dateTime);
    }
}
