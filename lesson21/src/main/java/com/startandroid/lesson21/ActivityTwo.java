package com.startandroid.lesson21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityTwo extends AppCompatActivity implements View.OnClickListener {

    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        button2 = findViewById(R.id.btn2_activity);
        button2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn2_activity:
                Intent intent = new Intent(this,Main3Activity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
