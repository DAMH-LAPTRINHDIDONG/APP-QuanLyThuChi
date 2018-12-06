package com.example.thanhkhoa.savemoney;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

public class TaiKhoanActivity extends AppCompatActivity {

    ArrayList<TaiKhoanItem> arrayList;
    TaiKhoanAdapter adapter;
    ListView listView;
    String urlgetdata ;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tai_khoan);

        KetNoi kn = new KetNoi();
        urlgetdata = kn.getChuoikn()+"getTaiKhoan.php";

        actionBar = getSupportActionBar();
        actionBar.setTitle("Chọn tài khoản");

        arrayList = new ArrayList<>();
        listView = findViewById(R.id.list_taikhoan);
        adapter = new TaiKhoanAdapter(arrayList,R.layout.taikhoan_row,TaiKhoanActivity.this);
//        getData(urlgetdata);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(TienTeActivity.this,arrayList.get(i)+"" , Toast.LENGTH_SHORT).show();
                getListItem(i);


            }
        });
    }


    //lấy dữ liệu
    private void getData(String url)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
//                Toast.makeText(TaiKhoanActivity.this,response.toString(),Toast.LENGTH_LONG).show();
                for (int  i = 0 ; i< response.length() ;i++)
                {
                    try {

                        JSONObject object = response.getJSONObject(i);
                        int id = object.getInt("ID");
                        int idtt = object.getInt("IDTienTe");
                        int idltt = object.getInt("IDLoaiTK");
                        String ten = object.getString("TenTK");
                        int sdbd = object.getInt("SoDuBD");
                        int sdht = object.getInt("SoDuHT");
                        arrayList.add(new TaiKhoanItem(id,idtt,idltt,ten,sdbd,sdht,R.drawable.wallet));
                        Log.d("B",id+"\n"+idltt+"\n"+idltt+"\n"+ten+"\n"+sdbd+"\n"+sdht);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(TaiKhoanActivity.this,"Lỗi"+ error.toString(),Toast.LENGTH_LONG).show();
            }
        }

        );
        requestQueue.add(jsonArrayRequest);
    }

    private void getListItem(int position)
    {

        TaiKhoanItem item = arrayList.get(position);
        Intent intent = new Intent(TaiKhoanActivity.this,LapPhieuFragment.class);
        intent.putExtra("dulieutt",item);
        setResult(101,intent);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        arrayList.clear();
        getData(urlgetdata);
        adapter.notifyDataSetChanged();
    }

    ///menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menu_addtk)
        {
            startActivity(new Intent(TaiKhoanActivity.this,ThemTaiKhoanActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.them_tk_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }
}
