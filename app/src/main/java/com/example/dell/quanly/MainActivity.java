package com.example.dell.quanly;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtusename;
    EditText edtmk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtusename = findViewById(R.id.edtusename);
        edtmk = findViewById(R.id.edtmk);

    }
    public void dangnhap(View view) {

        SharedPreferences pref = getSharedPreferences("dangnhap", MODE_PRIVATE);

        String ten = pref.getString("taikhoan", "a");
        String mk = pref.getString("matkhau", "a");
        String name = edtusename.getText().toString();
        String pasw = edtmk.getText().toString();

        startActivity(new Intent(MainActivity.this,ThongkeActivity.class));



    }
}
