package com.startandroid.lesson33_sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity33 extends AppCompatActivity implements View.OnClickListener{

    EditText edText;
    Button btnSave;
    Button btnLoad;
    SharedPreferences sPref;

    final String SAVE_TEXT = "save_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main33);

        edText = findViewById(R.id.edText);

        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        btnLoad = findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSave:
                saveText();
                break;
            case R.id.btnLoad:
                loadText();
                break;
            default:
                break;
        }
    }

    private void saveText() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putString(SAVE_TEXT, edText.getText().toString());
        editor.commit();
        Toast.makeText(MainActivity33.this, "Text saved", Toast.LENGTH_SHORT).show();
    }
    private void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        String saveText = sPref.getString(SAVE_TEXT,"");
        edText.setText(saveText);
        Toast.makeText(MainActivity33.this, "Text load", Toast.LENGTH_SHORT).show();
    }
}
