package com.example.dell.quanly;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.quanly.FragmentAdapter.QuanLyChiAdapter;

public class Quanly_Chi_Fragment extends Fragment {

    TabLayout tbqlchi;
    ViewPager vpqlchi;
    QuanLyChiAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.quanly_chi_layout,container,false);

        tbqlchi=view.findViewById(R.id.tbqlchi);
        vpqlchi=view.findViewById(R.id.vpqlchi);

        adapter=new QuanLyChiAdapter(getChildFragmentManager());

        vpqlchi.setAdapter(adapter);
        tbqlchi.setupWithViewPager(vpqlchi);


        return view;
    }
}
