package com.example.thuyduong.setmymoney;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

//public  class ChoniconAdapter extends BaseAdapter{
//    private  Context context;
//    private int layout;
//    private List<Images> imagesList;
//
//    public ChoniconAdapter(Context context, int layout, List<Images> imagesList) {
//        this.context = context;
//        this.layout = layout;
//        this.imagesList = imagesList;
//    }
//
//    public ChoniconAdapter(Context c, int gridicon, ArrayList<Images> arrayList){
//        context =c;
//
//    }
//    public ChoniconAdapter(Context c,Integer[]arrIds){
//        context=c;
//
//    }
//
//
//    @Override
//    public int getCount() {
//        return imagesList.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return 0;
//    }
//
//    private class ViewHolder{
//        ImageView imgHinh;
//    }
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        ViewHolder hoder;
//        if(view==null)
//        {
//            hoder = new ViewHolder();
//            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            view=inflater.inflate(layout,null);
//            hoder.imgHinh=(ImageView)view.findViewById(R.id.imgbtn);
//            view.setTag(hoder);
//        }
//        else {
//           hoder=(ViewHolder)view.getTag();
//        }
//            Images images=imagesList.get(i);
//        hoder.imgHinh.setImageResource(images.getImg());
//        return null;
//    }
//}

public class ChoniconAdapter extends ArrayAdapter {
    Context context;
    ArrayList<Imagess> arrayList;
    int layout;
    public ChoniconAdapter(@NonNull Context context, int resource,@NonNull ArrayList<Imagess>objects)
    {
        super(context,resource,objects);
        this.context=context;
        this.arrayList=objects;
        this.layout=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(layout,null);

        }
        ImageView imge=convertView.findViewById(R.id.image);
        imge.setImageResource(arrayList.get(position).getImage());
        return convertView;
    }
}
