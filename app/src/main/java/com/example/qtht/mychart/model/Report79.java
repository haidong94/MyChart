package com.example.qtht.mychart.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by qtht on 11/05/2017.
 */

public class Report79 implements Parcelable {
    private String hoTen;
    private String namSinhNam;
    private String namSinhNu;
    private String maTheBHYT;
    private String maĐKBĐ;
    private String maBenhKhac;
    private String ngayKham;
    private String tongCong;
    private String xetNghiem;
    private String CĐHA_TDCN;
    private String thuoc;
    private String mau;
    private String TTPT;
    private String VTYT;
    private String TyLe_DVKT;
    private String TyLe_Thuoc;
    private String TyLe_VTYT;
    private String tienKham;
    private String vanChuyen;
    private String nguoiBenhChiTra;
    private String BHXH_TTTongCong;
    private String BHXH_CPNgoai;

    public Report79() {
    }

    public Report79(String hoTen, String namSinhNam, String namSinhNu, String maTheBHYT, String maĐKBĐ, String maBenhKhac, String ngayKham, String tongCong, String xetNghiem, String CĐHA_TDCN, String thuoc, String mau, String TTPT, String VTYT, String tyLe_DVKT, String tyLe_Thuoc, String tyLe_VTYT, String tienKham, String vanChuyen, String nguoiBenhChiTra, String BHXH_TTTongCong, String BHXH_CPNgoai) {
        this.hoTen = hoTen;
        this.namSinhNam = namSinhNam;
        this.namSinhNu = namSinhNu;
        this.maTheBHYT = maTheBHYT;
        this.maĐKBĐ = maĐKBĐ;
        this.maBenhKhac = maBenhKhac;
        this.ngayKham = ngayKham;
        this.tongCong = tongCong;
        this.xetNghiem = xetNghiem;
        this.CĐHA_TDCN = CĐHA_TDCN;
        this.thuoc = thuoc;
        this.mau = mau;
        this.TTPT = TTPT;
        this.VTYT = VTYT;
        TyLe_DVKT = tyLe_DVKT;
        TyLe_Thuoc = tyLe_Thuoc;
        TyLe_VTYT = tyLe_VTYT;
        this.tienKham = tienKham;
        this.vanChuyen = vanChuyen;
        this.nguoiBenhChiTra = nguoiBenhChiTra;
        this.BHXH_TTTongCong = BHXH_TTTongCong;
        this.BHXH_CPNgoai = BHXH_CPNgoai;
    }

    protected Report79(Parcel in) {
        hoTen = in.readString();
        namSinhNam = in.readString();
        namSinhNu = in.readString();
        maTheBHYT = in.readString();
        maĐKBĐ = in.readString();
        maBenhKhac = in.readString();
        ngayKham = in.readString();
        tongCong = in.readString();
        xetNghiem = in.readString();
        CĐHA_TDCN = in.readString();
        thuoc = in.readString();
        mau = in.readString();
        TTPT = in.readString();
        VTYT = in.readString();
        TyLe_DVKT = in.readString();
        TyLe_Thuoc = in.readString();
        TyLe_VTYT = in.readString();
        tienKham = in.readString();
        vanChuyen = in.readString();
        nguoiBenhChiTra = in.readString();
        BHXH_TTTongCong = in.readString();
        BHXH_CPNgoai = in.readString();
    }

    public static final Creator<Report79> CREATOR = new Creator<Report79>() {
        @Override
        public Report79 createFromParcel(Parcel in) {
            return new Report79(in);
        }

        @Override
        public Report79[] newArray(int size) {
            return new Report79[size];
        }
    };


    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNamSinhNam() {
        return namSinhNam;
    }

    public void setNamSinhNam(String namSinhNam) {
        this.namSinhNam = namSinhNam;
    }

    public String getNamSinhNu() {
        return namSinhNu;
    }

    public void setNamSinhNu(String namSinhNu) {
        this.namSinhNu = namSinhNu;
    }

    public String getMaTheBHYT() {
        return maTheBHYT;
    }

    public void setMaTheBHYT(String maTheBHYT) {
        this.maTheBHYT = maTheBHYT;
    }

