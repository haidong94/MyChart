package com.example.qtht.mychart.common;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.example.qtht.mychart.LoginActivity;

import java.util.HashMap;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by qtht on 06/05/2017.
 */

public class SessionManager {
    private static final String MY_ACCOUNT = "my_account";
    public static final String KEY_NAME = "username";
    public static final String KEY_PASS = "password";
    private static final String IS_LOGIN = "IsLoggedIn";

    SharedPreferences pref;
    Editor editor;
    Context context;


    public SessionManager(Context context){
        this.context = context;
        pref = context.getSharedPreferences(MY_ACCOUNT, MODE_PRIVATE);
        editor = pref.edit();
    }

    public void createLoginSession(String name, String pass){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        editor.putString(KEY_NAME, name);
        editor.putString(KEY_PASS, pass);
        editor.commit();
    }

    public HashMap<String, String> getUserDetail(){

        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_NAME, pref.getString(KEY_NAME, ""));
        user.put(KEY_PASS, pref.getString(KEY_PASS, ""));
        return user;
    }


    public void logoutUser(){
        editor.clear();
        editor.commit();

        Intent i = new Intent(context, LoginActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        context.startActivity(i);
    }

    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

}
