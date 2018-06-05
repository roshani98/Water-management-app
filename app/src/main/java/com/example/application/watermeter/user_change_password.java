package com.example.application.watermeter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class user_change_password extends AppCompatActivity {

    private EditText user_old_password;
    private EditText user_new_password1;
    private EditText user_new_password2;
    private String admin;
    //    private String Amount0;
//    private String Amount1;
//    private String Amount2;
//    private String Amount3;
//    private String Amount4;
//    private String Amount5;
//    private String Amount6;
//    private String Amount7;
//    private String Amount8;
//    private String Amount9;
//    private String Amount10;
//    private String Amount11;
//    private String Amount12;
//    private String Area;
//    private String City;
//    private String Cost;
//    private String Date0;
//    private String Date1;
//    private String Date2;
//    private String Date3;
//    private String Date4;
//    private String Date5;
//    private String Date6;
//    private String Date7;
//    private String Date8;
//    private String Date9;
//    private String Date10;
//    private String Date11;
//    private String Date12;
//    private String Discount;
//    private String Final_Amount;
//    private String Flat;
//    private String Method;
//    private String Mobile_Number;
    private String Password;
    //    private String Pincode;
//    private String Reading0;
//    private String Reading1;
//    private String Reading2;
//    private String Reading3;
//    private String Reading4;
//    private String Reading5;
//    private String Reading6;
//    private String Reading7;
//    private String Reading8;
//    private String Reading9;
//    private String Reading10;
//    private String Reading11;
//    private String Reading12;
//    private String Society;
    private String Username;
//    private String username_password;

    FirebaseDatabase fbDatabase;
    DatabaseReference fbDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_change_password);

        user_old_password = (EditText)findViewById(R.id.user_old_password);

        user_new_password1 = (EditText) findViewById(R.id.user_new_password);

        user_new_password2 = (EditText) findViewById(R.id.user_new_password2);

        fbDatabase = FirebaseDatabase.getInstance();
        fbDatabaseReference = fbDatabase.getReference();

//        Intent intent = getIntent();
//        String username = intent.getStringExtra("Username");
//        String password = intent.getStringExtra("Password");

        Intent intent = getIntent();

//        Amount0 = intent.getStringExtra("Amount0");
//        Amount1 = intent.getStringExtra("Amount1");
//        Amount2 = intent.getStringExtra("Amount2");
//        Amount3 = intent.getStringExtra("Amount3");
//        Amount4 = intent.getStringExtra("Amount4");
//        Amount5 = intent.getStringExtra("Amount5");
//        Amount6 = intent.getStringExtra("Amount6");
//        Amount7 = intent.getStringExtra("Amount7");
//        Amount8 = intent.getStringExtra("Amount8");
//        Amount9 = intent.getStringExtra("Amount9");
//        Amount10 = intent.getStringExtra("Amount10");
//        Amount11 = intent.getStringExtra("Amount11");
//        Amount12 = intent.getStringExtra("Amount12");
//        Area = intent.getStringExtra("Area");
//        City = intent.getStringExtra("Area");
//        Cost = intent.getStringExtra("Area");
//        Date0 = intent.getStringExtra("Date0");
//        Date1 = intent.getStringExtra("Date1");
//        Date2 = intent.getStringExtra("Date2");
//        Date3 = intent.getStringExtra("Date3");
//        Date4 = intent.getStringExtra("Date4");
//        Date5 = intent.getStringExtra("Date5");
//        Date6 = intent.getStringExtra("Date6");
//        Date7 = intent.getStringExtra("Date7");
//        Date8 = intent.getStringExtra("Date8");
//        Date9 = intent.getStringExtra("Date9");
//        Date10 = intent.getStringExtra("Date10");
//        Date11 = intent.getStringExtra("Date11");
//        Date12 = intent.getStringExtra("Date12");
//        Discount = intent.getStringExtra("Discount");
//        Final_Amount = intent.getStringExtra("Final_Amount");
//        Flat = intent.getStringExtra("Flat");
//        Method = intent.getStringExtra("Method");
//        Mobile_Number = intent.getStringExtra("Mobile_Number");
        Password = intent.getStringExtra("Password");
