package com.mounika.task;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Mounika on 6/9/2017.
 */
public class VideoFragment extends Fragment {

    RecyclerView videoRecyclerView;
    RecyclerView.Adapter videoRecyclerViewAdapter;
    MainActivity TabsActivity;
    RecyclerView.LayoutManager videoLayoutManager;
    Context context;
    public ArrayList<Integer> image = new ArrayList<>();
    public ArrayList<String> title = new ArrayList<>();
    public ArrayList<String> time = new ArrayList<>();
    public ArrayList<String> desc = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        image.add(R.drawable.cardone);
        image.add(R.drawable.cardtwo);
        image.add(R.drawable.cardthree);
        image.add(R.drawable.cardforu);

        title.add("EMPTINESS FT.JUSTIN TIBLEKAR");
        title.add("I'M FALLING LOVE WITH YOU");
        title.add("BABY FT.JUSTIN BABER");
        title.add("WHITE HORSE FT.TAYLOR SWIFT");

        time.add("18 HOURS AGO");
        time.add("20 HOURS AGO");
        time.add("22 HOURS AGO");
        time.add("24 HOURS AGO");

        desc.add("Lorem Ipsum is simply dummy text of the printing and typesetting indusry.");
        desc.add("Lorem Ipsum is simply dummy text of the printing and typesetting indusry.");
        desc.add("Lorem Ipsum is simply dummy text of the printing and typesetting indusry.");
        desc.add("Lorem Ipsum is simply dummy text of the printing and typesetting indusry.");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_video, container, false);
        videoRecyclerView = ((RecyclerView) view.findViewById(R.id.videoRecyclerView));
        TabsActivity = new MainActivity();
        initViews();
        return view;
    }

    private void initViews() {
        Log.i("init", "initViews() called");

        videoLayoutManager = new LinearLayoutManager(getActivity());
        videoRecyclerView.setLayoutManager(videoLayoutManager);
        videoRecyclerViewAdapter = new VideoAdapter(getContext(),image,title,time,desc);
        videoRecyclerView.setAdapter(videoRecyclerViewAdapter);

        videoRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener(){
            GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener(){

                @Override public boolean onSingleTapUp(MotionEvent e){
                    return true;
                }

            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e){

                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if(child != null && gestureDetector.onTouchEvent(e)){
                    Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com"));
                    startActivity(i);
                }
                return false;
            }
            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e){
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept){

            }
        });

    }
}