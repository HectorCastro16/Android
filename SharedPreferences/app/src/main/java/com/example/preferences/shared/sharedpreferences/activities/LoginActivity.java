package com.example.preferences.shared.sharedpreferences.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.preferences.shared.sharedpreferences.R;
import com.example.preferences.shared.sharedpreferences.Utils.Util;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    private EditText editTextEmail;
    private EditText editTextPass;
    private Switch swiRemember;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindUI();

        sharedPreferences = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        setCredentilasIfExit();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= editTextEmail.getText().toString();
                String pass= editTextPass.getText().toString();

                if(login(email,pass)){
                    goToSecond();
                    saveOnPreferences(email,pass);
                }
            }
        });
    }

    private void bindUI(){
        editTextEmail=(EditText)findViewById(R.id.etUser);
        editTextPass=(EditText)findViewById(R.id.etPass);
        swiRemember=(Switch) findViewById(R.id.swRemember);
        btnLogin=(Button)findViewById(R.id.btnLogin);
    }

    private void setCredentilasIfExit(){
        String email= Util.getUserMailSharedPreferences(sharedPreferences);
        String pass=Util.getUserPassSharedPreferences(sharedPreferences);
        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass)){
            editTextEmail.setText(email);
            editTextPass.setText(pass);
            swiRemember.setChecked(true);
        }
    }

    private boolean login(String email, String pass){
        if(!isValidEmail(email)){
            Toast.makeText(LoginActivity.this,"User invalido",Toast.LENGTH_SHORT).show();
            return false;
        }else if(!isValidPass(pass)){
            Toast.makeText(LoginActivity.this,"Passsword invalido - 4 caractere a mas",Toast.LENGTH_SHORT).show();
            return false;
        } else{
            return true;
        }
    }

    private void saveOnPreferences(String email, String pass){
        if(swiRemember.isChecked()){
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("email",email);
            editor.putString("pass",pass);
            editor.apply();
        }
    }

    private boolean isValidEmail(String email){
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPass(String pass){
        return pass.length()>=4;
    }

    private void goToSecond(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
