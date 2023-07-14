package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String FILE_NAME = "file.txt";
        ConstraintLayout mainConstraint = new ConstraintLayout(this);

        EditText editText = new EditText(this);
        editText.setId(View.generateViewId());
        ConstraintLayout.LayoutParams editTextParams =
                new ConstraintLayout.LayoutParams(400,
                                                  ViewGroup.LayoutParams.WRAP_CONTENT);
        editTextParams.topToTop   = ConstraintLayout.LayoutParams.PARENT_ID;
        editTextParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        mainConstraint.addView(editText, editTextParams);

        Button sendButton = new Button(this);
        sendButton.setText("SEND");
        sendButton.setId(View.generateViewId());
        ConstraintLayout.LayoutParams sendButtonParams =
                new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                                  ViewGroup.LayoutParams.WRAP_CONTENT);
        sendButtonParams.leftToRight = editText.getId();
        sendButtonParams.topToTop    = ConstraintLayout.LayoutParams.PARENT_ID;
        mainConstraint.addView(sendButton, sendButtonParams);

        TextView textView = new TextView(this);
        textView.setTextSize(30);
        ConstraintLayout.LayoutParams textViewParams =
                new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                                  ViewGroup.LayoutParams.WRAP_CONTENT);
        textViewParams.topToBottom = editText.getId();
        textViewParams.leftToLeft  = ConstraintLayout.LayoutParams.PARENT_ID;
        mainConstraint.addView(textView, textViewParams);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FileOutputStream fos = null;
                try {

                    fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                    fos.write(editText.getText().toString().getBytes());
                } catch (Exception exception) {

                }

                FileInputStream fin = null;
                try {

                    fin = openFileInput(FILE_NAME);
                    byte[] bytes = new byte[fin.available()];
                    fin.read(bytes);
                    String string = new String(bytes);
                    textView.setText(string);
                } catch (Exception exception) {


                }
            }
        });

        setContentView(mainConstraint);
    }
}
