package com.example.preferences.shared.sharedpreferences.Utils;

import android.content.SharedPreferences;

public class Util {

    public static  String getUserMailSharedPreferences(SharedPreferences sharedPreferences){
        return sharedPreferences.getString("email","");
    }
    public static  String getUserPassSharedPreferences(SharedPreferences sharedPreferences){
        return sharedPreferences.getString("pass","");
    }

    public static void removeSharedPreferences(SharedPreferences sharedPreferences){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("email");
        editor.remove("pass");
        editor.apply();
    }
}
