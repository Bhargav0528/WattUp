package com.example.bhargav.wattup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ViewUsageActivity extends AppCompatActivity {

    private DatabaseReference mref;
    private int[] a = new int[9];
    private FirebaseAuth mAuth;
    private ImageView paybill;
    private ImageView homeauto;
    private ImageView usage;
    private ImageView opti;
    private ImageView settings;
    private GraphView graph;
    private GraphView bargraph;
    private String uid,city;
    private Double Total;
    private TextView showusage;
    private TextView showusage1;
    public ArrayList<ModelClass> models;
    private TextView tvpower;
    private TextView tvbill;
    public Double[] avg = {1.954,0.003,0.075,0.23,0.25,0.05,0.19,0.3};
    public Double num,hr;

    private static final String TAG = "ViewUsage";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_usage);
        mAuth = FirebaseAuth.getInstance();
        mref = FirebaseDatabase.getInstance().getReference();
        showusage = (TextView)findViewById(R.id.showusage);
        showusage1 = (TextView)findViewById(R.id.showusage1);
        tvpower = (TextView)findViewById(R.id.tvpower);
        tvbill = (TextView)findViewById(R.id.tvbill);
        paybill = (ImageView) findViewById(R.id.bill);
        usage = (ImageView) findViewById(R.id.usage);



        Total = 0.0;


        FirebaseUser user = mAuth.getCurrentUser();
        assert user!=null;
        uid = user.getUid();

        models = new ArrayList<>();

        mref.child("users").child(uid).child("Module 0").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot Postsnapshot : dataSnapshot.getChildren())
                {
                    ModelClass model = Postsnapshot.getValue(ModelClass.class);
                    models.add(model);

                }

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //Log.i(TAG,models.get(0).getHours());
        mref.child("users").child(uid).child("City").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                city = dataSnapshot.getValue().toString();
                Log.i(TAG,city);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        showusage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = mAuth.getCurrentUser();
                assert user!=null;
                uid = user.getUid();

                models = new ArrayList<>();

                mref.child("users").child(uid).child("Module 0").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot Postsnapshot : dataSnapshot.getChildren())
                        {
                            ModelClass model = Postsnapshot.getValue(ModelClass.class);
                            models.add(model);

                        }

                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                //Log.i(TAG,models.get(0).getHours());
                mref.child("users").child(uid).child("City").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        city = dataSnapshot.getValue().toString();
                        Log.i(TAG,city);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
        showusage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0;i<8;i++)
                {
                    num = Double.parseDouble(models.get(i).getNumber().toString());
                    hr = Double.parseDouble(models.get(i).getHours().toString());
                    //Log.i(TAG,num.toString());
                    //Log.i(TAG,hr.toString());
                    Total = Total + (avg[i]*num*hr);
                    //Log.i(TAG,avg[i].toString());
                }

                float temp;
                temp = Math.round(Total);
                tvpower.setText(temp+" kWh");

                tvbill.setText("Rs. "+temp*4.7*30+"/-");
                Log.i(TAG,Total.toString());
            }
        });




    }
}
