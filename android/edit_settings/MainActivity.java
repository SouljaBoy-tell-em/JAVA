package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_OPTIONS = "key_options";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ConstraintLayout mainConstraint = new ConstraintLayout(this);

        EditText editText = new EditText(this);
        editText.setId(View.generateViewId());
        ConstraintLayout.LayoutParams editTextParams =
                new ConstraintLayout.LayoutParams(400,
                                                  ViewGroup.LayoutParams.WRAP_CONTENT);
        editTextParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        editTextParams.topToTop   = ConstraintLayout.LayoutParams.PARENT_ID;
        mainConstraint.addView(editText, editTextParams);

        Button sendButton = new Button(this);
        sendButton.setText("SEND");
        sendButton.setId(View.generateViewId());
        ConstraintLayout.LayoutParams sendButtonParams =
                new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                                  ViewGroup.LayoutParams.WRAP_CONTENT);
        sendButtonParams.topToBottom = editText.getId();
        sendButtonParams.leftToLeft  = ConstraintLayout.LayoutParams.PARENT_ID;
        mainConstraint.addView(sendButton, sendButtonParams);

        TextView textData = new TextView(this);
        textData.setId(View.generateViewId());
        textData.setText("DEFAULT");
        textData.setTextSize(25);
        ConstraintLayout.LayoutParams textDataParams =
                new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                                  ViewGroup.LayoutParams.WRAP_CONTENT);
        textDataParams.topToBottom = sendButton.getId();
        textDataParams.leftToLeft  = ConstraintLayout.LayoutParams.PARENT_ID;
        mainConstraint.addView(textData, textDataParams);

        Button getButton = new Button(this);
        getButton.setText("GET");
        ConstraintLayout.LayoutParams getButtonParams =
                new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                                  ViewGroup.LayoutParams.WRAP_CONTENT);
        getButtonParams.topToBottom = textData.getId();
        getButtonParams.leftToLeft  = ConstraintLayout.LayoutParams.PARENT_ID;
        mainConstraint.addView(getButton, getButtonParams);

        SharedPreferences settings = getSharedPreferences(KEY_OPTIONS, MODE_PRIVATE);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor settingsEditor = settings.edit();
                settingsEditor.putString(KEY_OPTIONS, editText.getText().toString());
                settingsEditor.apply();
            }
        });


        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textData.setText(settings.getString(KEY_OPTIONS, "NOT DEFINE"));
            }
        });

        setContentView(mainConstraint);
    }
}
