package com.example.qtht.mychart;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.qtht.mychart.common.Common;
import com.example.qtht.mychart.common.SessionManager;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    LinearLayout ln_chart,ln_vienphi,ln_baocao,ln_noitru;
    SessionManager session;
    TextView tvUserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setItemIconTintList(null);
        addControl();
        addEvent();
    }

    private void addEvent() {
        inforAccount();

        ln_chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SelectChartActivity.class);
                startActivity(intent);
            }
        });
        ln_vienphi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AnalysisActivity.class);
                startActivity(intent);
            }
        });
        ln_baocao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SelectReportActivity.class);
                startActivity(intent);
            }
        });
        ln_noitru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,NoiTruActivity.class);
//                startActivity(intent);
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://hisone.ytecoso.vn/BaoCaoVienPhi/ViewPDF?json=%7B%22DonViCha%22%3A%22%22%2C%22DonViCon%22%3A%22%22%2C%22listBVID%22%3A%5B%22100262%22%5D%2C%22tuNgay%22%3A%2211%2F05%2F2017%22%2C%22denNgay%22%3A%2211%2F05%2F2017%22%2C%22NoiHayNgoaiTru%22%3A%222%22%2C%22loaiBaoCao%22%3A%22M%E1%BA%ABu%2079%20t%E1%BB%95ng%20h%E1%BB%A3p%22%2C%22thoiGianBaoCao%22%3A%22T%E1%BB%AB%20ng%C3%A0y%2011%2F05%2F2017%20%C4%91%E1%BA%BFn%2011%2F05%2F2017%22%2C%22khoaphong%22%3Anull%7D"));
                startActivity(browserIntent);
            }
        });
    }

    private void addControl() {
        session = new SessionManager(this);

        ln_chart= (LinearLayout) findViewById(R.id.ln_chart);
        ln_vienphi= (LinearLayout) findViewById(R.id.ln_vienphi);
        ln_baocao= (LinearLayout) findViewById(R.id.ln_baocao);
        ln_noitru= (LinearLayout) findViewById(R.id.ln_noitru);


    }
    public void inforAccount(){
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        tvUserName=(TextView) headerView.findViewById(R.id.tvUserName);
        tvUserName.setText(Common.account.getUserName());


        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);//lấy màu của ảnh ban đầu
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_logout) {
            session.logoutUser();
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
