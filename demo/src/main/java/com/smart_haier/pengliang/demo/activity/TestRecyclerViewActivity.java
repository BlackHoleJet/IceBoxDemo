package com.smart_haier.pengliang.demo.activity;

import android.app.Activity;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.smart_haier.pengliang.demo.R;
import com.smart_haier.pengliang.demo.adapter.NormalRecyclerViewAdapter;
import com.smart_haier.pengliang.demo.base.DividerGridItemDecoration;


public class TestRecyclerViewActivity extends Activity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_recycler_view);

        init();
    }

    private void init() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_test);
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4, OrientationHelper.HORIZONTAL, false));
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,OrientationHelper.HORIZONTAL));
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        mRecyclerView.setAdapter(new NormalRecyclerViewAdapter(this));
    }
}
