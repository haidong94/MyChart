package com.example.qtht.mychart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.qtht.mychart.model.ChiPhi;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

import static com.example.qtht.mychart.R.id.chart;

/**
 * Created by qtht on 28/04/2017.
 */

public class ChartThongTinTongHopChiPhiHuyenActivity extends AppCompatActivity {
    Toolbar toolbar;
    CombinedChart combinedChart;
    TextView tvchart;
    ArrayList<ChiPhi> list=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart_activity);

        Bundle bundle = getIntent().getExtras();
        list = bundle.getParcelableArrayList("list");

        addControl();
        addEvent();
    }

    private void addEvent() {
        CombinedData data = new CombinedData(getXAxisValues());
        data.setData(barData());
        data.setData(lineData());
        combinedChart.setData(data);
        combinedChart.setNoDataText("Chưa có dữ liệu cho biểu đồ");
        combinedChart.setNoDataTextDescription("Chưa lấy được dữ liệu từ service");
        combinedChart.animateXY(2000,2000);
        combinedChart.setDescription("");

        combinedChart.zoom(0,0,0.5f,0.5f);

    }
    private LineData lineData(){
        ArrayList<Entry> line=new ArrayList<>();

        for(ChiPhi duLieu:list)
        {
            line.add(new Entry(Float.parseFloat(duLieu.getTONGBHTHANHTOAN()),list.indexOf(duLieu)));
        }

        LineDataSet lineDataSet=new LineDataSet(line,"Tổng bảo hiểm thanh toán");
       // lineDataSet.setLineWidth(2.5f);
        lineDataSet.setCircleColor(Color.rgb(240, 238, 70));
        lineDataSet.setFillColor(Color.rgb(240, 238, 70));
        lineDataSet.setDrawValues(true);
        lineDataSet.setColor(Color.rgb(81, 31, 144));
       // lineDataSet.setDrawCubic(true);
        LineData lineData = new LineData(getXAxisValues(),lineDataSet);
        return lineData;

    }

    private BarData barData() {
        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        for(ChiPhi duLieu:list)
        {
            BarEntry v1e1 = new BarEntry(Float.parseFloat(duLieu.getTONGCHIPHI()), list.indexOf(duLieu)); // Jan
            valueSet1.add(v1e1);

        }

        BarDataSet barDataSet = new BarDataSet(valueSet1, "Tổng chi phí");
        barDataSet.setColor(Color.rgb(0, 155, 123));
        BarData barData=new BarData(getXAxisValues(),barDataSet);
        return barData;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        for(ChiPhi dulieu:list){
            xAxis.add(dulieu.getTYT());
        }
        return xAxis;
    }

    private void addControl() {
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //quay về activity trước
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);//mũi tên quay về
        combinedChart= (CombinedChart) findViewById(chart);
        tvchart= (TextView) findViewById(R.id.tvchart);
        tvchart.setText(getResources().getString(R.string.BieuDoThongTinTongHopChiPhiHuyen));
    }

}

