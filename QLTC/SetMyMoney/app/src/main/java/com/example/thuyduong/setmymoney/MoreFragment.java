package com.example.thuyduong.setmymoney;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends ListFragment {


    ListView list;
    ArrayList<MoreItem> arrayList;
    MoreitemAdapter adapter;
    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

//        list.findViewById(R.id.list);
        InitArray();
        adapter = new MoreitemAdapter(getActivity(),R.layout.more_item,arrayList);

//        list.setAdapter(adapter);
       setListAdapter(adapter);

       return inflater.inflate(R.layout.fragment_more, container, false);



    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent;
        switch (position)
        {
            case 0:
                Toast.makeText(getActivity(), "a",Toast.LENGTH_LONG).show();
                intent = new Intent(getActivity(),HangMucActivity.class);
                startActivity(intent);

        }
        super.onListItemClick(l, v, position, id);
    }
    //    @Override
//    public void onListItemClick(ListView l, View v, int position, long id) {
//        Toast.makeText(getActivity(), "a",Toast.LENGTH_LONG).show();
//    }



    public void InitArray()
    {
        arrayList =new ArrayList<MoreItem>();
        arrayList.add(new MoreItem(R.drawable.list,"Danh sách hạng mục"));
        arrayList.add(new MoreItem(R.drawable.tiente,"Danh sách tiền tệ"));
        arrayList.add(new MoreItem(R.drawable.mail,"Gửi thư góp ý"));
        arrayList.add(new MoreItem(R.drawable.ques,"Hướng dẫn sử dụng"));
        arrayList.add(new MoreItem(R.drawable.updata,"Lưu dữ liệu"));
        arrayList.add(new MoreItem(R.drawable.sync,"Đồng bộ dữ liệu"));
        arrayList.add(new MoreItem(R.drawable.logout,"Đăng xuất"));

    }
}
