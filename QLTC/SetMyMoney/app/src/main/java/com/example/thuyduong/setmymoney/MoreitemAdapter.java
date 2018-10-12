package com.example.thuyduong.setmymoney;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MoreitemAdapter extends ArrayAdapter{

    Context context;
    int layout;
    ArrayList<MoreItem> arrayList;

    public MoreitemAdapter(@NonNull Context context, int resource, @NonNull ArrayList objects) {
        super(context, resource, objects);
        this.context =context;
        this.layout = resource;
        this.arrayList = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MoreItem item = arrayList.get(position);
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(layout,null);
        }

        ImageView img = convertView.findViewById(R.id.img);
        img.setImageResource(item.getId());
        TextView name = convertView.findViewById(R.id.name);
        name.setText(item.getName());
        return convertView;
    }



}
