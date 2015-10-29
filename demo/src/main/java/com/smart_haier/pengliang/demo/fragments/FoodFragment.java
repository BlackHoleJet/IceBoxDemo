package com.smart_haier.pengliang.demo.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v17.leanback.widget.HorizontalGridView;
import android.support.v17.leanback.widget.OnChildSelectedListener;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.smart_haier.pengliang.demo.R;
import com.smart_haier.pengliang.demo.activity.OnChangeButtonListener;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class FoodFragment extends Fragment {
    private int[] imagIds = {R.mipmap.apple, R.mipmap.apple, R.mipmap.apple, R.mipmap.apple,
            R.mipmap.apple, R.mipmap.apple, R.mipmap.apple, R.mipmap.apple, R.mipmap.apple,
            R.mipmap.apple, R.mipmap.apple, R.mipmap.apple, R.mipmap.apple};
    private BarChart mChart;


    private OnChangeButtonListener mListener;
    private static FoodFragment instance = null;

    public FoodFragment() {

    }


    public static FoodFragment newInstance() {
        if (instance == null) {
            synchronized (FoodFragment.class) {
                if (instance == null) {
                    instance = new FoodFragment();
                }
            }
        }
        return instance;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food, container, false);

        GridView mGvFood = (GridView) view.findViewById(R.id.gv_food);
        mGvFood.setAdapter(new FoodGvAdapter());



        mChart = (BarChart) view.findViewById(R.id.chart1);
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


        return view;
    }


    class FoodGvAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return imagIds.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = View.inflate(FoodFragment.this.getActivity(), R.layout.gridview_food, null);

            }

            return convertView;
        }
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnChangeButtonListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
