package com.example.messenger;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.util.concurrent.locks.ReentrantLock;

public class MainActivity extends AppCompatActivity {

    TextView name;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        LinearLayout linearLayout = new LinearLayout(this);
//        LinearLayout.LayoutParams perks = new LinearLayout.LayoutParams(150, 150, 1);
//
//        TextView textView = new TextView(this);
//        textView.setText("1st Text");
//        textView.setTextSize(50);
////        linearLayout.addView(textView, perks);
////        setContentView(linearLayout);
//
//
//        RelativeLayout relativeLayout = new RelativeLayout(this);
//        EditText editText = new EditText(this);
//        editText.setId(RelativeLayout.generateViewId());
//        RelativeLayout.LayoutParams editTextParams = new RelativeLayout.LayoutParams(500, 100);
//        editTextParams.addRule(RelativeLayout.CENTER_VERTICAL);
//        editTextParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
//
//        Button button = new Button(this);
//        button.setText("SEND");
//        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(200, 100);
//        buttonParams.addRule(RelativeLayout.RIGHT_OF, editText.getId());
//
//        relativeLayout.addView(editText, editTextParams);
//        relativeLayout.addView(button, buttonParams);
//        setContentView(relativeLayout);


//        GridLayout gridLayout = new GridLayout(this);
//        //gridLayout.setRowCount(5);
//        gridLayout.setColumnCount(3);
//
//        int i = 0;
//        for(i = 0; i < 20; i++) {
//
//            Button button = new Button(this);
//            button.setText("Button #" + i);
//            gridLayout.addView(button);
//        }
//
//        setContentView(gridLayout);


