package com.example.bhargav.wattup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    private Switch gpsswitch;
    private RecyclerView recycler;
    private ImageView paybill;
    private ImageView homeauto;
    private ImageView usage;
    private ImageView opti;
    private ImageView settings;
    private TextView prof;
    private Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        paybill = (ImageView)findViewById(R.id.bill);
        homeauto = (ImageView)findViewById(R.id.homeauto);
        usage = (ImageView)findViewById(R.id.usage);
        opti = (ImageView)findViewById(R.id.opti2);
        settings = (ImageView)findViewById(R.id.settings);
        prof = (TextView)findViewById(R.id.textView);
        switch1=(Switch)findViewById(R.id.switch1);

        paybill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this,BillPaymentActivity.class));
            }
        });
        homeauto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this,HomeAutomationActivity.class));
            }
        });
        usage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this,UsageTrackingActivity.class));
            }
        });
        opti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this,OptimizationActivity.class));
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this,SettingsActivity.class));
            }
        });
        prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this,ProfileLayoutActivity.class));
            }
        });
        switch1.setChecked(true);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                startActivity(new Intent(SettingsActivity.this,HoursInfoActivity.class));
            }
        });
    }
}
