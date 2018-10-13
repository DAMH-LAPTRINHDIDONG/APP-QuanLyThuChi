package com.example.thuyduong.setmymoney;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class LoaiTaiKhoanActivity extends AppCompatActivity {

    ListView list;
    ArrayList<IconTK> arrayList;
    IconTKAdapter iconAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loai_tai_khoan);

        ImageView imageView = (ImageView)findViewById(R.id.imageBack);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),HangMucActivity.class);
                startActivity(intent);
            }
        });


        list=findViewById(R.id.list);

        arrayList=IconTK.initIconTK();
        iconAdapter=new IconTKAdapter(LoaiTaiKhoanActivity.this,R.layout.layout_row,arrayList);

        list.setAdapter(iconAdapter);
    }
}
