package com.example.qtht.mychart.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.qtht.mychart.interFace.ICallBack;
import com.example.qtht.mychart.model.Account;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by qtht on 06/05/2017.
 */

public class LoginTask extends AsyncTask<String,Void,Account> {
    private static final String URL = "http://10.61.68.143:8088/QuanLyTaiKhoan.svc/GetByUserName?";
    private static final String USERNAME = "username=";
    private static final String PASSWORD = "&password=";
    Account account=new Account();
    Context context;
    ProgressDialog progressDialog;
    ICallBack iCallBack;

    public LoginTask(Context context){
        this.context=context;
        progressDialog=new ProgressDialog(context);
        this.iCallBack= (ICallBack) context;

    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    @Override
    protected Account doInBackground(String... params) {
        try {
            URL url=new URL(URL + USERNAME + params[0] + PASSWORD + params[1]);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();

            InputStreamReader inputStreamReader=new InputStreamReader(connection.getInputStream());
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

            StringBuilder builder=new StringBuilder();
            String line=bufferedReader.readLine();
            while (line!=null)
            {
                builder.append(line);
                line=bufferedReader.readLine();
            }

            JSONObject jsonObject=new JSONObject(builder.toString());
            if(jsonObject.has("TrangThaiXuLy"))
                account.setStatus(jsonObject.getString("TrangThaiXuLy"));

            String jsonDuLieu=jsonObject.getString("DuLieu").toString();
            JSONArray dulieus = new JSONArray(jsonDuLieu);
            JSONObject c = dulieus.getJSONObject(0);
            account.setHangbenhvien(c.getString("HANGBENHVIEN"));
            account.setUserName(c.getString("USER_NAME"));
            account.setTenbenhvien(c.getString("TENBENHVIEN"));

        }catch (Exception e){
            Log.e("LOI",e.toString());
        }
        return account;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setMessage("Waiting...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(Account account) {
        super.onPostExecute(account);
        iCallBack.callback();
        progressDialog.dismiss();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


}