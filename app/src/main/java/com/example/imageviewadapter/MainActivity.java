package com.example.imageviewadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ImageClass> images = new ArrayList<>();
        images.add(new ImageClass(R.drawable.product));
        images.add(new ImageClass(R.drawable.product));
        images.add(new ImageClass(R.drawable.product));
        images.add(new ImageClass(R.drawable.product));
        images.add(new ImageClass(R.drawable.product));
        images.add(new ImageClass(R.drawable.product));

        ListView imageList = findViewById(R.id.imageList);
        ImageAdapter imageAdapter = new ImageAdapter(this, R.layout.item, images);
        imageList.setAdapter(imageAdapter);
    }
}