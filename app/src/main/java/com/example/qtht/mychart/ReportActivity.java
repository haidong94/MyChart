package com.example.qtht.mychart;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.qtht.mychart.asynctask.Report20Task;
import com.example.qtht.mychart.asynctask.Report21Task;
import com.example.qtht.mychart.asynctask.Report79GeneralTask;
import com.example.qtht.mychart.asynctask.Report79Task;
import com.example.qtht.mychart.asynctask.Report80GeneralTask;
import com.example.qtht.mychart.common.SessionManager;
import com.example.qtht.mychart.interFace.ICallListReport20;
import com.example.qtht.mychart.interFace.ICallListReport21;
import com.example.qtht.mychart.interFace.ICallListReport79;
import com.example.qtht.mychart.interFace.ICallListReport79General;
import com.example.qtht.mychart.interFace.ICallListReport80General;
import com.example.qtht.mychart.model.Report19;
import com.example.qtht.mychart.model.Report20;
import com.example.qtht.mychart.model.Report21;
import com.example.qtht.mychart.model.Report79;
import com.example.qtht.mychart.model.Report79General;
import com.example.qtht.mychart.model.Report80;
import com.example.qtht.mychart.model.Report80General;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import static com.example.qtht.mychart.common.Common.account;

/**
 * Created by qtht on 08/05/2017.
 */

public class ReportActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,ICallListReport79,ICallListReport20,ICallListReport21,ICallListReport79General,ICallListReport80General {
    Toolbar toolbar;
    TextView tv_startDate, tv_endDate;

    ShimmerTextView tv_cosoyte;
    Shimmer shimmer=new Shimmer();

    LinearLayout ln_startDate,ln_endDate;
    static final int START_DATE = 1;
    static final int END_DATE = 2;
    int date=0;

    Calendar now = Calendar.getInstance();
    String dateNow= String.valueOf(now.get(Calendar.DATE));
    String monthNow=String.valueOf(now.get(Calendar.MONTH)+1);
    String yearNow=String.valueOf(now.get(Calendar.YEAR));

    Spinner spin_KyBaoCao,spin_MauIn,spin_KhoaPhong,spin_Thang,spin_Nam;
    String arrKyBaoCao[],arrMauIn[],arrKhoaPhong[],arrThang[],arrQuy[],arrNam[];
    Button btn_report;

