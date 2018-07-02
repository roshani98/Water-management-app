package com.example.application.watermeter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

public class update_balance extends AppCompatActivity {

    private Spinner flatNo;
    private EditText amount;
    private Button update;

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
    private DatabaseReference mDatabase;

    FirebaseDatabase fbDatabase;
    DatabaseReference fbDatabaseReference;

    private RadioGroup method;
    private RadioButton add;
    private RadioButton updated;

    private ArrayList<String> arr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_balance);

        flatNo = (Spinner) findViewById(R.id.flat_no);

        final ArrayList<String> arr = new ArrayList<String>();

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

        amount = (EditText)findViewById(R.id.amt);

        fbDatabase = FirebaseDatabase.getInstance();
        fbDatabaseReference = fbDatabase.getReference();

        final int i = 0;

        Query query = fbDatabaseReference
                .child("Admin").child(Username)
                .orderByChild("username_password");

        arr.add("Select Flat Number");

        query.addListenerForSingleValueEvent(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.getValue()!=null) {

                    //Log.d("dataSnapshot ", dataSnapshot.toString());

                    HashMap<String, Object> studentdata = (HashMap<String, Object>) dataSnapshot.getValue();
                    //Log.d("dataSnapshot ", studentdata.toString());

                    for (String key : studentdata.keySet()) {

                        Object mObject = studentdata.get(key);
                        HashMap<String, Object> map = (HashMap<String, Object>) mObject;

                        HashMap<String, Object> userData = new HashMap<String, Object>();

                        if(!map.get("Username").toString().equals(Username)){
                            Log.d("Map",map.toString());

                            String user = map.get("Username").toString().trim();
                            arr.add(user);

                        }
                    }

                    ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,arr);
                    arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    flatNo.setAdapter(arrayAdapter1);

                }else {

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }});

        update = (Button)findViewById(R.id.update);

        method = (RadioGroup) findViewById(R.id.option);
        add = (RadioButton) findViewById(R.id.add_balance);
        updated = (RadioButton) findViewById(R.id.update_balance);

    }

    public void change(View view){
        final String username = flatNo.getSelectedItem().toString().trim();
        final String amt = amount.getText().toString().trim();

        if(username.equals("Select Flat Number")) {
            Toast.makeText(getApplicationContext(),"Select a flat number",Toast.LENGTH_LONG).show();
            return;
        }

        Query query = fbDatabaseReference
                .child("Admin").child(Username).orderByChild("Username")
                .equalTo(username);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() != null) {
                    HashMap<String, Object> studentdata = (HashMap<String, Object>) dataSnapshot.getValue();
                    for (String key : studentdata.keySet()) {

                        Object mObject = studentdata.get(key);
                        HashMap<String, Object> map = (HashMap<String, Object>) mObject;

                        HashMap<String, Object> userData = new HashMap<String, Object>();


                        userData.put("Username", username);
                        userData.put("username_password", map.get("username_password").toString().trim());
                        userData.put("Password", map.get("Password").toString().trim());
                        userData.put("Flat", map.get("Flat").toString().trim().trim());
                        userData.put("Reading0", map.get("Reading0").toString().trim());
                        userData.put("Reading1", map.get("Reading1").toString().trim());
                        userData.put("Reading2", map.get("Reading2").toString().trim());
                        userData.put("Reading3", map.get("Reading3").toString().trim());
                        userData.put("Reading4", map.get("Reading4").toString().trim());
                        userData.put("Reading5", map.get("Reading5").toString().trim());
                        userData.put("Reading6", map.get("Reading6").toString().trim());
                        userData.put("Reading7", map.get("Reading7").toString().trim());
                        userData.put("Reading8", map.get("Reading8").toString().trim());
                        userData.put("Reading9", map.get("Reading9").toString().trim());
                        userData.put("Reading10", map.get("Reading10").toString().trim());
                        userData.put("Reading11", map.get("Reading11").toString().trim());
                        userData.put("Reading12", map.get("Reading12").toString().trim());
                        userData.put("Date0", map.get("Date0").toString().trim());
                        userData.put("Date1", map.get("Date1").toString().trim());
                        userData.put("Date2", map.get("Date2").toString().trim());
                        userData.put("Date3", map.get("Date3").toString().trim());
                        userData.put("Date4", map.get("Date4").toString().trim());
                        userData.put("Date5", map.get("Date5").toString().trim());
                        userData.put("Date6", map.get("Date6").toString().trim());
                        userData.put("Date7", map.get("Date7").toString().trim());
                        userData.put("Date8", map.get("Date8").toString().trim());
                        userData.put("Date9", map.get("Date9").toString().trim());
                        userData.put("Date10", map.get("Date10").toString().trim());
                        userData.put("Date11", map.get("Date11").toString().trim());
                        userData.put("Date12", map.get("Date12").toString().trim());
                        userData.put("Amount0", map.get("Amount0").toString().trim());
                        userData.put("Amount1", map.get("Amount1").toString().trim());
                        userData.put("Amount2", map.get("Amount2").toString().trim());
                        userData.put("Amount3", map.get("Amount3").toString().trim());
                        userData.put("Amount4", map.get("Amount4").toString().trim());
                        userData.put("Amount5", map.get("Amount5").toString().trim());
                        userData.put("Amount6", map.get("Amount6").toString().trim());
                        userData.put("Amount7", map.get("Amount7").toString().trim());
                        userData.put("Amount8", map.get("Amount8").toString().trim());
                        userData.put("Amount9", map.get("Amount9").toString().trim());
                        userData.put("Amount10", map.get("Amount10").toString().trim());
                        userData.put("Amount11", map.get("Amount11").toString().trim());
                        userData.put("Amount12", map.get("Amount12").toString().trim());
                        userData.put("City", map.get("City").toString().trim());
                        userData.put("Area", map.get("Area").toString().trim());
                        userData.put("Pincode", map.get("Pincode").toString().trim());
                        userData.put("Society", map.get("Society").toString().trim());
                        userData.put("Final Amount", map.get("Final Amount").toString().trim());
                        userData.put("Cost", map.get("Cost").toString().trim());
                        userData.put("Discount", map.get("Discount").toString().trim());
                        userData.put("Method", map.get("Method").toString().trim());
                        userData.put("Mobile Number", map.get("Mobile Number").toString().trim());
                        userData.put("Final_Reading", map.get("Final_Reading").toString().trim());

                        if (add.isChecked()) {
                            Float previous = Float.parseFloat(map.get("Balance").toString().trim());
                            Float added = Float.parseFloat(amt);
                            previous += added;
                            userData.put("Balance", String.valueOf(previous));
                        } else if (updated.isChecked()) {
                            userData.put("Balance", amt);
                        }

                        fbDatabaseReference.child("Admin").child(Username).push().updateChildren(userData);
                        for (DataSnapshot areaSnapshot : dataSnapshot.getChildren()) {
                            areaSnapshot.getRef().setValue(null);
                        }

                        Toast.makeText(getApplicationContext(), "Updated Balance", Toast.LENGTH_LONG).show();

                        finish();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void onBackPressed(){
        finish();
    }
}
