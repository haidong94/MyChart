package com.example.qtht.mychart;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerButton;

/**
 * Created by qtht on 11/05/2017.
 */

public class SelectReportActivity extends AppCompatActivity {
    Toolbar toolbar;
    ShimmerButton btn_bcBHYT,btn_bcDP;
    Shimmer shimmer=new Shimmer();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_report_activity);

        addControl();
        addEvent();
    }

    private void addControl() {
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);//mũi tên quay về

        btn_bcBHYT= (ShimmerButton) findViewById(R.id.btn_bcBHYT);
        shimmer.start(btn_bcBHYT);
        btn_bcDP=(ShimmerButton) findViewById(R.id.btn_bcDP);
        shimmer.start(btn_bcDP);


    }

    private void addEvent() {
        btn_bcBHYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SelectReportActivity.this,ReportActivity.class);
                startActivity(intent);
            }
        });

        btn_bcDP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
