package com.smart_haier.pengliang.demo.activity;

import android.os.Bundle;

import com.smart_haier.pengliang.demo.fragments.FoodFragment;
import com.smart_haier.pengliang.demo.fragments.HomeFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.smart_haier.pengliang.demo.R;

import java.util.List;

public class MainActivity extends FragmentActivity implements OnChangeButtonListener, View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Fragment mHomeFragment, mFoodFragment;
    private TextView mTitle;
    private Button mBtHome, mBtFood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate()");
        if (savedInstanceState == null) {
            initFragments();
        }
        initView();
    }

    private void initView() {
        mTitle = (TextView) findViewById(R.id.title);
        mBtHome = (Button) findViewById(R.id.bt_home);
        mBtFood = (Button) findViewById(R.id.bt_food);
        mBtHome.setOnClickListener(this);
        mBtFood.setOnClickListener(this);
    }


    private void initFragments() {
        mHomeFragment = HomeFragment.newInstance();
        mFoodFragment = FoodFragment.newInstance();
        getSupportFragmentManager().beginTransaction().
                add(R.id.fragment_container, mHomeFragment).
                add(R.id.fragment_container, mFoodFragment).
                commit();
    }


    @Override
    public void onNextTouched(int what) {

    }


    public void changeFragment(Fragment show, int titleId) {

        Toast.makeText(MainActivity.this, "show:" + getShowFragment().getClass().getSimpleName(), Toast.LENGTH_SHORT).show();
        if (getShowFragment() != show) {
            mTitle.setText(titleId);
            getSupportFragmentManager().beginTransaction().hide(getShowFragment()).show(show).commit();
        }


    }


    public Fragment getShowFragment() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Log.d(TAG, "fragments:" + fragments.toString());
        for (Fragment f : fragments) {
            if (f != null && f.isVisible())
                return f;
        }
        return null;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_home:

                changeFragment(mHomeFragment, R.string.title_home);
                break;
            case R.id.bt_food:

                changeFragment(mFoodFragment, R.string.title_food);
                break;
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");

    }
}
