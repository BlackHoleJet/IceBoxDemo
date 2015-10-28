package com.smart_haier.pengliang.demo.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smart_haier.pengliang.demo.R;
import com.smart_haier.pengliang.demo.activity.OnChangeButtonListener;


public class FoodFragment extends Fragment {

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
        // Inflate the layout for this fragment
         View view=inflater.inflate(R.layout.fragment_food, container, false);

        return view;
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


}
