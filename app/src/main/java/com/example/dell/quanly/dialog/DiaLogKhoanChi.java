package com.example.dell.quanly.dialog;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dell.quanly.Database.DatabaseManager;
import com.example.dell.quanly.R;

import java.util.Calendar;

public class DiaLogKhoanChi extends DialogFragment {

    EditText edtkhoanchi;
    EditText edtgia;
    Button themkhoanchi;
    Button huykhoanchi;
    DatabaseManager manager;
    Spinner spinner;
    private Cursor cursorkhoanchi;
    private SimpleCursorAdapter adapterkhoanchi;
    String LoaiChi;
    TextView tv;
    ImageView chon;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_khoanchi, container, false);

        edtkhoanchi = view.findViewById(R.id.edtthemkhoanchi);
        themkhoanchi = view.findViewById(R.id.btnthemkhoanchi);
        huykhoanchi = view.findViewById(R.id.btnhuykhoanchi);
        spinner = view.findViewById(R.id.spkhoanchi);
        edtgia = view.findViewById(R.id.edtgia);

        tv = view.findViewById(R.id.tv);
        chon = view.findViewById(R.id.chon);

        chon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar cal = Calendar.getInstance();
                int Year = cal.get(Calendar.YEAR);
                int Month = cal.get(Calendar.MONTH);
                int Day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog date = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        if (month <13){
                            month++;
                        }

                        String stringOfDate = dayOfMonth + "/" + month + "/" + year;
                        tv.setText(tv.getText() + "\n " + stringOfDate);

                    }


                }, Year, Month, Day);

                date.show();

            }
        });


        manager = new DatabaseManager(getActivity());

        cursorkhoanchi = manager.getLoaiChi();
        if (cursorkhoanchi != null) {
            adapterkhoanchi = new SimpleCursorAdapter(getActivity(), android.R.layout.simple_spinner_item, cursorkhoanchi,
                    new String[]{"LoaiChi"},
                    new int[]{android.R.id.text1}
            );
            spinner.setAdapter(adapterkhoanchi);

        }
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = (Cursor) parent.getItemAtPosition(position);
                LoaiChi = cursor.getString(1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        huykhoanchi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();

            }
        });


        themkhoanchi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String edkhoanchi = edtkhoanchi.getText().toString();
                String edsotien = edtgia.getText().toString();
                String ngaythang = tv.getText().toString();

                manager.insertKhoanChi(edkhoanchi, LoaiChi, edsotien, ngaythang);

//                   Toast.makeText(getActivity(),"Them Thanh cong",Toast.LENGTH_SHORT).show();
//
                getDialog().dismiss();
            }
        });


        return view;
    }
}
