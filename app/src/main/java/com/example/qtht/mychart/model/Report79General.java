package com.example.qtht.mychart.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by qtht on 17/05/2017.
 */

public class Report79General implements Parcelable {
    private String TT;
    private String khamChuaBenh;
    private String soLuot;
    private String tongCong;
    private String xetNghiem;
    private String CDHA;
    private String thuoc;
    private String mau;
    private String TTPT;
    private String VTYT;
    private String DKVT_TyLe;
    private String Thuoc_TyLe;
    private String VTYT_TyLe;
    private String tienKham;
    private String vanChuyen;
    private String nguoiBenhTra;
    private String BHYT_TTTongCong;
    private String BHYT_NgoaiDinhSuat;

    public Report79General(String TT, String khamChuaBenh, String soLuot, String tongCong, String xetNghiem, String CDHA, String thuoc, String mau, String TTPT, String VTYT, String DKVT_TyLe, String thuoc_TyLe, String VTYT_TyLe, String tienKham, String vanChuyen, String nguoiBenhTra, String BHYT_TTTongCong, String BHYT_NgoaiDinhSuat) {
        this.TT = TT;
        this.khamChuaBenh = khamChuaBenh;
        this.soLuot = soLuot;
        this.tongCong = tongCong;
        this.xetNghiem = xetNghiem;
        this.CDHA = CDHA;
        this.thuoc = thuoc;
        this.mau = mau;
        this.TTPT = TTPT;
        this.VTYT = VTYT;
        this.DKVT_TyLe = DKVT_TyLe;
        Thuoc_TyLe = thuoc_TyLe;
        this.VTYT_TyLe = VTYT_TyLe;
        this.tienKham = tienKham;
        this.vanChuyen = vanChuyen;
        this.nguoiBenhTra = nguoiBenhTra;
        this.BHYT_TTTongCong = BHYT_TTTongCong;
        this.BHYT_NgoaiDinhSuat = BHYT_NgoaiDinhSuat;
    }

    public Report79General() {
    }



    protected Report79General(Parcel in) {
        TT = in.readString();
        khamChuaBenh = in.readString();
        soLuot = in.readString();
        tongCong = in.readString();
        xetNghiem = in.readString();
        CDHA = in.readString();
        thuoc = in.readString();
        mau = in.readString();
        TTPT = in.readString();
        VTYT = in.readString();
        DKVT_TyLe = in.readString();
        Thuoc_TyLe = in.readString();
        VTYT_TyLe = in.readString();
        tienKham = in.readString();
        vanChuyen = in.readString();
        nguoiBenhTra = in.readString();
        BHYT_TTTongCong = in.readString();
        BHYT_NgoaiDinhSuat = in.readString();
    }

    public static final Creator<Report79General> CREATOR = new Creator<Report79General>() {
        @Override
        public Report79General createFromParcel(Parcel in) {
            return new Report79General(in);
        }

        @Override
        public Report79General[] newArray(int size) {
            return new Report79General[size];
        }
    };

    public String getTT() {
        return TT;
    }

    public void setTT(String TT) {
        this.TT = TT;
    }

    public String getKhamChuaBenh() {
        return khamChuaBenh;
    }

    public void setKhamChuaBenh(String khamChuaBenh) {
        this.khamChuaBenh = khamChuaBenh;
    }

    public String getSoLuot() {
        return soLuot;
    }

    public void setSoLuot(String soLuot) {
        this.soLuot = soLuot;
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

    public String getDKVT_TyLe() {
        return DKVT_TyLe;
    }

    public void setDKVT_TyLe(String DKVT_TyLe) {
        this.DKVT_TyLe = DKVT_TyLe;
    }

    public String getThuoc_TyLe() {
        return Thuoc_TyLe;
    }

    public void setThuoc_TyLe(String thuoc_TyLe) {
        Thuoc_TyLe = thuoc_TyLe;
    }

    public String getVTYT_TyLe() {
        return VTYT_TyLe;
    }

    public void setVTYT_TyLe(String VTYT_TyLe) {
        this.VTYT_TyLe = VTYT_TyLe;
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

    public String getNguoiBenhTra() {
        return nguoiBenhTra;
    }

    public void setNguoiBenhTra(String nguoiBenhTra) {
        this.nguoiBenhTra = nguoiBenhTra;
    }

    public String getBHYT_TTTongCong() {
        return BHYT_TTTongCong;
    }

    public void setBHYT_TTTongCong(String BHYT_TTTongCong) {
        this.BHYT_TTTongCong = BHYT_TTTongCong;
    }

    public String getBHYT_NgoaiDinhSuat() {
        return BHYT_NgoaiDinhSuat;
    }

    public void setBHYT_NgoaiDinhSuat(String BHYT_NgoaiDinhSuat) {
        this.BHYT_NgoaiDinhSuat = BHYT_NgoaiDinhSuat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(TT);
        dest.writeString(khamChuaBenh);
        dest.writeString(soLuot);
        dest.writeString(tongCong);
        dest.writeString(xetNghiem);
        dest.writeString(CDHA);
        dest.writeString(thuoc);
        dest.writeString(mau);
        dest.writeString(TTPT);
        dest.writeString(VTYT);
        dest.writeString(DKVT_TyLe);
        dest.writeString(Thuoc_TyLe);
        dest.writeString(VTYT_TyLe);
        dest.writeString(tienKham);
        dest.writeString(vanChuyen);
        dest.writeString(nguoiBenhTra);
        dest.writeString(BHYT_TTTongCong);
        dest.writeString(BHYT_NgoaiDinhSuat);
    }
}