    ArrayList<Report19> listReport19s=new ArrayList<>();
    ArrayList<Report20> listReport20s=new ArrayList<>();
    ArrayList<Report21> listReport21s=new ArrayList<>();
    ArrayList<Report79> listReport79s=new ArrayList<>();
    ArrayList<Report79General> listReport79Gerenal=new ArrayList<>();
    ArrayList<Report80> listReport80s=new ArrayList<>();
    ArrayList<Report80General> listReport80Gerenal=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_bhyt_activity);

        addControl();
        addEvent();
        xuLyKyBaoCao();
    }

    private void xuLyKyBaoCao() {
        spin_KyBaoCao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:{
                        spin_Thang.setEnabled(false);
                        spin_Nam.setEnabled(false);
                        ln_startDate.setEnabled(true);
                        ln_endDate.setEnabled(true);
                        tv_startDate.setTextColor(getResources().getColor(R.color.colorBlack));
                        tv_endDate.setTextColor(getResources().getColor(R.color.colorBlack));
                        break;
                    }
                    case 1:{
                        ln_startDate.setEnabled(false);
                        ln_endDate.setEnabled(false);
                        tv_startDate.setTextColor(getResources().getColor(R.color.colorGray));
                        tv_endDate.setTextColor(getResources().getColor(R.color.colorGray));

                        arrThang=getResources().getStringArray(R.array.Thang);
                        ArrayAdapter<String> adapterThang=new ArrayAdapter<String>(ReportActivity.this,android.R.layout.simple_spinner_dropdown_item,arrThang);
                        spin_Thang.setAdapter(adapterThang);

                        spin_Thang.setSelection(adapterThang.getPosition(monthNow));
                        spin_Thang.setEnabled(true);
                        spin_Nam.setEnabled(true);
                        break;
                    }
                    case 2:{
                        arrQuy=getResources().getStringArray(R.array.Quy);
                        ArrayAdapter<String> adapterQuy=new ArrayAdapter<String>(ReportActivity.this,android.R.layout.simple_spinner_dropdown_item,arrQuy);
                        spin_Thang.setAdapter(adapterQuy);
                        spin_Thang.setEnabled(true);
                        spin_Nam.setEnabled(true);

                        int quater= (Integer.parseInt(monthNow)-1)/3 +1;
                        spin_Thang.setSelection(adapterQuy.getPosition(String.valueOf(quater)));

                        ln_startDate.setEnabled(false);
                        ln_endDate.setEnabled(false);
                        tv_startDate.setTextColor(getResources().getColor(R.color.colorGray));
                        tv_endDate.setTextColor(getResources().getColor(R.color.colorGray));

                        break;
                    }
                    case 3:{
                        ln_startDate.setEnabled(false);
                        ln_endDate.setEnabled(false);
                        tv_startDate.setTextColor(getResources().getColor(R.color.colorGray));
                        tv_endDate.setTextColor(getResources().getColor(R.color.colorGray));
                        spin_Thang.setEnabled(false);
                        spin_Nam.setEnabled(true);
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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

        tv_cosoyte= (ShimmerTextView) findViewById(R.id.tv_cosoyte);
        tv_cosoyte.setText(account.getTenbenhvien());
        shimmer.start(tv_cosoyte);

        tv_startDate= (TextView) findViewById(R.id.tv_startDate);
        tv_startDate.setText(dateNow + "/" + monthNow + "/" + yearNow);
        tv_endDate= (TextView) findViewById(R.id.tv_endDate);
        tv_endDate.setText(dateNow + "/" + monthNow + "/" + yearNow);
        ln_startDate= (LinearLayout) findViewById(R.id.ln_startDate);
        ln_endDate= (LinearLayout) findViewById(R.id.ln_endDate);

        btn_report= (Button) findViewById(R.id.btn_report);

        //spinner
        spin_KyBaoCao= (Spinner) findViewById(R.id.spin_KyBaoCao);
        spin_MauIn= (Spinner) findViewById(R.id.spin_MauIn);
        spin_KhoaPhong= (Spinner) findViewById(R.id.spin_KhoaPhong);
        spin_Thang= (Spinner) findViewById(R.id.spin_Thang);
        spin_Nam= (Spinner) findViewById(R.id.spin_Nam);


        arrKyBaoCao=getResources().getStringArray(R.array.KyBaoCao);
        ArrayAdapter<String> adapterKyBaoCao=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arrKyBaoCao);
        spin_KyBaoCao.setAdapter(adapterKyBaoCao);

        arrMauIn=getResources().getStringArray(R.array.MauIn);
        ArrayAdapter<String> adapterMauIn=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arrMauIn);
        spin_MauIn.setAdapter(adapterMauIn);

        arrKhoaPhong=getResources().getStringArray(R.array.KhoaPhong);
        ArrayAdapter<String> adapterKhoaPhong=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arrKhoaPhong);
        spin_KhoaPhong.setAdapter(adapterKhoaPhong);

        arrThang=getResources().getStringArray(R.array.Thang);
        ArrayAdapter<String> adapterThang=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arrThang);
        spin_Thang.setAdapter(adapterThang);
        spin_Thang.setSelection(adapterThang.getPosition(monthNow));

        arrNam=getResources().getStringArray(R.array.Nam);
        ArrayAdapter<String> adapterNam=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,arrNam);
        spin_Nam.setAdapter(adapterNam);
        spin_Nam.setSelection(adapterNam.getPosition(yearNow));
    }

    private void addEvent() {

        SessionManager session=new SessionManager(ReportActivity.this);
        HashMap<String, String> user = session.getUserDetail();
        final String name = user.get(SessionManager.KEY_NAME);
        final String pass = user.get(SessionManager.KEY_PASS);

        ln_startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date = START_DATE;
                showDatePickerDialog();
            }
        });

        ln_endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date=END_DATE;
                showDatePickerDialog();
            }
        });

        btn_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tungay=tv_startDate.getText().toString();
                String denngay=tv_endDate.getText().toString();
                if(spin_MauIn.getSelectedItem().toString().equals("19")) {
                    Intent intent = new Intent(ReportActivity.this, DetailReport19Activity.class);
                    startActivity(intent);
                }
                if(spin_MauIn.getSelectedItem().toString().equals("20")) {
                    Report20Task report20Task=new Report20Task(ReportActivity.this);
                    report20Task.execute(name,pass,"22003",tungay,denngay);
                    listReport20s=report20Task.getList();

                }
                if(spin_MauIn.getSelectedItem().toString().equals("21")) {
                    Report21Task report21Task=new Report21Task(ReportActivity.this);
                    report21Task.execute(name,pass,"22003",tungay,denngay);
                    listReport21s=report21Task.getList();
                }
                if(spin_MauIn.getSelectedItem().toString().equals("79")) {
                    Report79Task report79Task=new Report79Task(ReportActivity.this);
                    report79Task.execute(name,pass,"22003",tungay,denngay);
                    listReport79s=report79Task.getList();


                }
                if(spin_MauIn.getSelectedItem().toString().equals("80")) {
                    Intent intent = new Intent(ReportActivity.this, DetailReport80Activity.class);
                    startActivity(intent);
                }

                if(spin_MauIn.getSelectedItem().toString().equals("79 Tổng Hợp")) {
                    Report79GeneralTask report79GeneralTask=new Report79GeneralTask(ReportActivity.this);
                    report79GeneralTask.execute(name,pass,"22003",tungay,denngay);
                    listReport79Gerenal=report79GeneralTask.getList();
                }

                if(spin_MauIn.getSelectedItem().toString().equals("80 Tổng Hợp")) {
                    Report80GeneralTask report80GeneralTask=new Report80GeneralTask(ReportActivity.this);
                    report80GeneralTask.execute(name,pass,"22003",tungay,denngay);
                    listReport80Gerenal=report80GeneralTask.getList();
                }
            }
        });
    }

    private void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                ReportActivity.this,ReportActivity.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        if(date == START_DATE)
            tv_startDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
        else
            tv_endDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);

    }

    @Override
    public void callListBaoCao79() {
        Intent intent = new Intent(ReportActivity.this, DetailReport79Activity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", listReport79s);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void callListReport20() {
        Intent intent = new Intent(ReportActivity.this, DetailReport20Activity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", listReport20s);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void callListReport21() {
        Intent intent = new Intent(ReportActivity.this, DetailReport21Activity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", listReport21s);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void callListReport79Gerenal() {
        Intent intent = new Intent(ReportActivity.this, DetailReport79GeneralActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", listReport79Gerenal);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void callListReport80General() {
        Intent intent = new Intent(ReportActivity.this, DetailReport80GeneralActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", listReport80Gerenal);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
