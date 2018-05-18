package com.dhsoft.alfo6_20.hospital;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

/**
 * Created by alfo6-20 on 2018-05-09.
 */

public class MapBaseAdapter extends BaseAdapter {

    ArrayList<Item> items ;
    LayoutInflater inflater;

    public MapBaseAdapter(ArrayList<Item> items, LayoutInflater inflater) {
        this.items = items;
        this.inflater = inflater;
    }


    @Override
    public int getCount() {

        return items.size();
    }

    @Override
    public Object getItem(int position) {

        return items.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if(view==null){
            view=inflater.inflate(R.layout.mybase,null);
        }


        Item item=items.get(position);
        TextView tvname=view.findViewById(R.id.dutyName);
        TextView tvaddr=view.findViewById(R.id.dutyAddr);
        TextView tvtell=view.findViewById(R.id.dutyTell);
        TextView tvmsg=view.findViewById(R.id.tv_msg);

        tvname.setText(item.dutyName);
        tvaddr.setText(item.dutyAddr);
        tvtell.setText(item.dutyTel1);
        tvmsg.setText(item.msg);

        return view;
    }
}
