package com.example.dell.quanly.dialog;

import android.app.DatePickerDialog;
import android.content.Context;
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
import android.widget.Toast;

import com.example.dell.quanly.Database.DatabaseManager;
import com.example.dell.quanly.R;

import java.util.Calendar;

public class DiaLog_KhoanThu extends DialogFragment {
    EditText edtkhoanthu;
    Button themkhoanthu;
    Button huykhoanthu;
    DatabaseManager manager;
    Spinner spinner;
    private Cursor cursorkhoanthu;
    private SimpleCursorAdapter adapterkhoanthu;
    String LoaiThu;
    EditText sotien;
    Cursor cursor;
    SimpleCursorAdapter adapter;
    TextView tv;
    ImageView chon,xoa;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.dialog_khoanthu, container, false);

        themkhoanthu = view.findViewById(R.id.btnthemkhoanthu);
        huykhoanthu = view.findViewById(R.id.btnhuykhoanthu);
        edtkhoanthu = view.findViewById(R.id.edtkhoanthu);
        spinner = view.findViewById(R.id.spkhoanthu);
        sotien = view.findViewById(R.id.edtsotien);

        tv = view.findViewById(R.id.tv);
        chon = view.findViewById(R.id.chon);
        xoa = view.findViewById(R.id.xoa);

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


        cursorkhoanthu = manager.getLoaiThu();
        if (cursorkhoanthu != null) {
            adapterkhoanthu = new SimpleCursorAdapter(getActivity(), android.R.layout.simple_spinner_item, cursorkhoanthu,
                    new String[]{"LoaiThu"},
                    new int[]{android.R.id.text1}
            );
            spinner.setAdapter(adapterkhoanthu);

        }
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = (Cursor) parent.getItemAtPosition(position);
                LoaiThu = cursor.getString(1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        huykhoanthu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();

            }
        });


        themkhoanthu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String edkhoanthu = edtkhoanthu.getText().toString();
                String tien = sotien.getText().toString();
                String ngaythang = tv.getText().toString();

                manager.insertKhoanThu(edkhoanthu, LoaiThu, tien, ngaythang);

//                   Toast.makeText(getActivity(),"Them Thanh cong",Toast.LENGTH_SHORT).show();
                getDialog().dismiss();
            }
        });
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String edkhoanthu = edtkhoanthu.getText().toString();
                String tien = sotien.getText().toString();
                String ngaythang = tv.getText().toString();

                manager.insertKhoanThu(edkhoanthu, LoaiThu, tien, ngaythang);

//                   Toast.makeText(getActivity(),"Xoa Thanh cong",Toast.LENGTH_SHORT).show();
                getDialog().dismiss();
            }
        });

        return view;
    }

}
