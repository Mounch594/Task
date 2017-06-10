package com.mounika.task;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
/**
 * Created by Mounika on 6/9/2017.
 */
public class MilestoneFragment extends Fragment {

    RecyclerView milestoneRecyclerView;
    RecyclerView.Adapter milestoneRecyclerViewAdapter;
    MainActivity TabsActivity;
    RecyclerView.LayoutManager milestoneLayoutManager;
    Context context;
    public ArrayList<String> Contents = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Contents.add("Navigation Drawer");
        Contents.add("CircleIndicator");
        Contents.add("TabsPager");
        Contents.add("Recyclerview Cardview");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_milestone, container, false);
        milestoneRecyclerView = ((RecyclerView) view.findViewById(R.id.milestoneRecyclerView));
        TabsActivity = new MainActivity();
        initViews();
        return view;
    }

    private void initViews() {
        Log.i("init", "initViews() called");

        milestoneLayoutManager = new LinearLayoutManager(getActivity());
        milestoneRecyclerView.setLayoutManager(milestoneLayoutManager);
       milestoneRecyclerViewAdapter = new MilestoneAdapter(getContext(), Contents);
        milestoneRecyclerView.setAdapter(milestoneRecyclerViewAdapter);
    }
}