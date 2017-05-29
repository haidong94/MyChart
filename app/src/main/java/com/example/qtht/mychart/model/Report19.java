package com.example.qtht.mychart.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by qtht on 09/05/2017.
 */

public class Report19 implements Parcelable {
    private String maSo;
    private String tenVTYT;
    private String tenTM;
    private String quyCach;
    private String donViTinh;
    private String giaMuaVao;
    private String ngoaiTru;
    private String noiTru;
    private String giaTTBHYT;
    private String thanhTien;


    protected Report19(Parcel in) {
        maSo = in.readString();
        tenVTYT = in.readString();
        tenTM = in.readString();
        quyCach = in.readString();
        donViTinh = in.readString();
        giaMuaVao = in.readString();
        ngoaiTru = in.readString();
        noiTru = in.readString();
        giaTTBHYT = in.readString();
        thanhTien = in.readString();
    }

    public static final Creator<Report19> CREATOR = new Creator<Report19>() {
        @Override
        public Report19 createFromParcel(Parcel in) {
            return new Report19(in);
        }

        @Override
        public Report19[] newArray(int size) {
            return new Report19[size];
        }
    };

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getTenVTYT() {
        return tenVTYT;
    }

    public void setTenVTYT(String tenVTYT) {
        this.tenVTYT = tenVTYT;
    }

    public String getTenTM() {
        return tenTM;
    }

    public void setTenTM(String tenTM) {
        this.tenTM = tenTM;
    }

    public String getQuyCach() {
        return quyCach;
    }

    public void setQuyCach(String quyCach) {
        this.quyCach = quyCach;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getGiaMuaVao() {
        return giaMuaVao;
    }

    public void setGiaMuaVao(String giaMuaVao) {
        this.giaMuaVao = giaMuaVao;
    }

    public String getNgoaiTru() {
        return ngoaiTru;
    }

    public void setNgoaiTru(String ngoaiTru) {
        this.ngoaiTru = ngoaiTru;
    }

    public String getNoiTru() {
        return noiTru;
    }

    public void setNoiTru(String noiTru) {
        this.noiTru = noiTru;
    }

    public String getGiaTTBHYT() {
        return giaTTBHYT;
    }

    public void setGiaTTBHYT(String giaTTBHYT) {
        this.giaTTBHYT = giaTTBHYT;
    }

    public String getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(String thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Report19(){

    }

    public Report19(String maSo, String tenVTYT, String tenTM, String quyCach, String donViTinh, String giaMuaVao, String ngoaiTru, String noiTru, String giaTTBHYT, String thanhTien) {
        this.maSo = maSo;
        this.tenVTYT = tenVTYT;
        this.tenTM = tenTM;
        this.quyCach = quyCach;
        this.donViTinh = donViTinh;
        this.giaMuaVao = giaMuaVao;
        this.ngoaiTru = ngoaiTru;
        this.noiTru = noiTru;
        this.giaTTBHYT = giaTTBHYT;
        this.thanhTien = thanhTien;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(maSo);
        dest.writeString(tenVTYT);
        dest.writeString(tenTM);
        dest.writeString(quyCach);
        dest.writeString(donViTinh);
        dest.writeString(giaMuaVao);
        dest.writeString(ngoaiTru);
        dest.writeString(noiTru);
        dest.writeString(giaTTBHYT);
        dest.writeString(thanhTien);
    }
}
