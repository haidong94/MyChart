package com.example.qtht.mychart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.qtht.mychart.adapter.RecyclerReport80GeneralAdapter;
import com.example.qtht.mychart.model.Report80General;

import java.util.ArrayList;

/**
 * Created by qtht on 17/05/2017.
 */

public class DetailReport80GeneralActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerReport80GeneralAdapter adapter;
    RecyclerView.LayoutManager layout;
    ArrayList<Report80General> listReport80s = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_report80general_activity);

        Bundle bundle = getIntent().getExtras();
        listReport80s = bundle.getParcelableArrayList("list");

        addControl();
        addEvent();


    }

    private void addControl() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);//mũi tên quay về

        //set ryclerview
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layout);
        recyclerView.setNestedScrollingEnabled(false);

        adapter = new RecyclerReport80GeneralAdapter(listReport80s, this);
        recyclerView.setAdapter(adapter);

    }

    private void addEvent() {

    }
}