package com.example.dell.quanly;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.dell.quanly.Database.DatabaseManager;
import com.example.dell.quanly.dialog.DiaLog_LoaiChi;

public class LoaiChi_Fragment extends Fragment {
    ListView lvloaichi;
    FloatingActionButton flloaichi;
    DatabaseManager manager;
    Cursor cursor;
    SimpleCursorAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.loaichi_fragment,container,false);

        lvloaichi=view.findViewById(R.id.lvloaichi);
        flloaichi=view.findViewById(R.id.flloaichi);


        manager=new DatabaseManager(getActivity());

       cursor= manager.getLoaiChi();

        if (cursor != null) {
            adapter = new android.widget.SimpleCursorAdapter(getActivity(),
                    R.layout.xulythuchi_layout,
                    cursor,
                    new String[]{"LoaiChi"},
                    new int[]{R.id.tvten});

            lvloaichi.setAdapter(adapter);
           adapter.notifyDataSetChanged();
       }


        flloaichi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiaLog_LoaiChi diaLogLoaiChi=new DiaLog_LoaiChi();
                diaLogLoaiChi.show(getFragmentManager(),"dialog");
            }
        });

        return view;
    }
}
