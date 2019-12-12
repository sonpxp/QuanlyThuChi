package com.example.dell.quanly.dialog;

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

public class DiaLog_loaithu extends DialogFragment {
    private DatabaseManager manager;
    Button btkoaithu, bthuyloaithu;
    EditText edtloaithu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_loaithu, container, false);

        btkoaithu = view.findViewById(R.id.btnthemloaithu);
        bthuyloaithu = view.findViewById(R.id.btnhuylt);
        edtloaithu = view.findViewById(R.id.edtloaithu);

        manager = new DatabaseManager(getActivity());

        bthuyloaithu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        btkoaithu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loaithu = edtloaithu.getText().toString();

                manager.insertLoaiThu(loaithu);
                getDialog().dismiss();
            }
        });


        return view;
    }
}
