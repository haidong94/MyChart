package com.example.qtht.mychart.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by qtht on 12/05/2017.
 */

public class Report80 implements Parcelable {
    private String hoTen;
    private String namSinhNam;
    private String namSinhNu;
    private String maTheBHYT;
    private String maDKBD;
    private String maBenh;
    private String ngayVao;
    private String ngayRa;
    private String soNgayDieuTri;
    private String tongCong;
    private String xetNghiem;
    private String CDHA;
    private String thuoc;
    private String mau;
    private String TIPT;
    private String VTYT;
    private String DVKT_TyLe;
    private String thuoc_TyLe;
    private String VTYT_TyLe;
    private String tienGiuong;
    private String vanChuyen;
    private String nguoiBenhTra;

    public Report80() {
    }

    private String tongCong_BHYTTT;

    public Report80(String hoTen, String namSinhNam, String namSinhNu, String maTheBHYT, String maDKBD, String maBenh, String ngayVao, String ngayRa, String soNgayDieuTri, String tongCong, String xetNghiem, String CDHA, String thuoc, String mau, String TIPT, String VTYT, String DVKT_TyLe, String thuoc_TyLe, String VTYT_TyLe, String tienGiuong, String vanChuyen, String nguoiBenhTra, String tongCong_BHYTTT, String quyDinhSuat_BHYTTT) {
        this.hoTen = hoTen;
        this.namSinhNam = namSinhNam;
        this.namSinhNu = namSinhNu;
        this.maTheBHYT = maTheBHYT;
        this.maDKBD = maDKBD;
        this.maBenh = maBenh;
        this.ngayVao = ngayVao;
        this.ngayRa = ngayRa;
        this.soNgayDieuTri = soNgayDieuTri;
        this.tongCong = tongCong;
        this.xetNghiem = xetNghiem;
        this.CDHA = CDHA;
        this.thuoc = thuoc;
        this.mau = mau;
        this.TIPT = TIPT;
        this.VTYT = VTYT;
        this.DVKT_TyLe = DVKT_TyLe;
        this.thuoc_TyLe = thuoc_TyLe;
        this.VTYT_TyLe = VTYT_TyLe;
        this.tienGiuong = tienGiuong;
        this.vanChuyen = vanChuyen;
        this.nguoiBenhTra = nguoiBenhTra;
        this.tongCong_BHYTTT = tongCong_BHYTTT;
        this.quyDinhSuat_BHYTTT = quyDinhSuat_BHYTTT;
    }

    private String quyDinhSuat_BHYTTT;

    protected Report80(Parcel in) {
        hoTen = in.readString();
        namSinhNam = in.readString();
        namSinhNu = in.readString();
        maTheBHYT = in.readString();
        maDKBD = in.readString();
        maBenh = in.readString();
        ngayVao = in.readString();
        ngayRa = in.readString();
        soNgayDieuTri = in.readString();
        tongCong = in.readString();
        xetNghiem = in.readString();
        CDHA = in.readString();
        thuoc = in.readString();
        mau = in.readString();
        TIPT = in.readString();
        VTYT = in.readString();
        DVKT_TyLe = in.readString();
        thuoc_TyLe = in.readString();
        VTYT_TyLe = in.readString();
        tienGiuong = in.readString();
        vanChuyen = in.readString();
        nguoiBenhTra = in.readString();
        tongCong_BHYTTT = in.readString();
        quyDinhSuat_BHYTTT = in.readString();
    }

    public static final Creator<Report80> CREATOR = new Creator<Report80>() {
        @Override
        public Report80 createFromParcel(Parcel in) {
            return new Report80(in);
        }

        @Override
        public Report80[] newArray(int size) {
            return new Report80[size];
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

    public String getMaDKBD() {
        return maDKBD;
    }

    public void setMaDKBD(String maDKBD) {
        this.maDKBD = maDKBD;
    }

    public String getMaBenh() {
        return maBenh;
    }

    public void setMaBenh(String maBenh) {
        this.maBenh = maBenh;
    }

    public String getNgayVao() {
        return ngayVao;
    }

    public void setNgayVao(String ngayVao) {
        this.ngayVao = ngayVao;
    }

    public String getNgayRa() {
        return ngayRa;
    }

    public void setNgayRa(String ngayRa) {
        this.ngayRa = ngayRa;
    }

    public String getSoNgayDieuTri() {
        return soNgayDieuTri;
    }

    public void setSoNgayDieuTri(String soNgayDieuTri) {
        this.soNgayDieuTri = soNgayDieuTri;
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

    public String getCDHA() {
        return CDHA;
    }

    public void setCDHA(String CDHA) {
        this.CDHA = CDHA;
    }

    public String getThuoc() {
        return thuoc;
    }

    public void setThuoc(String thuoc) {
        this.thuoc = thuoc;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getTIPT() {
        return TIPT;
    }

    public void setTIPT(String TIPT) {
        this.TIPT = TIPT;
    }

    public String getVTYT() {
        return VTYT;
    }

    public void setVTYT(String VTYT) {
        this.VTYT = VTYT;
    }

    public String getDVKT_TyLe() {
        return DVKT_TyLe;
    }

    public void setDVKT_TyLe(String DVKT_TyLe) {
        this.DVKT_TyLe = DVKT_TyLe;
    }

    public String getThuoc_TyLe() {
        return thuoc_TyLe;
    }

    public void setThuoc_TyLe(String thuoc_TyLe) {
        this.thuoc_TyLe = thuoc_TyLe;
    }

    public String getVTYT_TyLe() {
        return VTYT_TyLe;
    }

    public void setVTYT_TyLe(String VTYT_TyLe) {
        this.VTYT_TyLe = VTYT_TyLe;
    }

    public String getTienGiuong() {
        return tienGiuong;
    }

    public void setTienGiuong(String tienGiuong) {
        this.tienGiuong = tienGiuong;
    }

    public String getVanChuyen() {
        return vanChuyen;
    }

    public void setVanChuyen(String vanChuyen) {
        this.vanChuyen = vanChuyen;
    }

    public String getNguoiBenhTra() {
        return nguoiBenhTra;
    }

    public void setNguoiBenhTra(String nguoiBenhTra) {
        this.nguoiBenhTra = nguoiBenhTra;
    }

    public String getTongCong_BHYTTT() {
        return tongCong_BHYTTT;
    }

    public void setTongCong_BHYTTT(String tongCong_BHYTTT) {
        this.tongCong_BHYTTT = tongCong_BHYTTT;
    }

    public String getQuyDinhSuat_BHYTTT() {
        return quyDinhSuat_BHYTTT;
    }

    public void setQuyDinhSuat_BHYTTT(String quyDinhSuat_BHYTTT) {
        this.quyDinhSuat_BHYTTT = quyDinhSuat_BHYTTT;
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
        dest.writeString(maDKBD);
        dest.writeString(maBenh);
        dest.writeString(ngayVao);
        dest.writeString(ngayRa);
        dest.writeString(soNgayDieuTri);
        dest.writeString(tongCong);
        dest.writeString(xetNghiem);
        dest.writeString(CDHA);
        dest.writeString(thuoc);
        dest.writeString(mau);
        dest.writeString(TIPT);
        dest.writeString(VTYT);
        dest.writeString(DVKT_TyLe);
        dest.writeString(thuoc_TyLe);
        dest.writeString(VTYT_TyLe);
        dest.writeString(tienGiuong);
        dest.writeString(vanChuyen);
        dest.writeString(nguoiBenhTra);
        dest.writeString(tongCong_BHYTTT);
        dest.writeString(quyDinhSuat_BHYTTT);
    }
}
