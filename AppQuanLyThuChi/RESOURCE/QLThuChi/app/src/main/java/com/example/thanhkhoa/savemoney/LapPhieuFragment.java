package com.example.thanhkhoa.savemoney;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class LapPhieuFragment extends Fragment {

    ListView listView;
    ArrayList<ListItem> arrayList;
    ArrayAdapter adapter;
    TextView taikhoan;
    TextView hangmuc;
    TextView date;
    ActionBar actionBar;
    EditText tien;
    Button luu;
    ImageView img,image_hangmuc;
    Spinner spinner;
    List<String> listspin;
    int tong=0;
    //nhận dữ liệu
    TaiKhoanItem taiKhoanItemResult=null;
    HangMucChiCon mucChiConResult=null;
    HangMucThuItem hangMucThuItemResult=null;
    String urladd,urlPT;
//    String urladd = "http://172.20.10.6:8080/androidwebservice/setPhieuChi.php";
    public LapPhieuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view   =  inflater.inflate(R.layout.fragment_lap_phieu, container, false);

        KetNoi kn = new KetNoi();
        urladd = kn.getChuoikn()+"setPhieuChi.php";
        urlPT = kn.getChuoikn()+"setPhieuThu.php";
        actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle("Lập phiếu chi");
        spinner = view.findViewById(R.id.spinner3);
        loadSpiner();

        arrayList = new ArrayList<ListItem>();

        taikhoan = view.findViewById(R.id.txt_taikhoan);

        hangmuc = view.findViewById(R.id.txt_hangmuc);

        date = view.findViewById(R.id.txt_date);

        luu = view.findViewById(R.id.btn_save);

        image_hangmuc = view.findViewById(R.id.img_hangmuc);


        tien = view.findViewById(R.id.edt_tien);

        luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sotien  =  tien.getText().toString().trim();
                String ngay = date.getText().toString().trim();
                String mucchi = hangmuc.getText().toString().trim();
                String tk = taiKhoanItemResult.getTentk().toString().trim();
                Log.d("mylog",sotien+"\n"+ngay);
                if (sotien.isEmpty() || ngay.isEmpty()|| mucchi.isEmpty()||tk.isEmpty())
                {
                    Toast.makeText(getActivity(),"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_LONG).show();

                }
                else
                {
                    if (spinner.getSelectedItem().toString()=="Phiếu chi") {

                        ThemPhieuChi(urladd);
                    }
                    else
                        ThemPhieuThu(urlPT);


                }
            }
        });


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChonNgay();
                Toast.makeText(getActivity(),date.getText().toString().trim(),Toast.LENGTH_LONG).show();
            }
        });

        hangmuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent();
                if(spinner.getSelectedItem().toString()=="Phiếu chi") {
                    intent = new Intent(getActivity(), HangMucSpinerActivity.class);
                }
                if(spinner.getSelectedItem().toString()=="Phiếu thu")
                {
                    intent = new Intent(getActivity(), HangMucThuActivity.class);

                }
                startActivityForResult(intent,100);
            }
        });
        taikhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  =new Intent(getActivity(),TaiKhoanActivity.class);
                startActivityForResult(intent,100);
            }
        });



        return view;

    }

    /// lay du lieu tai khoan
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100 && resultCode==101){
            taiKhoanItemResult = (TaiKhoanItem) data.getSerializableExtra("dulieutt");
            taikhoan.setText(taiKhoanItemResult.getTentk());
        }
        if (requestCode == 100 && resultCode ==102)
        {
            mucChiConResult = (HangMucChiCon) data.getSerializableExtra("data");
            hangmuc.setText(mucChiConResult.getTenMucChiCon());
            Glide.with(getActivity())
                    .load(mucChiConResult.getIconCon())
                    .override(100,80)// Uri of the picture
                    .into(image_hangmuc);
        }
        if(requestCode == 100 && resultCode ==105)
        {
            hangMucThuItemResult = (HangMucThuItem) data.getSerializableExtra("datahangmuc");
            hangmuc.setText(hangMucThuItemResult.getTenmucthu());
            Glide.with(getActivity())
                    .load(hangMucThuItemResult.getHinh())
                    .override(100,80)// Uri of the picture
                    .into(image_hangmuc);
        }
    }

    private void ChonNgay()
    {
        final Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(calendar.DATE);
        int thang = calendar.get(calendar.MONTH);
        int nam = calendar.get(calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(i,i1,i2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                date.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }

    private  void ThemPhieuChi(String url)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest=  new StringRequest(Request.Method.POST,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if (response.trim().equals("success"))
                        {
                            Toast.makeText(getActivity(),"Thêm thành công",Toast.LENGTH_LONG).show();
//                            startActivity(new Intent(ThemTaiKhoanActivity.this,TaiKhoanActivity.class));

                        }
                        else
                            Toast.makeText(getActivity(),"Thêm thành công",Toast.LENGTH_LONG).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(),"Xảy ra lỗi",Toast.LENGTH_LONG).show();
                        Log.d("AAA","Lỗi \n"+error.toString());

                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();
                params.put("tien",tien.getText().toString().trim());
                params.put("ngaylap",date.getText().toString().trim());
                params.put("idtaikhoan", String.valueOf(taiKhoanItemResult.getID()).trim());
                params.put("idmucchi",String.valueOf(mucChiConResult.getID()).trim());
                params.put("tienconlai",String.valueOf(tong ).trim());

                return params;
            }
        };
        requestQueue.add(stringRequest);


    }

    private int KiemTraTien(TaiKhoanItem item , String tien)
    {
        try{
            int s1 = item.getSoduht();
            int s2 = Integer.parseInt(tien);

            tong = s1-s2;

        }
        catch (Exception ex)
        {
            Toast.makeText(getActivity(),"Dữ liệu lỗi",Toast.LENGTH_LONG).show();

        }
        return 1;
    }

    private  void loadSpiner()
    {
        listspin = new ArrayList<String>();
        listspin.add("Phiếu chi");
        listspin.add("Phiếu thu");
        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item,listspin);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spinner.getSelectedItem().toString()=="Phiếu chi") {
                    if(!hangmuc.getText().toString().isEmpty())
                    {
                        hangmuc.setText(null);
                    }
                    tien.setTextColor(Color.parseColor("#FF0000"));
                }
                if (spinner.getSelectedItem().toString()=="Phiếu thu")
                {
                    if(!hangmuc.getText().toString().isEmpty())
                    {
                        hangmuc.setText(null);
                    }
                    tien.setTextColor(Color.parseColor("#00FF00"));
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void ThemPhieuThu(String url)
    {

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest=  new StringRequest(Request.Method.POST,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if (response.trim().equals("success"))
                        {
                            Toast.makeText(getActivity(),"Thêm thành công",Toast.LENGTH_LONG).show();
//                            startActivity(new Intent(ThemTaiKhoanActivity.this,TaiKhoanActivity.class));

                        }
                        else
                            Toast.makeText(getActivity(),"Thêm thành công",Toast.LENGTH_LONG).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(),"Xảy ra lỗi",Toast.LENGTH_LONG).show();
                        Log.d("AAA","Lỗi \n"+error.toString());

                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();
                params.put("tien",tien.getText().toString().trim());
                params.put("ngaylap",date.getText().toString().trim());
                params.put("idtaikhoan", String.valueOf(taiKhoanItemResult.getID()).trim());
                params.put("idmucthu",String.valueOf(hangMucThuItemResult.getID()).trim());

                return params;
            }
        };
        requestQueue.add(stringRequest);

    }


}
