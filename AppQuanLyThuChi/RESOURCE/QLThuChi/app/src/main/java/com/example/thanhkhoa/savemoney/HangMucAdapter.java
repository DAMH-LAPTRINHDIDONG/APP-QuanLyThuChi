package com.example.thanhkhoa.savemoney;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.List;

public class HangMucAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<HangMucChiCha> listDataHeader;
    private HashMap<HangMucChiCha,List<HangMucChiCon>> listHashMap;

    public HangMucAdapter(Context context, List<HangMucChiCha> listDataHeader, HashMap<HangMucChiCha, List<HangMucChiCon>> listHashMap) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listHashMap  =listHashMap;
    }

    @Override
    public int getGroupCount() {
        return listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int i) {

        return listHashMap.get(listDataHeader.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return listDataHeader.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return listHashMap.get(listDataHeader.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
       HangMucChiCha headTitle = (HangMucChiCha) getGroup(i);
       if (view == null)
       {
           LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           view = inflater.inflate(R.layout.list_group,null);
       }
        TextView lblListHeader = view.findViewById(R.id.lblListHeader);
       lblListHeader.setTypeface(null, Typeface.BOLD);
       lblListHeader.setText(headTitle.getTenMucChiCha());
//        ImageView headimg = view.findViewById(R.id.imgListHead);
//        Glide.with(context)
//                .load(loaiTkItem.getImg())
//                .override(100,80)// Uri of the picture
//                .into(holder.img);
        return  view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        final HangMucChiCon child = (HangMucChiCon) getChild(i,i1);
        if (view == null)
        {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item,null);
        }

        TextView txtListChild = view.findViewById(R.id.lblListItem);
        txtListChild.setText(child.getTenMucChiCon());

        return  view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