        //setContentView(R.layout.activity_main);

//        ScrollView scrollView = new ScrollView(this);
//
//        TextView textView = new TextView(this);
//        textView.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry...like Aldus PageMaker including versions of Lorem Ipsum." +
//                "Lorem Ipsum is simply dummy text of the printing and typesetting industry...like Aldus PageMaker including versions of Lorem Ipsum." +
//                "Lorem Ipsum is simply dummy text of the printing and typesetting industry...like Aldus PageMaker including versions of Lorem Ipsum." +
//                "Lorem Ipsum is simply dummy text of the printing and typesetting industry...like Aldus PageMaker including versions of Lorem Ipsum." +
//                "Lorem Ipsum is simply dummy text of the printing and typesetting industry...like Aldus PageMaker including versions of Lorem Ipsum." +
//                "Lorem Ipsum is simply dummy text of the printing and typesetting industry...like Aldus PageMaker including versions of Lorem Ipsum." +
//                "Lorem Ipsum is simply dummy text of the printing and typesetting industry...like Aldus PageMaker including versions of Lorem Ipsum." +
//                "Lorem Ipsum is simply dummy text of the printing and typesetting industry...like Aldus PageMaker including versions of Lorem Ipsum." +
//                "Lorem Ipsum is simply dummy text of the printing and typesetting industry...like Aldus PageMaker including versions of Lorem Ipsum." +
//                " Lorem Ipsum is simply dummy text of the printing and typesetting industry...like Aldus PageMaker including versions of Lorem Ipsum." +
//                "Lorem Ipsum is simply dummy text of the printing and typesetting industry...like Aldus PageMaker including versions of Lorem Ipsum." +
//                "Lorem Ipsum is simply dummy text of the printing and typesetting industry...like Aldus PageMaker including versions of Lorem Ipsum.");
//        textView.setLayoutParams(new ViewGroup.LayoutParams
//                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        textView.setTextSize(26);
//        scrollView.addView(textView);
//        setContentView(scrollView);

//        RelativeLayout relativeLayout = new RelativeLayout(this);
//        RelativeLayout.LayoutParams textRelativeLayoutParams =
//                new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//        TextView textView = new TextView(this);
//        textView.setText("Text");
//        textView.setId(View.generateViewId());
//
//        relativeLayout.addView(textView, textRelativeLayoutParams);
//
//        TextView textView1 = new TextView(this);
//        textView1.setText("Text22");
//        textView1.setId(View.generateViewId());
//
//        RelativeLayout.LayoutParams text1RelativeLayoutParams =
//                new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        text1RelativeLayoutParams.addRule(RelativeLayout.BELOW, textView.getId());
//        relativeLayout.addView(textView1, text1RelativeLayoutParams);
//
//        TextView textView2 = findViewById(R.id.testTextView);
//        textView2.setText("fslkdfsld");
//
//        setContentView(relativeLayout);



//        setContentView(R.layout.activity_main);
//        TextView textView2 = (TextView) findViewById(R.id.id2);
//        textView2.setText("HELLO, WORLD !!!");
        
//        Toast toast = Toast.makeText(this, "Hello, world !", Toast.LENGTH_LONG);
//        toast.show();
        //setContentView(R.layout.activity_main);

//        ConstraintLayout constraintLayout = new ConstraintLayout(this);
//        ConstraintLayout.LayoutParams buttonParams = new ConstraintLayout.LayoutParams(400, 100);
//        constraintLayout.setId(View.generateViewId());
//        buttonParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
//
//        Display display = getWindowManager().getDefaultDisplay();
//
//
//        Button button = new Button(this);
//        button.setText("CLICK");
//        constraintLayout.addView(button, buttonParams);
//
////        RelativeLayout relativeLayout = new RelativeLayout(this);
////        RelativeLayout.LayoutParams snackBarParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
////        snackBarParams.addRule(RelativeLayout.BELOW);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Snackbar snackbar = Snackbar.make(findViewById(constraintLayout.getId()), "True answer", 10000);
//                snackbar.setActionTextColor(0XFF81C784);
//                snackbar.show();
//                snackbar.setAction("next question", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                        Snackbar snackbar1 = Snackbar.make(view, "new window with quetion.", Snackbar.LENGTH_LONG);
//                        snackbar1.show();
//                    }
//                });
//            }
//        });
//
//        setContentView(constraintLayout);


//        RelativeLayout relativeLayout = new RelativeLayout(this);
//        relativeLayout.setId(View.generateViewId());
//
//        TextView textView = new TextView(this);
//        textView.setId(RelativeLayout.generateViewId());
//        textView.setText("CLICK");
//        RelativeLayout.LayoutParams textParams =
//                new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        textParams.addRule(RelativeLayout.CENTER_VERTICAL);
//
//        CheckBox checkBox = new CheckBox(this);
//        checkBox.setText("ON");
//
//        RelativeLayout.LayoutParams checkBoxParams =
//                new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        checkBoxParams.addRule(RelativeLayout.RIGHT_OF, textView.getId());
//        checkBoxParams.addRule(RelativeLayout.CENTER_IN_PARENT, textView.getId());
//
//        relativeLayout.addView(textView, textParams);
//        relativeLayout.addView(checkBox, checkBoxParams);
//
//        checkBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if(checkBox.isChecked()) {
//
//                    checkBox.setText("OFF");
//                    textView.setText("UNCHECK");
//                }
//
//                else {
//
//                    checkBox.setText("ON");
//                    textView.setText("CHECK");
//                }
//
//                Snackbar snackbar = Snackbar.make(findViewById(relativeLayout.getId()), "True answer", 10000);
//                snackbar.setActionTextColor(0XFF81C784);
//                snackbar.show();
//                snackbar.setAction("next question", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                        Snackbar snackbar1 = Snackbar.make(view, "new window with quetion.", Snackbar.LENGTH_LONG);
//                        snackbar1.show();
//                    }
//                });
//            }
//        });
//
//        setContentView(relativeLayout);


//        RelativeLayout relativeLayout = new RelativeLayout(this);
//        relativeLayout.setId(View.generateViewId());
//
//        RelativeLayout.LayoutParams seekBarParams =
//                new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//        SeekBar seekBar = new SeekBar(this);
//        seekBar.setId(View.generateViewId());
//        seekBar.setMax(100);
//        seekBar.setProgress(25);
//
//
//        TextView textView = new TextView(this);
//        textView.setId(View.generateViewId());
//        textView.setText(String.valueOf(seekBar.getProgress()));
//
//        TextView textVolume = new TextView(this);
//        textVolume.setText("VOLUME:  ");
//
//        RelativeLayout.LayoutParams textVolumeParams =
//                new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//        RelativeLayout.LayoutParams textParams =
//                new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//        seekBarParams.addRule(RelativeLayout.CENTER_IN_PARENT);
//        textParams.addRule(RelativeLayout.BELOW, seekBar.getId());
//        textParams.addRule(RelativeLayout.CENTER_HORIZONTAL, seekBar.getId());
//        textVolumeParams.addRule(RelativeLayout.LEFT_OF, textView.getId());
//        textVolumeParams.addRule(RelativeLayout.BELOW, seekBar.getId());
//
//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//
//                textView.setText(String.valueOf(seekBar.getProgress()));
//
//                if(seekBar.getProgress() > 75) {
//
//                    Snackbar snackbar = Snackbar.make(findViewById(relativeLayout.getId()),
//                            "it's loud.",
//                            Snackbar.LENGTH_LONG);
//
//                    snackbar.setActionTextColor(0XFF81C784);
//                    snackbar.show();
//                    snackbar.setAction("Yes", new View.OnClickListener() {
//
//                        @Override
//                        public void onClick(View view) {
//
//                            seekBar.setProgress(45);
//                            textView.setText(String.valueOf(seekBar.getProgress()));
//                        }
//                    });
//                }
//
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
//
//        relativeLayout.addView(seekBar, seekBarParams);
//        relativeLayout.addView(textView, textParams);
//        relativeLayout.addView(textVolume, textVolumeParams);
//        setContentView(relativeLayout);


