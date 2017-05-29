package com.example.qtht.mychart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.qtht.mychart.adapter.RecyclerReport79Adapter;
import com.example.qtht.mychart.model.Report79;

import java.util.ArrayList;

/**
 * Created by qtht on 10/05/2017.
 */

public class DetailReport79Activity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerReport79Adapter adapter;
    RecyclerView.LayoutManager layout;
    ArrayList<Report79> listReport79s=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_report79_activity);

        Bundle bundle = getIntent().getExtras();
        listReport79s = bundle.getParcelableArrayList("list");

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

        //set ryclerview
        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layout=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layout);
        recyclerView.setNestedScrollingEnabled(false);

        adapter=new RecyclerReport79Adapter(listReport79s,this);
        recyclerView.setAdapter(adapter);

    }
    private void addEvent(){

    }


}
