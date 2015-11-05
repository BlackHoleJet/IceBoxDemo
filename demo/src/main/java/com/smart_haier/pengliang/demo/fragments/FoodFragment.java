package com.smart_haier.pengliang.demo.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
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
import com.jess.ui.TwoWayAdapterView;
import com.jess.ui.TwoWayGridView;
import com.smart_haier.pengliang.demo.R;
import com.smart_haier.pengliang.demo.activity.OnChangeButtonListener;

import java.util.ArrayList;


public class FoodFragment extends Fragment {
    private static final String TAG = FoodFragment.class.getSimpleName();
    private AlertDialog dialog = null;
    public boolean isShow;

    private int[] imagIds = {R.mipmap.apple, R.mipmap.apple, R.mipmap.apple, R.mipmap.apple,
            R.mipmap.apple, R.mipmap.apple, R.mipmap.apple, R.mipmap.apple, R.mipmap.apple,
            R.mipmap.apple, R.mipmap.apple, R.mipmap.apple, R.mipmap.apple};
    private BarChart mChart;
    private RequestQueue mRequestQueue;
    private String ImageUrl = "http://www.51qe.cn/zhongyao/UploadFiles_5272/201210/2012101109342023.jpg";
    private String ImageAppleUrl = "http://www.xuyaocai.com/images/201405/goods_img/339_P_1399000342751.jpg";
    private String ImageUrl1 = "http://pic.nipic.com/2008-02-16/2008216151436165_2.jpg";
    private String ImageUrl2 = "http://u2.zhenyouliao.com/images/20140315/759e26d3-90e7-49e2-be46-4cc8d0f922e8.jpg";
    private String ImageUrl3 = "http://thumbs.dreamstime.com/x/%C5%A3%C8%E2%B2%E9%B3%F6%B5%C4%C8%E2-22017642.jpg";
    private String ImageUrl4 = "http://pica.nipic.com/2008-05-26/2008526233336488_2.jpg";
    private String ImageUrl5 = "http://img3.tubachina.com/2007xintukuaidi/other/shucai/mid_53Y3ZNC121XR95O.jpg";
    private String ImageUrl6 = "http://pic8.nipic.com/20100701/2839526_124431785971_2.jpg";
    private String ImageUrl7 = "http://jining.dzwww.com/jk/xt/201301/W020130128330647216422.jpg";
    private String ImageUrl8 = "http://img.taopic.com/uploads/allimg/120405/10021-12040500331876.jpg";
    private String ImageUrl9 = "http://img0.imgtn.bdimg.com/it/u=3606920438,902821268&fm=21&gp=0.jpg";
    private String ImageUrl0 = "http://www.linjulu.com/bk/uploads/201312/1387864590odAORgm0.jpg";
    private String[] Images = {ImageUrl, ImageAppleUrl, ImageUrl1, ImageUrl2, ImageUrl3, ImageUrl4, ImageUrl5, ImageUrl6, ImageUrl7, ImageUrl8, ImageUrl9, ImageUrl0};
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
        final TwoWayGridView mGvFood = (TwoWayGridView) view.findViewById(R.id.gv_food);
        mGvFood.setAdapter(new FoodGvAdapter());
        final View v = View.inflate(FoodFragment.this.getActivity(), R.layout.gridview_item, null);

        dialog = new AlertDialog.Builder(FoodFragment.this.getActivity())
                .setTitle("实物详情")
                .setPositiveButton("确定", null)
                .create();

        mGvFood.setOnItemClickListener(new TwoWayAdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(TwoWayAdapterView<?> parent, View view, int position, long id) {
                dialogShow(dialog, v);

            }
        });

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


    public void dialogShow(AlertDialog dialog, View view) {
        dialog.setView(view);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);  //此处可以设置dialog显示的位置
        window.setWindowAnimations(R.style.mystyle);  //添加动画
        dialog.show();
    }


    class FoodGvAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Images.length;
        }

        @Override
        public Object getItem(int position) {
            return Images[position];
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
            if (isShow == true) {
                ImageRequest irequest = new ImageRequest(
                        Images[position],
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
                        Toast.makeText(FoodFragment.this.getActivity(), "err:"+arg0.toString(), Toast.LENGTH_SHORT).show();

                    }
                });
                irequest.setShouldCache(true);
                mRequestQueue.add(irequest);
            }

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


    public void changeShowState(boolean state) {
        isShow = state;

    }


}
