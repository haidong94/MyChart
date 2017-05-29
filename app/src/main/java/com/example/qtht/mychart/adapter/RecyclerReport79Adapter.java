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
import com.example.qtht.mychart.model.Report79;

import java.util.List;

/**
 * Created by qtht on 11/05/2017.
 */

public class RecyclerReport79Adapter  extends RecyclerView.Adapter<RecyclerReport79Adapter.RecyclerViewHoder> {
    private List<Report79> list;
    private Context context;

    public RecyclerReport79Adapter(List<Report79> list, Context context){
        this.list=list;
        this.context=context;
    }


    @Override
    public RecyclerViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.item_report79_activity,parent,false);

        return new RecyclerViewHoder(itemView);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(RecyclerViewHoder holder, int position) {
        holder.tv_STT.setText(String.valueOf(list.indexOf(list.get(position))+1));
        holder.tv_hoten.setText(list.get(position).getHoTen());
        holder.tv_Nam.setText(list.get(position).getNamSinhNam());
        holder.tv_Nu.setText(list.get(position).getNamSinhNu());
        holder.tv_MaThe.setText(list.get(position).getMaTheBHYT());
        holder.tv_maDKBD.setText(list.get(position).getMaĐKBĐ());

        holder.tv_maBenh.setText(list.get(position).getMaBenhKhac());
        holder.tv_ngayKham.setText(list.get(position).getNgayKham());
        holder.tv_tongCong.setText(list.get(position).getTongCong());
        holder.tv_xetNghiem.setText(list.get(position).getXetNghiem());
        holder.tv_CDHA_TDCN.setText(list.get(position).getCĐHA_TDCN());

        holder.tv_thuoc.setText(list.get(position).getThuoc());
        holder.tv_mau.setText(list.get(position).getMau());
        holder.tv_TTPT.setText(list.get(position).getTTPT());
        holder.tv_VTYT.setText(list.get(position).getVTYT());
        holder.tv_DVKTTyLe.setText(list.get(position).getTyLe_DVKT());

        holder.tv_ThuocTyLe.setText(list.get(position).getTyLe_Thuoc());
        holder.tv_VTYT_TyLe.setText(list.get(position).getTyLe_VTYT());
        holder.tv_tienKham.setText(list.get(position).getTienKham());
        holder.tv_vanChuyen.setText(list.get(position).getVanChuyen());
        holder.tv_nguoiBenhTra.setText(list.get(position).getNguoiBenhChiTra());

        holder.tv_tongCongBHtra.setText(list.get(position).getBHXH_TTTongCong());
        holder.tv_dinhSuat.setText(list.get(position).getBHXH_CPNgoai());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHoder extends RecyclerView.ViewHolder {
        public TextView tv_STT,tv_hoten,tv_Nam,tv_Nu,tv_MaThe,tv_maDKBD,
                tv_maBenh,tv_ngayKham,tv_tongCong, tv_xetNghiem,tv_CDHA_TDCN,
                tv_thuoc,tv_mau, tv_TTPT,tv_VTYT,tv_DVKTTyLe,
                tv_ThuocTyLe,tv_VTYT_TyLe,tv_tienKham, tv_vanChuyen,tv_nguoiBenhTra,
                tv_tongCongBHtra,tv_dinhSuat;


        public RecyclerViewHoder(View itemView) {
            super(itemView);
            tv_STT= (TextView) itemView.findViewById(R.id.tv_STT);
            tv_hoten= (TextView) itemView.findViewById(R.id.tv_hoten);
            tv_Nam= (TextView) itemView.findViewById(R.id.tv_Nam);
            tv_Nu= (TextView) itemView.findViewById(R.id.tv_Nu);
            tv_MaThe= (TextView) itemView.findViewById(R.id.tv_MaThe);
            tv_maDKBD= (TextView) itemView.findViewById(R.id.tv_maDKBD);
            tv_maBenh= (TextView) itemView.findViewById(R.id.tv_maBenh);
            tv_ngayKham= (TextView) itemView.findViewById(R.id.tv_ngayKham);
            tv_tongCong= (TextView) itemView.findViewById(R.id.tv_tongCong);
            tv_xetNghiem= (TextView) itemView.findViewById(R.id.tv_xetNghiem);
            tv_CDHA_TDCN= (TextView) itemView.findViewById(R.id.tv_CDHA_TDCN);
            tv_thuoc= (TextView) itemView.findViewById(R.id.tv_thuoc);
            tv_mau= (TextView) itemView.findViewById(R.id.tv_mau);
            tv_TTPT= (TextView) itemView.findViewById(R.id.tv_TTPT);
            tv_VTYT= (TextView) itemView.findViewById(R.id.tv_VTYT);
            tv_DVKTTyLe= (TextView) itemView.findViewById(R.id.tv_DVKTTyLe);
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
