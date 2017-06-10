package com.mounika.task;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Mounika on 6/9/2017.
 */

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Created by Mounika on 6/9/2017.
 */
public class MilestoneAdapter extends RecyclerView.Adapter<MilestoneAdapter.ViewHolder>{

    public ArrayList<String> Content=new ArrayList<>();
    Context context1;
    public MilestoneAdapter(Context context2, ArrayList<String> content)
    {
        this.Content = content;
        context1 = context2;
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView contentTv;
        public View view;

        public ViewHolder(View v)
        {
            super(v);
            contentTv = (TextView) v.findViewById(R.id.milecard);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view1 = LayoutInflater.from(context1).inflate(R.layout.milestone_adapter,parent,false);
        ViewHolder viewHolder1 = new ViewHolder(view1);
        return viewHolder1;
    }
    @Override
    public void onBindViewHolder(final ViewHolder Vholder, final int position) {

        Vholder.contentTv.setText(Content.get(position));
    }
    @Override
    public int getItemCount() {
        return Content.size();
    }
}
