package com.example.qtht.mychart.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.qtht.mychart.interFace.ICallListTTTHSLH;
import com.example.qtht.mychart.model.BenhNhan;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by qtht on 06/05/2017.
 */

public class ChartTask_ThongTinTongHopSoLuongHuyen extends AsyncTask<String,Void,ArrayList<BenhNhan>> {
    private static final String URL = "http://10.61.68.143:8088/QuanLyTaiKhoan.svc/ThongTinTongHopSoLuongHuyen?";

    private static final String USERNAME = "username=";
    private static final String PASSWORD = "&password=";
    private static final String MABENHVIEN="&mabenhvien=";
    Context context;
    ArrayList<BenhNhan> list=new ArrayList<>();
    ProgressDialog progressDialog;
    ICallListTTTHSLH iCallListTTTHSLH;

    public ArrayList<BenhNhan> getList() {
        return list;
    }

    public void setList(ArrayList<BenhNhan> list) {
        this.list = list;
    }

    public ChartTask_ThongTinTongHopSoLuongHuyen(Context context){
        this.context=context;
        progressDialog=new ProgressDialog(context);
        this.iCallListTTTHSLH= (ICallListTTTHSLH) context;
    }

    @Override
    protected ArrayList<BenhNhan> doInBackground(String... params) {

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
                String tyt=c.getString("TYT");
                String tentyt=c.getString("TENTYT");
                String tongsobenhnhan=c.getString("TONGSOBENHNHAN");
                String tongbnngoaitrubhyt=c.getString("TONGBNNGOAITRUBHYT");
                String tongbnngoaitrumienphi=c.getString("TONGBNNGOAITRUMIENPHI");
                String tongbnngoaitruthuphi=c.getString("TONGBNNGOAITRUTHUPHI");
                String tongbnnoitrubhyt=c.getString("TONGBNNOITRUBHYT");
                String tongbnnoitrumienphi=c.getString("TONGBNNOITRUMIENPHI");
                String tongbnnoitruthuphi=c.getString("TONGBNNOITRUTHUPHI");


                BenhNhan duLieu=new BenhNhan();
                duLieu.setTYT(tyt);
                duLieu.setTENTYT(tentyt);
                duLieu.setTONGSOBENHNHAN(tongsobenhnhan);
                duLieu.setTONGBNNGOAITRUBHYT(tongbnngoaitrubhyt);
                duLieu.setTONGBNNGOAITRUMIENPHI(tongbnngoaitrumienphi);
                duLieu.setTONGBNNGOAITRUTHUPHI(tongbnngoaitruthuphi);
                duLieu.setTONGBNNOITRUBHYT(tongbnnoitrubhyt);
                duLieu.setTONGBNNOITRUMIENPHI(tongbnnoitrumienphi);
                duLieu.setTONGBNNOITRUTHUPHI(tongbnnoitruthuphi);

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
    protected void onPostExecute(ArrayList<BenhNhan> costs) {
        super.onPostExecute(costs);
        iCallListTTTHSLH.callListTTTHSLH();
        if(progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}