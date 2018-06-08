package com.example.application.watermeter;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class admin_change_details extends AppCompatActivity {

    private EditText admin_change_password;
    private EditText admin_change_pincode;
    private EditText admin_change_area;
    private EditText admin_change_society;
    private String Area;
    private String Cost;
    private String Discount;
    private String Method;
    private String Password;
    private String Pincode;
    private String Society;
    private String Username;
    private String City;
    private String username_password;

    private FirebaseDatabase fbDatabase;
    private DatabaseReference fbDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_change_details);

        admin_change_area = (EditText) findViewById(R.id.admin_change_area);
        admin_change_password = (EditText) findViewById(R.id.admin_change_password);
        admin_change_pincode = (EditText) findViewById(R.id.admin_change_pincode);
        admin_change_society = (EditText) findViewById(R.id.admin_change_society);

        fbDatabase = FirebaseDatabase.getInstance();
        fbDatabaseReference = fbDatabase.getReference();

        Intent intent = getIntent();
        Area = intent.getStringExtra("Area");
        Cost = intent.getStringExtra("Cost");
        Discount = intent.getStringExtra("Discount");
        Method = intent.getStringExtra("Method");
        Password = intent.getStringExtra("Password");
        Pincode = intent.getStringExtra("Pincode");
        Society = intent.getStringExtra("Society");
        Username = intent.getStringExtra("Username");
        City = intent.getStringExtra("City");
        username_password = intent.getStringExtra("username_password");

        admin_change_password.setText(Password);
        admin_change_area.setText(Area);
        admin_change_pincode.setText(Pincode);
        admin_change_society.setText(Society);
    }

    public void save_changes(View view) {
        Area = admin_change_area.getText().toString().trim();
        Password = admin_change_password.getText().toString().trim();
        Pincode = admin_change_pincode.getText().toString().trim();
        Society = admin_change_society.getText().toString().trim();

        Query query = fbDatabaseReference
                .child("Admin").child(Username)
                .orderByChild("username_password")
                .equalTo(username_password);

        query.addListenerForSingleValueEvent(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getValue()!=null) {

                    Log.d("dataSnapshot ", dataSnapshot.toString());

                    HashMap<String, Object> studentdata = (HashMap<String, Object>) dataSnapshot.getValue();
                    Log.d("dataSnapshot ", studentdata.toString());


                    for (String key : studentdata.keySet()) {

                        Object mObject = studentdata.get(key);
                        HashMap<String, Object> map = (HashMap<String, Object>) mObject;

                        HashMap<String, Object> userData = new HashMap<String, Object>();

                        username_password = Username + "_" + Password;

                        userData.put("Username", Username);
                        userData.put("Password", Password);
                        userData.put("Society", Society);
                        userData.put("username_password", username_password);
                        userData.put("City",City);
                        userData.put("Area",Area);
                        userData.put("Pincode",Pincode);
                        userData.put("Cost",Cost);
                        userData.put("Discount",Discount);
                        userData.put("Method",Method);



                        fbDatabaseReference.child("Admin").child(Username).push().updateChildren(userData);
                        for(DataSnapshot areaSnapshot: dataSnapshot.getChildren()) {
                            areaSnapshot.getRef().setValue(null);
                        }

                        Toast.makeText(getApplicationContext(), "Details Updated", Toast.LENGTH_LONG).show();

                        Intent i = new Intent(getApplicationContext(), admin_logged_in.class);
                        i.putExtra("Area",Area);
                        i.putExtra("Cost",Cost);
                        i.putExtra("Discount",Discount);
                        i.putExtra("Method",Method);
                        i.putExtra("Password",Password);
                        i.putExtra("Pincode",Pincode);
                        i.putExtra("Society",Society);
                        i.putExtra("Username",Username);
                        i.putExtra("City",City);
                        i.putExtra("username_password",username_password);
                        startActivity(i);
                    }

                }else {
                    Toast.makeText(getApplicationContext(), "Sorry cant find the user in the database", Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }});

    }
}
