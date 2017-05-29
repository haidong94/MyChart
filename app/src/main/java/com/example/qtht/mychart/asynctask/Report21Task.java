package com.example.qtht.mychart.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.qtht.mychart.interFace.ICallListReport21;
import com.example.qtht.mychart.model.Report21;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by qtht on 12/05/2017.
 */

public class Report21Task extends AsyncTask<String,Void,ArrayList<Report21>> {
    private static final String URL = "http://10.61.68.143:8088/QuanLyTaiKhoan.svc/LayChiTietBaoCao21?";

    private static final String USERNAME = "username=";
    private static final String PASSWORD = "&password=";
    private static final String MABENHVIEN="&mabenhvien=";
    private static final String TUNGAY="&tungay=";
    private static final String DENNGAY="&denngay=";
    Context context;
    ArrayList<Report21> list=new ArrayList<>();
    ProgressDialog progressDialog;
    ICallListReport21 iCallListReport21;

    public ArrayList<Report21> getList() {
        return list;
    }

    public void setList(ArrayList<Report21> list) {
        this.list = list;
    }

    public Report21Task(Context context){
        this.context=context;
        progressDialog=new ProgressDialog(context);
        this.iCallListReport21= (ICallListReport21) context;
    }



    @Override
    protected ArrayList<Report21> doInBackground(String... params) {

        try{
            URL url=new URL(URL + USERNAME + params[0] + PASSWORD + params[1] + MABENHVIEN + params[2]+ TUNGAY + params[3]+ DENNGAY + params[4] + "&ngoaitru=1&noitru=1");

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

            JSONArray jsonArray = new JSONArray(jsonDuLieu);
            String jsonDuLieu1=jsonArray.get(0).toString();
            JSONArray dulieus = new JSONArray(jsonDuLieu1);

            for (int i = 0; i < dulieus.length(); i++) {
                JSONObject c = dulieus.getJSONObject(i);
                String MSTheoDMBYT=c.getString("STT_DMBYT");
                String TenDVYT=c.getString("LOAIDICHVU");
               // String NgoaiTru=c.getString("SOLUONGNGOAITRU");
                String NoiTru=c.getString("SOLUONGNOITRU");
                String DonGia=c.getString("DONGIABV");
                String ThanhTien=c.getString("THANHTIEN");

                Report21 duLieu=new Report21();

                duLieu.setMaSoTheoDMBYT(MSTheoDMBYT);
                duLieu.setTenDVYT(TenDVYT);
              //  duLieu.setNgoaiTru(NgoaiTru);
                duLieu.setNoiTru(NoiTru);
                duLieu.setDonGia(DonGia);
                duLieu.setThanhTien(ThanhTien);

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
    protected void onPostExecute(ArrayList<Report21> costs) {
        super.onPostExecute(costs);
        iCallListReport21.callListReport21();
        progressDialog.dismiss();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}


