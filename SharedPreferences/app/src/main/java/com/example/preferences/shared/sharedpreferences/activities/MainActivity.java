package com.example.preferences.shared.sharedpreferences.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.preferences.shared.sharedpreferences.R;
import com.example.preferences.shared.sharedpreferences.Utils.Util;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    private TextView editTextUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

        editTextUser=(TextView)findViewById(R.id.etUser2);

        editTextUser.setText(Util.getUserMailSharedPreferences(sharedPreferences));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_logout:
                logout();
                return true;
            case R.id.menu_forget_logout:
                Util.removeSharedPreferences(sharedPreferences);
                logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void logout(){
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }
}
