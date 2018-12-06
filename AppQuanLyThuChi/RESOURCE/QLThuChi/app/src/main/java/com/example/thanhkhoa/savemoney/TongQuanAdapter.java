package com.example.thanhkhoa.savemoney;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TongQuanAdapter extends BaseAdapter{

    public TongQuanAdapter(List<TongQuanItem> arrayList, int layout, Context context) {
        this.arrayList = arrayList;
        this.layout = layout;
        this.context = context;
    }

    List<TongQuanItem> arrayList;
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
        TextView tentk,tenmuc,tien,ngay;
        ImageView img;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null)
        {
            holder = new  ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.tentk = view.findViewById(R.id.txt_tentk);
            holder.tenmuc = view.findViewById(R.id.txt_tenhm);
            holder.ngay = view.findViewById(R.id.txt_ngay);
            holder.tien = view.findViewById(R.id.txt_mon);
            holder.img = view.findViewById(R.id.tq_img);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        TongQuanItem item = arrayList.get(i);
        holder.tentk.setText(item.getTentk());
        holder.tenmuc.setText(item.getTenhm());
        holder.ngay.setText(item.getNgay());
        holder.tien.setText(String.valueOf(item.getTien()));

//        holder.img.setImageResource(loaiTkItem.getImg());
        Glide.with(context)
                .load(item.getHinh())
                .into(holder.img);
        return view;
    }

}
