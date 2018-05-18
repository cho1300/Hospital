package com.dhsoft.alfo6_20.hospital;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by alfo6-20 on 2018-05-16.
 */

public class Recycler extends RecyclerView.Adapter {

    ArrayList<Item> items;
    Context context;

    public Recycler(ArrayList<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //recycler_item.xml를 View객체로 만들어주는 작 업
        LayoutInflater inflater=LayoutInflater.from(context);
        View itemView=inflater.inflate(R.layout.recy,parent,false);
        VH holder=new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        VH vh=(VH)holder;
        Item Item= items.get(position);
        vh.tvMsg.setText(Item.msg);
    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        TextView tvMsg;

        public VH(View itemView) {
            super(itemView);
            tvMsg=itemView.findViewById(R.id.tv_msg);
        }
    }
}
