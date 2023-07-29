package com.example.test;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment {

    private Creater creater;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        creater = (Creater) context;
    }

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        String name = getArguments().getString("keyname");
        long code = getArguments().getLong("keycode");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                creater.CreateCard(name, code);
            }
        });

        return builder.create();
    }
}
