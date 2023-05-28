package com.example.watertank;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {
    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE=0;

    private static final String PREF_NAME="LOGIN";
    private static final String LOGIN = "IS_LOGIN";
    public static final String NAME="NAME";

    public SessionManager(Context content){
        this.context = content;
        sharedPreferences = context.getSharedPreferences("LOGIN",PRIVATE_MODE);
        editor =sharedPreferences.edit();
    }
    public void createSession(String name){
        editor.putBoolean("LOGIN",true);
        editor.putString("NAME",name);
        editor.apply();
    }
    public boolean isLoggin(){
        return sharedPreferences.getBoolean(LOGIN,false);
    }
    public void checkLogin(){
        if(!this.isLoggin()){
            Intent i = new Intent(context,LoginActivity.class);
            context.startActivity(i);
            ((MainActivity) context).finish();
        }
    }
    public HashMap<String,String>getUserDetail(){
        HashMap<String, String> user = new HashMap<>();
        user.put(NAME,sharedPreferences.getString(NAME,null));
        return  user;
    }
    public void logout(){
        editor.clear();
        editor.commit();
        Intent i = new Intent(context,LoginActivity.class);
        context.startActivity(i);
        ((MainActivity)context).finish();
    }
}
