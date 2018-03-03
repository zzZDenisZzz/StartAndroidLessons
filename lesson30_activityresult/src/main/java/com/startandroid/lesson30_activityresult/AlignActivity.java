package com.startandroid.lesson30_activityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class AlignActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnLeft;
    Button btnCenter;
    Button btnRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_align);

        btnLeft = findViewById(R.id.Left);
        btnCenter = findViewById(R.id.Center);
        btnRight = findViewById(R.id.Right);

        btnLeft.setOnClickListener(this);
        btnCenter.setOnClickListener(this);
        btnRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.Left:
                intent.putExtra("alignment", Gravity.LEFT);
                break;
            case R.id.Center:
                intent.putExtra("alignment", Gravity.CENTER);
                break;
            case R.id.Right:
                intent.putExtra("alignment", Gravity.RIGHT);
                break;
        }
        setResult(RESULT_OK,intent);
        finish();
    }
}
