package com.example.thanhkhoa.savemoney;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LapPhieuListAdapter extends ArrayAdapter {
    Context context;
    int layout;
    ArrayList<ListItem> arrayList;
    public LapPhieuListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<ListItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.arrayList = objects;
        this.layout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ListItem listItem =arrayList.get(position);
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(layout,null);
        }
        TextView textView = convertView.findViewById(R.id.txt_listitem);
        textView.setText(listItem.getName());
        ImageView imageView = convertView.findViewById(R.id.lp_list_img);
        imageView.setImageResource(listItem.getId());
        return convertView;
    }
}
