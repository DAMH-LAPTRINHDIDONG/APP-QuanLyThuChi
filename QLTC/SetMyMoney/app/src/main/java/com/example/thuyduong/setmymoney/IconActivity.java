package com.example.thuyduong.setmymoney;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static java.util.Collections.*;

public class IconActivity extends AppCompatActivity {

    TableLayout myTable;

    ListView listView;
    ArrayList<Imagess> arrayList1;
    ChoniconAdapter choniconAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon);

        listView = findViewById(R.id.listview);
        arrayList1 = new ArrayList<>();
        arrayList1.add(new Imagess(R.drawable.box));
        arrayList1.add(new Imagess(R.drawable.box));
        arrayList1.add(new Imagess(R.drawable.box));
        arrayList1.add(new Imagess(R.drawable.face));


        choniconAdapter = new ChoniconAdapter(IconActivity.this,
                                                R.layout.hangmucitem_row,
                                                    arrayList1);
        listView.setAdapter(choniconAdapter);



    }
}
