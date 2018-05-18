
package com.dhsoft.alfo6_20.hospital;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapView;

public class EungActivity extends NMapActivity {

    NMapView nMapView;
    private final String CLIENT_ID = "hpatAdi96Zcp8WIa7IQE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eung);



        nMapView=findViewById(R.id.nMap);
        nMapView.setClientId(CLIENT_ID); // 클라이언트 아이디 값 설정
        nMapView.setClickable(true);
        nMapView.setEnabled(true);
        nMapView.setFocusable(true);
        nMapView.setFocusableInTouchMode(true);
        nMapView.requestFocus();

    }


}
