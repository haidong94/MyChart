package com.example.qtht.mychart;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qtht.mychart.asynctask.LoginTask;
import com.example.qtht.mychart.common.AppStatus;
import com.example.qtht.mychart.common.SessionManager;
import com.example.qtht.mychart.interFace.ICallBack;

import java.util.HashMap;

import static com.example.qtht.mychart.common.Common.account;


/**
 * Created by qtht on 28/04/2017.
 */

public class LoginActivity  extends AppCompatActivity implements ICallBack{

    TextInputLayout layout_phone,layout_pass;
    EditText edt_user,edt_pass;
    CheckBox cb_ShowPassword;
    Button btn_continue;
    SessionManager session;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        if (AppStatus.getInstance(this).isOnline()) {
            addControl();
            addEvent();

        } else {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.title_connect)
                    .setMessage(R.string.mess)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }

    private void addControl() {

        session = new SessionManager(this);

        layout_phone= (TextInputLayout) findViewById(R.id.phone);
        layout_pass= (TextInputLayout) findViewById(R.id.pass);
        edt_user= (EditText) findViewById(R.id.edt_user);
        edt_pass= (EditText) findViewById(R.id.edt_pass);
        btn_continue= (Button) findViewById(R.id.btn_continue);
        cb_ShowPassword= (CheckBox) findViewById(R.id.cb_ShowPassword);
        cb_ShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    edt_pass.setTransformationMethod(null);
                else
                    edt_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });
    }

    private void addEvent() {
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginTask loginTask=new LoginTask(LoginActivity.this);
                loginTask.execute(edt_user.getText().toString(),edt_pass.getText().toString());
                account=loginTask.getAccount();
            }
        });
    }


    //đọc tài khoản
    public void restoringPreferences(){
        HashMap<String, String> user = session.getUserDetail();
        String name = user.get(SessionManager.KEY_NAME);
        String pass = user.get(SessionManager.KEY_PASS);
        edt_user.setText(name);
        edt_pass.setText(pass);
    }

    @Override
    protected void onPause() {
        super.onPause();
         session.createLoginSession(account.getUserName(),account.getPassword());
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoringPreferences();
    }


    @Override
    public void callback() {
        if(account.getStatus().equals("1"))
        {
            account.setPassword(edt_pass.getText().toString());
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }
        else
            Toast.makeText(LoginActivity.this,"Tài Khoản Không Đúng",Toast.LENGTH_SHORT).show();
    }
}
