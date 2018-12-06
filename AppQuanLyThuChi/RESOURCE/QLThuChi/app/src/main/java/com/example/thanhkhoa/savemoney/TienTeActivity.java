package com.example.thanhkhoa.savemoney;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

public class TienTeActivity extends AppCompatActivity {

    ArrayList<TienTe> arrayList;
    TienTeAdapter adapter;
    ListView listView;
    String urlgetdata ;
    ActionBar actionBar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tien_te);

        KetNoi kn = new KetNoi();
        urlgetdata = kn.getChuoikn()+"getTienTe.php";


        listView = findViewById(R.id.lst_tiente);
        actionBar = getSupportActionBar();

        actionBar.setTitle("Chọn loại tiền tệ");
        arrayList = new ArrayList<>();
        getData(urlgetdata);
        adapter  = new TienTeAdapter(this,R.layout.tiente_row,arrayList);


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(TienTeActivity.this,arrayList.get(i)+"" , Toast.LENGTH_SHORT).show();
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
//                Toast.makeText(TienTeActivity.this,response.toString(),Toast.LENGTH_LONG).show();
//                Log.d("tien",response.toString());
                for (int  i = 0 ; i< response.length() ;i++)
                {
                    try {

                        JSONObject object = response.getJSONObject(i);
                        int id = object.getInt("ID");
                        String tentt = object.getString("TenTT");
                        String kyhieu = object.getString("KyHieu");
                        String tigia = object.getString("TiGia");
                        String hinh = object.getString("Hinh");
                        arrayList.add(new TienTe(id,kyhieu,tentt,hinh,tigia));
                        Log.d("tien",tentt+"\n"+kyhieu+"\n"+tigia+"\n"+hinh);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(TienTeActivity.this,"Lỗi",Toast.LENGTH_LONG).show();
            }
        }

        );
        requestQueue.add(jsonArrayRequest);
    }

    private void getListItem(int position)
    {

        TienTe item = arrayList.get(position);
        Intent intent = new Intent(TienTeActivity.this,ThemTaiKhoanActivity.class);
        intent.putExtra("dulieutt",item);
        setResult(102,intent);
        finish();
    }
}
