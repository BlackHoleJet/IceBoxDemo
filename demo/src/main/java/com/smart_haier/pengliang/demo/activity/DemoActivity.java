package com.smart_haier.pengliang.demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.smart_haier.pengliang.demo.R;

import java.util.ArrayList;


public class DemoActivity extends AppCompatActivity {
    private ImageView bt1, bt2, bt3, img_origin, img_lizhi, img_apple;
    private YoYo.YoYoString rope;
    private static final String TAG = DemoActivity.class.getSimpleName();
    private BarChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
        mChart = (BarChart) findViewById(R.id.chart1);

        mChart.setDescription("近日食物消耗：");

        // scaling can now only be done on x- and y-axis separately
        mChart.setPinchZoom(false);

        mChart.setDrawBarShadow(false);
        mChart.setDrawGridBackground(false);
        mChart.setTouchEnabled(false);
        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setLabelsToSkip(0);
        xAxis.setDrawGridLines(false);

        mChart.getAxisLeft().setDrawGridLines(false);

        mChart.getLegend().setEnabled(false);

        setData(10);

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


    private void setData(int count) {

        ArrayList<BarEntry> yVals = new ArrayList<BarEntry>();
        ArrayList<String> xVals = new ArrayList<String>();

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * count) + 15;
            yVals.add(new BarEntry((int) val, i));
            xVals.add((int) val + "");
        }

        BarDataSet set = new BarDataSet(yVals, "食物：");
        set.setColors(ColorTemplate.VORDIPLOM_COLORS);
        set.setDrawValues(false);

        BarData data = new BarData(xVals, set);

        mChart.setData(data);
        mChart.invalidate();
        mChart.animateY(800);
    }

}
