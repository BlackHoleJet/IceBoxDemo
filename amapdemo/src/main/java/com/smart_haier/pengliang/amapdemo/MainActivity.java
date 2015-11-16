package com.smart_haier.pengliang.amapdemo;

import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;
import com.amap.api.services.poisearch.PoiItemDetail;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;

public class MainActivity extends AppCompatActivity implements AMapLocationListener,PoiSearch.OnPoiSearchListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private LocationManagerProxy mLocationManagerProxy;
    private TextView mAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mLocationManagerProxy = LocationManagerProxy.getInstance(this);
//        mLocationManagerProxy.requestLocationData(LocationManagerProxy.NETWORK_PROVIDER, 60 * 1000, 15, this);
        mLocationManagerProxy.requestLocationData(LocationProviderProxy.AMapNetwork, 60 * 1000, 15, this);
        mLocationManagerProxy.setGpsEnable(false);
        mAddress = (TextView) findViewById(R.id.tv_address);
    }


    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        Log.d(TAG, "aMapLocation");
//        if (aMapLocation != null && aMapLocation.getAMapException().getErrorCode() == 0) {
            //获取位置信息
//            Double geoLat = aMapLocation.getLatitude();
//            Double geoLng = aMapLocation.getLongitude();
//            Log.d(TAG, "lat: " + geoLat + "  lon: " + geoLng);
//            Log.d(TAG, "adress: " + aMapLocation.getAddress());
//            Log.d(TAG, "extras: " + aMapLocation.getExtras());
//            String adress="lat: " + geoLat + "  lon: " + geoLng+"    adress: " + aMapLocation.getAddress()+"   extras: " + aMapLocation.getExtras().toString();
//            mAddress.setText(adress);

            if (aMapLocation != null) {
//                this.aMapLocation = ;location// 判断超时机制
                Log.d(TAG,"err: "+aMapLocation.getAMapException().getErrorMessage() );
                Double geoLat = aMapLocation.getLatitude();
                Double geoLng = aMapLocation.getLongitude();
                String cityCode = "";
                String desc = "";
                Bundle locBundle = aMapLocation.getExtras();
                if (locBundle != null) {
                    cityCode = locBundle.getString("citycode");
                    desc = locBundle.getString("desc");
                }
                String str = ("定位成功:(" + geoLng + "," + geoLat + ")"
                        + "\n精    度    :" + aMapLocation.getAccuracy() + "米"
                        + "\n定位方式:" + aMapLocation.getProvider() + "\n定位时间:"
                        + "  " + "\n城市编码:"
                        + cityCode + "\n位置描述:" + desc + "\n省:"
                        + aMapLocation.getProvince() + "\n市:" + aMapLocation.getCity()
                        + "\n区(县):" + aMapLocation.getDistrict() + "\n区域编码:" + aMapLocation
                        .getAdCode());
                mAddress.setText(str);
            }
//        }
    }


    @Override
    public void onLocationChanged(Location location) {
        //此方法已废弃
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d(TAG, "onStatusChanged: " + provider + "  " + status + "  " + extras.toString());

    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d(TAG, "onProviderEnabled: " + provider);

    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d(TAG, "onProviderDisabled: " + provider);
    }

    private void stopLocation() {
        if (mLocationManagerProxy != null) {
            mLocationManagerProxy.removeUpdates(this);
            mLocationManagerProxy.destory();
        }
        mLocationManagerProxy = null;
    }


    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopLocation();
    }

    @Override
    public void onPoiSearched(PoiResult poiResult, int i) {

    }

    @Override
    public void onPoiItemDetailSearched(PoiItemDetail poiItemDetail, int i) {

    }
}
