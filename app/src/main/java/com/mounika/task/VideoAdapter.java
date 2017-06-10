package com.mounika.task;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * Created by Mounika on 6/9/2017.
 */


public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder>{

    public ArrayList<Integer> image=new ArrayList<>();
    public ArrayList<String> title=new ArrayList<>();
    public ArrayList<String> time=new ArrayList<>();
    public ArrayList<String> desc=new ArrayList<>();
    Context context1;
    public VideoAdapter(Context context2, ArrayList<Integer> image, ArrayList<String> title, ArrayList<String> time, ArrayList<String> desc)
    {
        this.image = image;
        this.title = title;
        this.time = time;
        this.desc = desc;
        context1 = context2;
    }
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView title,time,desc;
        public ImageView image;
        public View view;

        public ViewHolder(View v)
        {
            super(v);
            image =(ImageView)v.findViewById(R.id.imagecard);
            title = (TextView) v.findViewById(R.id.titlevideo);
            time = (TextView) v.findViewById(R.id.textset);
            desc = (TextView) v.findViewById(R.id.descvideo);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view1 = LayoutInflater.from(context1).inflate(R.layout.video_adapter,parent,false);
        ViewHolder viewHolder1 = new ViewHolder(view1);
        return viewHolder1;
    }
    @Override
    public void onBindViewHolder(final ViewHolder Vholder, final int position) {

        Vholder.image.setImageResource(image.get(position));
        Vholder.title.setText(title.get(position));
        Vholder.time.setText(time.get(position));
        Vholder.desc.setText(desc.get(position));
    }
    @Override
    public int getItemCount() {
        return title.size();
    }
}
