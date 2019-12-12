package com.example.dell.quanly;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class giowiThieu_Fragmrnt extends Fragment {
    ListView lvgt;
    private ArrayAdapter arrayAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.gioithieu_fragment, container, false);

        lvgt=view.findViewById(R.id.lvgt);

        String[] values = new String[] { "Loại Bài: Assigment android", "Tên Bài: Quản Lý Chi tiêu", "ngày xuất bản :2019","Cảm Ơn Bạn Đã Sử Dụng APP" };
        arrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values);
        lvgt.setAdapter(arrayAdapter);
        return view;
    }
}
