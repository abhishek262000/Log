package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

         Logo l=new Logo();
         l.start();
    }

    private class Logo extends Thread{
        @Override
        public void run() {
            try{
                sleep(4000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Intent intent =new Intent(Splash.this,GifView.class);
            startActivity(intent);
            Splash.this.finish();
        }
    }
}