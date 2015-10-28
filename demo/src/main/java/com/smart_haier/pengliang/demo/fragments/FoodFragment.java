package com.smart_haier.pengliang.demo.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v17.leanback.widget.HorizontalGridView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.smart_haier.pengliang.demo.R;
import com.smart_haier.pengliang.demo.activity.OnChangeButtonListener;

import java.util.zip.Inflater;


public class FoodFragment extends Fragment {
    private int[] imagIds = {R.mipmap.apple, R.mipmap.apple, R.mipmap.apple, R.mipmap.apple,
            R.mipmap.apple, R.mipmap.apple, R.mipmap.apple, R.mipmap.apple, R.mipmap.apple,
            R.mipmap.apple, R.mipmap.apple, R.mipmap.apple, R.mipmap.apple};


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
        View view = inflater.inflate(R.layout.fragment_food, container, false);
        HorizontalGridView mGvFood = (HorizontalGridView) view.findViewById(R.id.gv_food);
        mGvFood.setAdapter(new FoodAdapter(this.getActivity()));
        return view;
    }


    class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
        private Context mContext;

        public FoodAdapter(Context context) {
            this.mContext = context;
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(mContext, R.layout.gridview_food, null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.imageView.setImageResource(imagIds[position]);
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(FoodFragment.this.getActivity(), "ok", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return imagIds.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView imageView;

            public ViewHolder(View itemView) {
                super(itemView);
                imageView = (ImageView) itemView.findViewById(R.id.img_food);
            }
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


}
