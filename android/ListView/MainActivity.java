package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Product> productsArrayList = new ArrayList<Product>();
        productsArrayList.add(new Product("New Balance 327", 12000, R.drawable.newbalance584));
        productsArrayList.add(new Product("New Balance 550", 19000, R.drawable.newbalance584));

        ListView productsList = findViewById(R.id.listView);
        ProductAdapter productAdapter = new ProductAdapter(this, R.layout.items, productsArrayList);
        productsList.setAdapter(productAdapter);
    }
}
