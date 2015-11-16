package com.smart_haier.pengliang.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smart_haier.pengliang.demo.R;

import java.util.Random;

public class NormalRecyclerViewAdapter extends RecyclerView.Adapter<NormalRecyclerViewAdapter.NormalTextViewHolder> {
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private String[] mTitles;
    private static final String TAG = NormalRecyclerViewAdapter.class.getSimpleName();

    public NormalRecyclerViewAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mTitles = new String[]{"aa", "bb", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc", "cc"};
    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NormalTextViewHolder normalTextViewHolder = new
                NormalTextViewHolder(mLayoutInflater.inflate(R.layout.gridview_item, parent, false));
        return normalTextViewHolder;
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position) {
//        holder.mTextView.setText(mTitles[position]);
        Random random = new Random();
        int a = random.nextInt(500);
        int b = random.nextInt(100);
        int c = random.nextInt(100);
        int d = random.nextInt(100);
        Log.d(TAG, "random num:" + a + "  " + b + "  " + c + "  " + d);
        holder.image.setPadding(0, 20, 0, 20);
//        ViewGroup.LayoutParams layoutParams = holder.image.getLayoutParams();
//        layoutParams.height = a;
//        holder.image.setLayoutParams(layoutParams);


    }

    @Override
    public int getItemCount() {
        return mTitles == null ? 0 : mTitles.length;
    }

    public static class NormalTextViewHolder extends RecyclerView.ViewHolder {
        //        TextView mTextView;
        ImageView image;
        LinearLayout linearLayout;

        NormalTextViewHolder(View view) {
            super(view);
            image = (ImageView) view.findViewById(R.id.tv_test);
            linearLayout = (LinearLayout) view;

        }
    }
}