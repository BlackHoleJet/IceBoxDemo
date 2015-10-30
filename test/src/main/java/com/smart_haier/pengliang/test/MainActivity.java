package com.smart_haier.pengliang.test;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.jess.ui.TwoWayAdapterView;
import com.jess.ui.TwoWayGridView;

public class MainActivity extends AppCompatActivity {
    private TwoWayGridView twoWayGridView;
    private ImageView img;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRequestQueue = Volley.newRequestQueue(MainActivity.this);
        twoWayGridView = (TwoWayGridView) findViewById(R.id.gv_test);
        twoWayGridView.setAdapter(new Myadapter());
        twoWayGridView.setOnItemClickListener(new TwoWayAdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(TwoWayAdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();
            }
        });
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
                convertView = View.inflate(MainActivity.this, R.layout.gv_item, null);
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
