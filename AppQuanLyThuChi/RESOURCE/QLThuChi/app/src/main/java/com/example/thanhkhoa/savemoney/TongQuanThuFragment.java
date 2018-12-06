package com.example.thanhkhoa.savemoney;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TongQuanThuFragment extends Fragment {


    String urlngay,urlthang,urlnam ;
    ActionBar actionBar;
    RadioGroup radioGroup;
    RadioButton ngay,thang,nam;
    List<String> tenhmchi;
    List<Float> tongtienchi;
    List<CharItem> list;
    ActionBar thisacctionbar;
    int n;
    float[] yData = new float[20];
     String[] xData = new String[20];
    PieChart pieChart;
    public TongQuanThuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tong_quan_thu, container, false);
        KetNoi kn = new KetNoi();
        urlngay = kn.getChuoikn()+"getTongTienChi.php";
        thisacctionbar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        thisacctionbar.setTitle("Lập phiếu chi");

        list = new ArrayList<>();
        tenhmchi = new ArrayList<>();
        tongtienchi = new ArrayList<>();
        getData(urlngay);

        for (int i = 0 ; i < list.size();i++)
            Log.d("my",list.get(i).getTongtien()+"\n"+yData[i]+"");
        pieChart = view.findViewById(R.id.idPieChart);

        pieChart.setRotationEnabled(true);
        //pieChart.setUsePercentValues(true);
        //pieChart.setHoleColor(Color.BLUE);
        //pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("Super Cool Chart");
        pieChart.setCenterTextSize(10);

        addDataSet();


        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

            }

            @Override
            public void onNothingSelected() {

            }
        });






//        Toast.makeText(getActivity(),tenhmchi.size()+"",Toast.LENGTH_SHORT).show();


        return view;
    }

    private void addDataSet() {
         ArrayList<PieEntry> yEnTrys = new ArrayList<>();
         ArrayList<String> xEntrys = new ArrayList<>();
         for (int i = 0 ; i<yData.length ;i++)
         {
             yEnTrys.add(new PieEntry(yData[i],xData[i]));
             Log.d("mulog",yData[i]+"");
//             Log.d("mulog",list.get(i).getTongtien()+"");
//             Log.d("mulog",Float.valueOf( list.get(i).tongtien+"f")+"");
         }
//         for (int i =0 ; i<xData.length;i++)
//         {
//             xEntrys.add(xData[i]);
//         }

         PieDataSet pieDataSet = new PieDataSet(yEnTrys,"Hạng mục chi");
         pieDataSet.setSliceSpace(2);
         pieDataSet.setValueTextSize(12);

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.GRAY);
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.CYAN);
        colors.add(Color.YELLOW);
        colors.add(Color.MAGENTA);

        pieDataSet.setColors(colors);

        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();

    }


    private void getData(String url)
    {
//        arrayList.clear();
        final RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Toast.makeText(getActivity(),response.toString(),Toast.LENGTH_LONG).show();
                n = response.length();
                for (int  i = 0 ; i< response.length() ;i++)
                {
                    try {

                        JSONObject object = response.getJSONObject(i);
                        list.add(new CharItem(Float.valueOf(object.getString("TongTien")+"f"),object.getString("Ten")));
                        yData[i]=Float.valueOf(object.getString("TongTien")+"f");
                        xData[i] = object.getString("Ten");
//                                     Log.d("mulog",yData[i]+"");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                Toast.makeText(getActivity(),list.size()+"",Toast.LENGTH_SHORT).show();

//                adapter.notifyDataSetChanged();
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

//    CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
//        @Override
//        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//            if(b)
//            {
//                String s = compoundButton.getText().toString();
////                Toast.makeText(getActivity(),s,Toast.LENGTH_SHORT).show();
//                if (s.equals("Ngày")) {
//                    getData(urlngay);
//                }
//                if(s.equals("Tháng"))
//                    getData(urlthang);
//
//            }
//        }
//    };
//    private void setupPieChart()
//    {
//
//    }





}
