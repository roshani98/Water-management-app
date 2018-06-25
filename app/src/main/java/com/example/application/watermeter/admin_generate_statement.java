package com.example.application.watermeter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import static android.widget.LinearLayout.VERTICAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.view.ViewGroup.LayoutParams.FILL_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;


public class admin_generate_statement extends AppCompatActivity {

    private GridView gridView;
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
    private TextView textView;

    private TextView textView1;

    private List<TextView> TextList = new ArrayList<TextView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_generate_statement);

        textView = (TextView) findViewById(R.id.textView);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        textView = (TextView) findViewById(R.id.textView);
        textView1 = (TextView) findViewById(R.id.textView1);

        mDatabase = FirebaseDatabase.getInstance().getReference();

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
        final String[] str = {""};

        Query query = mDatabase
                .child("Admin").child(Username)
                .orderByChild("username_password");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                if (dataSnapshot.getValue() != null) {

                    Log.d("dataSnapshot ", dataSnapshot.toString());


                    if (dataSnapshot.getValue() != null) {

                        Log.d("dataSnapshot ", dataSnapshot.toString());

                        HashMap<String, Object> studentdata = (HashMap<String, Object>) dataSnapshot.getValue();
                        Log.d("dataSnapshot ", studentdata.toString());


                        for (String key : studentdata.keySet()) {

                            Object mObject = studentdata.get(key);
                            HashMap<String, Object> map = (HashMap<String, Object>) mObject;

                            HashMap<String, Object> userData = new HashMap<String, Object>();

                            if (!map.get("Username").toString().equals(Username)) {

                                textView.append(map.get("Username").toString() + "\n\n");
                                textView1.append(map.get("Final Amount").toString() + "\n\n");

                            }
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "Sorry cant find the user in the database", Toast.LENGTH_LONG).show();

                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}