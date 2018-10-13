package com.example.thuyduong.setmymoney;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ThemhangmucchiActivity extends AppCompatActivity {
  ImageButton btn;
   public static ArrayList<Imagess> arrayList;
    ImageView imagenhan;
    int REQUEST_CODE_IMAGE = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themhangmucchi);
        imagenhan=findViewById(R.id.imgnhan);
       // String[] mangten = getResources().getStringArray(R.array.list_name);
        // arrayList=new ArrayList<>(Arrays.asList(mangten));
   ///     int idHinh=getResources().getIdentifier(arrayName.get(5),"drawable",getPackageName());
      //  imagenhan.setImageResource(idHinh);
        imagenhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemhangmucchiActivity.this, IconActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100 && resultCode==101)
        {
            int tenHinhNhan= Integer.parseInt(data.getStringExtra("id"));
            Toast.makeText(ThemhangmucchiActivity.this,tenHinhNhan+"aaa",Toast.LENGTH_LONG).show();
        }

    }
    //
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        if(requestCode==REQUEST_CODE_IMAGE&& resultCode==RESULT_OK &&data!=null)
//        {
//            int tenHinhNhan= Integer.parseInt(data.getStringExtra("id"));
//            Toast.makeText(ThemhangmucchiActivity.this,tenHinhNhan+"aaa",Toast.LENGTH_LONG).show();
//        //    int idHinhNhan=getResources().getIdentifier("id","drawable",getPackageName());
//
////            imagenhan = new ImageView(tenHinhNhan);
//
//
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }
//        @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode==100&&requestCode==101)
//        {
////            btn.setImageDrawable(null);
//           // btn.setBackgroundResource(Integer.parseInt(i));
//        }
//    }
}
