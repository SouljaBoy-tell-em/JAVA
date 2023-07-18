package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements Creater {

    private static final String KEY_OPTIONS = "key_options";
    ConstraintLayout mainConstraint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    mainConstraint = new ConstraintLayout(this);

    EditText editText = new EditText(this);
    editText.setId(View.generateViewId());
    ConstraintLayout.LayoutParams editTextParams = new ConstraintLayout.LayoutParams(400, ViewGroup.LayoutParams.WRAP_CONTENT);
    editTextParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
    editTextParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
    mainConstraint.addView(editText, editTextParams);

    Button sendButton = new Button(this);
    ConstraintLayout.LayoutParams sendButtonParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    sendButtonParams.leftToRight = editText.getId();
    sendButtonParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
    mainConstraint.addView(sendButton, sendButtonParams);


    sendButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Bundle bundle = new Bundle();
            bundle.putString("keyname", editText.getText().toString());
            bundle.putLong("keycode", 228);

            MyDialog dialog = new MyDialog();
            dialog.setArguments(bundle);
            dialog.show(getSupportFragmentManager(), "custom");
        }
    });

    setContentView(mainConstraint);
    }

    @Override
    public void CreateCard(String name, long numberPhone) {

        ConstraintLayout cardConstraint = new ConstraintLayout(this);
        ConstraintLayout.LayoutParams cardConstraintParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        cardConstraintParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        cardConstraintParams.topToTop     = ConstraintLayout.LayoutParams.PARENT_ID;

        cardConstraint.setId(View.generateViewId());

        TextView nameView = new TextView(this);
        nameView.setId(View.generateViewId());
        nameView.setText(name);

        ConstraintLayout.LayoutParams nameViewParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        nameViewParams.topToTop   = cardConstraint.getId();
        nameViewParams.leftToLeft = cardConstraint.getId();
        cardConstraint.addView(nameView, nameViewParams);

        TextView cardView = new TextView(this);
        cardView.setText(numberPhone + "");
        ConstraintLayout.LayoutParams cardViewParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        cardViewParams.topToBottom = nameView.getId();
        cardViewParams.leftToLeft  = cardConstraint.getId();
        cardConstraint.addView(cardView, cardViewParams);

        mainConstraint.addView(cardConstraint, cardConstraintParams);
    }
}
