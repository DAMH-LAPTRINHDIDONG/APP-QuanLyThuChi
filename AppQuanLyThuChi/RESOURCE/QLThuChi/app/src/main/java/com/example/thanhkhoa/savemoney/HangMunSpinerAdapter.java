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

public class HangMunSpinerAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<HangMucChiCha> list;

    public HangMunSpinerAdapter(Context context, int layout, List<HangMucChiCha> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
        TextView tenhm;
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
            holder.tenhm = view.findViewById(R.id.lblListHeader);
            holder.img = view.findViewById(R.id.imgListHead);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        HangMucChiCha item = list.get(i);
        holder.tenhm.setText(item.getTenMucChiCha());
        Glide.with(context)
                .load(item.getIconCha())
                .into(holder.img);
        return  view;
    }
}
