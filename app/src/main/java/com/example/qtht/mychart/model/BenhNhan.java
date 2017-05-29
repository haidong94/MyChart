package com.example.qtht.mychart.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by qtht on 06/05/2017.
 */

public class BenhNhan implements Parcelable {
    private String NGAYTHANG;
    private String TYT;
    private String TENTYT;

    private String TONGSOBENHNHAN;
    private String TONGBNNGOAITRUBHYT;
    private String TONGBNNGOAITRUTHUPHI;
    private String TONGBNNGOAITRUMIENPHI;
    private String TONGBNNOITRUBHYT;
    private String TONGBNNOITRUTHUPHI;
    private String TONGBNNOITRUMIENPHI;

    public BenhNhan(Parcel in) {
        NGAYTHANG=in.readString();
        TYT=in.readString();
        TENTYT=in.readString();
        TONGSOBENHNHAN = in.readString();
        TONGBNNGOAITRUBHYT = in.readString();
        TONGBNNGOAITRUTHUPHI = in.readString();
        TONGBNNGOAITRUMIENPHI = in.readString();
        TONGBNNOITRUBHYT = in.readString();
        TONGBNNOITRUTHUPHI = in.readString();
        TONGBNNOITRUMIENPHI = in.readString();
    }

    public static final Creator<BenhNhan> CREATOR = new Creator<BenhNhan>() {
        @Override
        public BenhNhan createFromParcel(Parcel in) {
            return new BenhNhan(in);
        }

        @Override
        public BenhNhan[] newArray(int size) {
            return new BenhNhan[size];
        }
    };

    public BenhNhan() {

    }

    public BenhNhan(String NGAYTHANG,String TYT, String TENTYT,String TONGSOBENHNHAN, String TONGBNNGOAITRUBHYT, String TONGBNNGOAITRUTHUPHI, String TONGBNNGOAITRUMIENPHI, String TONGBNNOITRUBHYT, String TONGBNNOITRUTHUPHI, String TONGBNNOITRUMIENPHI) {
        this.NGAYTHANG=NGAYTHANG;
        this.TYT=TYT;
        this.TENTYT=TENTYT;

        this.TONGSOBENHNHAN = TONGSOBENHNHAN;
        this.TONGBNNGOAITRUBHYT = TONGBNNGOAITRUBHYT;
        this.TONGBNNGOAITRUTHUPHI = TONGBNNGOAITRUTHUPHI;
        this.TONGBNNGOAITRUMIENPHI = TONGBNNGOAITRUMIENPHI;
        this.TONGBNNOITRUBHYT = TONGBNNOITRUBHYT;
        this.TONGBNNOITRUTHUPHI = TONGBNNOITRUTHUPHI;
        this.TONGBNNOITRUMIENPHI = TONGBNNOITRUMIENPHI;
    }

    public String getTYT() {
        return TYT;
    }

    public void setTYT(String TYT) {
        this.TYT = TYT;
    }

    public String getTENTYT() {
        return TENTYT;
    }

    public void setTENTYT(String TENTYT) {
        this.TENTYT = TENTYT;
    }

    public String getNGAYTHANG() {
        return NGAYTHANG;
    }

    public void setNGAYTHANG(String NGAYTHANG) {
        this.NGAYTHANG = NGAYTHANG;
    }

    public String getTONGSOBENHNHAN() {
        return TONGSOBENHNHAN;
    }

    public void setTONGSOBENHNHAN(String TONGSOBENHNHAN) {
        this.TONGSOBENHNHAN = TONGSOBENHNHAN;
    }

    public String getTONGBNNGOAITRUBHYT() {
        return TONGBNNGOAITRUBHYT;
    }

    public void setTONGBNNGOAITRUBHYT(String TONGBNNGOAITRUBHYT) {
        this.TONGBNNGOAITRUBHYT = TONGBNNGOAITRUBHYT;
    }

    public String getTONGBNNGOAITRUTHUPHI() {
        return TONGBNNGOAITRUTHUPHI;
    }

    public void setTONGBNNGOAITRUTHUPHI(String TONGBNNGOAITRUTHUPHI) {
        this.TONGBNNGOAITRUTHUPHI = TONGBNNGOAITRUTHUPHI;
    }

    public String getTONGBNNGOAITRUMIENPHI() {
        return TONGBNNGOAITRUMIENPHI;
    }

    public void setTONGBNNGOAITRUMIENPHI(String TONGBNNGOAITRUMIENPHI) {
        this.TONGBNNGOAITRUMIENPHI = TONGBNNGOAITRUMIENPHI;
    }

    public String getTONGBNNOITRUBHYT() {
        return TONGBNNOITRUBHYT;
    }

    public void setTONGBNNOITRUBHYT(String TONGBNNOITRUBHYT) {
        this.TONGBNNOITRUBHYT = TONGBNNOITRUBHYT;
    }

    public String getTONGBNNOITRUTHUPHI() {
        return TONGBNNOITRUTHUPHI;
    }

    public void setTONGBNNOITRUTHUPHI(String TONGBNNOITRUTHUPHI) {
        this.TONGBNNOITRUTHUPHI = TONGBNNOITRUTHUPHI;
    }

    public String getTONGBNNOITRUMIENPHI() {
        return TONGBNNOITRUMIENPHI;
    }

    public void setTONGBNNOITRUMIENPHI(String TONGBNNOITRUMIENPHI) {
        this.TONGBNNOITRUMIENPHI = TONGBNNOITRUMIENPHI;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(NGAYTHANG);
        dest.writeString(TYT);
        dest.writeString(TENTYT);
        dest.writeString(TONGSOBENHNHAN);
        dest.writeString(TONGBNNGOAITRUBHYT);
        dest.writeString(TONGBNNGOAITRUTHUPHI);
        dest.writeString(TONGBNNGOAITRUMIENPHI);
        dest.writeString(TONGBNNOITRUBHYT);
        dest.writeString(TONGBNNOITRUTHUPHI);
        dest.writeString(TONGBNNOITRUMIENPHI);
    }
}
