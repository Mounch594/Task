package com.mounika.task;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Mounika on 6/10/2017.
 */

public class ImgAdapter extends BaseAdapter {
    private Context Context;

    public Integer[] mThumbIds = {
            R.drawable.first, R.drawable.second,
            R.drawable.third, R.drawable.fourth,
            R.drawable.fifth, R.drawable.cardone,
            R.drawable.cardtwo, R.drawable.cardthree,
            R.drawable.cardforu,
    };

    // Constructor
    public ImgAdapter(Context c){
        Context = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(Context);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
        return imageView;
    }

}
