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
import com.example.qtht.mychart.model.Report20;

import java.util.List;

/**
 * Created by qtht on 12/05/2017.
 */

public class RecyclerReport20Adapter extends RecyclerView.Adapter<RecyclerReport20Adapter.RecyclerViewHoder> {
    private List<Report20> list;
    private Context context;

    public RecyclerReport20Adapter(List<Report20> list, Context context){
        this.list=list;
        this.context=context;
    }


    @Override
    public RecyclerViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.item_report20_activity,parent,false);

        return new RecyclerViewHoder(itemView);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(RecyclerViewHoder holder, int position) {
        holder.tv_STT.setText(String.valueOf(list.indexOf(list.get(position))+1));
        holder.tv_STTDM.setText(list.get(position).getSTTTheoDMT());
        holder.tv_TenHoatChat.setText(list.get(position).getTenHoatChat());
        holder.tv_TenThuoc.setText(list.get(position).getTenThuoc());
        holder.tv_DuongDung.setText(list.get(position).getDuongDungDangBC());
        holder.tv_HamLuong.setText(list.get(position).getHamLuong());
        holder.tv_SoDK.setText(list.get(position).getSoDangKy());
        holder.tv_DonViTinh.setText(list.get(position).getDonViTinh());
        holder.tv_NoiTru.setText(list.get(position).getNoiTru());
        holder.tv_NgoaiTru.setText(list.get(position).getNgoaiTru());
        holder.tv_DonGia.setText(list.get(position).getDonGia());
        holder.tv_ThanhTien.setText(list.get(position).getThanhTien());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHoder extends RecyclerView.ViewHolder {
        public TextView tv_STT,tv_STTDM,tv_TenHoatChat,tv_TenThuoc,tv_DuongDung,tv_HamLuong,
                tv_SoDK,tv_DonViTinh,tv_NoiTru, tv_NgoaiTru,tv_DonGia,
                tv_ThanhTien;

        public RecyclerViewHoder(View itemView) {
            super(itemView);
            tv_STT= (TextView) itemView.findViewById(R.id.tv_STT);
            tv_STTDM= (TextView) itemView.findViewById(R.id.tv_STTDM);
            tv_TenHoatChat= (TextView) itemView.findViewById(R.id.tv_TenHoatChat);
            tv_TenThuoc= (TextView) itemView.findViewById(R.id.tv_TenThuoc);
            tv_DuongDung= (TextView) itemView.findViewById(R.id.tv_DuongDung);
            tv_HamLuong= (TextView) itemView.findViewById(R.id.tv_HamLuong);
            tv_SoDK= (TextView) itemView.findViewById(R.id.tv_SoDK);
            tv_DonViTinh= (TextView) itemView.findViewById(R.id.tv_DonViTinh);
            tv_NoiTru= (TextView) itemView.findViewById(R.id.tv_NoiTru);
            tv_NgoaiTru= (TextView) itemView.findViewById(R.id.tv_NgoaiTru);
            tv_DonGia= (TextView) itemView.findViewById(R.id.tv_DonGia);
            tv_ThanhTien= (TextView) itemView.findViewById(R.id.tv_ThanhTien);

        }
    }
}
