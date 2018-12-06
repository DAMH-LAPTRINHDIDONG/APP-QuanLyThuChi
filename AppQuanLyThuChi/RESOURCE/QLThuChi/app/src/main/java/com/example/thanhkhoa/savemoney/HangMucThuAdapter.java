package com.example.thanhkhoa.savemoney;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class HangMucThuAdapter extends BaseAdapter {

    public HangMucThuAdapter(List<HangMucThuItem> arrayList, int layout, Context context) {
        this.arrayList = arrayList;
        this.layout = layout;
        this.context = context;
    }

    List<HangMucThuItem> arrayList;
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
       TextView tenmucthu;
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
            holder.tenmucthu = view.findViewById(R.id.txt_mucthu);
            holder.img = view.findViewById(R.id.img_mucthu);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        HangMucThuItem item = arrayList.get(i);
        holder.tenmucthu.setText(item.getTenmucthu());
        Glide.with(context)
                .load(item.getHinh())
                .into(holder.img);
        return view;
    }
}
