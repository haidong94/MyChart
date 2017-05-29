package com.example.qtht.mychart.asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.qtht.mychart.interFace.ICallListReport80;
import com.example.qtht.mychart.model.Report80;

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

public class Report80Task extends AsyncTask<String,Void,ArrayList<Report80>> {
    private static final String URL = "http://10.61.68.143:8088/QuanLyTaiKhoan.svc/LayChiTietBaoCao80?";

    private static final String USERNAME = "username=";
    private static final String PASSWORD = "&password=";
    private static final String MABENHVIEN="&mabenhvien=";
    Context context;
    ArrayList<Report80> list=new ArrayList<>();
    ProgressDialog progressDialog;
    ICallListReport80 iCallListReport80;

    public ArrayList<Report80> getList() {
        return list;
    }

    public void setList(ArrayList<Report80> list) {
        this.list = list;
    }

    public Report80Task(Context context){
        this.context=context;
        progressDialog=new ProgressDialog(context);
        this.iCallListReport80= (ICallListReport80) context;
    }



    @Override
    protected ArrayList<Report80> doInBackground(String... params) {

        try{
            URL url=new URL(URL + USERNAME + params[0] + PASSWORD + params[1] + MABENHVIEN + params[2]+"&tungay=01/09/2016&denngay=01/09/2016&ngoaitru=1&noitru=1");

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
                String HoTen=c.getString("HOTEN");
                String NamSinhNam=c.getString("NAMSINHNAM");
                String NamSinhNu=c.getString("NAMSINHNU");
                String MaTheBHYT=c.getString("SOTHE");
                String MaDKBD=c.getString("MAKCBBD");
                String MaBenh=c.getString("MABENH");
                String NgayVao=c.getString("NGAYGIOVAO");
                String NgayRa=c.getString("NGAYGIORA");
                String SoNgayDieuTri=c.getString("SONGAYDIEUTRI");
                String TongCong=c.getString("TONGHIPHI");
                String XetNghiem=c.getString("XN");
                String CDHA=c.getString("CDHA");
                String Thuoc=c.getString("THUOC_BHYT");
                String Mau=c.getString("MAU");
                String TTPT=c.getString("PTTT");
                String VTYT=c.getString("VTYT");
                String DVKTTyLe=c.getString("DVKT_TYLE");
                String ThuocTyLe=c.getString("THUOC_TYLE");
                String VTYTTyLe=c.getString("VTYT_TYLE");
                String TienGiuong=c.getString("TIENGIUONG");
                String VanChuyen=c.getString("VANCHUYEN");
                String NguoiBenhTra=c.getString("TONGBNTT");
                String BHYTTra=c.getString("TONGBHYTTT");
                String ChiPhiNgoai=c.getString("NGOAIDINHSUAT");

                Report80 duLieu=new Report80();
                duLieu.setHoTen(HoTen);
                duLieu.setNamSinhNam(NamSinhNam);
                duLieu.setNamSinhNu(NamSinhNu);
                duLieu.setMaTheBHYT(MaTheBHYT);
                duLieu.setMaDKBD(MaDKBD);
                duLieu.setMaBenh(MaBenh);
                duLieu.setNgayVao(NgayVao);
                duLieu.setNgayRa(NgayRa);
                duLieu.setSoNgayDieuTri(SoNgayDieuTri);
                duLieu.setMaDKBD(MaDKBD);
                duLieu.setTongCong(TongCong);
                duLieu.setXetNghiem(XetNghiem);
                duLieu.setCDHA(CDHA);
                duLieu.setThuoc(Thuoc);
                duLieu.setMau(Mau);
                duLieu.setTIPT(TTPT);
                duLieu.setVTYT(VTYT);
                duLieu.setDVKT_TyLe(DVKTTyLe);
                duLieu.setThuoc_TyLe(ThuocTyLe);
                duLieu.setVTYT_TyLe(VTYTTyLe);
                duLieu.setTienGiuong(TienGiuong);
                duLieu.setVanChuyen(VanChuyen);
                duLieu.setNguoiBenhTra(NguoiBenhTra);
                duLieu.setTongCong_BHYTTT(BHYTTra);
                duLieu.setQuyDinhSuat_BHYTTT(ChiPhiNgoai);

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
    protected void onPostExecute(ArrayList<Report80> costs) {
        super.onPostExecute(costs);
        iCallListReport80.callListReport80();
        progressDialog.dismiss();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}


