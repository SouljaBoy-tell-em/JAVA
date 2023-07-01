package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        ConstraintLayout[] productsLayout = {(new Product("New Balance 584", 12000, R.drawable.newbalance584)).OptionsProduct(this),
//                                             (new Product("New Balance 327", 19000, R.drawable.newbalance327)).OptionsProduct(this)};
//
//        ListView listProducts = new ListView(this);
//        ArrayAdapter<ConstraintLayout> listProductsAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, productsLayout);
//        listProducts.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
//        listProducts.setAdapter(listProductsAdapter);
//        setContentView(listProducts);
    }
}
