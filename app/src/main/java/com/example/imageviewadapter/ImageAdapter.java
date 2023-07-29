package com.example.imageviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class ImageAdapter extends ArrayAdapter<ImageClass> {

    private LayoutInflater inflater;
    private int layout;
    private List<ImageClass> images;

    public ImageAdapter(@NonNull Context context, int resource, @NonNull List<ImageClass> images) {
        super(context, resource, images);

        this.images   =                       images;
        this.layout   =                     resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(this.layout, parent, false);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView  productName = view.findViewById(R.id.name);

        ImageClass imageClass = images.get(position);
        imageView.setImageResource(imageClass.getResource());
        productName.setText("product");

        return view;
    }
}
