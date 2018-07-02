package com.example.application.watermeter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;


public class admin_change_method extends AppCompatActivity {

    private EditText cost;
    private EditText discount;
    private Button done;
    private DatabaseReference mDatabase;
    private RadioGroup pricing_method;
    private RadioButton fixed;
    private RadioButton variable;
    private RadioButton value;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_change_method);

        cost = (EditText)findViewById(R.id.editText);
        discount = (EditText)findViewById(R.id.editText2);
        //done = (Button)findViewById(R.id.done);

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

        mDatabase = FirebaseDatabase.getInstance().getReference();

        // String method = "2";

        cost.setText(Cost);
        discount.setText(Discount);

        pricing_method = (RadioGroup) findViewById(R.id.pricing_method);
        fixed = (RadioButton) findViewById(R.id.fixed);
        variable = (RadioButton) findViewById(R.id.variable);

        if(Method.equals("1")){
            fixed.setChecked(true);
        }else{
            variable.setChecked(true);
        }

    }

    public void save_method_changes(View view){
        String pricing = "";

        if(fixed.isChecked()){
            pricing="Fixed Costing";
        }else{
            pricing = "Variable Costing";
        }

        Cost = cost.getText().toString().trim();
        Discount = discount.getText().toString().trim();

        Query query = mDatabase
                .child("Admin").child(Username)
                .orderByChild("username_password")
                .equalTo(username_password);

        final String finalPricing = pricing;
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
                        if(finalPricing.equals("Fixed Costing")){
                            userData.put("Method",String.valueOf(1));
                        }else{
                            userData.put("Method",String.valueOf(2));
                        }

                        mDatabase.child("Admin").child(Username).push().updateChildren(userData);
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

        query = mDatabase
                .child("Admin").child(Username)
                .orderByChild("username_password");

        final String finalPricing1 = pricing;
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
                            userData.put("Username", map.get("Username").toString().trim());
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
                            userData.put("Flat", map.get("Flat").toString().trim());
                            userData.put("City", map.get("City").toString().trim());
                            userData.put("Area", map.get("Area").toString().trim());
                            userData.put("Pincode", map.get("Pincode").toString().trim());
                            userData.put("Society",map.get("Society").toString().trim());
                            userData.put("Final Amount",map.get("Final Amount").toString());
                            userData.put("Cost", Cost);
                            userData.put("Discount", Discount);
                            if(finalPricing1.equals("Fixed Costing")){
                                userData.put("Method",String.valueOf(1));
                            }else{
                                userData.put("Method",String.valueOf(2));
                            }
                            userData.put("Mobile Number", map.get("Mobile Number").toString().trim());
                            userData.put("username_password",map.get("username_password").toString().trim());
                            userData.put("Password",map.get("Password").toString().trim());


                            mDatabase.child("Admin").child(Username).push().updateChildren(userData);
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
        if(pricing.equals("Fixed Costing")){
            i.putExtra("Method",String.valueOf(1));
        }else{
            i.putExtra("Method",String.valueOf(2));
        }
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