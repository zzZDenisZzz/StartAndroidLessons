package com.startandroid.lesson18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity18 extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    SeekBar sbWeight;
    Button btn1;
    Button btn2;

    LinearLayout.LayoutParams layoutParams1;
    LinearLayout.LayoutParams layoutParams2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main18);

        sbWeight = findViewById(R.id.sbWeight);
        sbWeight.setOnSeekBarChangeListener(this);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        layoutParams1 = (LinearLayout.LayoutParams) btn1.getLayoutParams();
        layoutParams2 = (LinearLayout.LayoutParams) btn2.getLayoutParams();

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int leftValue = progress;
        int rightValue = seekBar.getMax()-progress;

        layoutParams1.weight = leftValue;
        layoutParams2.weight = rightValue;

        btn1.setText(String.valueOf(leftValue));
        btn2.setText(String.valueOf(rightValue));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
