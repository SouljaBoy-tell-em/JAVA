package com.example.sql;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "products.db";
    public static final String TABLE_NAME = "PRODUCT_TABLE";
    public static final String NAME = "PRODUCT_NAME";
    public static final String PRICE = "PRODUCT_PRICE";
    private static final int DATABASE_VERSION = 5;

    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + NAME + " TEXT, " + PRICE + " INTEGER, " + " UNIQUE(" + PRICE + "))");
        db.execSQL("INSERT INTO " + DatabaseHelper.TABLE_NAME + " VALUES ('NEW BALANCE 327', 12000)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }



}