package com.example.thanhkhoa.savemoney;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
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

public class HangMucSpinerActivity extends AppCompatActivity {

    Spinner spinnerHangMuc;
    ListView lst ;
    ArrayList<HangMucChiCha> arrayList;
    ArrayList<HangMucChiCon> arrayListcon;
    HangMunSpinerAdapter adapter;
    HangMucConSpinerAdapter subAdapter;
    ArrayList<HangMucChiCon> temp;

    int lc=0;
    String urlgetdata ;
    String url ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hang_muc_spiner);
        KetNoi kn = new KetNoi();
        urlgetdata = kn.getChuoikn()+"getMucChiCha.php";
        url = kn.getChuoikn()+"getMucChiCon.php";


        //
        lst = findViewById(R.id.list_muccon);
        spinnerHangMuc = findViewById(R.id.spin_hm);
        //

        arrayList = new ArrayList<>();
        arrayListcon = new ArrayList<>();

        subAdapter = new HangMucConSpinerAdapter(HangMucSpinerActivity.this,R.layout.list_item,arrayListcon);
        adapter = new HangMunSpinerAdapter(HangMucSpinerActivity.this,R.layout.list_group,arrayList);

        getData(urlgetdata);
        getDataMucCon(url);

        spinnerHangMuc.setAdapter(adapter);
        lst.setAdapter(subAdapter);

        spinnerHangMuc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(HangMucSpinerActivity.this, arrayList.get(i).getID()+"", Toast.LENGTH_SHORT).show();
                getSelected(arrayList.get(i).getID());
            }   

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(HangMucSpinerActivity.this, temp.get(i).getTenMucChiCon(), Toast.LENGTH_SHORT).show();
                getListItem(i);
            }
        });


    }

    private void getSelected(int i) {
        temp = new ArrayList<>();
        for (HangMucChiCon hmc : arrayListcon)
        {
            if (hmc.getIDMucChiCha() == i)
                temp.add(hmc);

        }
        subAdapter = new HangMucConSpinerAdapter(HangMucSpinerActivity.this,R.layout.list_item,temp);
        lst.setAdapter(subAdapter);
    }


    private void getData(String url)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int  i = 0 ; i< response.length() ;i++)
                {
                    try {

                        JSONObject object = response.getJSONObject(i);
                        int id = object.getInt("ID");
                        String ten = object.getString("TenMucChiCha");
                        String hinh = object.getString("Hinh");
                        arrayList.add(new HangMucChiCha(id,ten,hinh));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(HangMucSpinerActivity.this,"Lỗi"+ error.toString(),Toast.LENGTH_LONG).show();
            }
        }

        );
        requestQueue.add(jsonArrayRequest);
    }

    private void getDataMucCon(String url)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int  i = 0 ; i< response.length() ;i++)
                {
                    try {

                        JSONObject object = response.getJSONObject(i);
                        int id = object.getInt("ID");
                        String ten = object.getString("TenMucChiCon");
                        int idcha = object.getInt("IDMucChiCha");
                        String hinh = object.getString("Hinh");
                        arrayListcon.add(new HangMucChiCon(id,ten,hinh,idcha));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                subAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(HangMucSpinerActivity.this,"Lỗi"+ error.toString(),Toast.LENGTH_LONG).show();
            }
        }

        );
        requestQueue.add(jsonArrayRequest);
    }

    private void getListItem(int position)
    {

        HangMucChiCon item = temp.get(position);
        Intent intent = new Intent(HangMucSpinerActivity.this,LapPhieuFragment.class);
        intent.putExtra("data",item);
        setResult(102,intent);
        finish();
    }

}
