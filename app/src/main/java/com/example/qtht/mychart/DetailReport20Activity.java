package com.example.qtht.mychart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.example.qtht.mychart.adapter.RecyclerReport20Adapter;
import com.example.qtht.mychart.common.ZoomLayout;
import com.example.qtht.mychart.model.Report20;

import java.util.ArrayList;

/**
 * Created by qtht on 10/05/2017.
 */

public class DetailReport20Activity extends AppCompatActivity {
    LinearLayout ln_layout;
    ZoomLayout zoomLayout;
    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerReport20Adapter adapter;
    RecyclerView.LayoutManager layout;
    ArrayList<Report20> listReport20s=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_report20_activity);

        Bundle bundle = getIntent().getExtras();
        listReport20s = bundle.getParcelableArrayList("list");

        addControl();
        addEvent();


    }

    private void addControl() {
        //zoom
        zoomLayout = new ZoomLayout(DetailReport20Activity.this);
        ln_layout = (LinearLayout) findViewById(R.id.ln_layout);
        ln_layout.addView(zoomLayout);

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

        //set ryclerview
        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layout=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layout);

        adapter=new RecyclerReport20Adapter(listReport20s,this);
        recyclerView.setAdapter(adapter);
    }
    private void addEvent(){

    }
}
