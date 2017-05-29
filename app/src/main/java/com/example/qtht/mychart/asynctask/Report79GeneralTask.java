package com.example.qtht.mychart.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.qtht.mychart.interFace.ICallListReport79General;
import com.example.qtht.mychart.model.Report79General;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by qtht on 17/05/2017.
 */

public class Report79GeneralTask extends AsyncTask<String,Void,ArrayList<Report79General>> {
    private static final String URL = "http://10.61.68.143:8088/QuanLyTaiKhoan.svc/LayChiTietBaoCao79TongHop?";

    private static final String USERNAME = "username=";
    private static final String PASSWORD = "&password=";
    private static final String MABENHVIEN="&mabenhvien=";
    private static final String TUNGAY="&tungay=";
    private static final String DENNGAY="&denngay=";
    Context context;
    ArrayList<Report79General> list=new ArrayList<>();
    ProgressDialog progressDialog;
    ICallListReport79General iCallListReport79Gerenal;

    public ArrayList<Report79General> getList() {
        return list;
    }

    public void setList(ArrayList<Report79General> list) {
        this.list = list;
    }

    public Report79GeneralTask(Context context){
        this.context=context;
        progressDialog=new ProgressDialog(context);
        this.iCallListReport79Gerenal= (ICallListReport79General) context;
    }



    @Override
    protected ArrayList<Report79General> doInBackground(String... params) {

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
                String KhamChuaBenh=c.getString("KHAMBENH");
                String SoLuot=c.getString("SOLUOT");
                String TongCong=c.getString("TONGCHIPHI");
                String XetNghiem=c.getString("XN");
                String CDHA=c.getString("CDHA");
                String Thuoc=c.getString("THUOC_BHYT");
                String Mau=c.getString("MAU");
                String TTPT=c.getString("PTTT");
                String VTYT=c.getString("VTYT");

                String DKVT_TyLe=c.getString("DVKT_TYLE");
                String Thuoc_TyLe=c.getString("MAU");
                String VTYT_TyLe=c.getString("VTYT_TYLE");
                String TienKham=c.getString("TONGCHIPHI");
                String VanChuyen=c.getString("VANCHUYEN");
                String NguoiBenhTra=c.getString("TONGBNTT");
                String BHYT_TTTongCong=c.getString("TONGBHYTTT");
                String BHYT_NgoaiDinhSuat=c.getString("NGOAIDINHSUAT");

                Report79General duLieu=new Report79General();

                duLieu.setKhamChuaBenh(KhamChuaBenh);
                duLieu.setSoLuot(SoLuot);
                duLieu.setTongCong(TongCong);
                duLieu.setXetNghiem(XetNghiem);
                duLieu.setCDHA(CDHA);
                duLieu.setThuoc(Thuoc);
                duLieu.setMau(Mau);
                duLieu.setTTPT(TTPT);
                duLieu.setVTYT(VTYT);
                duLieu.setDKVT_TyLe(DKVT_TyLe);
                duLieu.setThuoc_TyLe(Thuoc_TyLe);
                duLieu.setVTYT_TyLe(VTYT_TyLe);
                duLieu.setTienKham(TienKham);
                duLieu.setVanChuyen(VanChuyen);
                duLieu.setNguoiBenhTra(NguoiBenhTra);
                duLieu.setBHYT_TTTongCong(BHYT_TTTongCong);
                duLieu.setBHYT_NgoaiDinhSuat(BHYT_NgoaiDinhSuat);

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
    protected void onPostExecute(ArrayList<Report79General> costs) {
        super.onPostExecute(costs);
        iCallListReport79Gerenal.callListReport79Gerenal();
        progressDialog.dismiss();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}

