package com.example.thanhkhoa.savemoney;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;
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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class HangMucActivity extends AppCompatActivity {

    private ExpandableListView listView;
    HangMucAdapter adapter;
    List<HangMucChiCha> listDataHeader;

    HashMap<HangMucChiCha,List<HangMucChiCon>> listHash;

    String urlgetdata = "http://172.20.10.6:8080/androidwebservice/test.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hang_muc);

        listView = findViewById(R.id.lvEx);
        getData(urlgetdata);

//        loadListData();
        adapter = new HangMucAdapter(this,listDataHeader,listHash);
        listView.setAdapter(adapter);
    }

    private void getData(String url)
    {
        listDataHeader  = new ArrayList<>();
        listHash = new HashMap<>();

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Toast.makeText(HangMucActivity.this,response.toString(),Toast.LENGTH_LONG).show();
                for (int  i = 0 ; i< response.length() ;i++)
                {
                    try {
                        HangMucChiCha itemcha=null;
                        HangMucChiCon itemcon=null;
                        JSONObject object = response.getJSONObject(i);
                        int id = object.getInt("0");
                        String tenmuccha = object.getString("1");
                        JSONArray jsonArray = object.getJSONArray("b");
                        itemcha = new HangMucChiCha(id,tenmuccha);
                        listDataHeader.add(itemcha);
                        List<HangMucChiCon> listDataItem = new ArrayList<>();
                        for (int j = 0; j<jsonArray.length();i++)
                        {

                            JSONObject sub = jsonArray.getJSONObject(i);
                            int idcon = sub.getInt("ID");
                            String tenmuccon = sub.getString("TenMucChiCon");
                            int idcha = sub.getInt("IDMucChiCha");
                            itemcon  =new HangMucChiCon(idcon,tenmuccon,idcha);

                            listDataItem.add(itemcon);
                            Log.d("con",listDataHeader.get(i)+"");

                        }
                        listHash.put(listDataHeader.get(0),listDataItem);
                        adapter.notifyDataSetChanged();
                        Log.d("cha",id +"\n"+tenmuccha+"\n");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(HangMucActivity.this,"Lỗi"+ error.toString(),Toast.LENGTH_LONG).show();
            }
        }

        );
        requestQueue.add(jsonArrayRequest);
    }

    private void loadListData() {
        listDataHeader = new ArrayList<HangMucChiCha>();
        listHash = new HashMap<HangMucChiCha, List<HangMucChiCon>>();

        // Adding group header data
        listDataHeader.add(new HangMucChiCha("An"));
        listDataHeader.add(new HangMucChiCha("Ngu"));
        listDataHeader.add(new HangMucChiCha("Nghi"));
        // Adding child data
        List<HangMucChiCon> movies = new ArrayList<HangMucChiCon>();
        movies.add(new HangMucChiCon("COn"));
        movies.add(new HangMucChiCon("COn"));
        movies.add(new HangMucChiCon("COn"));

        List<HangMucChiCon> music = new ArrayList<HangMucChiCon>();
        movies.add(new HangMucChiCon("COn"));
        movies.add(new HangMucChiCon("COn"));
        movies.add(new HangMucChiCon("COn"));

        List<HangMucChiCon> books = new ArrayList<HangMucChiCon>();
        movies.add(new HangMucChiCon("COn"));
        movies.add(new HangMucChiCon("COn"));
        movies.add(new HangMucChiCon("COn"));

        // Group header, Child data
        listHash.put(listDataHeader.get(0), movies);
        listHash.put(listDataHeader.get(3), music);
        listHash.put(listDataHeader.get(2), books);
    }
}
