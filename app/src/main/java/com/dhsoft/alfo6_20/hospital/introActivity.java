package com.dhsoft.alfo6_20.hospital;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class introActivity extends AppCompatActivity {

    ImageView iv;

    Timer timer=new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        iv=findViewById(R.id.iv_intro);

        Animation ani= AnimationUtils.loadAnimation(this,R.anim.logo);

        iv.startAnimation(ani);

        timer.schedule(task,4000);
        

    }



    //timer의 스케쥴링 작업을 수행하는 객체 생성
    TimerTask task=new TimerTask() {
        @Override
        public void run() {

            Intent intent=new Intent(introActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    };
}
