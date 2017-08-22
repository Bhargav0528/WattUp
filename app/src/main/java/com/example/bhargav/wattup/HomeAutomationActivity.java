package com.example.bhargav.wattup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

public class HomeAutomationActivity extends AppCompatActivity {

    
    private Switch gpsswitch;
    private RecyclerView recycler;
    private ImageView paybill;
    private ImageView homeauto;
    private ImageView usage;
    private ImageView opti;
    private ImageView settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_automation);

        paybill = (ImageView)findViewById(R.id.bill);
        homeauto = (ImageView)findViewById(R.id.homeauto);
        usage = (ImageView)findViewById(R.id.usage);
        opti = (ImageView)findViewById(R.id.opti);
        settings = (ImageView)findViewById(R.id.settings);

        paybill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeAutomationActivity.this,BillPaymentActivity.class));
            }
        });
        homeauto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeAutomationActivity.this,HomeAutomationActivity.class));
            }
        });
        usage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeAutomationActivity.this,UsageTrackingActivity.class));
            }
        });
        opti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeAutomationActivity.this,OptimizationActivity.class));
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeAutomationActivity.this,SettingsActivity.class));
            }
        });

    }
}
