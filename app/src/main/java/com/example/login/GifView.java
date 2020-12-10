package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class GifView extends AppCompatActivity {


    TextView regi,logi ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_gif_view);
        getSupportActionBar().hide();
        regi=(TextView) findViewById(R.id.reg1);
        logi=(TextView)findViewById(R.id.log1);
        regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GifView.this,MainActivity.class));
            }
        });

        logi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GifView.this,Login1.class));
            }
        });


    }
}