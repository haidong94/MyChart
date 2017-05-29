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
import com.example.qtht.mychart.model.Report79General;

import java.util.List;

/**
 * Created by qtht on 17/05/2017.
 */

public class RecyclerReport79GeneralAdapter extends RecyclerView.Adapter<RecyclerReport79GeneralAdapter.RecyclerViewHoder> {
    private List<Report79General> list;
    private Context context;

    public RecyclerReport79GeneralAdapter(List<Report79General> list, Context context){
        this.list=list;
        this.context=context;
    }


    @Override
    public RecyclerViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.item_report79general_activity,parent,false);

        return new RecyclerViewHoder(itemView);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(RecyclerViewHoder holder, int position) {
        holder.tv_tt.setText(list.get(position).getTT());
        holder.tv_khambenh.setText(list.get(position).getKhamChuaBenh());
        holder.tv_soluot.setText(list.get(position).getSoLuot());
        holder.tv_tongcong.setText(list.get(position).getTongCong());
        holder.tv_xetNghiem.setText(list.get(position).getXetNghiem());

        holder.tv_CDHA_TDCN.setText(list.get(position).getCDHA());
        holder.tv_thuoc.setText(list.get(position).getThuoc());
        holder.tv_mau.setText(list.get(position).getMau());
        holder.tv_TTPT.setText(list.get(position).getTTPT());
        holder.tv_VTYT.setText(list.get(position).getVTYT());
        holder.tv_DKVT.setText(list.get(position).getDKVT_TyLe());
        holder.tv_ThuocTyLe.setText(list.get(position).getThuoc_TyLe());
        holder.tv_VTYT_TyLe.setText(list.get(position).getVTYT_TyLe());
        holder.tv_tienKham.setText(list.get(position).getTienKham());
        holder.tv_vanChuyen.setText(list.get(position).getVanChuyen());

        holder.tv_nguoiBenhTra.setText(list.get(position).getNguoiBenhTra());
        holder.tv_tongCongBHtra.setText(list.get(position).getBHYT_TTTongCong());
        holder.tv_dinhSuat.setText(list.get(position).getBHYT_NgoaiDinhSuat());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHoder extends RecyclerView.ViewHolder {
        public TextView tv_tt,tv_khambenh,tv_soluot,tv_tongcong,tv_xetNghiem,tv_CDHA_TDCN,
                tv_thuoc,tv_mau,tv_TTPT, tv_VTYT,tv_DKVT,
                tv_ThuocTyLe,tv_VTYT_TyLe, tv_tienKham,tv_vanChuyen,tv_nguoiBenhTra,
                tv_tongCongBHtra,tv_dinhSuat;


        public RecyclerViewHoder(View itemView) {
            super(itemView);
            tv_tt= (TextView) itemView.findViewById(R.id.tv_tt);
            tv_khambenh= (TextView) itemView.findViewById(R.id.tv_khambenh);
            tv_soluot= (TextView) itemView.findViewById(R.id.tv_soluot);
            tv_tongcong= (TextView) itemView.findViewById(R.id.tv_tongcong);
            tv_xetNghiem= (TextView) itemView.findViewById(R.id.tv_xetNghiem);
            tv_CDHA_TDCN= (TextView) itemView.findViewById(R.id.tv_CDHA_TDCN);
            tv_thuoc= (TextView) itemView.findViewById(R.id.tv_thuoc);
            tv_mau= (TextView) itemView.findViewById(R.id.tv_mau);
            tv_TTPT= (TextView) itemView.findViewById(R.id.tv_TTPT);
            tv_VTYT= (TextView) itemView.findViewById(R.id.tv_VTYT);
            tv_DKVT= (TextView) itemView.findViewById(R.id.tv_DKVT);
            tv_ThuocTyLe= (TextView) itemView.findViewById(R.id.tv_ThuocTyLe);
            tv_VTYT_TyLe= (TextView) itemView.findViewById(R.id.tv_VTYT_TyLe);
            tv_tienKham= (TextView) itemView.findViewById(R.id.tv_tienKham);
            tv_vanChuyen= (TextView) itemView.findViewById(R.id.tv_vanChuyen);
            tv_nguoiBenhTra= (TextView) itemView.findViewById(R.id.tv_nguoiBenhTra);
            tv_tongCongBHtra= (TextView) itemView.findViewById(R.id.tv_tongCongBHtra);
            tv_dinhSuat= (TextView) itemView.findViewById(R.id.tv_dinhSuat);

        }
    }
}
