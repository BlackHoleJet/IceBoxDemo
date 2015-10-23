package com.smart_haier.pengliang.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class DemoActivity extends AppCompatActivity {
    private ImageView bt1, bt2, bt3, img_origin, img_lizhi, img_apple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        init();

    }

    private void init() {
        bt1 = (ImageView) findViewById(R.id.bt_bt1);
        bt2 = (ImageView) findViewById(R.id.bt_bt2);
        bt3 = (ImageView) findViewById(R.id.bt_bt3);
        img_apple = (ImageView) findViewById(R.id.img_apple);
        img_origin = (ImageView) findViewById(R.id.img_origin);
        img_lizhi = (ImageView) findViewById(R.id.img_lizhi);


    }


    public void showAndHide(ImageView hide, ImageView show) {
        hide.setVisibility(View.GONE);
        Animation animation = AnimationUtils.loadAnimation(DemoActivity.this, R.anim.animation1);
        animation.setFillAfter(true);
        show.startAnimation(animation);
        show.setVisibility(View.VISIBLE);
    }


    public void bt1(View view) {
        showAndHide(bt1, img_origin);
    }

    public void bt2(View view) {
        showAndHide(bt2, img_apple);
    }

    public void bt3(View view) {
        showAndHide(bt3, img_lizhi);
    }

    public void btapple(View view) {
        showAndHide(img_apple, bt2);
    }

    public void btlizhi(View view) {
        showAndHide(img_lizhi, bt3);
    }

    public void btorigin(View view) {
        showAndHide(img_origin, bt1);
    }


}
