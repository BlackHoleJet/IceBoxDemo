package com.smart_haier.pengliang.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;


import java.util.HashMap;
import java.util.Map;

public class VolleyActivity extends AppCompatActivity {
    private String testUrl = "http://www.weather.com.cn/adat/sk/101280101.html";
    StringRequest stringRequest;
    private Button mBtTest;
    private TextView testContent;
    private static final String TAG = VolleyActivity.class.getSimpleName();
    private Gson gson;
    private wether wetherInfo;


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
                stringRequest = new StringRequest(Request.Method.GET, testUrl, new Response.Listener<String>() {
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
                }) {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> map = new HashMap<String, String>();
                        map.put("params1", "value1");
                        map.put("params2", "value2");
                        return map;

                    }
                };


                MyApplication.getRequestQueue().add(stringRequest);
            }

        });
    }
}
