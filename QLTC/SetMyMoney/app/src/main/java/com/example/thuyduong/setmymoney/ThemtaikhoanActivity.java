package com.example.thuyduong.setmymoney;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ThemtaikhoanActivity extends AppCompatActivity {

    ListView listview;
    ArrayList arrayList;
    ArrayAdapter themtaikhoanAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themtaikhoan);
        listview=findViewById(R.id.lst);
        arrayList=Themtaikhoan.initThemtaikhoan();
        themtaikhoanAdapter= new ThemtaikhoanAdapter(ThemtaikhoanActivity.this,R.layout.listthemtaikhoan,arrayList);

        listview.setAdapter(themtaikhoanAdapter);



    }
}
