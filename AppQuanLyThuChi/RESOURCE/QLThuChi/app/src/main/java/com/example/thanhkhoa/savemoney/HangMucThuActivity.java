package com.example.thanhkhoa.savemoney;

import android.content.Context;
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
import java.util.List;

public class HangMucThuActivity extends AppCompatActivity {

    List<HangMucThuItem> arraylist;
    ListView listView;
    HangMucThuAdapter adapter;
    String urlgetdata ;
    ActionBar actionBar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hang_muc_thu);

        KetNoi kn = new KetNoi();
        urlgetdata = kn.getChuoikn()+"getMucThu.php";
        //
        actionBar = getSupportActionBar();
        actionBar.setTitle("Chọn hạng mục thu");
        //
        listView = findViewById(R.id.list_mucthu);
        //
        arraylist = new ArrayList<>();
        adapter = new HangMucThuAdapter(arraylist,R.layout.muchthu_row,this);
        getData(urlgetdata);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(HangMucThuActivity.this, arraylist.get(i).getTenmucthu(), Toast.LENGTH_SHORT).show();

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
//                Toast.makeText(HangMucThuActivity.this,response.toString(),Toast.LENGTH_LONG).show();
                for (int  i = 0 ; i< response.length() ;i++)
                {
                    try {

                        JSONObject object = response.getJSONObject(i);
                        arraylist.add(new HangMucThuItem(object.getString("ID"),object.getString("TenMucThu"),object.getString("Hinh")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(HangMucThuActivity.this,"Lỗi",Toast.LENGTH_LONG).show();
            }
        }

        );
        requestQueue.add(jsonArrayRequest);
    }

    private void getListItem(int position)
    {

        HangMucThuItem item = arraylist.get(position);
        Intent intent = new Intent(HangMucThuActivity.this,LapPhieuFragment.class);
        intent.putExtra("datahangmuc",item);
        setResult(105,intent);
        finish();
    }
}
