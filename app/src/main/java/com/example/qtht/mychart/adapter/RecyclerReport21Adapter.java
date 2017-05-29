package com.example.qtht.mychart.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qtht.mychart.R;
import com.example.qtht.mychart.model.Report21;

import java.util.List;

/**
 * Created by qtht on 12/05/2017.
 */

public class RecyclerReport21Adapter extends RecyclerView.Adapter<RecyclerReport21Adapter.RecyclerViewHoder> {
    private List<Report21> list;
    private Context context;

    public RecyclerReport21Adapter(List<Report21> list, Context context){
        this.list=list;
        this.context=context;
    }


    @Override
    public RecyclerViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.item_report21_activity,parent,false);

        return new RecyclerViewHoder(itemView);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(RecyclerViewHoder holder, int position) {
        holder.tv_STT.setText(String.valueOf(list.indexOf(list.get(position))+1));
        holder.tv_MSTheoDm.setText(list.get(position).getMaSoTheoDMBYT());
        holder.tv_TenDVYT.setText(list.get(position).getTenDVYT());
        holder.tv_NgoaiTru.setText(list.get(position).getNgoaiTru());
        holder.tv_NoiTru.setText(list.get(position).getNoiTru());
        holder.tv_DonGia.setText(list.get(position).getDonGia());
        holder.tv_ThanhTien.setText(list.get(position).getThanhTien());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHoder extends RecyclerView.ViewHolder {
        public TextView tv_STT,tv_MSTheoDm,tv_TenDVYT,tv_NgoaiTru,tv_NoiTru,tv_DonGia,
                tv_ThanhTien;

        public RecyclerViewHoder(View itemView) {
            super(itemView);
            tv_STT= (TextView) itemView.findViewById(R.id.tv_STT);
            tv_MSTheoDm= (TextView) itemView.findViewById(R.id.tv_MSTheoDm);
            tv_TenDVYT= (TextView) itemView.findViewById(R.id.tv_TenDVYT);
            tv_NgoaiTru= (TextView) itemView.findViewById(R.id.tv_NgoaiTru);
            tv_NoiTru= (TextView) itemView.findViewById(R.id.tv_NoiTru);
            tv_DonGia= (TextView) itemView.findViewById(R.id.tv_DonGia);
            tv_ThanhTien= (TextView) itemView.findViewById(R.id.tv_ThanhTien);
        }
    }
}
