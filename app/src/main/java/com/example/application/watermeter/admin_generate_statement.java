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

//        LinearLayout linearLayout = new LinearLayout(this);
//        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(FILL_PARENT, WRAP_CONTENT);
//        linearLayout.setLayoutParams(params);
//        linearLayout.setOrientation(VERTICAL);

        textView = (TextView)findViewById(R.id.textView);

        mDatabase = FirebaseDatabase.getInstance().getReference();

//        Query q = myDatabase
//                .child("Admin")
//                .orderByChild("username");
//
//        final long[] size = new long[1];
//
//        q.addListenerForSingleValueEvent(new ValueEventListener(){
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                size[0] = dataSnapshot.getChildrenCount();
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });


        textView = (TextView)findViewById(R.id.textView);
        textView1 = (TextView) findViewById(R.id.textView1);

        mDatabase = FirebaseDatabase.getInstance().getReference();

//        Query q = myDatabase
//                .child("Admin")
//                .orderByChild("username");
//
//        final long[] size = new long[1];
//
//        q.addListenerForSingleValueEvent(new ValueEventListener(){
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                size[0] = dataSnapshot.getChildrenCount();
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

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

        query.addListenerForSingleValueEvent(new ValueEventListener(){
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


                                textView.append(map.get("Username").toString() + "\t \t \t" + map.get("Final Amount").toString() + "\n");

//                            Log.d("Map",map.toString());
//                            userData.put("Username", map.get("Username").toString());
//                            userData.put("Reading0", map.get("Reading0").toString());
//                            userData.put("Reading1", map.get("Reading1").toString());
//                            userData.put("Reading2", map.get("Reading2").toString());
//                            userData.put("Reading3", map.get("Reading3").toString());
//                            userData.put("Reading4", map.get("Reading4").toString());
//                            userData.put("Reading5", map.get("Reading5").toString());
//                            userData.put("Reading6", map.get("Reading6").toString());
//                            userData.put("Reading7", map.get("Reading7").toString());
//                            userData.put("Reading8", map.get("Reading8").toString());
//                            userData.put("Reading9", map.get("Reading9").toString());
//                            userData.put("Reading10", map.get("Reading10").toString());
//                            userData.put("Reading11", map.get("Reading11").toString());
//                            userData.put("Reading12", map.get("Reading12").toString());
//                            userData.put("Date0", map.get("Date0").toString());
//                            userData.put("Date1", map.get("Date1").toString());
//                            userData.put("Date2", map.get("Date2").toString());
//                            userData.put("Date3", map.get("Date3").toString());
//                            userData.put("Date4", map.get("Date4").toString());
//                            userData.put("Date5", map.get("Date5").toString());
//                            userData.put("Date6", map.get("Date6").toString());
//                            userData.put("Date7", map.get("Date7").toString());
//                            userData.put("Date8", map.get("Date8").toString());
//                            userData.put("Date9", map.get("Date9").toString());
//                            userData.put("Date10", map.get("Date10").toString());
//                            userData.put("Date11", map.get("Date11").toString());
//                            userData.put("Date12", map.get("Date12").toString());
//                            userData.put("Amount0", map.get("Amount0").toString());
//                            userData.put("Amount1", map.get("Amount1").toString());
//                            userData.put("Amount2", map.get("Amount2").toString());
//                            userData.put("Amount3", map.get("Amount3").toString());
//                            userData.put("Amount4", map.get("Amount4").toString());
//                            userData.put("Amount5", map.get("Amount5").toString());
//                            userData.put("Amount6", map.get("Amount6").toString());
//                            userData.put("Amount7", map.get("Amount7").toString());
//                            userData.put("Amount8", map.get("Amount8").toString());
//                            userData.put("Amount9", map.get("Amount9").toString());
//                            userData.put("Amount10", map.get("Amount10").toString());
//                            userData.put("Amount11", map.get("Amount11").toString());
//                            userData.put("Amount12", map.get("Amount12").toString());
//                            userData.put("Flat", map.get("Flat").toString());
//                            userData.put("City", map.get("City").toString());
//                            userData.put("Area", map.get("Area").toString());
//                            userData.put("Pincode", map.get("Pincode").toString());
//                            userData.put("Society",map.get("Society").toString());
//                            userData.put("Final Amount",map.get("Final Amount").toString());
//                            userData.put("Cost", Cost);
//                            userData.put("Discount", Discount);
//                            if(pricing.equals("Fixed Costing")){
//                                userData.put("Method",String.valueOf(1));
//                            }else{
//                                userData.put("Method",String.valueOf(2));
//                            }
//                            userData.put("Mobile Number", map.get("Mobile Number").toString());
//                            userData.put("username_password",map.get("username_password").toString());
//                            userData.put("Password",map.get("Password").toString());
//
//
//                            mDatabase.child("Admin").child(Username).push().updateChildren(userData);
//                            for(DataSnapshot areaSnapshot: dataSnapshot.getChildren()) {
//                                areaSnapshot.getRef().setValue(null);
//                            }
//
//                            Toast.makeText(getApplicationContext(), "One user updated", Toast.LENGTH_LONG).show();


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

            }});

