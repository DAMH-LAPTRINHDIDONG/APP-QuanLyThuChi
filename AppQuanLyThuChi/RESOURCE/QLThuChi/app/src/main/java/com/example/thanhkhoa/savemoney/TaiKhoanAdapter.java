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

import java.util.ArrayList;
import java.util.List;

public class TaiKhoanAdapter extends BaseAdapter {

    public TaiKhoanAdapter(List<TaiKhoanItem> arrayList, int layout, Context context) {
        this.arrayList = arrayList;
        this.layout = layout;
        this.context = context;
    }

    List<TaiKhoanItem> arrayList;
    int layout;
    Context context;

    @Override
    public int getCount() {
//        return 0;
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
        TextView sdbd;
        TextView sdht;
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
            holder.tentk = view.findViewById(R.id.taikhoan_ten_row);
            holder.sdbd = view.findViewById(R.id.taikhoan_sodubd_row);
            holder.sdht = view.findViewById(R.id.taikhoan_soduht_row);
            holder.img = view.findViewById(R.id.taikhoan_img_row);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        TaiKhoanItem taiKhoanItem = arrayList.get(i);
        holder.tentk.setText(taiKhoanItem.getTentk());
        holder.sdbd.setText("Số dư ban đầu  "+String.valueOf(taiKhoanItem.getSodubd())+"đ");
        holder.sdht.setText("Số dư hiện tại "+String.valueOf(taiKhoanItem.getSoduht())+"đ");
        holder.img.setImageResource(taiKhoanItem.getImg());

        return view;
    }
}
