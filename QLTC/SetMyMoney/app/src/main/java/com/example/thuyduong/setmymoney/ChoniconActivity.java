package com.example.thuyduong.setmymoney;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
/// moi
//public  class ChoniconActivity extends AppCompatActivity {
//    GridView gv;
//    ArrayList<File> list;
//    public void onClick(Bundle saveInstanceState) {
//        super.onCreate(saveInstanceState);
//        setContentView(R.layout.activity_chonicon);
//        list=imageReader( Environment.getExternalStorageDirectory());
//        gv=(GridView)findViewById(R.id.gridview);
//        gv.setAdapter(new GridAdapter());
//        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                startActivity(new Intent(getApplicationContext(),Main2Activity.class).putExtra("img",list.get(position).toString()));
//            }
//        });
//
//
//    }
//    class GridAdapter extends BaseAdapter{
//
//        @Override
//        public int getCount() {
//            return list.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return list.get(position);
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//       // @SuppressLint("ViewHolder")
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            convertView =getLayoutInflater().inflate(R.layout.gridicon,parent,false);
//            ImageView iv=convertView.findViewById(R.id.imgbtn);
//            iv.setImageURI(Uri.parse(getItem(position).toString()));
//            return convertView;
//        }
//    }
//    ArrayList<File> imageReader(File root){
//        ArrayList<File> a=new ArrayList<>();
//        File[] files=root.listFiles();
//        for(int i=0;i<files.length;i++)
//        {
//            if(files[i].isDirectory())
//            {
//                a.addAll(imageReader(files[i]));
//            }
//            else {
//                if(files[i].getName().endsWith(".png"))
//                {
//                    a.add(files[i]);
//                }
//            }
//        }
//        return a;
//
//
//    }
//}
//////

public class ChoniconActivity extends AppCompatActivity {

    ListView listitem;
    int item;
    Integer[] lstIDImg;
    int[] intArray;
    ArrayList<Images> arrayList;
    ChoniconAdapter adapter;
    ImageView imgContext;
    Bundle myBackupBundle;




    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chonicon);
        listitem = findViewById(R.id.listview);
        listitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChoniconActivity.this,ThemhangmucchiActivity.class);


            }
        });
       // arrayList = Images.intit();
////chay dk
//        arrayList = new ArrayList<>();
//        arrayList.add(new Images(R.drawable.arrowsicon, "hinh so 1"));
//        arrayList.add(new Images(R.drawable.arrowsicon, "hinh so 1"));
//        arrayList.add(new Images(R.drawable.arrowsicon, "hinh so 1"));
//        arrayList.add(new Images(R.drawable.arrowsicon, "hinh so 1"));
//        arrayList.add(new Images(R.drawable.arrowsicon, "hinh so 1"));
//        arrayList.add(new Images(R.drawable.arrowsicon, "hinh so 1"));

       // adapter = new ChoniconAdapter(this, R.layout.gridicon, arrayList);
       // gridView.setAdapter(adapter);
//       gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//           @Override
//           public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
//               Toast.makeText(ChoniconActivity.this,arrayList.get(i).getImg(),Toast.LENGTH_SHORT);
//           }
//       });

        //chay
        //   gridView.setOnClickListener(ChoniconActivity.this);
        //  lstIDImg= new Integer[]{R.drawable.face,R.drawable.email,R.drawable.purse,
        //        R.drawable.payment,R.drawable.arrowsicon

        // };//chay
        //  gridView=findViewById(R.id.grid);
        //  adapter= new adapter(this,lstIDImg);
        // gridView.setAdapter(adapter);
//        intArray = new int[lstIDImg.length];
//        for(int i=0;i<lstIDImg.length;i++)
//        {
//            intArray[i]=lstIDImg[i].intValue();
//            gridView.setOnClickListener(ChoniconActivity.this);
//        }
        //  }


//    @Override
//    public void onClick(View v) {
//        Intent intent = new Intent(ChoniconActivity.this, ThemhangmucchiActivity.class);
////         intent.putExtra("")
////        this.startActivities(intent);
//    }


//}
    }
}

   