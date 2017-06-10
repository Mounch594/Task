package com.mounika.task;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * Created by Mounika on 6/9/2017.
 */
public class ImageFragment extends Fragment {


    MainActivity TabsActivity;
    GridView gridView;
    Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_image, container, false);
        gridView = ((GridView) view.findViewById(R.id.grid_view));
        TabsActivity = new MainActivity();
        initViews();
        return view;
    }

    private void initViews() {
        gridView.setAdapter(new ImgAdapter(getContext()));
    }
}