//        if (size[0] != 0) {
//            linearLayout.addView(tableLayout((int) size[0]));
//            linearLayout.addView(submitButton());
//            setContentView(linearLayout);
//        }
//        else {
//            linearLayout.addView(tableLayout(10));
//            linearLayout.addView(submitButton());
//            setContentView(linearLayout);
//        }


//        gridView = (GridView) findViewById(R.id.all_users);
//        Toast.makeText(getApplicationContext(), str[0].toString(), Toast.LENGTH_LONG).show();
//        textView.setText(str[0]);

    }

//    private Button submitButton() {
//        Button button = new Button(this);
//        button.setHeight(WRAP_CONTENT);
//        button.setText("Submit");
//        button.setOnClickListener(submitListener);
//        return button;
//    }
//
//    // Access the value of the EditText
//
//    private View.OnClickListener submitListener = new View.OnClickListener() {
//        public void onClick(View view) {
//            StringBuilder stringBuilder = new StringBuilder();
//            for (TextView Textview : TextList) {
//                stringBuilder.append(Textview.getText().toString());
//            }
//        }
//    };
//
//    // Using a TableLayout as it provides you with a neat ordering structure
//
//    private TableLayout tableLayout(int count) {
//        TableLayout tableLayout = new TableLayout(this);
//        tableLayout.setStretchAllColumns(true);
//        int noOfRows = count;
//        for (int i = 0; i < noOfRows; i++) {
//            int rowId = 5 * i;
//            tableLayout.addView(createOneFullRow(rowId));
//        }
//        int individualCells = count % 5;
//        tableLayout.addView(createLeftOverCells(individualCells, count));
//        return tableLayout;
//    }
//
//    private TableRow createLeftOverCells(int individualCells, int count) {
//        TableRow tableRow = new TableRow(this);
//        tableRow.setPadding(0, 10, 0, 0);
//        int rowId = count - individualCells;
//        for (int i = 1; i <= individualCells; i++) {
//            tableRow.addView(textView(String.valueOf(rowId + i)));
//        }
//        return tableRow;
//    }
//
//    private TableRow createOneFullRow(int rowId) {
//        TableRow tableRow = new TableRow(this);
//        tableRow.setPadding(0, 10, 0, 0);
//        for (int i = 1; i <= 5; i++) {
//            tableRow.addView(textView(String.valueOf(rowId + i)));
//        }
//        return tableRow;
//    }
//
//    private TextView textView(String hint) {
//        TextView textView = new TextView(this);
//        textView.setId(Integer.valueOf(hint));
//        textView.setHint(hint);
//        TextList.add(textView);
//        textView.setText("Hello");
//        return textView;
//    }
}


