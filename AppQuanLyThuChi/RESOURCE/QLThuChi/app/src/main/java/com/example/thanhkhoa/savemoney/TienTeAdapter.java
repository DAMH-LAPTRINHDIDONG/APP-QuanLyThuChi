package com.example.thanhkhoa.savemoney;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

public class TienTeAdapter extends BaseAdapter{
    private Context context;
    private  int layout;

    public TienTeAdapter(Context context, int layout, List<TienTe> tienTeList) {
        this.context = context;
        this.layout = layout;
        this.tienTeList = tienTeList;
    }

    private List<TienTe> tienTeList;

    @Override
    public int getCount() {
        return tienTeList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private  class ViewHolder{
        TextView txtTen,txtKyhieu;
        ImageView hinh;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if (view == null)
        {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.txtTen = view.findViewById(R.id.ten_tien_row);
            holder.txtKyhieu = view.findViewById(R.id.tien_ma_row);
            holder.hinh = view.findViewById(R.id.tiente_img);
            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }
        TienTe tienTe = tienTeList.get(i);
        holder.txtTen.setText(tienTe.getTen());
        holder.txtKyhieu.setText(tienTe.getKyhieu());
//        Picasso.with(context).load(tienTe.getHinh()).into(holder.hinh);
        Glide.with(context)
                .load(tienTe.getHinh())
                .override(100,80)// Uri of the picture
                .into(holder.hinh);
        return view;
    }
}
