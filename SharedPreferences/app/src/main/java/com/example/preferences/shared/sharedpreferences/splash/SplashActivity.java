package com.example.preferences.shared.sharedpreferences.splash;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.example.preferences.shared.sharedpreferences.Utils.Util;
import com.example.preferences.shared.sharedpreferences.activities.LoginActivity;
import com.example.preferences.shared.sharedpreferences.activities.MainActivity;

public class SplashActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        Intent intentLogin = new Intent(SplashActivity.this,LoginActivity.class);
        Intent intentMain = new Intent(SplashActivity.this,MainActivity.class);

        if(!TextUtils.isEmpty(Util.getUserMailSharedPreferences(sharedPreferences)) && !TextUtils.isEmpty(Util.getUserPassSharedPreferences(sharedPreferences))){
            startActivity(intentMain);
        }else{
            startActivity(intentLogin);
        }

        finish();
    }
}
