package com.example.thanhkhoa.savemoney;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThemTaiKhoanActivity extends AppCompatActivity {

    TextView textView,Tiente;
    EditText soduBD,tenTK;
    ActionBar actionBar;
    Button button;
    //Item chua du lieu tra ve
    LoaiTkItem loaiTkItemResult;
    TienTe tienTeResult;
    //
    String url ;
    ///
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_tai_khoan);

        KetNoi kn = new KetNoi();
        url = kn.getChuoikn()+"setTaiKhoan.php";
        //
        soduBD = findViewById(R.id.edt_sodubd);
        textView = findViewById(R.id.txt_loaitk);
        button = findViewById(R.id.btn_save_tk);
        tenTK = findViewById(R.id.edt_tentk);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  =new Intent(ThemTaiKhoanActivity.this,LoaiTaiKhoanActivity.class);
                startActivityForResult(intent,100);
            }
        });

        Tiente = findViewById(R.id.txt_tiente);
        Tiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  =new Intent(ThemTaiKhoanActivity.this,TienTeActivity.class);
                startActivityForResult(intent,100);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sodu = soduBD.getText().toString().trim();
                String ten =  tenTK.getText().toString().trim();
                if (loaiTkItemResult==null || tienTeResult ==null|| sodu.isEmpty()||ten.isEmpty())
                {
                    Toast.makeText(ThemTaiKhoanActivity.this,"Vui lòng nhập đủ thông tin",Toast.LENGTH_LONG).show();
                }
                else
                {
                    ThemTaiKhoan(url);
                    finish();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode==101)
        {
            loaiTkItemResult  = (LoaiTkItem) data.getSerializableExtra("dulieu");
            textView.setText(loaiTkItemResult.getName());
        }
        if (requestCode == 100 && resultCode==102)
        {
            tienTeResult = (TienTe) data.getSerializableExtra("dulieutt");
            Tiente.setText(tienTeResult.getKyhieu());
        }

    }



    //them tài khoản
    private  void ThemTaiKhoan(String url)
    {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest=  new StringRequest(Request.Method.POST,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if (response.trim().equals("success"))
                        {
                            Toast.makeText(ThemTaiKhoanActivity.this,"Thêm thành công",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(ThemTaiKhoanActivity.this,TaiKhoanActivity.class));

                        }
                        else
                        {  Toast.makeText(ThemTaiKhoanActivity.this,"Thêm thành công",Toast.LENGTH_LONG).show();
//                            startActivity(new Intent(ThemTaiKhoanActivity.this,TaiKhoanActivity.class));

                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ThemTaiKhoanActivity.this,"Xảy ra lỗi",Toast.LENGTH_LONG).show();
                        Log.d("AAA","Lỗi \n"+error.toString());

                    }
                }
                ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("tenTK",String.valueOf(tenTK.getText()).trim());
                params.put("soduBD",String.valueOf(soduBD.getText()).trim());
                params.put("idTT", String.valueOf(tienTeResult.getId()).trim());
                params.put("idloaiTK",String.valueOf(loaiTkItemResult.getId()).trim());


                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

}
