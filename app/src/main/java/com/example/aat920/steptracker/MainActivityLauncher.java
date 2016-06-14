package com.example.aat920.steptracker;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivityLauncher extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Sensor sensor;
    private PieChart pieChart;
    private RelativeLayout relativeLayout;
    private String[] xData={"sensor1","sensor2","sensor3","sensor4","sensor5"};
    private   ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_launcher);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        ObjectAnimator animation = ObjectAnimator.ofInt (progressBar, "progress", 0, 500); // see this max value coming back here, we animale towards that value
        animation.setDuration (5000); //in milliseconds
        animation.setInterpolator (new DecelerateInterpolator());
        animation.start ();


    }

    public void setProgressBar(int topMargin,int leftMargin,int rightMargin, int imgWidth, int imgHeight){
        relativeLayout = (RelativeLayout) findViewById(R.id.mainlayout);
        //create the new piechart
        pieChart = new PieChart(this);
        relativeLayout.addView(pieChart);
        //Sets the size of the pie chart
        RelativeLayout.LayoutParams layout = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layout.topMargin= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, topMargin, getResources().getDisplayMetrics());
        layout.leftMargin= (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftMargin, getResources().getDisplayMetrics());
        layout.rightMargin=(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightMargin, getResources().getDisplayMetrics());
        pieChart.setLayoutParams(layout);
        ViewGroup.LayoutParams sizeRules = pieChart.getLayoutParams();
        sizeRules.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, imgWidth, getResources().getDisplayMetrics()); //Using dp instead of px.
        sizeRules.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, imgHeight, getResources().getDisplayMetrics());
        pieChart.setLayoutParams(sizeRules);
        //configure tbe pie chart
        pieChart.setUsePercentValues(true);
        //define the in the center
        pieChart.setDrawHoleEnabled(true);
        //enable rotation of the chart by touch
        pieChart.setRotationAngle(0);
        pieChart.setRotationEnabled(true);
        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                //Display msg whn value selected
                if(e==null) {
                    return;
                }
                if(xData[e.getXIndex()] =="sensor5"){
                    setSensorImg(135,275,0,50,50);
                }
                Toast.makeText(MainActivityLauncher.this,xData[e.getXIndex()]+"="+e.getVal()+"%",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

        ArrayList<Entry> yList = new ArrayList<Entry>();
        yList.add(new Entry(5, 1));
        yList.add(new Entry(10, 2));
        yList.add(new Entry(15, 3));
        yList.add(new Entry(30, 4));
        yList.add(new Entry(40, 5));
        ArrayList<String> xVals = new ArrayList<String>(Arrays.asList(xData));

        PieDataSet dataSet = new PieDataSet(yList, "Right Sensor");
        dataSet.setSliceSpace(0);
        dataSet.setSelectionShift(5);
        ArrayList<Integer> colors = new ArrayList<Integer>();
        for (int c : ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(c);
        }
        dataSet.setColors(colors);

        //Instantiating the pieData object
        PieData data = new PieData(xVals,dataSet);

        pieChart.setData(data);

        //undo all highlight
        pieChart.highlightValue(null);

        //update piechart
        pieChart.invalidate();

    }

    public void setSensorImg(int topMargin,int leftMargin,int rightMargin, int imgWidth, int imgHeight){
        //create an ImageView
        ImageView image = new ImageView(getApplicationContext());
        //get the path
        image.setImageResource(R.drawable.heel_foot);
        image.setAlpha(0.5f);
        //setting the position
        RelativeLayout.LayoutParams layout = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layout.topMargin= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, topMargin, getResources().getDisplayMetrics());
        layout.leftMargin= (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftMargin, getResources().getDisplayMetrics());
        layout.rightMargin=(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightMargin, getResources().getDisplayMetrics());
        image.setLayoutParams(layout);
        //setting the size
        ViewGroup.LayoutParams sizeRules = image.getLayoutParams();
        sizeRules.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, imgWidth, getResources().getDisplayMetrics()); //Using dp instead of px.
        sizeRules.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, imgHeight, getResources().getDisplayMetrics());
        image.setLayoutParams(sizeRules);
        //Fetch your layout you want to add the image  to
        relativeLayout = (RelativeLayout) findViewById(R.id.mainlayout);
        //add the image to the layout
        relativeLayout.addView(image);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        progressBar.clearAnimation();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_launcher, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
