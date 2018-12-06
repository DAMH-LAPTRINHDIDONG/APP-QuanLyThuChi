package com.example.thanhkhoa.savemoney;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LoaiTaiKhoanActivity extends AppCompatActivity {

    ArrayList<LoaiTkItem> arrayList;
    LoaiTKAdapter adapter;
    ListView listView;
    String urlgetdata ;
    ActionBar actionBar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loai_tai_khoan);

        KetNoi kn = new KetNoi();
        urlgetdata = kn.getChuoikn()+"getdatabase.php";

        listView = findViewById(R.id.lst_loaitk);
        actionBar = getSupportActionBar();

        actionBar.setTitle("Chọn loại tài khoản");
        arrayList = new ArrayList<>();
        adapter = new LoaiTKAdapter(arrayList,R.layout.loaitk_row,this);
        getData(urlgetdata);
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(LoaiTaiKhoanActivity.this,arrayList.get(i)+"" , Toast.LENGTH_SHORT).show();
                getListItem(i);


            }
        });

    }

    private void getData(String url)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
//                Toast.makeText(LoaiTaiKhoanActivity.this,response.toString(),Toast.LENGTH_LONG).show();
                for (int  i = 0 ; i< response.length() ;i++)
                {
                    try {

                        JSONObject object = response.getJSONObject(i);
                        arrayList.add(new LoaiTkItem(object.getInt("ID"),object.getString("TenTK"),object.getString("Icon")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(LoaiTaiKhoanActivity.this,"Lỗi",Toast.LENGTH_LONG).show();
            }
        }

        );
        requestQueue.add(jsonArrayRequest);
    }

    private void getListItem(int position)
    {

        LoaiTkItem item = arrayList.get(position);
        Intent intent = new Intent(LoaiTaiKhoanActivity.this,ThemTaiKhoanActivity.class);
        intent.putExtra("dulieu",item);
        setResult(101,intent);
        finish();
    }
}
