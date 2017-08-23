package com.example.bhargav.wattup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HoursInfoActivity extends AppCompatActivity {

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
    private DatabaseReference ref;
    private DatabaseReference mDatabase;
    private int[] items = new int[9];
    private String[] names = new String[]{"Module","Fan","Bulb","AC","Oven","Refrigerator","Speaker","TV","Water"};
    public String uid;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hours_info);

        fan=(EditText)findViewById(R.id.fan);
        bulb=(EditText)findViewById(R.id.bulb);
        ac=(EditText)findViewById(R.id.ac);
        oven=(EditText)findViewById(R.id.oven);
        refri=(EditText)findViewById(R.id.ref);
        speak=(EditText)findViewById(R.id.speak);
        tv=(EditText)findViewById(R.id.tv);
        water=(EditText)findViewById(R.id.water);
        module = (EditText)findViewById(R.id.module);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        assert user!=null;
        uid = user.getUid();

        ref = FirebaseDatabase.getInstance().getReference();



    }
    //Settings button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.settings:
                items[0] = Integer.parseInt(module.getText().toString());
                items[1] = Integer.parseInt(fan.getText().toString());
                items[2]= Integer.parseInt(bulb.getText().toString());
                items[3] = Integer.parseInt(ac.getText().toString());
                items[4]= Integer.parseInt(oven.getText().toString());
                items[5] = Integer.parseInt(refri.getText().toString());
                items[6] = Integer.parseInt(speak.getText().toString());
                items[7] = Integer.parseInt(tv.getText().toString());
                items[8] = Integer.parseInt(water.getText().toString());
                fan.setText("");
                bulb.setText("");
                ac.setText("");
                oven.setText("");
                refri.setText("");
                speak.setText("");
                tv.setText("");
                water.setText("");
                module.setText("");
                for(int i=1;i<9;i++)
                {
                    ref.child("users").child(uid).child(names[0]+" "+items[0]).child(names[i]+"").child("hours").setValue(items[i]+"");
                }


                return true;

            case R.id.upload:
                items[0] = Integer.parseInt(module.getText().toString());
                items[1] = Integer.parseInt(fan.getText().toString());
                items[2]= Integer.parseInt(bulb.getText().toString());
                items[3] = Integer.parseInt(ac.getText().toString());
                items[4]= Integer.parseInt(oven.getText().toString());
                items[5] = Integer.parseInt(refri.getText().toString());
                items[6] = Integer.parseInt(speak.getText().toString());
                items[7] = Integer.parseInt(tv.getText().toString());
                items[8] = Integer.parseInt(water.getText().toString());
                for(int i=1;i<9;i++)
                {
                    ref.child("users").child(uid).child(names[0]+" "+items[0]).child(names[i]+"").child("hours").setValue(items[i]+"");
                }
                startActivity(new Intent(HoursInfoActivity.this,SettingsActivity.class));

                return true;
            default:


                return super.onOptionsItemSelected(item);
        }
    }
}
