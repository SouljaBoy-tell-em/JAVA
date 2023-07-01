package com.example.shop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

public class Product {

    private String          name;
    private double         price;
    private int resourceDrawable;

    public Product(String name, double price, int resourceDrawable) {

        this.name             =             name;
        this.price            =            price;
        this.resourceDrawable = resourceDrawable;
    }

    public ConstraintLayout OptionsProduct(Context context) {

        ConstraintLayout constraintLayout = new ConstraintLayout(context);


        ImageView imageProduct = new ImageView(context);
        imageProduct.setId(View.generateViewId());
        imageProduct.setImageResource(this.resourceDrawable);
        ConstraintLayout.LayoutParams imageProductParams = new ConstraintLayout.LayoutParams(200, 200);
        imageProductParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        imageProductParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
        imageProductParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        constraintLayout.addView(imageProduct, imageProductParams);


        TextView nameText = new TextView(context);
        nameText.setId(View.generateViewId());
        nameText.setText(this.name);
        ConstraintLayout.LayoutParams nameTextParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        nameTextParams.topToTop = imageProduct.getId();
        nameTextParams.leftToRight = imageProduct.getId();


        TextView priceText = new TextView(context);
        priceText.setText("PRICE: " + this.price + "$");
        ConstraintLayout.LayoutParams priceTextParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        priceTextParams.topToBottom = nameText.getId();
        priceTextParams.leftToRight = imageProduct.getId();

        constraintLayout.addView(imageProduct, imageProductParams);
        constraintLayout.addView(nameText, nameTextParams);
        constraintLayout.addView(priceText, priceTextParams);

        return constraintLayout;

    }

    public String getName()  { return this.name;}
    public double getPrice() { return this.price;}
    public int getResourceDrawable() {return this.resourceDrawable;}
    public void setName(String name) {this.name = name;}
    public void setPrice(double price) {this.price = price;}
    public void setResourceDrawable(int resourceDrawable) {this.resourceDrawable = resourceDrawable;}
}
