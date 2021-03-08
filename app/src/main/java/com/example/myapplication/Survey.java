package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.DialogInterface;
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
import java.util.Arrays;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Survey extends AppCompatActivity {

    Integer poor, water_tank_num, water_tank_clean, water_tank_time, straw_fead_tank, straw_normal, straw_resting_place, outward_hygiene, shade,
            summer_ventilating, mist_spray, wind_block, winter_ventilating, winter_straw, calf_warm, calf_wind_block, limp, hair_loss, cough, runny_nose,
            ophthalmic_secretion, respiratory_failure, diarrhea, ruminant, fall_dead, horn, horn_anesthesia, horn_painkiller, castration,
            castration_anesthesia, castration_painkiller, struggle, harmony, touch_possibility, touch_near, touch_far, touch_impossibility, farm;
    Button sndbtn, backbtn;
    String rslt, name, tel, age, num, sam;

    Integer protocol1, protocol2, protocol3, protocol4, total;
    Integer protocol1_length, protocol2_length, protocol3_length, protocol4_length;
    JSONArray protocol1_info, protocol2_info, protocol3_info, protocol4_info;
    JSONArray temp = new JSONArray();

    JSONObject data = new JSONObject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        Intent intent = getIntent();

        name = intent.getExtras().getString("name");
        tel = intent.getExtras().getString("tel");
        age = intent.getExtras().getString("age");
        farm = intent.getExtras().getInt("farm");
        num = intent.getExtras().getString("num");
        sam = intent.getExtras().getString("sam");

        sndbtn = (Button)findViewById(R.id.sndbtn);
        backbtn = (Button)findViewById(R.id.backbtn);

        final EditText ed_1_poor = (EditText)findViewById(R.id.a1);
        final EditText ed_8_outward_hygiene = (EditText)findViewById(R.id.a8);
        final EditText ed_17_limp = (EditText)findViewById(R.id.a17);
        final EditText ed_18_hair_loss = (EditText)findViewById(R.id.a18);
        final EditText ed_19_cough = (EditText)findViewById(R.id.a19);
        final EditText ed_20_runny_nose = (EditText)findViewById(R.id.a20);
        final EditText ed_21_ophthalmic_secretion = (EditText)findViewById(R.id.a21);
        final EditText ed_22_respiratory_failure = (EditText)findViewById(R.id.a22);
        final EditText ed_23_diarrhea = (EditText)findViewById(R.id.a23);
        final EditText ed_24_ruminant = (EditText)findViewById(R.id.a24);
        final EditText ed_25_fall_dead = (EditText)findViewById(R.id.a25);
        final EditText ed_32_struggle = (EditText)findViewById(R.id.a32);
        final EditText ed_33_harmony = (EditText)findViewById(R.id.a33);
        final EditText ed_34_touch_possibility = (EditText)findViewById(R.id.a34);
        final EditText ed_35_touch_near = (EditText)findViewById(R.id.a35);
        final EditText ed_36_touch_far = (EditText)findViewById(R.id.a36);
        final EditText ed_37_touch_impossibility = (EditText)findViewById(R.id.a37);

        RadioGroup rdiog_2_water_tank_num = (RadioGroup)findViewById(R.id.rdogrp2);

        rdiog_2_water_tank_num.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.a2_1){
                    water_tank_num = 1;
                } else if (checkedId == R.id.a2_2){
                    water_tank_num = 2;
                }
            }
        });

        RadioGroup rdiog_3_water_tank_clean = (RadioGroup)findViewById(R.id.rdogrp3);

        rdiog_3_water_tank_clean.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.a3_1){
                    water_tank_clean = 1;
                } else if (checkedId == R.id.a3_2){
                    water_tank_clean = 2;
                } else if (checkedId == R.id.a3_3){
                    water_tank_clean = 3;
                }
            }
        });

        RadioGroup rdiog_4_water_tank_time = (RadioGroup)findViewById(R.id.rdogrp4);

        rdiog_4_water_tank_time.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.a4_1){
                    water_tank_time = 1;
                } else if (checkedId == R.id.a4_2){
                    water_tank_time = 2;
                } else if (checkedId == R.id.a4_3){
                    water_tank_time = 3;
                }
            }
        });

        RadioGroup rdiog_5_straw_fead_tank = (RadioGroup)findViewById(R.id.rdogrp5);

        rdiog_5_straw_fead_tank.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.a5_1){
                    straw_fead_tank = 1;
                } else if (checkedId == R.id.a5_2){
                    straw_fead_tank = 2;
                } else if (checkedId == R.id.a5_3){
                    straw_fead_tank = 3;
                } else if (checkedId == R.id.a5_4){
                    straw_fead_tank = 4;
                }
            }
        });

        RadioGroup rdiog_6_straw_normal = (RadioGroup)findViewById(R.id.rdogrp6);

        rdiog_6_straw_normal.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.a6_1){
                    straw_normal = 1;
                } else if (checkedId == R.id.a6_2){
                    straw_normal = 2;
                } else if (checkedId == R.id.a6_3){
                    straw_normal = 3;
                } else if (checkedId == R.id.a6_4){
                    straw_normal = 4;
                }
            }
        });

        RadioGroup rdiog_7_straw_resting_place = (RadioGroup)findViewById(R.id.rdogrp7);

        rdiog_7_straw_resting_place.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.a7_1){
                    straw_resting_place = 1;
                } else if (checkedId == R.id.a7_2){
                    straw_resting_place = 2;
                } else if (checkedId == R.id.a7_3){
                    straw_resting_place = 3;
                } else if (checkedId == R.id.a7_4){
                    straw_resting_place = 4;
                }
            }
        });

        RadioGroup rdiog_9_shade = (RadioGroup)findViewById(R.id.rdogrp9);

        rdiog_9_shade.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.a9_1){
                    shade = 1;
                } else if (checkedId == R.id.a9_2){
                    shade = 2;
                }
            }
        });

        RadioGroup rdiog_10_summer_ventilating = (RadioGroup)findViewById(R.id.rdogrp10);

        rdiog_10_summer_ventilating.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.a10_1){
                    summer_ventilating = 1;
                } else if (checkedId == R.id.a10_2){
                    summer_ventilating = 2;
                }
            }
        });

        RadioGroup rdiog_11_mist_spray = (RadioGroup)findViewById(R.id.rdogrp11);

        rdiog_11_mist_spray.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.a11_1){
                    mist_spray = 1;
                } else if (checkedId == R.id.a11_2){
                    mist_spray = 2;
                }
            }
        });

        RadioGroup rdiog_12_wind_block = (RadioGroup)findViewById(R.id.rdogrp12);

        rdiog_12_wind_block.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.a12_1){
                    wind_block = 1;
                } else if (checkedId == R.id.a12_2){
                    wind_block = 2;
                }
            }
        });

        RadioGroup rdiog_13_winter_ventilating = (RadioGroup)findViewById(R.id.rdogrp13);

        rdiog_13_winter_ventilating.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.a13_1){
                    winter_ventilating = 1;
                } else if (checkedId == R.id.a13_2){
                    winter_ventilating = 2;
                }
            }
        });

        RadioGroup rdiog_14_winter_straw = (RadioGroup)findViewById(R.id.rdogrp14);

        rdiog_14_winter_straw.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.a14_1){
                    winter_straw = 1;
                } else if (checkedId == R.id.a14_2){
                    winter_straw = 2;
                }
            }
        });

        RadioGroup rdiog_15_calf_warm = (RadioGroup)findViewById(R.id.rdogrp15);

        rdiog_15_calf_warm.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.a15_1){
                    calf_warm = 1;
                } else if (checkedId == R.id.a15_2){
                    calf_warm = 2;
                }
            }
        });

        RadioGroup rdiog_16_calf_wind_block = (RadioGroup)findViewById(R.id.rdogrp16);

        rdiog_16_calf_wind_block.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.a16_1){
                    calf_wind_block = 1;
                } else if (checkedId == R.id.a16_2){
                    calf_wind_block = 2;
                }
            }
        });

        RadioGroup rdiog_26_horn = (RadioGroup)findViewById(R.id.rdogrp26);

        rdiog_26_horn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.a26_1){
                    horn = 1;
                } else if (checkedId == R.id.a26_2){
                    horn = 2;
                } else if (checkedId == R.id.a26_3){
                    horn = 3;
                } else if (checkedId == R.id.a26_4){
                    horn = 4;
                }
            }
        });

        RadioGroup rdiog_27_horn_anesthesia = (RadioGroup)findViewById(R.id.rdogrp27);

        rdiog_27_horn_anesthesia.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.a27_1){
                    horn_anesthesia = 1;
                } else if (checkedId == R.id.a27_2){
                    horn_anesthesia = 2;
                }
            }
        });

        RadioGroup rdiog_28_horn_painkiller = (RadioGroup)findViewById(R.id.rdogrp28);

        rdiog_28_horn_painkiller.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.a28_1){
                    horn_painkiller = 1;
                } else if (checkedId == R.id.a28_2){
                    horn_painkiller = 2;
                }
            }
        });

        RadioGroup rdiog_29_castration = (RadioGroup)findViewById(R.id.rdogrp29);

        rdiog_29_castration.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.a29_1){
                    castration = 1;
                } else if (checkedId == R.id.a29_2){
                    castration = 2;
                } else if (checkedId == R.id.a29_3){
                    castration = 3;
                } else if (checkedId == R.id.a29_4){
                    castration = 4;
                }
            }
        });

        RadioGroup rdiog_30_castration_anesthesia = (RadioGroup)findViewById(R.id.rdogrp30);

        rdiog_30_castration_anesthesia.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.a30_1){
                    castration_anesthesia = 1;
                } else if (checkedId == R.id.a30_2){
                    castration_anesthesia = 2;
                }
            }
        });

        RadioGroup rdiog_31_castration_painkiller = (RadioGroup)findViewById(R.id.rdogrp31);

        rdiog_31_castration_painkiller.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.a31_1){
                    castration_painkiller = 1;
                } else if (checkedId == R.id.a31_2){
                    castration_painkiller = 2;
                }
            }
        });


        sndbtn.setOnClickListener(new View.OnClickListener() {
            //버튼 클릭시 이벤트입니다.
            @Override
            public void onClick(View view) {
                poor = Integer.parseInt(ed_1_poor.getText().toString());
                outward_hygiene = Integer.parseInt(ed_8_outward_hygiene.getText().toString());
                limp = Integer.parseInt(ed_17_limp.getText().toString());
                hair_loss = Integer.parseInt(ed_18_hair_loss.getText().toString());
                cough = Integer.parseInt(ed_19_cough.getText().toString());
                runny_nose = Integer.parseInt(ed_20_runny_nose.getText().toString());
                ophthalmic_secretion = Integer.parseInt(ed_21_ophthalmic_secretion.getText().toString());
                respiratory_failure = Integer.parseInt(ed_22_respiratory_failure.getText().toString());
                diarrhea = Integer.parseInt(ed_23_diarrhea.getText().toString());
                ruminant = Integer.parseInt(ed_24_ruminant.getText().toString());
                fall_dead = Integer.parseInt(ed_25_fall_dead.getText().toString());
                struggle = Integer.parseInt(ed_32_struggle.getText().toString());
                harmony = Integer.parseInt(ed_33_harmony.getText().toString());
                touch_possibility = Integer.parseInt(ed_34_touch_possibility.getText().toString());
                touch_near = Integer.parseInt(ed_35_touch_near.getText().toString());
                touch_far = Integer.parseInt(ed_36_touch_far.getText().toString());
                touch_impossibility = Integer.parseInt(ed_37_touch_impossibility.getText().toString());


                data.put("poor", poor);
                data.put("water_tank_num",  water_tank_num);
                data.put("water_tank_clean", water_tank_clean);
                data.put("water_tank_time",  water_tank_time);
                data.put("straw_fead_tank", straw_fead_tank);
                data.put("straw_normal",  straw_normal);
                data.put("straw_resting_place", straw_resting_place);
                data.put("outward_hygiene",  outward_hygiene);
                data.put("shade", shade);
                data.put("summer_ventilating", summer_ventilating);
                data.put("mist_spray", mist_spray);
                data.put("wind_block",  wind_block);
                data.put("winter_ventilating", winter_ventilating);
                data.put("winter_straw", winter_straw);
                data.put("calf_warm", calf_warm);
                data.put("calf_wind_block", calf_wind_block);
                data.put("limp", limp);
                data.put("hair_loss", hair_loss);
                data.put("cough", cough);
                data.put("runny_nose", runny_nose);
                data.put("ophthalmic_secretion", ophthalmic_secretion);
                data.put("respiratory_failure", respiratory_failure);
                data.put("diarrhea", diarrhea);
                data.put("ruminant", ruminant);
                data.put("fall_dead", fall_dead);
                data.put("horn", horn);
                data.put("horn_anesthesia", horn_anesthesia);
                data.put("horn_painkiller", horn_painkiller);
                data.put("castration", castration);
                data.put("castration_anesthesia", castration_anesthesia);
                data.put("castration_painkiller", castration_painkiller);
                data.put("struggle", struggle);
                data.put("harmony", harmony);
                data.put("touch_possibility", touch_possibility);
                data.put("touch_near", touch_near);
                data.put("touch_far", touch_far);
                data.put("touch_impossibility", touch_impossibility);


                Send snd = new Send();
                snd.execute();

            }

        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            //버튼 클릭시 이벤트입니다.
            @Override
            public void onClick(View view) {
                finish();
            }

        });


    }

    public class Send extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... unused) {

            StringBuffer buffer = new StringBuffer();

            try {
                /* 서버연결 */
                URL url = new URL(
                   "http://10.0.2.2/survey.php");
                HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setHostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        //TODO: Make this more restrictive
                        return true;
                    }
                });
                conn.connect();

                /* 안드로이드 -> 서버 파라메터값 전달 */
                OutputStreamWriter outStream = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
                buffer.append("name").append("=").append(name).append("&");
                buffer.append("tel").append("=").append(tel).append("&");
                buffer.append("age").append("=").append(age).append("&");
                buffer.append("num_of_sample").append("=").append(sam).append("&");
                buffer.append("num_of_all").append("=").append(num).append("&");
                buffer.append("category").append("=").append(farm).append("&");
                buffer.append("data").append("=").append(data);
                PrintWriter writer = new PrintWriter(outStream);
                writer.write(buffer.toString());
                outStream.flush();
                outStream.close();

                /* 서버 -> 안드로이드 파라메터값 전달 */
                InputStream is = null;
                BufferedReader in = null;
                String data = "";

                is = conn.getInputStream();
                in = new BufferedReader(new InputStreamReader(is), 8 * 1024);
                String line = null;
                StringBuffer buff = new StringBuffer();
                while ((line = in.readLine()) != null) {
                    buff.append(line + "\n");
                }
                rslt = buff.toString().trim();
                Log.e("이렇게 와요", rslt);
                pars(rslt);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch(NullPointerException e){
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Toast.makeText(getApplicationContext(), "자료를 분석 중 입니다.", Toast.LENGTH_SHORT).show();
            iosetting();
        }

    }
    public void iosetting() {
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
    }
    public void reset(){

    }

    public void pars(String jsonString) throws ParseException, JSONException {

        JSONParser parser = new JSONParser();

        JSONObject univ = (JSONObject) parser.parse(jsonString);
        Log.e("univ", univ.toString());

        temp.add("추가 정보가 없습니다.");

        protocol1 =((Long) univ.get("protocol1")).intValue();
        protocol2 =((Long) univ.get("protocol2")).intValue();
        protocol3 =((Long) univ.get("protocol3")).intValue();
        protocol4 =((Long) univ.get("protocol4")).intValue();
        total = ((Long) univ.get("total")).intValue();

        protocol1_length = ((Long) univ.get("protocol1_length")).intValue();
        protocol2_length = ((Long) univ.get("protocol2_length")).intValue();
        protocol3_length = ((Long) univ.get("protocol3_length")).intValue();
        protocol4_length = ((Long) univ.get("protocol4_length")).intValue();


        if (protocol1_length == 0) {
            protocol1_length = 1;
        protocol1_info = temp; }
        else{
        protocol1_info = (org.json.simple.JSONArray) univ.get("protocol1_info");
        }
        if (protocol2_length == 0) {
            protocol2_length = 1;
            protocol2_info = temp; }
        else{
        protocol2_info = (org.json.simple.JSONArray) univ.get("protocol2_info");
        }
        if (protocol3_length == 0) {
            protocol3_length = 1;
            protocol3_info = temp; }
        else {
            protocol3_info = (org.json.simple.JSONArray) univ.get("protocol3_info");
        }
        if (protocol4_length == 0) {
            protocol4_length = 1;
            protocol4_info = temp; }
        else {
            protocol4_info = (org.json.simple.JSONArray) univ.get("protocol4_info");
        }

        /* j = arr.size();
        String[] sendarr = new String[j];
        tmppg = ((Long) univ.get("total")).intValue();

        for (i = 0; i < j; i++) {

            JSONObject tmp = (JSONObject) arr.get(i);
            sendarr[i] = tmp.toString();

            arrayString = Arrays.toString(sendarr);
        }
        Log.e("arrayString", arrayString); */
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