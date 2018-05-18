package com.dhsoft.alfo6_20.hospital;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView iv_hospi;
    ImageView iv_phar;
    ImageView iv_eng;

    boolean isRun=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_hospi=findViewById(R.id.iv_hospital);
        iv_phar=findViewById(R.id.iv_phar);
        iv_eng=findViewById(R.id.iv_eung);


    }//onCreate

    public void clickHospi(View v){
        Intent intent=new Intent(this,HospiActivity.class);
        startActivity(intent);

    }

    public void clickPhar(View v){
        Intent intent=new Intent(this,PharActivity.class);
        startActivity(intent);
    }

    public void clickEung(View v){
        Intent intent=new Intent(this,EungActivity.class);
        startActivity(intent);
    }

    public void clickBoard(View v){

        //다이얼로그
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);

        builder.setTitle("로그인이 필요합니다.\n하시겠습니까?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {



            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //로그인된상태이면 BoardActivity2로 intent넘겨주기
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.create();
        builder.show();

    }


}