        //Resources res = getResources();
//        TextView textView = new TextView(this);
//        textView.setText(getString(R.string.app_name));
//        setContentView(textView);


//        ConstraintLayout constraintLayout = new ConstraintLayout(this);
//        ConstraintLayout.LayoutParams layoutParams =
//                new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                                                  ViewGroup.LayoutParams.WRAP_CONTENT);
//
//        Button button = new Button(this);
//        button.setText("CLICK");
//
//        layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
//        layoutParams.rightToRight   = ConstraintLayout.LayoutParams.PARENT_ID;
//        constraintLayout.addView(button, layoutParams);
//
//        Intent intent = new Intent(this, SecondActivity.class);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                startActivity(intent);
//            }
//        });
//
//        setContentView(constraintLayout);


//        RelativeLayout relativeLayout = new RelativeLayout(this);
//
//        EditText editText = new EditText(this);
//        editText.setId(View.generateViewId());
//        RelativeLayout.LayoutParams editTextParams =
//                new RelativeLayout.LayoutParams(400,
//                                                ViewGroup.LayoutParams.WRAP_CONTENT);
//        editTextParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
//        editTextParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
//
//        Button button = new Button(this);
//        button.setText("NEXT");
//        RelativeLayout.LayoutParams buttonParams =
//                new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                                                ViewGroup.LayoutParams.WRAP_CONTENT);
//        buttonParams.addRule(RelativeLayout.RIGHT_OF, editText.getId());
//
//        relativeLayout.addView(editText, editTextParams);
//        relativeLayout.addView(button, buttonParams);
//
//        Intent intent = new Intent(this, SecondActivity.class);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                intent.putExtra("text", editText.getText().toString());
//                startActivity(intent);
//            }
//        });
//
//
//        setContentView(relativeLayout);


        RelativeLayout relativeLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                                ViewGroup.LayoutParams.WRAP_CONTENT);
        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

        Button button = new Button(this);
        button.setId(View.generateViewId());
        button.setText("INPUT");

        name = new TextView(this);
        name.setText("Your name is ");
        RelativeLayout.LayoutParams nameParams =
                new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                                ViewGroup.LayoutParams.WRAP_CONTENT);
        nameParams.addRule(RelativeLayout.RIGHT_OF, button.getId());

        Intent intent = new Intent(this, SecondActivity.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivityForResult(intent, 1);
            }
        });

        relativeLayout.addView(button, buttonParams);
        relativeLayout.addView(name, nameParams);
        setContentView(relativeLayout);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        String Name = data.getStringExtra("name");
        name.setText("Your name is " + Name.toString() + ".");
    }
}
