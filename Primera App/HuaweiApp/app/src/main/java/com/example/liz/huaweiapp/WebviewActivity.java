package com.example.liz.huaweiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebviewActivity extends AppCompatActivity {

    String URL="http://hectorcastro1373.cloudapp.net/siah/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        WebView view=(WebView)this.findViewById(R.id.webv);
        view.setWebViewClient(new MyWebViewClient());
        WebSettings settings = view.getSettings();
        settings.setJavaScriptEnabled(true);
        //view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(URL);

        int result=probandoDebug();
        Person p= new Person("Hector");
        Toast.makeText(this,"Resultado: "+result+" - "+p.name,Toast.LENGTH_LONG).show();
    }

    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String URL){
            view.loadUrl(URL);
            return true;
        }
    }

    private int probandoDebug(){
        int a=5,b=10,c=20,res=0;
        if(a>b){
            res= 0;
        }else {
            if(c>a){
                res= c;
            }else{
                res= a;
            }
        }
        return res;
    }

    public class Person{
        String name;
        Person(String name){
            this.name=name;
        }
    }
}
