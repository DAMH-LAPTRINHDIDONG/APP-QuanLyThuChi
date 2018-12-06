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
import android.widget.Button;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class TaiKhoanFragment extends Fragment {


    ArrayList<TaiKhoanItem> arrayList;
    TaiKhoanAdapter adapter;
    ListView listView;
    String urlgetdata ;
//    String urlgetdata = "http://172.20.10.6:8080/androidwebservice/getTaiKhoan.php";
    ActionBar actionBar;
    KetNoi kn;
    public TaiKhoanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tai_khoan, container, false);
        kn  =  new KetNoi();
        urlgetdata = kn.getChuoikn()+"getTaiKhoan.php";
        actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle("Chọn tài khoản");

        arrayList = new ArrayList<>();
        listView = view.findViewById(R.id.list_taikhoan);
        adapter = new TaiKhoanAdapter(arrayList,R.layout.taikhoan_row,getActivity());
        getData(urlgetdata);
        listView.setAdapter(adapter);


        return view;
    }



    //lấy dữ liệu
    private void getData(String url)
    {
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

                Toast.makeText(getActivity(),"Lỗi"+ error.toString(),Toast.LENGTH_LONG).show();
            }
        }

        );
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.them_tk_menu, menu);  // Use filter.xml from step 1
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_addtk)
        {
            startActivity(new Intent(getActivity(),ThemTaiKhoanActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

}