//        Pincode = intent.getStringExtra("Pincode");
//        Reading0 = intent.getStringExtra("Reading0");
//        Reading1 = intent.getStringExtra("Reading1");
//        Reading2 = intent.getStringExtra("Reading2");
//        Reading3 = intent.getStringExtra("Reading3");
//        Reading4 = intent.getStringExtra("Reading4");
//        Reading5 = intent.getStringExtra("Reading5");
//        Reading6 = intent.getStringExtra("Reading6");
//        Reading7 = intent.getStringExtra("Reading7");
//        Reading8 = intent.getStringExtra("Reading8");
//        Reading9 = intent.getStringExtra("Reading9");
//        Reading10 = intent.getStringExtra("Reading10");
//        Reading11 = intent.getStringExtra("Reading11");
//        Reading12 = intent.getStringExtra("Reading12");
//        Society = intent.getStringExtra("Society");
        Username = intent.getStringExtra("Username");
//        username_password = intent.getStringExtra("username_password");
        admin = intent.getStringExtra("Admin");
    }

    public void user_change(View view){
        //startActivity(new Intent(this, user_login.class));

//        Intent intent = getIntent();
//
//        final String username = intent.getStringExtra("Username");
//        String password = intent.getStringExtra("Password");
//        final String admin = intent.getStringExtra("Admin");

        String old_password = user_old_password.getText().toString().trim();

        if(!old_password.equals(Password)){
            Toast.makeText(getApplicationContext(),"Old password is incorrect",Toast.LENGTH_LONG).show();
            return;
        }

        final String new_password  = user_new_password1.getText().toString().trim();

        final String new_password1  = user_new_password2.getText().toString().trim();

        final String y = Username + "_" + Password;

        Query query = fbDatabaseReference
                .child("Admin").child(admin)
                .orderByChild("username_password")
                .equalTo(y);

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

//                        String flat = map.get("Flat").toString();
//                        String cost = map.get("Cost").toString();
//                        String final_amount = map.get("Final Amount").toString();
//                        String society = map.get("Society").toString();
//                        String password = map.get("Password").toString();
//                        String username_password = map.get("username_password").toString();
//                        String reading0 = map.get("Reading0").toString();
//                        String reading1 = map.get("Reading1").toString();
//                        String reading2 = map.get("Reading2").toString();
//                        String reading3 = map.get("Reading3").toString();
//                        String reading4 = map.get("Reading4").toString();
//                        String reading5 = map.get("Reading5").toString();
//                        String reading6 = map.get("Reading6").toString();
//                        String reading7 = map.get("Reading7").toString();
//                        String reading8 = map.get("Reading8").toString();
//                        String reading9 = map.get("Reading9").toString();
//                        String reading10 = map.get("Reading10").toString();
//                        String reading11 = map.get("Reading11").toString();
//                        String reading12 = map.get("Reading12").toString();
//                        Toast.makeText(getApplicationContext(), reading0, Toast.LENGTH_LONG).show();
//                        String date0 = map.get("Date0").toString();
//                        String date1 = map.get("Date1").toString();
//                        String date2 = map.get("Date2").toString();
//                        String date3 = map.get("Date3").toString();
//                        String date4 = map.get("Date4").toString();
//                        String date5 = map.get("Date5").toString();
//                        String date6 = map.get("Date6").toString();
//                        String date7 = map.get("Date7").toString();
//                        String date8 = map.get("Date8").toString();
//                        String date9 = map.get("Date9").toString();
//                        String date10 = map.get("Date10").toString();
//                        String date11 = map.get("Date11").toString();
//                        String date12 = map.get("Date12").toString();


                        HashMap<String, Object> userData = new HashMap<String, Object>();

                        String newpassword = new_password1;
                        String username_newpassword = Username + "_" + new_password;

                        userData.put("Username", Username);
                        userData.put("username_password",username_newpassword);
                        userData.put("Password",newpassword);
                        userData.put("Flat", map.get("Flat").toString());
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
                        userData.put("City", map.get("City").toString());
                        userData.put("Area", map.get("Area").toString());
                        userData.put("Pincode", map.get("Pincode").toString());
                        userData.put("Society",map.get("Society").toString());
                        userData.put("Final Amount",map.get("Final Amount").toString());
                        userData.put("Cost", map.get("Cost").toString());
                        userData.put("Discount", map.get("Discount").toString());
                        userData.put("Method", map.get("Method").toString());
                        userData.put("Mobile Number", map.get("Mobile Number").toString());

                        Intent i = new Intent(getApplicationContext(), user_logged_in.class);
//        i.putExtra("username", username);
//        i.putExtra("password", password);
                        i.putExtra("Admin",admin);
                        i.putExtra("Amount0",map.get("Amount0").toString());
                        i.putExtra("Amount1",map.get("Amount1").toString());
                        i.putExtra("Amount2",map.get("Amount2").toString());
                        i.putExtra("Amount3",map.get("Amount3").toString());
                        i.putExtra("Amount4",map.get("Amount4").toString());
                        i.putExtra("Amount5",map.get("Amount5").toString());
                        i.putExtra("Amount6",map.get("Amount6").toString());
                        i.putExtra("Amount7",map.get("Amount7").toString());
                        i.putExtra("Amount8",map.get("Amount8").toString());
                        i.putExtra("Amount9",map.get("Amount9").toString());
                        i.putExtra("Amount10",map.get("Amount10").toString());
                        i.putExtra("Amount11",map.get("Amount11").toString());
                        i.putExtra("Amount12",map.get("Amount12").toString());
                        i.putExtra("Area",map.get("Area").toString());
                        i.putExtra("City",map.get("City").toString());
                        i.putExtra("Cost",map.get("Cost").toString());
                        i.putExtra("Date0",map.get("Date0").toString());
                        i.putExtra("Date1",map.get("Date1").toString());
                        i.putExtra("Date2",map.get("Date2").toString());
                        i.putExtra("Date3",map.get("Date3").toString());
                        i.putExtra("Date4",map.get("Date4").toString());
                        i.putExtra("Date5",map.get("Date5").toString());
                        i.putExtra("Date6",map.get("Date6").toString());
                        i.putExtra("Date7",map.get("Date7").toString());
                        i.putExtra("Date8",map.get("Date8").toString());
                        i.putExtra("Date9",map.get("Date9").toString());
                        i.putExtra("Date10",map.get("Date10").toString());
                        i.putExtra("Date11",map.get("Date11").toString());
                        i.putExtra("Date12",map.get("Date12").toString());
                        i.putExtra("Discount",map.get("Discount").toString());
//                        i.putExtra("Final_Amount",map.get("Final_Amount").toString());
                        i.putExtra("Flat",map.get("Flat").toString());
                        i.putExtra("Method",map.get("Method").toString());
                        i.putExtra("Mobile_Number",map.get("Mobile Number").toString());
                        i.putExtra("Password",new_password);
                        i.putExtra("Pincode",map.get("Pincode").toString());
                        i.putExtra("Reading0",map.get("Reading0").toString());
                        i.putExtra("Reading1",map.get("Reading1").toString());
                        i.putExtra("Reading2",map.get("Reading2").toString());
                        i.putExtra("Reading3",map.get("Reading3").toString());
                        i.putExtra("Reading4",map.get("Reading4").toString());
                        i.putExtra("Reading5",map.get("Reading5").toString());
                        i.putExtra("Reading6",map.get("Reading6").toString());
                        i.putExtra("Reading7",map.get("Reading7").toString());
                        i.putExtra("Reading8",map.get("Reading8").toString());
                        i.putExtra("Reading9",map.get("Reading9").toString());
                        i.putExtra("Reading10",map.get("Reading10").toString());
                        i.putExtra("Reading11",map.get("Reading11").toString());
                        i.putExtra("Reading12",map.get("Reading12").toString());
                        i.putExtra("Society",map.get("Society").toString());
                        i.putExtra("Username",Username);
                        i.putExtra("username_password",map.get("username_password").toString());

                        fbDatabaseReference.child("Admin").child(admin).push().updateChildren(userData);
                        for(DataSnapshot areaSnapshot: dataSnapshot.getChildren()) {
                            areaSnapshot.getRef().setValue(null);
                        }

                        Toast.makeText(getApplicationContext(), "Password Updated", Toast.LENGTH_LONG).show();

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