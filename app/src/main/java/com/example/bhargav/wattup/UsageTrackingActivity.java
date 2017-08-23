package com.example.bhargav.wattup;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class UsageTrackingActivity extends AppCompatActivity {

    private Switch gpsswitch;
    private RecyclerView recycler;
    private ImageView paybill;
    private ImageView homeauto;
    private ImageView usage;
    private ImageView opti;
    private ImageView settings;
    private GraphView graph;
    private GraphView bargraph;
    private long[] datapoint = new long[8];
    private ViewUsageActivity vu = new ViewUsageActivity();
    private long inti;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usage_tracking);

        paybill = (ImageView) findViewById(R.id.bill);
        homeauto = (ImageView) findViewById(R.id.homeauto);
        usage = (ImageView) findViewById(R.id.usage);
        opti = (ImageView) findViewById(R.id.opti2);
        settings = (ImageView) findViewById(R.id.settings);
        graph = (GraphView) findViewById(R.id.graph);
        bargraph = (GraphView) findViewById(R.id.bargraph);


        paybill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UsageTrackingActivity.this, BillPaymentActivity.class));
            }
        });
        homeauto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UsageTrackingActivity.this, HomeAutomationActivity.class));
            }
        });
        usage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UsageTrackingActivity.this, UsageTrackingActivity.class));
            }
        });
        opti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UsageTrackingActivity.this, OptimizationActivity.class));
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UsageTrackingActivity.this, SettingsActivity.class));
            }
        });


        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(2, 5),
                new DataPoint(4, 3),
                new DataPoint(6, 2),
                new DataPoint(8, 6),
                new DataPoint(10, 1),
                new DataPoint(12, 5),
                new DataPoint(14, 3),
                new DataPoint(16, 2),
                new DataPoint(18, 6),
                new DataPoint(20, 1),
                new DataPoint(22, 5),
                new DataPoint(24, 3)

        });
        graph.addSeries(series);

        BarGraphSeries<DataPoint> series2 = new BarGraphSeries<>(new DataPoint[]{



                new DataPoint(1, 3),
                new DataPoint(2, 2),
                new DataPoint(3, 1),
                new DataPoint(4, 4),
                new DataPoint(5, 5),
                new DataPoint(6, 2),
                new DataPoint(7, 1),
                new DataPoint(8, 4)


        });


// styling
        series2.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                //return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
                return Color.rgb(120, 0, 20);
            }
        });

        series2.setSpacing(20);

// draw values on top
        series2.setDrawValuesOnTop(true);
        series2.setValuesOnTopColor(Color.BLACK);
//series.setValuesOnTopSize(50);
        bargraph.addSeries(series2);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.settings:
                startActivity(new Intent(UsageTrackingActivity.this,ViewUsageActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
