package com.example.shop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;

public class Product {

    private String          name;
    private double         price;
    private int resourceDrawable;

    public Product(String name, double price, int resourceDrawable) {

        this.name             =             name;
        this.price            =            price;
        this.resourceDrawable = resourceDrawable;
    }

    public String getName()  { return this.name;}
    public double getPrice() { return this.price;}
    public int getResourceDrawable() {return this.resourceDrawable;}
    public void setName(String name) {this.name = name;}
    public void setPrice(double price) {this.price = price;}
    public void setResourceDrawable(int resourceDrawable) {this.resourceDrawable = resourceDrawable;}
}
