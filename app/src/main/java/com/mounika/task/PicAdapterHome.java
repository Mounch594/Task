package com.mounika.task;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
/**
 * Created by Mounika on 6/9/2017.
 */

public class PicAdapterHome extends PagerAdapter {

    private int mSize;
    private Activity mActivity;
    private float mImageCorner = -1F;
    private int[] ResIds;

    public PicAdapterHome(Activity activity, int[] ResIds){
        mActivity = activity;
        this.ResIds=ResIds;

    }

    @Override
    public int getCount(){
        return ResIds.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object){
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup view, int position, Object object){
        view.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        View view = LayoutInflater.from(mActivity.getApplicationContext()).inflate
                (R.layout.recommend_page_home, container, false);
        ImageView imageView = (ImageView)view.findViewById(R.id.image);
        imageView.setImageResource(ResIds[position]);
        Bitmap image = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        Bitmap newimage = getRoundCornerImage(image,50);
        ImageView imageView2 = new ImageView(view.getContext());
        imageView2.setImageBitmap(newimage);
        container.addView(view);
        return view;
    }

    public void addItem(){
        mSize++;
        notifyDataSetChanged();
    }
    public void removeItem(){
        mSize--;
        mSize = mSize < 0 ? 0 : mSize;

        notifyDataSetChanged();
    }
    public Bitmap getRoundCornerImage(Bitmap bitmap, int roundPixels)
    {
        Bitmap roundConcerImage = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(roundConcerImage);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawRoundRect(rectF, roundPixels, roundPixels, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, null, rect, paint);
        return roundConcerImage;
    }
}

