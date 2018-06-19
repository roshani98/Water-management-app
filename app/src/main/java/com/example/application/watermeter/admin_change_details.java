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


                    }

                }else {
                    Toast.makeText(getApplicationContext(), "Sorry cant find the user in the database", Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }});

        query = fbDatabaseReference
                .child("Admin").child(Username)
                .orderByChild("username_password");

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

                        if(!map.get("Username").toString().equals(Username)){
                            Log.d("Map",map.toString());
                            userData.put("Username", map.get("Username").toString());
                            userData.put("Reading0", map.get("Reading0").toString());
                            userData.put("Reading1", map.get("Reading1").toString());
                            userData.put("Reading2", map.get("Reading2").toString());
                            userData.put("Reading3", map.get("Reading3").toString());
                            userData.put("Reading4", map.get("Reading4").toString());
                            userData.put("Reading5", map.get("Reading5").toString());
                            userData.put("Reading6", map.get("Reading6").toString());
                            userData.put("Reading7", map.get("Reading7").toString());
                            userData.put("Reading8", map.get("Reading8").toString());
                            userData.put("Reading9", map.get("Reading9").toString());
                            userData.put("Reading10", map.get("Reading10").toString());
                            userData.put("Reading11", map.get("Reading11").toString());
                            userData.put("Reading12", map.get("Reading12").toString());
                            userData.put("Date0", map.get("Date0").toString());
                            userData.put("Date1", map.get("Date1").toString());
                            userData.put("Date2", map.get("Date2").toString());
                            userData.put("Date3", map.get("Date3").toString());
                            userData.put("Date4", map.get("Date4").toString());
                            userData.put("Date5", map.get("Date5").toString());
                            userData.put("Date6", map.get("Date6").toString());
                            userData.put("Date7", map.get("Date7").toString());
                            userData.put("Date8", map.get("Date8").toString());
                            userData.put("Date9", map.get("Date9").toString());
                            userData.put("Date10", map.get("Date10").toString());
                            userData.put("Date11", map.get("Date11").toString());
                            userData.put("Date12", map.get("Date12").toString());
                            userData.put("Amount0", map.get("Amount0").toString());
                            userData.put("Amount1", map.get("Amount1").toString());
                            userData.put("Amount2", map.get("Amount2").toString());
                            userData.put("Amount3", map.get("Amount3").toString());
                            userData.put("Amount4", map.get("Amount4").toString());
                            userData.put("Amount5", map.get("Amount5").toString());
                            userData.put("Amount6", map.get("Amount6").toString());
                            userData.put("Amount7", map.get("Amount7").toString());
                            userData.put("Amount8", map.get("Amount8").toString());
                            userData.put("Amount9", map.get("Amount9").toString());
                            userData.put("Amount10", map.get("Amount10").toString());
                            userData.put("Amount11", map.get("Amount11").toString());
                            userData.put("Amount12", map.get("Amount12").toString());
                            userData.put("Flat", map.get("Flat").toString());
                            userData.put("City", map.get("City").toString());
                            userData.put("Area", Area);
                            userData.put("Pincode", Pincode);
                            userData.put("Society",Society);
                            userData.put("Final Amount",map.get("Final Amount").toString());
                            userData.put("Cost", Cost);
                            userData.put("Discount", Discount);
                            userData.put("Method",Method);
                            userData.put("Mobile Number", map.get("Mobile Number").toString());
                            userData.put("username_password",map.get("username_password").toString());
                            userData.put("Password",map.get("Password").toString());


                            fbDatabaseReference.child("Admin").child(Username).push().updateChildren(userData);
                            for(DataSnapshot areaSnapshot: dataSnapshot.getChildren()) {
                                areaSnapshot.getRef().setValue(null);
                            }

                            Toast.makeText(getApplicationContext(), "One user updated", Toast.LENGTH_LONG).show();

                        }
                    }

                }else {
                    Toast.makeText(getApplicationContext(), "Sorry cant find the user in the database", Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }});

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
}
