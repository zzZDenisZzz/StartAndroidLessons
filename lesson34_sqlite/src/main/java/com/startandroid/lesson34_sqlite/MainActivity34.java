package com.startandroid.lesson34_sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity34 extends AppCompatActivity implements View.OnClickListener {

    Button btnAdd, btnRead, btnClear,btnUpd,btnDel;
    EditText etName, etEmail,etId;

    DBHelper dbHelper;
    private static final String TAG = "mLog";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main34);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnRead = findViewById(R.id.btnRead);
        btnRead.setOnClickListener(this);

        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);

        btnUpd = findViewById(R.id.btnUpd);
        btnUpd.setOnClickListener(this);

        btnDel = findViewById(R.id.btnDel);
        btnDel.setOnClickListener(this);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etId = findViewById(R.id.etId);


        dbHelper = new DBHelper(this);

    }

    @Override
    public void onClick(View v) {
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String id = etId.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        switch (v.getId()){

            case R.id.btnAdd:
                contentValues.put(DBHelper.KEY_NAME, name);
                contentValues.put(DBHelper.KEY_MAIL, email);

                database.insert(DBHelper.TABLE_CONTACTS,null,contentValues);
                break;

            case R.id.btnRead:
                Cursor cursor = database.query(DBHelper.TABLE_CONTACTS,null,null,null,null,null,null);

                if (cursor.moveToFirst()){
                    int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                    int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                    int emailIndex = cursor.getColumnIndex(DBHelper.KEY_MAIL);
                        do{
                            Log.d(TAG,"ID = " + cursor.getInt(idIndex) +
                                    ", name = " + cursor.getString(nameIndex) +
                                    ", email = " + cursor.getString(emailIndex));
                    }while (cursor.moveToNext());
                }else
                    Log.d(TAG, "0 rows");

                cursor.close();
                break;

            case R.id.btnClear:
                database.delete(DBHelper.TABLE_CONTACTS,null,null);
                break;

            case R.id.btnUpd:
                if(id.equalsIgnoreCase("")){
                    break;
                }
                contentValues.put(DBHelper.KEY_MAIL,email);
                contentValues.put(DBHelper.KEY_NAME,name);
                int updCount = database.update(DBHelper.TABLE_CONTACTS, contentValues,DBHelper.KEY_ID + "= ?", new String[]{id});

                Log.d(TAG, "update row count = " + updCount);

            case R.id.btnDel:
                if(id.equalsIgnoreCase("")){
                    break;
                }
                int delCount = database.delete(DBHelper.TABLE_CONTACTS,DBHelper.KEY_ID + "=" + id, null);

                Log.d(TAG, "deleted row count = " + delCount);
        }
        dbHelper.close();
    }
}
