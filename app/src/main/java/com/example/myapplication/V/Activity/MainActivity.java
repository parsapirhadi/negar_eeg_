package com.example.myapplication.V.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.P.FileReader;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      startActivity(new Intent(this,EightRootActivity.class));
      new Thread(new Runnable() {
          @Override
          public void run() {

          }
      }).start();
        finish();



    }
}














