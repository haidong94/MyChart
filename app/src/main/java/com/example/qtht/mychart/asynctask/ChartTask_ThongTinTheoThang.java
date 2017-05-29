package com.example.qtht.mychart.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.qtht.mychart.interFace.ICallListTTTT;
import com.example.qtht.mychart.model.ChiPhi;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by qtht on 05/05/2017.
 */

public class ChartTask_ThongTinTheoThang extends AsyncTask<String,Void,ArrayList<ChiPhi>> {
    private static final String URL = "http://10.61.68.143:8088/QuanLyTaiKhoan.svc/ThongTinTheoThang?";

    private static final String USERNAME = "username=";
    private static final String PASSWORD = "&password=";
    private static final String MABENHVIEN="&mabenhvien=";
    Context context;
    ArrayList<ChiPhi> list=new ArrayList<>();
    ICallListTTTT iCallListTTTT;
    ProgressDialog progressDialog;

    public ArrayList<ChiPhi> getList() {
        return list;
    }

    public void setList(ArrayList<ChiPhi> list) {
        this.list = list;
    }

    public ChartTask_ThongTinTheoThang(Context context){
        this.context=context;
        progressDialog=new ProgressDialog(context);
        this.iCallListTTTT= (ICallListTTTT) context;
    }

    @Override
    protected ArrayList<ChiPhi> doInBackground(String... params) {

        try{
            URL url=new URL(URL + USERNAME + params[0] + PASSWORD + params[1] + MABENHVIEN + params[2]);

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
            String jsonDuLieu=jsonObject.getString("DuLieu").toString();

            JSONArray dulieus = new JSONArray(jsonDuLieu);
            for (int i = 0; i < dulieus.length(); i++) {
                JSONObject c = dulieus.getJSONObject(i);
                String ngaythang=c.getString("NGAYTHANG");
                String tongsobenhnhan=c.getString("TONGSOBENHNHAN");
                String tongbhthanhtoan=c.getString("TONGBHTHANHTOAN");
                String tongbnthanhtoan=c.getString("TONGBNTHANHTOAN");
                String tongchiphi=c.getString("TONGCHIPHI");


                ChiPhi duLieu=new ChiPhi();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                try {
                    Date date = format.parse(ngaythang);
                    SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM");
                    String newDateStr=dateFormat.format(date).toUpperCase();
                    duLieu.setNGAYTHANG(newDateStr.toString());
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                duLieu.setTONGSOBENHNHAN(tongsobenhnhan);
                duLieu.setTONGBHTHANHTOAN(tongbhthanhtoan);
                duLieu.setTONGBNTHANHTOAN(tongbnthanhtoan);
                duLieu.setTONGCHIPHI(tongchiphi);

                list.add(duLieu);

            }


        }catch (Exception e){
            Log.e("Lỗi",e.toString());
        }
        return list;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setMessage("Waiting...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(ArrayList<ChiPhi> costs) {
        super.onPostExecute(costs);
        iCallListTTTT.callListTTTT();
        progressDialog.dismiss();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}

