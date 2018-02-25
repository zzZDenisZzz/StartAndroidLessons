package com.startandroid.lesson21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity21 extends AppCompatActivity implements View.OnClickListener{

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main21);

        button = findViewById(R.id.btn_activity);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_activity:
                Intent intent = new Intent(this,ActivityTwo.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
