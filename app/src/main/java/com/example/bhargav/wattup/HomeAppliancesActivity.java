package com.example.bhargav.wattup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeAppliancesActivity extends AppCompatActivity {

    private RadioButton bangalore;
    private RadioButton mumbai;
    private DatabaseReference ref;
    private FirebaseAuth mAuth;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_appliances);

        bangalore = (RadioButton)findViewById(R.id.bangalore);
        mumbai = (RadioButton)findViewById(R.id.mumbai);


        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        assert user!=null;
        uid = user.getUid();
        ref = FirebaseDatabase.getInstance().getReference();
        bangalore.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                ref.child("users").child(uid).child("City").setValue("Bangalore");
                startActivity(new Intent(HomeAppliancesActivity.this,SettingsActivity.class));
            }
        });
        mumbai.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                ref.child("users").child(uid).child("City").setValue("Mumbai");
                startActivity(new Intent(HomeAppliancesActivity.this,SettingsActivity.class));

            }
        });
    }
}
