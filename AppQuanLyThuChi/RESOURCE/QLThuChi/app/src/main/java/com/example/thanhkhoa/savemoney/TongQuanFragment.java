package com.example.thanhkhoa.savemoney;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TongQuanFragment extends Fragment {

    ArrayList<TongQuanItem> arrayList;
    TongQuanAdapter adapter;
    ListView listView;
    String urlngay,urlthang,urlnam ;
    String urlthungay,urlthuthang,urlthunam ;
    ActionBar actionBar;
    RadioGroup radioGroup;
    RadioButton ngay,thang,nam;
    Button thu,chi;
    Spinner spiner;
    List<String> listspin;
    public TongQuanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view   =  inflater.inflate(R.layout.fragment_tong_quan, container, false);
        actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle("Tổng quan chi");




        KetNoi kn = new KetNoi();
        urlngay = kn.getChuoikn()+"getPhieuChingay.php";
        urlthang = kn.getChuoikn()+"getPhieuChiThang.php";
        urlnam = kn.getChuoikn()+"getPhieuChinam.php";
        urlthungay = kn.getChuoikn()+"getPhieuThungay.php";
        urlthuthang = kn.getChuoikn()+"getPhieuThuthang.php";
        urlthunam = kn.getChuoikn()+"getPhieuThunam.php";
        arrayList = new ArrayList<>();

        listView = view.findViewById(R.id.list_chitiet);
        radioGroup = view.findViewById(R.id.rd_group);
        spiner = view.findViewById(R.id.spinner);
        loadSpiner();

        ngay = view.findViewById(R.id.rd_day);
        thang = view.findViewById(R.id.rd_month);
        nam = view.findViewById(R.id.rd_year);


        ngay.setOnCheckedChangeListener(listener);
        thang.setOnCheckedChangeListener(listener);
        nam.setOnCheckedChangeListener(listener);

        getData(urlngay);
        adapter = new TongQuanAdapter(arrayList,R.layout.tongquan_row,getActivity());

        listView.setAdapter(adapter);

//


        return view;

    }






    private void getData(String url)
    {
        arrayList.clear();
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
//                Toast.makeText(getActivity(),response.toString(),Toast.LENGTH_LONG).show();
                for (int  i = 0 ; i< response.length() ;i++)
                {
                    try {

                        JSONObject object = response.getJSONObject(i);
                        int id = object.getInt("ID");
                        int tien = object.getInt("Tien");
                        String ngay = object.getString("NgayLap");
                        String tentk = object.getString("TenTK");
                        String tencon = object.getString("TenMucChiCon");
                        String hinh = object.getString("Hinh");
                        arrayList.add(new TongQuanItem(id,tien,tentk,tencon,ngay,hinh));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getActivity(),"Lỗi"+ error.toString(),Toast.LENGTH_LONG).show();
            }
        }

        );
        requestQueue.add(jsonArrayRequest);
    }

    private  void loadSpiner()
    {
        listspin = new ArrayList<String>();
        listspin.add("Tổng quan chi");
        listspin.add("Tổng quan thu");
        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item,listspin);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spiner.setAdapter(adapter);
        spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spiner.getSelectedItem().toString()=="Tổng quan chi") {
                    if(ngay.isChecked())
                        getData(urlngay);
                    if(thang.isChecked())
                        getData(urlthang);
                    if(nam.isChecked())
                        getData(urlnam);

                }
                if(spiner.getSelectedItem().toString()=="Tổng quan thu") {
                    if(ngay.isChecked())
                        getData(urlthungay);
                    if(thang.isChecked())
                        getData(urlthuthang);
                    if(nam.isChecked())
                        getData(urlthunam);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }



    CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(b)
            {
                String s = compoundButton.getText().toString();
//                Toast.makeText(getActivity(),s,Toast.LENGTH_SHORT).show();
                if (s.equals("Ngày")) {
                    if(spiner.getSelectedItem().toString()=="Tổng quan chi") {
                        getData(urlngay);
                    }
                    else
                        getData(urlthungay);
                }
                if(s.equals("Tháng"))
                    if(spiner.getSelectedItem().toString()=="Tổng quan chi"){
                        getData(urlthang);
                }
                    else
                        getData(urlthuthang);

                if(s.equals("Năm"))
                    if(spiner.getSelectedItem().toString()=="Tổng quan chi"){
                        getData(urlnam);}
                        else
                        getData(urlthunam);


            }
        }
    };





}
