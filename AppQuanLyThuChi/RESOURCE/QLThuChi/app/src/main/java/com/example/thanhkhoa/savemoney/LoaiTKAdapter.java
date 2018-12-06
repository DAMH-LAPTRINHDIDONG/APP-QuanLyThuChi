package com.example.thanhkhoa.savemoney;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class LoaiTKAdapter extends BaseAdapter {

    public LoaiTKAdapter(List<LoaiTkItem> arrayList, int layout, Context context) {
        this.arrayList = arrayList;
        this.layout = layout;
        this.context = context;
    }

    List<LoaiTkItem> arrayList;
    int layout;
    Context context;

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    class ViewHolder {
        TextView tentk;
        ImageView img;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null)
        {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.tentk = view.findViewById(R.id.txt_loaitk_row);
            holder.img = view.findViewById(R.id.img_loaitk_row);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        LoaiTkItem loaiTkItem = arrayList.get(i);
        holder.tentk.setText(loaiTkItem.getName());
//        holder.img.setImageResource(loaiTkItem.getImg());
        Glide.with(context)
                .load(loaiTkItem.getImg())
                .override(100,80)// Uri of the picture
                .into(holder.img);
        return view;
    }
}
