package com.example.bhargav.wattup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;

public class UserInfoActivity extends AppCompatActivity {
    private EditText fan;
    private EditText bulb;
    private EditText ac;
    private EditText oven;
    private EditText refri;
    private EditText speak;
    private EditText tv;
    private EditText water;
    private EditText module;
    private int fan1;
    private int bulb1;
    private int ac1;
    private int oven1;
    private int refri1;
    private int speak1;
    private int tv1;
    private int water1;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        fan=(EditText)findViewById(R.id.fan);
        bulb=(EditText)findViewById(R.id.bulb);
        ac=(EditText)findViewById(R.id.ac);
        oven=(EditText)findViewById(R.id.oven);
        refri=(EditText)findViewById(R.id.ref);
        speak=(EditText)findViewById(R.id.speak);
        tv=(EditText)findViewById(R.id.tv);
        water=(EditText)findViewById(R.id.water);
        module = (EditText)findViewById(R.id.module);


    }
    //Settings button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.settings:
                fan.setText("");
                bulb.setText("");
                ac.setText("");
                oven.setText("");
                refri.setText("");
                speak.setText("");
                tv.setText("");
                water.setText("");
                module.setText("");
                return true;


            default:


                return super.onOptionsItemSelected(item);
        }
    }
}

