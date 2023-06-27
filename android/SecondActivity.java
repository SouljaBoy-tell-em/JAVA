package com.example.messenger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams textParams =
                new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                                ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView textView = new TextView(this);
        Bundle bundle = getIntent().getExtras();
        textView.setText(bundle.get("text").toString());
        textParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        textParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

        ImageView imageView= new ImageView(this);
        imageView.setImageResource(R.drawable.vasav);
        RelativeLayout.LayoutParams imageParams = new RelativeLayout.LayoutParams(200, 200);
        imageParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        imageParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        relativeLayout.addView(textView, textParams);
        relativeLayout.addView(imageView, imageParams);
        setContentView(relativeLayout);
    }
}
