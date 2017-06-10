package com.mounika.task;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hejunlin.superindicatorlibray.CircleIndicator;
import com.hejunlin.superindicatorlibray.LoopViewPager;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Mounika on 6/9/2017.
 */

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, View.OnClickListener {
    TextView textView;
    private int[] ResIds = new int[]{
            R.drawable.first,
            R.drawable.second,
            R.drawable.third,
            R.drawable.fourth,
            R.drawable.fifth,
    };
    private MediaPlayer mp;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    String[]titles = {"Home","Images", "MileStone", "Navi MileStone","Video","About Us"};
    private CharSequence mTitle;
    private CharSequence mDrawerTitle;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar topToolBar;
    ImageView b2;

    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTitle = mDrawerTitle = getTitle();
        b2 = (ImageView) findViewById(R.id.play);
        mp = MediaPlayer.create(MainActivity.this, R.raw.kalimba);
        topToolBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);
        topToolBar.setTitle("Home");

        tabLayout = (TabLayout) findViewById(R.id.TabLayout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        LayoutInflater inflater = getLayoutInflater();
        View listHeaderView = inflater.inflate(R.layout.header_list,null, false);


        List<ItemObject> listViewItems = new ArrayList<ItemObject>();
        listViewItems.add(new ItemObject("Home", R.drawable.home));
        listViewItems.add(new ItemObject("Images", R.drawable.image));
        listViewItems.add(new ItemObject("MileStone", R.drawable.milestone));
        listViewItems.add(new ItemObject("Navi MileStone", R.drawable.navi_milestone));
        listViewItems.add(new ItemObject("Video", R.drawable.video));
        listViewItems.add(new ItemObject("About Us", R.drawable.ab));

        mDrawerList.setAdapter(new CustomAdapter(this, listViewItems));
       // mDrawerList.addHeaderView(listHeaderView);

        mDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close){

            public void onDrawerClosed(View view){
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.setDrawerIndicatorEnabled(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                selectItemFragment(position);
            }
        });
        mDrawerList.addHeaderView(listHeaderView);

        LoopViewPager viewpager = (LoopViewPager) findViewById(R.id.viewpager);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        viewpager.setAdapter(new PicAdapterHome(MainActivity.this, ResIds));
        viewpager.setLooperPic(true);
        indicator.setViewPager(viewpager);

        TextView dtv=new TextView(MainActivity.this);
        dtv.setText("VIDEOS");
        dtv.setTextColor(Color.parseColor("#fe5723"));
        dtv.setTextSize(22);
        String current=dtv.getText().toString();

        TextView mtv=new TextView(MainActivity.this);
        mtv.setText("IMAGES");
        mtv.setTextColor(Color.parseColor("#fe5723"));
        mtv.setTextSize(22);
        String monthly= mtv.getText().toString();

        TextView mtvs=new TextView(MainActivity.this);
        mtvs.setText("MILESTONE");
        mtvs.setTextColor(Color.parseColor("#fe5723"));
        mtvs.setTextSize(22);
        String monthlyss= mtvs.getText().toString();

        tabLayout.addTab(tabLayout.newTab().setText(current).setCustomView(R.layout.videocustomview));
        tabLayout.addTab(tabLayout.newTab().setText(monthly).setCustomView(R.layout.imagescustomview));
        tabLayout.addTab(tabLayout.newTab().setText(monthlyss).setCustomView(R.layout.milestonescustomview));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        viewPager = (ViewPager) findViewById(R.id.taskPager);

        TabsPager tabsPager = new TabsPager(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabsPager);
        tabLayout.setOnTabSelectedListener(this);

        b2.setOnClickListener(this);
    }

    private void selectItemFragment(int position){

        switch(position){
            default:
            case 1:
                break;
            case 2:
                Intent i1 = new Intent(MainActivity.this, Images.class);
                startActivity(i1);
                break;
            case 3:
                Intent i2 = new Intent(MainActivity.this, Milestone.class);
                startActivity(i2);
                break;
            case 4:
                Intent i3 = new Intent(MainActivity.this,NaviMilestone.class);
                startActivity(i3);
                break;
            case 5:
                Intent i4= new Intent(MainActivity.this, Video.class);
                startActivity(i4);
                break;
            case 6:
                Intent i5= new Intent(MainActivity.this, AboutsUs.class);
                startActivity(i5);
                break;
        }
        mDrawerList.setItemChecked(position, true);
        //setTitle(titles[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onClick(View v) {
        // If the music is playing
        if(mp.isPlaying() == true)
            // Pause the music player
            mp.pause();
            // If it's not playing
        else
            // Resume the music player
            mp.start();
    }
}