package com.example.qtht.mychart;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.qtht.mychart.asynctask.ChartTask_ThongTinSoLuongTheoThang;
import com.example.qtht.mychart.asynctask.ChartTask_ThongTinTheoThang;
import com.example.qtht.mychart.asynctask.ChartTask_ThongTinTongHopChiPhiHuyen;
import com.example.qtht.mychart.asynctask.ChartTask_ThongTinTongHopSoLuongHuyen;
import com.example.qtht.mychart.common.Common;
import com.example.qtht.mychart.common.SessionManager;
import com.example.qtht.mychart.interFace.ICallListTTSLTT;
import com.example.qtht.mychart.interFace.ICallListTTTHCPH;
import com.example.qtht.mychart.interFace.ICallListTTTHSLH;
import com.example.qtht.mychart.interFace.ICallListTTTT;
import com.example.qtht.mychart.model.BenhNhan;
import com.example.qtht.mychart.model.ChiPhi;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by qtht on 06/05/2017.
 */

public class SelectChartActivity extends AppCompatActivity implements ICallListTTTHCPH,ICallListTTTHSLH,ICallListTTTT,ICallListTTSLTT {
    Toolbar toolbar;
    Button btn_chart1,btn_chart2;
    ArrayList<ChiPhi> list=new ArrayList<>();
    ArrayList<BenhNhan> listbenhNhan=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_chart_activity);

        addControl();
        addEvent();

    }

    private void addEvent() {
        SessionManager session=new SessionManager(SelectChartActivity.this);
        HashMap<String, String> user = session.getUserDetail();
        final String name = user.get(SessionManager.KEY_NAME);
        final String pass = user.get(SessionManager.KEY_PASS);

        if(Common.account.getHangbenhvien().equals("4")){
            btn_chart1.setText("Biểu đồ thông tin theo tháng");
            btn_chart2.setText("Biểu đồ thông tin số lượng theo tháng");

            btn_chart1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ChartTask_ThongTinTheoThang chartTask=new ChartTask_ThongTinTheoThang(SelectChartActivity.this);
                    chartTask.execute(name,pass,"01841");
                    list=chartTask.getList();
                }
            });

            btn_chart2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ChartTask_ThongTinSoLuongTheoThang chartTask=new ChartTask_ThongTinSoLuongTheoThang(SelectChartActivity.this);
                    chartTask.execute(name,pass,"01841");
                    listbenhNhan=chartTask.getList();
                }
            });
        }else {
            btn_chart1.setText("Biểu đồ thông tin tổng hợp chi phí huyện");
            btn_chart2.setText("Biểu đồ thông tin tổng hợp số lượng huyện");

            btn_chart1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ChartTask_ThongTinTongHopChiPhiHuyen chartTask=new ChartTask_ThongTinTongHopChiPhiHuyen(SelectChartActivity.this);
                    chartTask.execute(name,pass,"01841");
                    list=chartTask.getList();
                }
            });

            btn_chart2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ChartTask_ThongTinTongHopSoLuongHuyen chartTask=new ChartTask_ThongTinTongHopSoLuongHuyen(SelectChartActivity.this);
                    chartTask.execute(name,pass,"01841");
                    listbenhNhan=chartTask.getList();

                }
            });
        }
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

        btn_chart1= (Button) findViewById(R.id.btn_chart1);
        btn_chart2= (Button) findViewById(R.id.btn_chart2);
    }

    @Override
    public void callListTTTHCPH() {
        Intent intent=new Intent(SelectChartActivity.this,ChartThongTinTongHopChiPhiHuyenActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", list);
        intent.putExtras(bundle);
        startActivity(intent);
    }


    @Override
    public void callListTTTHSLH() {
        Intent intent=new Intent(SelectChartActivity.this,ChartThongTinTongHopSoLuongHuyenActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", listbenhNhan);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void callListTTTT() {
        Intent intent=new Intent(SelectChartActivity.this,ChartThongTinTheoThangActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", list);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void callListTTSLTT() {
        Intent intent=new Intent(SelectChartActivity.this,ChartThongTinSoLuongTheoThangActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", listbenhNhan);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
