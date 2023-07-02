package com.example.shop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {

    private LayoutInflater inflater;
    private int layout;
    private List<Product> products;

    public ProductAdapter(Context context, int resource, List<Product> products) {

        super(context, resource, products);
        this.inflater = LayoutInflater.from(context);
        this.layout   =                     resource;
        this.products = products;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(this.layout, parent, false);

        ImageView flagView       = view.findViewById(R.id.productImage);
        flagView.setId(View.generateViewId());

        TextView productName     = view.findViewById(R.id.productName);
        productName.setId(View.generateViewId());

        TextView productPrice    = view.findViewById(R.id.productPrice);
        productPrice.setId(View.generateViewId());

        Product product = products.get(position);
        flagView.setImageResource(product.getResourceDrawable());
        productName.setText(product.getName());
        productPrice.setText("PRICE: " + product.getPrice() + "$");

        return view;
    }
}
