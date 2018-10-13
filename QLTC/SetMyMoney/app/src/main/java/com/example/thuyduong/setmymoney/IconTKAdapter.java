package com.example.thuyduong.setmymoney;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class IconTKAdapter extends ArrayAdapter {
    Context context;
    ArrayList<IconTK> arrayList;
    int layout;

    public IconTKAdapter(@NonNull Context context, int resource, @NonNull ArrayList<IconTK> object)
    {
        super(context,resource,object);
        this.context = context;
        this.arrayList=object;
        this.layout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        IconTK icon = arrayList.get(position);

        if (convertView ==null) {
            convertView = LayoutInflater.from(context).inflate(layout, null);
        }
            ImageView img = convertView.findViewById(R.id.imageIcon);
            img.setImageResource(icon.getId());
            TextView txt=convertView.findViewById(R.id.iconName);
            txt.setText(icon.getName());

            return convertView;
        }
    }

