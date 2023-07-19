package com.example.messenger;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        RelativeLayout relativeLayout = new RelativeLayout(this);
//        RelativeLayout.LayoutParams textParams =
//                new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                                                ViewGroup.LayoutParams.WRAP_CONTENT);
//        TextView textView = new TextView(this);
//        Bundle bundle = getIntent().getExtras();
//        textView.setText(bundle.get("text").toString());
//        textParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
//        textParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
//
//        ImageView imageView= new ImageView(this);
//        imageView.setImageResource(R.drawable.vasav);
//        RelativeLayout.LayoutParams imageParams = new RelativeLayout.LayoutParams(200, 200);
//        imageParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
//        imageParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
//
//        relativeLayout.addView(textView, textParams);
//        relativeLayout.addView(imageView, imageParams);
//        setContentView(relativeLayout);

        RelativeLayout relativeLayout = new RelativeLayout(this);

        EditText editText = new EditText(this);
        editText.setId(View.generateViewId());
        RelativeLayout.LayoutParams editTextParams =
                new RelativeLayout.LayoutParams(400,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
        editTextParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        editTextParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

        Button button = new Button(this);
        button.setText("CONFIRM");
        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
        buttonParams.addRule(RelativeLayout.RIGHT_OF, editText.getId());

        relativeLayout.addView(editText, editTextParams);
        relativeLayout.addView(button, buttonParams);

        Intent intent = new Intent(this, SecondActivity.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent.putExtra("name", editText.getText().toString());
                setResult(RESULT_OK, intent); // отправление в родительское Activity
                finish();
            }
        });

        setContentView(relativeLayout);
    }
}
