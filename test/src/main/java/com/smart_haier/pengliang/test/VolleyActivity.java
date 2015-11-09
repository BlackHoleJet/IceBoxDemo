package com.smart_haier.pengliang.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

public class VolleyActivity extends AppCompatActivity {
    private String testUrl = "http://www.weather.com.cn/adat/sk/101280101.html";
    StringRequest stringRequest;
    private Button mBtTest;
    private TextView testContent;
    private static final String TAG = VolleyActivity.class.getSimpleName();
    Gson gson;
    wether wetherInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        init();

    }

    private void init() {
        gson = new Gson();
        mBtTest = (Button) findViewById(R.id.btTest);
        testContent = (TextView) findViewById(R.id.json);
        mBtTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringRequest = new StringRequest(testUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "json:" + response);
                        Toast.makeText(VolleyActivity.this, "json:" + response, Toast.LENGTH_SHORT).show();
                        wetherInfo = gson.fromJson(response, wether.class);
                        testContent.setText(wetherInfo.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(VolleyActivity.this, "err:" + error.toString(), Toast.LENGTH_SHORT).show();

                    }
                });

                MyApplication.getRequestQueue().add(stringRequest);
            }

        });
    }

}
