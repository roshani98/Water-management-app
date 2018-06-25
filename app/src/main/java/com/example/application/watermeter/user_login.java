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

public class user_login extends AppCompatActivity {

    private EditText user_login_username;
    private EditText user_login_password;
    private Button user_login_submit;
    private EditText user_login_admin;

    FirebaseDatabase fbDatabase;
    DatabaseReference fbDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        user_login_password = (EditText)findViewById(R.id.user_login_password);
        user_login_submit = (Button)findViewById(R.id.user_login_submit);
        user_login_username = (EditText)findViewById(R.id.user_login_username);
        user_login_admin = (EditText)findViewById(R.id.user_login_admin);

        fbDatabase = FirebaseDatabase.getInstance();
        fbDatabaseReference = fbDatabase.getReference();

        user_login_submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String username = user_login_username.getText().toString().trim();
                String password = user_login_password.getText().toString().trim();
                String admin = user_login_admin.getText().toString().trim();

                if(username!=null && password!=null && admin!=null){
                    fetchData(username,password,admin);
                }else if(username==null){
                    Toast.makeText(getApplicationContext(),"Enter your username",Toast.LENGTH_LONG).show();
                }else if(password==null){
                    Toast.makeText(getApplicationContext(),"Enter your password",Toast.LENGTH_LONG).show();
                }else if(admin==null){
                    Toast.makeText(getApplicationContext(),"Enter name of your admin",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void fetchData(final String username, final String password, final String admin ){

        final String y = username + "_" + password;

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


                        Intent i = new Intent(getApplicationContext(), user_logged_in.class);

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
                        i.putExtra("Final_Amount",map.get("Final Amount").toString());
                        i.putExtra("Flat",map.get("Flat").toString());
                        i.putExtra("Method",map.get("Method").toString());
                        i.putExtra("Mobile_Number",map.get("Mobile Number").toString());
                        i.putExtra("Password",map.get("Password").toString());
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
                        i.putExtra("Username",map.get("Username").toString());
                        i.putExtra("Final_Reading",map.get("Final_Reading").toString());
                        i.putExtra("username_password",map.get("username_password").toString());

                        startActivity(i);
                        finish();
                        break;

                    }

                }else {
                    Toast.makeText(getApplicationContext(), "Not valid", Toast.LENGTH_LONG).show();

                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Log.d( "error ",databaseError.toString());
            }
        });
    }
}