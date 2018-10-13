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

import static com.example.thuyduong.setmymoney.R.id.themtaikhoanName;

public class ThemtaikhoanAdapter extends ArrayAdapter {
    Context context;
    ArrayList<Themtaikhoan> arrayList;
    int layout;



    public ThemtaikhoanAdapter(@NonNull Context context,int resource, ArrayList<Themtaikhoan> object)
    {
        super(context, resource, object);
        this.context=context;
        this.arrayList=object;
        this.layout=resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Themtaikhoan themtaikhoan=arrayList.get(position);
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(layout,null);
        }
        ImageView img= convertView.findViewById(R.id.imagethemtaikhoan);
        img.setImageResource(themtaikhoan.getId());
        TextView txt=convertView.findViewById(themtaikhoanName);
        txt.setText(themtaikhoan.getName());
        ImageView arr= convertView.findViewById(R.id.icon_arr);
        arr.setImageResource(themtaikhoan.getId2());
        return convertView;
    }
}
