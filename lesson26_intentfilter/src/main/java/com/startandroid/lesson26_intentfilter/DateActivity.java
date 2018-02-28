package com.startandroid.lesson26_intentfilter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy");
        String date = dateFormat.format(new Date(System.currentTimeMillis()));

        TextView tvDate = findViewById(R.id.text_date);
        tvDate.setText(date);
    }
}
