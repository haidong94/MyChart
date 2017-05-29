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
import com.example.qtht.mychart.model.Report19;

import java.util.List;

/**
 * Created by qtht on 09/05/2017.
 */

public class RecyclerReport19Adapter extends RecyclerView.Adapter<RecyclerReport19Adapter.RecyclerViewHoder> {
    private List<Report19> list;
    private Context context;

    public RecyclerReport19Adapter(List<Report19> list, Context context){
        this.list=list;
        this.context=context;
    }


    @Override
    public RecyclerViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.item_report19_activity,parent,false);

        return new RecyclerViewHoder(itemView);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(RecyclerViewHoder holder, int position) {
        holder.tv_STT.setText(String.valueOf(list.indexOf(list.get(position))+1));
        holder.tv_MaSo.setText(list.get(position).getMaSo());
        holder.tv_TenVTYT.setText(list.get(position).getTenVTYT());
        holder.tv_TenTM.setText(list.get(position).getTenTM());
        holder.tv_QuyCach.setText(list.get(position).getQuyCach());
        holder.tv_DonViTinh.setText(list.get(position).getDonViTinh());
        holder.tv_GiaMuaVao.setText(list.get(position).getGiaMuaVao());
        holder.tv_NgoaiTru.setText(list.get(position).getNgoaiTru());
        holder.tv_NoiTru.setText(list.get(position).getNoiTru());
        holder.tv_GiaTTBHYT.setText(list.get(position).getGiaTTBHYT());
        holder.tv_ThanhTien.setText(list.get(position).getThanhTien());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHoder extends RecyclerView.ViewHolder {
        public TextView tv_STT,tv_MaSo,tv_TenVTYT,tv_TenTM,tv_QuyCach,
                tv_DonViTinh,tv_GiaMuaVao,tv_NgoaiTru,
                tv_NoiTru,tv_GiaTTBHYT,tv_ThanhTien;


        public RecyclerViewHoder(View itemView) {
            super(itemView);
            tv_STT= (TextView) itemView.findViewById(R.id.txtTen);
            tv_MaSo= (TextView) itemView.findViewById(R.id.tv_MaSo);
            tv_TenVTYT= (TextView) itemView.findViewById(R.id.tv_TenVTYT);
            tv_TenTM= (TextView) itemView.findViewById(R.id.tv_TenTM);
            tv_QuyCach= (TextView) itemView.findViewById(R.id.tv_QuyCach);
            tv_DonViTinh= (TextView) itemView.findViewById(R.id.tv_DonViTinh);
            tv_GiaMuaVao= (TextView) itemView.findViewById(R.id.tv_GiaMuaVao);
            tv_NgoaiTru= (TextView) itemView.findViewById(R.id.tv_NgoaiTru);
            tv_NoiTru= (TextView) itemView.findViewById(R.id.tv_NoiTru);
            tv_GiaTTBHYT= (TextView) itemView.findViewById(R.id.tv_GiaTTBHYT);
            tv_ThanhTien= (TextView) itemView.findViewById(R.id.tv_ThanhTien);
        }
    }
}
