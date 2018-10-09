package com.example.thuyduong.setmymoney;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HangMucActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<ExpandItem> listdataheader;
    HashMap<ExpandItem, List<ExpandItem>> listdatachild;
    CustomExpandleListView customExpandleListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hang_muc);
        addControl();
        customExpandleListView = new CustomExpandleListView(HangMucActivity.this,listdataheader,listdatachild);
        expandableListView.setAdapter(customExpandleListView);
    }

    private void addControl() {
        expandableListView = findViewById(R.id.exlist);
        listdataheader = new ArrayList<>();
        listdatachild= new HashMap<ExpandItem, List<ExpandItem>>();

        listdataheader.add(new ExpandItem(R.drawable.food,"Ăn uống"));
        listdataheader.add(new ExpandItem(R.drawable.kid,"Con cái"));
        listdataheader.add(new ExpandItem(R.drawable.relax,"Hưởng thụ"));
        List<ExpandItem> anuong = new ArrayList<ExpandItem>();
        anuong.add(new ExpandItem(R.drawable.antiem,"Ăn tiệm"));
        anuong.add(new ExpandItem(R.drawable.coffe,"Cà phê"));
        anuong.add(new ExpandItem(R.drawable.shopping,"Đi chợ/Siêu thị"));
        List<ExpandItem> concai = new ArrayList<ExpandItem>();
        concai.add(new ExpandItem(R.drawable.toy,"Đồ chơi"));
        concai.add(new ExpandItem(R.drawable.shoolfee,"Học phí"));
        concai.add(new ExpandItem(R.drawable.book,"Sách vở"));
        List<ExpandItem> huongthu = new ArrayList<ExpandItem>();
        huongthu.add(new ExpandItem(R.drawable.travel,"Du lịch"));


        listdatachild.put(listdataheader.get(0),anuong);
        listdatachild.put(listdataheader.get(1),concai);
        listdatachild.put(listdataheader.get(2),huongthu);




    }
}
