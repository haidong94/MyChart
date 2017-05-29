package com.example.qtht.mychart.model;

/**
 * Created by qtht on 03/05/2017.
 */

public class Account {
    private String userName;
    private String password;
    private String status;
    private String hangbenhvien;
    private String tenbenhvien;

    public String getTenbenhvien() {
        return tenbenhvien;
    }

    public void setTenbenhvien(String tenbenhvien) {
        this.tenbenhvien = tenbenhvien;
    }


    public String getHangbenhvien() {
        return hangbenhvien;
    }

    public void setHangbenhvien(String hangbenhvien) {
        this.hangbenhvien = hangbenhvien;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
