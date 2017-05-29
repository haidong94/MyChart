package com.example.qtht.mychart;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;


/**
 * Created by qtht on 19/05/2017.
 */

public class NoiTruActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rotation_activity);


        webView= (WebView) findViewById(R.id.web_pdf);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://hisone.ytecoso.vn/BaoCaoVienPhi/ViewPDF?json=%7B%22DonViCha%22%3A%22%22%2C%22DonViCon%22%3A%22%22%2C%22listBVID%22%3A%5B%22100262%22%5D%2C%22tuNgay%22%3A%2211%2F05%2F2017%22%2C%22denNgay%22%3A%2211%2F05%2F2017%22%2C%22NoiHayNgoaiTru%22%3A%222%22%2C%22loaiBaoCao%22%3A%22M%E1%BA%ABu%2079%20t%E1%BB%95ng%20h%E1%BB%A3p%22%2C%22thoiGianBaoCao%22%3A%22T%E1%BB%AB%20ng%C3%A0y%2011%2F05%2F2017%20%C4%91%E1%BA%BFn%2011%2F05%2F2017%22%2C%22khoaphong%22%3Anull%7D");

    }
}
