package com.dhsoft.alfo6_20.hospital;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class Board2Activity extends AppCompatActivity {

    ArrayList<Item> items=new ArrayList<>();
    RecyclerView rec;
    ImageView imageView;
    EditText editText;
    RecyclerView recyclerView;
    Recycler adapter;
//    ListView listView;
//    MapBaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board2);
        rec = findViewById(R.id.rec);
        imageView = findViewById(R.id.iv_feat);
        editText=findViewById(R.id.edit);
        recyclerView=findViewById(R.id.rec);
        adapter=new Recycler(items,this);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);


    }

    public void clickIv(View v) {
        Item item=new Item();


        item.setMsg(editText.getText().toString());
        Toast.makeText(this, item.getMsg(), Toast.LENGTH_SHORT).show();
        items.add(item);
        adapter.notifyDataSetChanged();


    }


}

