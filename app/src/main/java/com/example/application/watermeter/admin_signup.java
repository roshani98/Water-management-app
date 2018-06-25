package com.example.application.watermeter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class admin_signup extends AppCompatActivity {

    private EditText admin_signup_society;
    private EditText admin_signup_area;
    private Spinner admin_signup_city;
    private EditText admin_signup_pincode;
    private EditText admin_signup_password;
    private EditText admin_signup_password_2;
    private Button admin_signup_submit;
    private RadioButton radioButton;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    private TextView usernames;

    private DatabaseReference mDatabase;
    private DatabaseReference myDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_signup);

        admin_signup_submit  = (Button)findViewById(R.id.admin_signup_submit);
        admin_signup_password  = (EditText) findViewById(R.id.admin_signup_password);
        admin_signup_society = (EditText)findViewById(R.id.admin_signup_society);
        admin_signup_password_2 = (EditText)findViewById(R.id.admin_signup_password_2);

        admin_signup_area = (EditText) findViewById(R.id.admin_signup_area);
        admin_signup_city = (Spinner) findViewById(R.id.admin_signup_city);
        admin_signup_pincode = (EditText) findViewById(R.id.admin_signup_pincode);
        usernames = (TextView)findViewById(R.id.username);


        mDatabase = FirebaseDatabase.getInstance().getReference();
        myDatabase = FirebaseDatabase.getInstance().getReference();

        ArrayAdapter<CharSequence> arrayAdapter= ArrayAdapter.createFromResource(this,R.array.city_names,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        admin_signup_city.setAdapter(arrayAdapter);


        Query q = myDatabase
                .child("Admin")
                .orderByChild("username");

        final String[] username = new String[1];
        final long[] size = new long[1];

        q.addListenerForSingleValueEvent(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                size[0] = dataSnapshot.getChildrenCount();
                size[0]++;
                String t = "";
                t = "Username : " + t + String.valueOf(size[0]);
                usernames.setText(t);
                username[0] = String.valueOf(size[0]);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        admin_signup_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final String password = admin_signup_password.getText().toString().trim();
                final String society = admin_signup_society.getText().toString().trim();
                final String city = String.valueOf(admin_signup_city.getSelectedItem());
                final String area = admin_signup_area.getText().toString().trim();
                final String pincode = admin_signup_pincode.getText().toString().trim();
                final String password_2 = admin_signup_password_2.getText().toString().trim();

                if(TextUtils.isEmpty(city)){
                    Toast.makeText(admin_signup.this,"Please enter the name of your city",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(area)){
                    Toast.makeText(admin_signup.this,"Please enter the area of your city",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(pincode.isEmpty() || pincode.length() != 6){
                    admin_signup_pincode.setError("The pincode must of 6 digits");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(admin_signup.this,"Please enter your password",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.isEmpty() || password.length() < 6) {  admin_signup_password.setError("Password cannot be less than 6 characters!"); return;
                }


                if(TextUtils.isEmpty(password_2)){
                    Toast.makeText(admin_signup.this,"Please re enter your password",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!password.equals(password_2)){
                    Toast.makeText(admin_signup.this,"Re entered password doesnt match with the one provided",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(society)){
                    Toast.makeText(admin_signup.this,"Please enter your society",Toast.LENGTH_SHORT).show();
                    return;
                }

                Query query = mDatabase
                        .child("Admin")
                        .orderByChild("username")
                        .equalTo(username[0]);

                query.addListenerForSingleValueEvent(new ValueEventListener(){
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if (dataSnapshot.getValue() != null) {
                            Toast.makeText(getApplicationContext(), "Username already taken", Toast.LENGTH_LONG).show();
                            return;
                        } else {

<<<<<<< HEAD
=======

>>>>>>> upstream/master
                            HashMap<String, String> userData = new HashMap<String, String>();

                            String y = username[0] + "_" + password;

                            userData.put("Username", username[0]);
                            userData.put("Password", password);
                            userData.put("Society", society);
                            userData.put("username_password", y);
                            userData.put("city",city);
                            userData.put("area",area);
                            userData.put("pincode",pincode);

                            mDatabase.child("Admin").child(username[0]).push().setValue(userData);
<<<<<<< HEAD
=======

>>>>>>> upstream/master
                            Intent i = new Intent(getApplicationContext(), EnterSocietyDetails.class);
                            i.putExtra("username", username[0]);
                            i.putExtra("password", password);
                            i.putExtra("society",society);
                            i.putExtra("username_password",y);
                            i.putExtra("cost","0");
                            i.putExtra("discount","0");
                            i.putExtra("area",area);
                            i.putExtra("city",city);
                            i.putExtra("pincode",pincode);
<<<<<<< HEAD
=======

>>>>>>> upstream/master
                            startActivity(i);
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}