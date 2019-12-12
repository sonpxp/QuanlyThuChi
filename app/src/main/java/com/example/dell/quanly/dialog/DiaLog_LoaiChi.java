package com.example.dell.quanly.dialog;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.dell.quanly.Database.DatabaseManager;
import com.example.dell.quanly.R;

public class DiaLog_LoaiChi extends DialogFragment {
    Button btnthemloaichi, btnhuyLoaichi;
    EditText edtloaichi;
    DatabaseManager manager;
    Cursor cursor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_loaichi, container, false);
        btnthemloaichi = view.findViewById(R.id.btnthemloaichi);
        btnhuyLoaichi = view.findViewById(R.id.btnhuylchi);
        edtloaichi = view.findViewById(R.id.edtloaichi);

        manager = new DatabaseManager(getActivity());

        btnhuyLoaichi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        btnthemloaichi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loaichi = edtloaichi.getText().toString();

                manager.insertLoaiChi(loaichi);
                getDialog().dismiss();
            }
        });


        return view;
    }
}