    public String getMaĐKBĐ() {
        return maĐKBĐ;
    }

    public void setMaĐKBĐ(String maĐKBĐ) {
        this.maĐKBĐ = maĐKBĐ;
    }

    public String getMaBenhKhac() {
        return maBenhKhac;
    }

    public void setMaBenhKhac(String maBenhKhac) {
        this.maBenhKhac = maBenhKhac;
    }

    public String getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(String ngayKham) {
        this.ngayKham = ngayKham;
    }

    public String getTongCong() {
        return tongCong;
    }

    public void setTongCong(String tongCong) {
        this.tongCong = tongCong;
    }

    public String getXetNghiem() {
        return xetNghiem;
    }

    public void setXetNghiem(String xetNghiem) {
        this.xetNghiem = xetNghiem;
    }

    public String getCĐHA_TDCN() {
        return CĐHA_TDCN;
    }

    public void setCĐHA_TDCN(String CĐHA_TDCN) {
        this.CĐHA_TDCN = CĐHA_TDCN;
    }

    public String getThuoc() {
        return thuoc;
    }

    public void setThuoc(String thuocBHYT) {
        this.thuoc = thuoc;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getTTPT() {
        return TTPT;
    }

    public void setTTPT(String TTPT) {
        this.TTPT = TTPT;
    }

    public String getVTYT() {
        return VTYT;
    }

    public void setVTYT(String VTYT) {
        this.VTYT = VTYT;
    }

    public String getTyLe_DVKT() {
        return TyLe_DVKT;
    }

    public void setTyLe_DVKT(String tyLe_DVKT) {
        TyLe_DVKT = tyLe_DVKT;
    }

    public String getTyLe_Thuoc() {
        return TyLe_Thuoc;
    }

    public void setTyLe_Thuoc(String tyLe_Thuoc) {
        TyLe_Thuoc = tyLe_Thuoc;
    }

    public String getTyLe_VTYT() {
        return TyLe_VTYT;
    }

    public void setTyLe_VTYT(String tyLe_VTYT) {
        TyLe_VTYT = tyLe_VTYT;
    }

    public String getTienKham() {
        return tienKham;
    }

    public void setTienKham(String tienKham) {
        this.tienKham = tienKham;
    }

    public String getVanChuyen() {
        return vanChuyen;
    }

    public void setVanChuyen(String vanChuyen) {
        this.vanChuyen = vanChuyen;
    }

    public String getNguoiBenhChiTra() {
        return nguoiBenhChiTra;
    }

    public void setNguoiBenhChiTra(String nguoiBenhChiTra) {
        this.nguoiBenhChiTra = nguoiBenhChiTra;
    }

    public String getBHXH_TTTongCong() {
        return BHXH_TTTongCong;
    }

    public void setBHXH_TTTongCong(String BHXH_TTTongCong) {
        this.BHXH_TTTongCong = BHXH_TTTongCong;
    }

    public String getBHXH_CPNgoai() {
        return BHXH_CPNgoai;
    }

    public void setBHXH_CPNgoai(String BHXH_CPNgoai) {
        this.BHXH_CPNgoai = BHXH_CPNgoai;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(hoTen);
        dest.writeString(namSinhNam);
        dest.writeString(namSinhNu);
        dest.writeString(maTheBHYT);
        dest.writeString(maĐKBĐ);
        dest.writeString(maBenhKhac);
        dest.writeString(ngayKham);
        dest.writeString(tongCong);
        dest.writeString(xetNghiem);
        dest.writeString(CĐHA_TDCN);
        dest.writeString(thuoc);
        dest.writeString(mau);
        dest.writeString(TTPT);
        dest.writeString(VTYT);
        dest.writeString(TyLe_DVKT);
        dest.writeString(TyLe_Thuoc);
        dest.writeString(TyLe_VTYT);
        dest.writeString(tienKham);
        dest.writeString(vanChuyen);
        dest.writeString(nguoiBenhChiTra);
        dest.writeString(BHXH_TTTongCong);
        dest.writeString(BHXH_CPNgoai);
    }
}
