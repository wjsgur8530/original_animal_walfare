package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Input extends AppCompatActivity {
    EditText ed_name, ed_tel, ed_age, ed_num, ed_sam;
    String sname, stel, sage, snum, ssam;
    Integer iage, ifarm;
    public String rslt;
    private RadioGroup rdio;
    private RadioButton rdmale, rdfmale;

    //검색시 선택된 매세지를 띄우기 위한 선언하였습니다. 그냥 선언안하고 인자로 넘기셔도 됩니다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Button regbtn = (Button) findViewById(R.id.regbtn);
        Button backbtn = (Button) findViewById(R.id.backbtn);

        ed_name = (EditText) findViewById(R.id.namereg);
        ed_tel = (EditText) findViewById(R.id.telreg);
        ed_age = (EditText) findViewById(R.id.agereg);
        ed_num = (EditText) findViewById(R.id.numberreg);
        ed_sam = (EditText) findViewById(R.id.samplereg);

        RadioGroup rgfarm = (RadioGroup)findViewById(R.id.farmgrp);

        rgfarm.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.farm1){
                    ifarm = 1;
                } else if (checkedId == R.id.farm2){
                    ifarm = 2;
                } else if (checkedId == R.id.farm3){
                    ifarm = 3;
                }
            }
        });


        regbtn.setOnClickListener(new View.OnClickListener() {
            //버튼 클릭시 이벤트입니다.
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "잠시만 기다려주세요.", Toast.LENGTH_SHORT).show();
                sname = ed_name.getText().toString();
                stel = ed_tel.getText().toString();
                sage = ed_age.getText().toString();
                snum = ed_num.getText().toString();
                ssam = ed_sam.getText().toString();

                if(sname.matches("") || stel.matches("") || sage.matches("") || snum.matches("") || ssam.matches(""))
                {
                    Toast.makeText(getApplicationContext(), "빈 칸이 있습니다.", Toast.LENGTH_SHORT).show();
                } else{
                        iage = Integer.parseInt(ed_age.getText().toString());

                    Intent intent = new Intent(Input.this, Survey.class);
                    intent.putExtra("name", sname);
                    intent.putExtra("tel", stel);
                    intent.putExtra("age", sage);
                    intent.putExtra("num", snum);
                    intent.putExtra("sam", ssam);
                    intent.putExtra("farm", ifarm);
                    startActivity(intent);
                }}
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            //버튼 클릭시 이벤트입니다.
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View focusView = getCurrentFocus();
        if (focusView != null) {
            Rect rect = new Rect();
            focusView.getGlobalVisibleRect(rect);
            int x = (int) ev.getX(), y = (int) ev.getY();
            if (!rect.contains(x, y)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if (imm != null)
                    imm.hideSoftInputFromWindow(focusView.getWindowToken(), 0);
                focusView.clearFocus();
            }
        }
        return super.dispatchTouchEvent(ev);
    }
}