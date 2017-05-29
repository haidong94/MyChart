package com.example.qtht.mychart.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.qtht.mychart.interFace.ICallListReport20;
import com.example.qtht.mychart.model.Report20;

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

public class Report20Task extends AsyncTask<String,Void,ArrayList<Report20>> {
    private static final String URL = "http://10.61.68.143:8088/QuanLyTaiKhoan.svc/LayChiTietBaoCao20?";

    private static final String USERNAME = "username=";
    private static final String PASSWORD = "&password=";
    private static final String MABENHVIEN="&mabenhvien=";
    private static final String TUNGAY="&tungay=";
    private static final String DENNGAY="&denngay=";
    Context context;
    ArrayList<Report20> list=new ArrayList<>();
    ProgressDialog progressDialog;
    ICallListReport20 iCallListReport20;

    public ArrayList<Report20> getList() {
        return list;
    }

    public void setList(ArrayList<Report20> list) {
        this.list = list;
    }

    public Report20Task(Context context){
        this.context=context;
        progressDialog=new ProgressDialog(context);
        this.iCallListReport20= (ICallListReport20) context;
    }



    @Override
    protected ArrayList<Report20> doInBackground(String... params) {

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
            JSONArray dulieus = new JSONArray(jsonDuLieu);

            for (int i = 0; i < dulieus.length(); i++) {
                JSONObject c = dulieus.getJSONObject(i);
                String STTTheoDMT=c.getString("STT_DMBYT");
                String TenHoatChat=c.getString("HOATCHAT");
                String TenThuoc=c.getString("TEN");
                String DuongDung=c.getString("DUONGDUNG");
                String SoDK=c.getString("SODK");
                String DonViTinh=c.getString("DANG");
                String NgoaiTru=c.getString("SOLUONGNGOAITRU");
                String NoiTru=c.getString("SOLUONGNOITRU");
                String DonGia=c.getString("DONGIABV");
                String ThanhTien=c.getString("THANHTIEN");

                Report20 duLieu=new Report20();

                duLieu.setSTTTheoDMT(STTTheoDMT);
                duLieu.setTenHoatChat(TenHoatChat);
                duLieu.setTenThuoc(TenThuoc);
                duLieu.setDuongDungDangBC(DuongDung);
                duLieu.setSoDangKy(SoDK);
                duLieu.setDonViTinh(DonViTinh);
                duLieu.setNoiTru(NoiTru);
                duLieu.setNgoaiTru(NgoaiTru);

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
    protected void onPostExecute(ArrayList<Report20> costs) {
        super.onPostExecute(costs);
        iCallListReport20.callListReport20();
        progressDialog.dismiss();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}


