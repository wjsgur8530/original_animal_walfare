package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

public class Result1 extends AppCompatActivity {

    private ListView m_oListView = null;

    public Integer protocol1, protocol2, protocol3, protocol4, total;
    public Integer protocol1_length, protocol2_length, protocol3_length, protocol4_length, z;
    public String protocol1_info, protocol2_info, protocol3_info, protocol4_info;

    ArrayList<ItemData> oData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result1);

        Intent intent = getIntent();

        TextView score1 = (TextView) findViewById(R.id.scr1);

        protocol1 = intent.getExtras().getInt("protocol1");
        protocol2 = intent.getExtras().getInt("protocol2");
        protocol3 = intent.getExtras().getInt("protocol3");
        protocol4 = intent.getExtras().getInt("protocol4");
        total = intent.getExtras().getInt("total");

        score1.setText(protocol1.toString() + "점");

        protocol1_length = intent.getIntExtra("protocol1_length", 0);
        protocol2_length = intent.getIntExtra("protocol2_length", 0);
        protocol3_length = intent.getIntExtra("protocol3_length", 0);
        protocol4_length = intent.getIntExtra("protocol4_length", 0);

        protocol1_info = intent.getStringExtra("protocol1_info");
        protocol2_info = intent.getStringExtra("protocol2_info");
        protocol3_info = intent.getStringExtra("protocol3_info");
        protocol4_info = intent.getStringExtra("protocol4_info");

        try {
            pars(protocol1_info);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Button btn1 = (Button)findViewById(R.id.btn1_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            //버튼 클릭시 이벤트입니다.
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Result1.this, Result.class);
                intent.putExtra("protocol1", protocol1);
                intent.putExtra("protocol2", protocol2);
                intent.putExtra("protocol3", protocol3);
                intent.putExtra("protocol4", protocol4);
                intent.putExtra("total", total);
                intent.putExtra("protocol1_length", protocol1_length);
                intent.putExtra("protocol2_length", protocol2_length);
                intent.putExtra("protocol3_length", protocol3_length);
                intent.putExtra("protocol4_length", protocol4_length);
                intent.putExtra("protocol1_info", protocol1_info.toString());
                intent.putExtra("protocol2_info", protocol2_info.toString());
                intent.putExtra("protocol3_info", protocol3_info.toString());
                intent.putExtra("protocol4_info", protocol4_info.toString());
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        Button btn2 = (Button)findViewById(R.id.btn2_1);
        btn2.setOnClickListener(new View.OnClickListener() {
            //버튼 클릭시 이벤트입니다.
            @Override
            public void onClick(View view) {

            }
        });
        Button btn3 = (Button)findViewById(R.id.btn3_1);
        btn3.setOnClickListener(new View.OnClickListener() {
            //버튼 클릭시 이벤트입니다.
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Result1.this, Result2.class);
                intent.putExtra("protocol1", protocol1);
                intent.putExtra("protocol2", protocol2);
                intent.putExtra("protocol3", protocol3);
                intent.putExtra("protocol4", protocol4);
                intent.putExtra("total", total);
                intent.putExtra("protocol1_length", protocol1_length);
                intent.putExtra("protocol2_length", protocol2_length);
                intent.putExtra("protocol3_length", protocol3_length);
                intent.putExtra("protocol4_length", protocol4_length);
                intent.putExtra("protocol1_info", protocol1_info.toString());
                intent.putExtra("protocol2_info", protocol2_info.toString());
                intent.putExtra("protocol3_info", protocol3_info.toString());
                intent.putExtra("protocol4_info", protocol4_info.toString());
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        Button btn4 = (Button)findViewById(R.id.btn4_1);
        btn4.setOnClickListener(new View.OnClickListener() {
            //버튼 클릭시 이벤트입니다.
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Result1.this, Result3.class);
                intent.putExtra("protocol1", protocol1);
                intent.putExtra("protocol2", protocol2);
                intent.putExtra("protocol3", protocol3);
                intent.putExtra("protocol4", protocol4);
                intent.putExtra("total", total);
                intent.putExtra("protocol1_length", protocol1_length);
                intent.putExtra("protocol2_length", protocol2_length);
                intent.putExtra("protocol3_length", protocol3_length);
                intent.putExtra("protocol4_length", protocol4_length);
                intent.putExtra("protocol1_info", protocol1_info.toString());
                intent.putExtra("protocol2_info", protocol2_info.toString());
                intent.putExtra("protocol3_info", protocol3_info.toString());
                intent.putExtra("protocol4_info", protocol4_info.toString());
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        Button btn5 = (Button)findViewById(R.id.btn5_1);
        btn5.setOnClickListener(new View.OnClickListener() {
            //버튼 클릭시 이벤트입니다.
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Result1.this, Result4.class);
                intent.putExtra("protocol1", protocol1);
                intent.putExtra("protocol2", protocol2);
                intent.putExtra("protocol3", protocol3);
                intent.putExtra("protocol4", protocol4);
                intent.putExtra("total", total);
                intent.putExtra("protocol1_length", protocol1_length);
                intent.putExtra("protocol2_length", protocol2_length);
                intent.putExtra("protocol3_length", protocol3_length);
                intent.putExtra("protocol4_length", protocol4_length);
                intent.putExtra("protocol1_info", protocol1_info.toString());
                intent.putExtra("protocol2_info", protocol2_info.toString());
                intent.putExtra("protocol3_info", protocol3_info.toString());
                intent.putExtra("protocol4_info", protocol4_info.toString());
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

    }

    /*public void clickHandler1(View view) {

        switch (view.getId()) {
            case R.id.btn1_1:
                Intent intent = new Intent(this,Result.class);
                intent.putExtra("protocol1", protocol1);
                intent.putExtra("protocol2", protocol2);
                intent.putExtra("protocol3", protocol3);
                intent.putExtra("protocol4", protocol4);
                intent.putExtra("total", total);
                intent.putExtra("protocol1_length", protocol1_length);
                intent.putExtra("protocol2_length", protocol2_length);
                intent.putExtra("protocol3_length", protocol3_length);
                intent.putExtra("protocol4_length", protocol4_length);
                intent.putExtra("protocol1_info", protocol1_info.toString());
                intent.putExtra("protocol2_info", protocol2_info.toString());
                intent.putExtra("protocol3_info", protocol3_info.toString());
                intent.putExtra("protocol4_info", protocol4_info.toString());
                startActivity(intent);
                break;
            case R.id.btn2_1:

                break;
            case R.id.btn3_1:
                Intent intent2 = new Intent(this, Result_2.class);
                intent2.putExtra("protocol1", protocol1);
                intent2.putExtra("protocol2", protocol2);
                intent2.putExtra("protocol3", protocol3);
                intent2.putExtra("protocol4", protocol4);
                intent2.putExtra("total", total);
                intent2.putExtra("protocol1_length", protocol1_length);
                intent2.putExtra("protocol2_length", protocol2_length);
                intent2.putExtra("protocol3_length", protocol3_length);
                intent2.putExtra("protocol4_length", protocol4_length);
                intent2.putExtra("protocol1_info", protocol1_info.toString());
                intent2.putExtra("protocol2_info", protocol2_info.toString());
                intent2.putExtra("protocol3_info", protocol3_info.toString());
                intent2.putExtra("protocol4_info", protocol4_info.toString());
                break;
            case R.id.btn4_1:
                Intent intent3 = new Intent(this, Result_3.class);
                intent3.putExtra("protocol1", protocol1);
                intent3.putExtra("protocol2", protocol2);
                intent3.putExtra("protocol3", protocol3);
                intent3.putExtra("protocol4", protocol4);
                intent3.putExtra("total", total);
                intent3.putExtra("protocol1_length", protocol1_length);
                intent3.putExtra("protocol2_length", protocol2_length);
                intent3.putExtra("protocol3_length", protocol3_length);
                intent3.putExtra("protocol4_length", protocol4_length);
                intent3.putExtra("protocol1_info", protocol1_info.toString());
                intent3.putExtra("protocol2_info", protocol2_info.toString());
                intent3.putExtra("protocol3_info", protocol3_info.toString());
                intent3.putExtra("protocol4_info", protocol4_info.toString());
                break;
            case R.id.btn5_1:
                Intent intent4 = new Intent(this, Result_4.class);
                intent4.putExtra("protocol1", protocol1);
                intent4.putExtra("protocol2", protocol2);
                intent4.putExtra("protocol3", protocol3);
                intent4.putExtra("protocol4", protocol4);
                intent4.putExtra("total", total);
                intent4.putExtra("protocol1_length", protocol1_length);
                intent4.putExtra("protocol2_length", protocol2_length);
                intent4.putExtra("protocol3_length", protocol3_length);
                intent4.putExtra("protocol4_length", protocol4_length);
                intent4.putExtra("protocol1_info", protocol1_info.toString());
                intent4.putExtra("protocol2_info", protocol2_info.toString());
                intent4.putExtra("protocol3_info", protocol3_info.toString());
                intent4.putExtra("protocol4_info", protocol4_info.toString());
                break;
        }
    }*/

    public void pars(String jsonString) throws ParseException, JSONException {

        JSONParser parser = new JSONParser();

        if (jsonString == null) {

        } else {
            JSONArray arr = (JSONArray) parser.parse(jsonString);
            Log.e("arr", arr.toString());
            oData.clear();
            for (z = 0; z < protocol1_length; ++z) {
                ItemData oItem = new ItemData();
                oItem.strText = (String) arr.get(z);
                oData.add(oItem);
            }
            m_oListView = (ListView) findViewById(R.id.listView_1);
            ListAdapter oAdapter = new ListAdapter(oData);
            m_oListView.setAdapter(oAdapter);
        }
    }

}

