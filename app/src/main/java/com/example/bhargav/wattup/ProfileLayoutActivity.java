package com.example.bhargav.wattup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfileLayoutActivity extends AppCompatActivity {

    private TextView tv;
    private TextView tvhome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_layout);
        tv = (TextView)findViewById(R.id.textView);
        tvhome = (TextView)findViewById(R.id.textView2);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileLayoutActivity.this,UserInfoActivity.class));
            }
        });
        tvhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileLayoutActivity.this,HomeAppliancesActivity.class));
            }
        });

    }
}
