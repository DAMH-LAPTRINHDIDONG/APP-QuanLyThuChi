package com.example.thanhkhoa.savemoney;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class ViewHolder extends RecyclerView.ViewHolder {
    View mView;

    public ViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
    }

    public void setDetails (Context ctx, String name,String img)
    {
        TextView ten = mView.findViewById(R.id.name);
        ImageView hinh = mView.findViewById(R.id.img);
        ten.setText(name);
        Picasso.with(ctx).load(img).into(hinh);


    }
}
