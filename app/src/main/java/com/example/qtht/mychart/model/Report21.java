package com.example.qtht.mychart.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by qtht on 12/05/2017.
 */

public class Report21 implements Parcelable {
    private String maSoTheoDMBYT;
    private String tenDVYT;
    private String noiTru;
    private String ngoaiTru;
    private String donGia;
    private String thanhTien;

    public Report21() {
    }

    public Report21(String maSoTheoDMBYT, String tenDVYT, String noiTru, String ngoaiTru, String donGia, String thanhTien) {
        this.maSoTheoDMBYT = maSoTheoDMBYT;
        this.tenDVYT = tenDVYT;
        this.noiTru = noiTru;
        this.ngoaiTru = ngoaiTru;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }



    protected Report21(Parcel in) {
        maSoTheoDMBYT = in.readString();
        tenDVYT = in.readString();
        noiTru = in.readString();
        ngoaiTru = in.readString();
        donGia = in.readString();
        thanhTien = in.readString();
    }

    public static final Creator<Report21> CREATOR = new Creator<Report21>() {
        @Override
        public Report21 createFromParcel(Parcel in) {
            return new Report21(in);
        }

        @Override
        public Report21[] newArray(int size) {
            return new Report21[size];
        }
    };

    public String getMaSoTheoDMBYT() {
        return maSoTheoDMBYT;
    }

    public void setMaSoTheoDMBYT(String maSoTheoDMBYT) {
        this.maSoTheoDMBYT = maSoTheoDMBYT;
    }

    public String getTenDVYT() {
        return tenDVYT;
    }

    public void setTenDVYT(String tenDVYT) {
        this.tenDVYT = tenDVYT;
    }

    public String getNoiTru() {
        return noiTru;
    }

    public void setNoiTru(String noiTru) {
        this.noiTru = noiTru;
    }

    public String getNgoaiTru() {
        return ngoaiTru;
    }

    public void setNgoaiTru(String ngoaiTru) {
        this.ngoaiTru = ngoaiTru;
    }

    public String getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public String getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(String thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(maSoTheoDMBYT);
        dest.writeString(tenDVYT);
        dest.writeString(noiTru);
        dest.writeString(ngoaiTru);
        dest.writeString(donGia);
        dest.writeString(thanhTien);
    }
}
