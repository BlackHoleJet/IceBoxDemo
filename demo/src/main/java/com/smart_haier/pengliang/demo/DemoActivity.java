package com.smart_haier.pengliang.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nineoldandroids.animation.Animator;


public class DemoActivity extends AppCompatActivity {
    private ImageView bt1, bt2, bt3, img_origin, img_lizhi, img_apple;
    private YoYo.YoYoString rope;
    private static final String TAG = DemoActivity.class.getSimpleName();

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
//        final long[] time = new long[1];
//        final long[] time1 = new long[1];
        bt3.setVisibility(View.GONE);
        img_lizhi.setVisibility(View.VISIBLE);
        rope = YoYo.with(Techniques.ZoomInLeft).duration(2000).playOn(img_lizhi);
//        rope = YoYo.with(Techniques.BounceInRight).duration(2000).withListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//                time[0] = System.currentTimeMillis();
//                bt3.setVisibility(View.GONE);
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                time1[0]=System.currentTimeMillis();
//                Log.d(TAG, "time" + (time1[0] - time[0]));
//
//
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        }).playOn(img_lizhi);
//            YoYo.with(Techniques.BounceInRight).playOn(img_lizhi);
    }

    public void btapple(View view) {
        showAndHide(img_apple, bt2);
    }

    public void btlizhi(View view) {
//        showAndHide(img_lizhi, bt3);
        bt3.setVisibility(View.VISIBLE);
        img_lizhi.setVisibility(View.GONE);
        YoYo.with(Techniques.ZoomInDown).duration(2000).playOn(bt3);
    }


    public void btorigin(View view) {
        showAndHide(img_origin, bt1);
    }


}
