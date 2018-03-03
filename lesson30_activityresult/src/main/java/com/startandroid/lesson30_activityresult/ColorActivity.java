package com.startandroid.lesson30_activityresult;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ColorActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRed;
    Button btnGreen;
    Button btnBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        btnRed = findViewById(R.id.Red);
        btnGreen = findViewById(R.id.Green);
        btnBlue = findViewById(R.id.Blue);

        btnRed.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        btnBlue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.Red:
                intent.putExtra("color", Color.RED);
                break;
            case R.id.Green:
                intent.putExtra("color", Color.GREEN);
                break;
            case R.id.Blue:
                intent.putExtra("color", Color.BLUE);
                break;
        }
        setResult(RESULT_OK,intent);
        finish();
    }
}
