package com.smart_haier.pengliang.test;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.jess.ui.TwoWayGridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TwoWayGridView twoWayGridView;
    private ImageView img;
    private RequestQueue mRequestQueue;
    private ViewPager viewPage;
    private int[] ImageIds = {R.mipmap.home1, R.mipmap.home2};
    View image1;
    View image2;
    private List<View> imageLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        imageLists = new ArrayList<>(2);
        viewPage = (ViewPager) findViewById(R.id.viewpager_homepage);
//        mRequestQueue = Volley.newRequestQueue(MainActivity.this);
//        twoWayGridView = (TwoWayGridView) findViewById(R.id.gv_test);
//        twoWayGridView.setAdapter(new Myadapter());
//        twoWayGridView.setOnItemClickListener(new TwoWayAdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(TwoWayAdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();
//            }
//        });

        image1 = View.inflate(this, R.layout.image1, null);
        image2 = View.inflate(this, R.layout.image2, null);
        imageLists.add(image1);
        imageLists.add(image2);
        viewPage.setAdapter(new ViewPagerAdapter());

    }


    class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageLists.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageLists.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageLists.get(position));
            return imageLists.get(position);

        }
    }


    class Myadapter extends BaseAdapter {

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
                convertView = View.inflate(MainActivity.this, R.layout.image1, null);
                vh.imageView = (ImageView) convertView.findViewById(R.id.imageView);
                convertView.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }
            ImageRequest irequest = new ImageRequest(
                    "http://a.hiphotos.baidu.com/image/w%3D2048/sign=d2ebf5336963f6241c5d3e03b37ceaf8/902397dda144ad347976f98dd2a20cf430ad85ea.jpg",
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
                    Toast.makeText(MainActivity.this, "load img err", Toast.LENGTH_SHORT).show();

                }
            });
            mRequestQueue.add(irequest);
            return convertView;
        }
    }

    class ViewHolder {
        ImageView imageView;
    }


}
