package com.example.qtht.mychart.model;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by qtht on 03/05/2017.
 */

public class ChiPhi implements Parcelable {
    private String NGAYTHANG;
    private String TYT;
    private String TENTYT;

    private String TONGSOBENHNHAN;
    private String TONGBHTHANHTOAN;
    private String TONGBNTHANHTOAN;
    private String TONGCHIPHI;

    public ChiPhi() {
    }

    public ChiPhi(String NGAYTHANG,String TYT, String TENTYT,String TONGSOBENHNHAN, String TONGBHTHANHTOAN, String TONGBNTHANHTOAN, String TONGCHIPHI) {
        this.NGAYTHANG=NGAYTHANG;
        this.TYT=TYT;
        this.TENTYT=TENTYT;

        this.TONGSOBENHNHAN = TONGSOBENHNHAN;
        this.TONGBHTHANHTOAN = TONGBHTHANHTOAN;
        this.TONGBNTHANHTOAN = TONGBNTHANHTOAN;
        this.TONGCHIPHI = TONGCHIPHI;
    }

    protected ChiPhi(Parcel in) {
        NGAYTHANG=in.readString();
        TYT=in.readString();
        TENTYT=in.readString();
        TONGSOBENHNHAN = in.readString();
        TONGBHTHANHTOAN = in.readString();
        TONGBNTHANHTOAN = in.readString();
        TONGCHIPHI = in.readString();
    }

    public static final Creator<ChiPhi> CREATOR = new Creator<ChiPhi>() {
        @Override
        public ChiPhi createFromParcel(Parcel in) {
            return new ChiPhi(in);
        }

        @Override
        public ChiPhi[] newArray(int size) {
            return new ChiPhi[size];
        }
    };

    public String getNGAYTHANG() {
        return NGAYTHANG;
    }

    public void setNGAYTHANG(String NGAYTHANG) {
        this.NGAYTHANG = NGAYTHANG;
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
    public String getTONGCHIPHI() {
        return TONGCHIPHI;
    }

    public void setTONGCHIPHI(String TONGCHIPHI) {
        this.TONGCHIPHI = TONGCHIPHI;
    }

    public String getTONGSOBENHNHAN() {
        return TONGSOBENHNHAN;
    }

    public void setTONGSOBENHNHAN(String TONGSOBENHNHAN) {
        this.TONGSOBENHNHAN = TONGSOBENHNHAN;
    }

    public String getTONGBHTHANHTOAN() {
        return TONGBHTHANHTOAN;
    }

    public void setTONGBHTHANHTOAN(String TONGBHTHANHTOAN) {
        this.TONGBHTHANHTOAN = TONGBHTHANHTOAN;
    }

    public String getTONGBNTHANHTOAN() {
        return TONGBNTHANHTOAN;
    }

    public void setTONGBNTHANHTOAN(String TONGBNTHANHTOAN) {
        this.TONGBNTHANHTOAN = TONGBNTHANHTOAN;
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
        dest.writeString(TONGBHTHANHTOAN);
        dest.writeString(TONGBNTHANHTOAN);
        dest.writeString(TONGCHIPHI);
    }
}
