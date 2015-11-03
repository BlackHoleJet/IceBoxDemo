package com.smart_haier.pengliang.demo.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smart_haier.pengliang.demo.R;
import com.smart_haier.pengliang.demo.activity.OnChangeButtonListener;


public class HomeFragment extends Fragment {
    private static final String TAG = HomeFragment.class.getSimpleName();

    private OnChangeButtonListener mListener;
    private static HomeFragment instance = null;

    public HomeFragment() {

    }


    public static HomeFragment newInstance() {
        if (instance == null) {
            synchronized (HomeFragment.class) {
                if (instance == null) {
                    instance = new HomeFragment();
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

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView testTv = (TextView) view.findViewById(R.id.test);
        testTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testTv.setText("test");
            }
        });

        return view;
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


}
