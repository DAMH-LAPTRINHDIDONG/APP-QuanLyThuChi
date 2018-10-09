package com.example.thuyduong.setmymoney;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class CustomExpandleListView extends BaseExpandableListAdapter {
    Context context;
    List<ExpandItem> listHeader;
    HashMap<ExpandItem,List<ExpandItem>> listChild;

    public CustomExpandleListView(Context context, List<ExpandItem> listHeader, HashMap<ExpandItem, List<ExpandItem>> listChild) {
        this.context = context;
        this.listHeader = listHeader;
        this.listChild = listChild;
    }

    @Override
    public int getGroupCount() {
        return listHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listChild.get(listHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listChild.get(listHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ExpandItem headertitle = (ExpandItem) getGroup(groupPosition);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.groupview_hangmuc,null);
        TextView txtheader = convertView.findViewById(R.id.txtHeader);
        txtheader.setText(headertitle.getName());
        ImageView imageView = convertView.findViewById(R.id.groupicon);
        imageView.setImageResource(headertitle.getId());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ExpandItem child = (ExpandItem) getChild(groupPosition,childPosition);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.childview_hangmuc,null);
        TextView txtchild = convertView.findViewById(R.id.txtChild);
        txtchild.setText(child.getName());
        ImageView imageView = convertView.findViewById(R.id.item_icon);
        imageView.setImageResource(child.getId());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
