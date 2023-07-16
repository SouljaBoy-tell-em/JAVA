package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.widget.SimpleCursorAdapter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        databaseHelper = new DatabaseHelper(this);
        db = databaseHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.PRICE, "10000");
//        db.execSQL( "UPDATE " + DatabaseHelper.TABLE_NAME + " SET " + DatabaseHelper.NAME + "='NEW BALANCE 228' WHERE " +  DatabaseHelper.NAME + " like 'NEW BALANCE 327'");
        //db.execSQL( "UPDATE " + DatabaseHelper.TABLE_NAME + " SET " + DatabaseHelper.PRICE + "='NEW BALANCE 229' WHERE " +  DatabaseHelper.NAME + " like 'NEW BALANCE 228'");
        db.update(DatabaseHelper.TABLE_NAME, cv, DatabaseHelper.PRICE + "=?", new String[]{"12000"});

        info = new TextView(this);
        info.setText("DEFAULT");
        info.setTextSize(30);

        setContentView(info);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Cursor cursor = databaseHelper.getReadableDatabase().rawQuery("select * from " + DatabaseHelper.TABLE_NAME, null);

        info.setText("");
        while(cursor.moveToNext())
            info.append(cursor.getString(0) + "\n" + cursor.getInt(1) + "\n\n");
    }
}
