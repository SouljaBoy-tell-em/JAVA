package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    private static final String KEY_OPTIONS = "key_options";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ConstraintLayout mainConstraint = new ConstraintLayout(this);

        Button getButton = new Button(this);
        getButton.setId(View.generateViewId());
        getButton.setText("GET");
        ConstraintLayout.LayoutParams getButtonParams =
                new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
        getButtonParams.topToTop    = ConstraintLayout.LayoutParams.PARENT_ID;
        getButtonParams.leftToLeft  = ConstraintLayout.LayoutParams.PARENT_ID;
        mainConstraint.addView(getButton, getButtonParams);

        TextView dataBaseText = new TextView(this);
        dataBaseText.setTextSize(15);
        dataBaseText.setText("DEFAULT");
        dataBaseText.setId(View.generateViewId());
        ConstraintLayout.LayoutParams dataBaseTextLayout =
                new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                                  ViewGroup.LayoutParams.WRAP_CONTENT);
        dataBaseTextLayout.leftToLeft  = ConstraintLayout.LayoutParams.PARENT_ID;
        dataBaseTextLayout.topToBottom = getButton.getId();
        mainConstraint.addView(dataBaseText, dataBaseTextLayout);

        SQLiteDatabase database = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS users (name TEXT, age INTEGER, UNIQUE(name))");
        database.execSQL("INSERT OR IGNORE INTO users VALUES ('Semen Semenov', 19), ('Alexandr Zaytsev', 20)");
        Cursor query = database.rawQuery("SELECT * FROM users;", null);

        final boolean[] flag = {false};

        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                while(query.moveToNext()) {

                    if(flag[0] == false) {

                        dataBaseText.setText("");
                        flag[0] = true;
                    }
                    dataBaseText.append("Name: " + query.getString(0) + ", " + "Age: " + query.getInt(1) + " ;\n");
                }

                query.close();
                database.close();
            }
        });

        setContentView(mainConstraint);
    }
}
