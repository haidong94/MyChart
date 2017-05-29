package com.example.qtht.mychart.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by qtht on 12/05/2017.
 */

public class Report20 implements Parcelable {
    private String STTTheoDMT;
    private String tenHoatChat;
    private String tenThuoc;
    private String duongDungDangBC;
    private String hamLuong;
    private String soDangKy;
    private String donViTinh;
    private String ngoaiTru;
    private String noiTru;

    public Report20() {
    }

    public Report20(String STTTheoDMT, String tenHoatChat, String tenThuoc, String duongDungDangBC, String hamLuong, String soDangKy, String donViTinh, String ngoaiTru, String noiTru, String donGia, String thanhTien) {
        this.STTTheoDMT = STTTheoDMT;
        this.tenHoatChat = tenHoatChat;
        this.tenThuoc = tenThuoc;
        this.duongDungDangBC = duongDungDangBC;
        this.hamLuong = hamLuong;
        this.soDangKy = soDangKy;
        this.donViTinh = donViTinh;
        this.ngoaiTru = ngoaiTru;
        this.noiTru = noiTru;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    private String donGia;

    protected Report20(Parcel in) {
        STTTheoDMT = in.readString();
        tenHoatChat = in.readString();
        tenThuoc = in.readString();
        duongDungDangBC = in.readString();
        hamLuong = in.readString();
        soDangKy = in.readString();
        donViTinh = in.readString();
        ngoaiTru = in.readString();
        noiTru = in.readString();
        donGia = in.readString();
        thanhTien = in.readString();
    }

    public static final Creator<Report20> CREATOR = new Creator<Report20>() {
        @Override
        public Report20 createFromParcel(Parcel in) {
            return new Report20(in);
        }

        @Override
        public Report20[] newArray(int size) {
            return new Report20[size];
        }
    };

    public String getSTTTheoDMT() {
        return STTTheoDMT;
    }

    public void setSTTTheoDMT(String STTTheoDMT) {
        this.STTTheoDMT = STTTheoDMT;
    }

    public String getTenHoatChat() {
        return tenHoatChat;
    }

    public void setTenHoatChat(String tenHoatChat) {
        this.tenHoatChat = tenHoatChat;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public String getDuongDungDangBC() {
        return duongDungDangBC;
    }

    public void setDuongDungDangBC(String duongDungDangBC) {
        this.duongDungDangBC = duongDungDangBC;
    }

    public String getHamLuong() {
        return hamLuong;
    }

    public void setHamLuong(String hamLuong) {
        this.hamLuong = hamLuong;
    }

    public String getSoDangKy() {
        return soDangKy;
    }

    public void setSoDangKy(String soDangKy) {
        this.soDangKy = soDangKy;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
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

    private String thanhTien;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(STTTheoDMT);
        dest.writeString(tenHoatChat);
        dest.writeString(tenThuoc);
        dest.writeString(duongDungDangBC);
        dest.writeString(hamLuong);
        dest.writeString(soDangKy);
        dest.writeString(donViTinh);
        dest.writeString(ngoaiTru);
        dest.writeString(noiTru);
        dest.writeString(donGia);
        dest.writeString(thanhTien);
    }
}
