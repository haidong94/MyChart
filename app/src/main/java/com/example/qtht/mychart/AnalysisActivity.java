package com.example.qtht.mychart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.qtht.mychart.adapter.RecyclerAnalysisAdapter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by qtht on 03/05/2017.
 */

public class AnalysisActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAnalysisAdapter adapter;
    RecyclerView.LayoutManager layout;
    ArrayList<String> list=new ArrayList<String>(Arrays.asList("item 1","item 2","item 3"));
    Integer[] listImage={R.drawable.ic_baocao,R.drawable.ic_baocao,R.drawable.ic_baocao};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analysis_activity);

        addControl();

    }

    private void addControl() {
        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layout=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layout);

        adapter=new RecyclerAnalysisAdapter(list,listImage,this);
        recyclerView.setAdapter(adapter);

    }
}
