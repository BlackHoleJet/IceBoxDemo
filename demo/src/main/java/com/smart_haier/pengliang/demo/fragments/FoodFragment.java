package com.smart_haier.pengliang.demo.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.jess.ui.TwoWayGridView;
import com.smart_haier.pengliang.demo.R;
import com.smart_haier.pengliang.demo.activity.MainActivity;
import com.smart_haier.pengliang.demo.activity.OnChangeButtonListener;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class FoodFragment extends Fragment {
    private static final String TAG = FoodFragment.class.getSimpleName();

    private int[] imagIds = {R.mipmap.apple, R.mipmap.apple, R.mipmap.apple, R.mipmap.apple,
            R.mipmap.apple, R.mipmap.apple, R.mipmap.apple, R.mipmap.apple, R.mipmap.apple,
            R.mipmap.apple, R.mipmap.apple, R.mipmap.apple, R.mipmap.apple};
    private BarChart mChart;
    private RequestQueue mRequestQueue;
    private String ImageUrl = "http://www.51qe.cn/zhongyao/UploadFiles_5272/201210/2012101109342023.jpg";

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
        Log.d(TAG, "onCreate()");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView()");

        View view = inflater.inflate(R.layout.fragment_food, container, false);
        mRequestQueue = Volley.newRequestQueue(FoodFragment.this.getActivity());
        TwoWayGridView mGvFood = (TwoWayGridView) view.findViewById(R.id.gv_food);
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
            return 1000;
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
            final ViewHolder vh;
            if (convertView == null) {
                vh = new ViewHolder();
                convertView = View.inflate(FoodFragment.this.getActivity(), R.layout.gridview_item, null);
                vh.imageView = (ImageView) convertView.findViewById(R.id.img_food);
                convertView.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }
            ImageRequest irequest = new ImageRequest(
                    ImageUrl,
                    new Response.Listener<Bitmap>() {
                        @SuppressLint("NewApi")
                        @SuppressWarnings("deprecation")
                        @Override
                        public void onResponse(Bitmap bitmap) {
//                            img.setBackgroundDrawable(new BitmapDrawable(
//                                    MainActivity.this.getResources(), bitmap));
                            vh.imageView.setImageBitmap(bitmap);
                        }
                    }, 0, 0, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError arg0) {
                    Toast.makeText(FoodFragment.this.getActivity(), "load img err", Toast.LENGTH_SHORT).show();

                }
            });
            mRequestQueue.add(irequest);
            return convertView;

        }
    }

    class ViewHolder {
        ImageView imageView;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(TAG, "onAttach()");

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
        Log.d(TAG, "onDetach()");

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
