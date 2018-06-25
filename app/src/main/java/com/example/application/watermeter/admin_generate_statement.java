package com.example.application.watermeter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


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
    private TextView textView2;

    private List<TextView> TextList = new ArrayList<TextView>();
    private String final_reading;

    private Spinner month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_generate_statement);

        textView = (TextView) findViewById(R.id.textView);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        month = (Spinner)findViewById(R.id.month);

        textView = (TextView)findViewById(R.id.textView);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);

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



        month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedmonth = adapterView.getItemAtPosition(i).toString().trim();
//                Toast.makeText(getApplicationContext(), selectedmonth, Toast.LENGTH_LONG).show();

                textView.setText("");
                textView1.setText("");
                textView2.setText("");

                final String converted  = convert(selectedmonth);
                final String[] str = {""};

                Query query = mDatabase
                        .child("Admin").child(Username)
                        .orderByChild("username_password");

                query.addListenerForSingleValueEvent(new ValueEventListener(){
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        if (dataSnapshot.getValue() != null) {

                            Log.d("dataSnapshot ", dataSnapshot.toString());

                            int count = 0;

                            if (dataSnapshot.getValue() != null) {

                                Log.d("dataSnapshot ", dataSnapshot.toString());

                                HashMap<String, Object> studentdata = (HashMap<String, Object>) dataSnapshot.getValue();
                                Log.d("dataSnapshot ", studentdata.toString());


                                for (String key : studentdata.keySet()) {

                                    Object mObject = studentdata.get(key);
                                    HashMap<String, Object> map = (HashMap<String, Object>) mObject;

                                    HashMap<String, Object> userData = new HashMap<String, Object>();

                                    if (!map.get("Username").toString().equals(Username)) {


                                        if(!map.get("Date0").toString().trim().equals("0") && design(map.get("Date0").toString()).equals(converted)){

                                            appendTextView(textView,map.get("Username").toString().trim());
                                            appendTextView(textView1,map.get("Reading0").toString().trim());
                                            appendTextView(textView2,map.get("Amount0").toString().trim());

                                            continue;
                                        }else if(!map.get("Date1").toString().trim().equals("0") && design(map.get("Date1").toString()).equals(converted)){

                                            appendTextView(textView,map.get("Username").toString().trim());
                                            appendTextView(textView1,map.get("Reading1").toString().trim());
                                            appendTextView(textView2,map.get("Amount1").toString().trim());

                                            continue;
                                        }else if(!map.get("Date2").toString().trim().equals("0") && design(map.get("Date2").toString()).equals(converted)){


                                            appendTextView(textView,map.get("Username").toString().trim());
                                            appendTextView(textView1,map.get("Reading2").toString().trim());
                                            appendTextView(textView2,map.get("Amount2").toString().trim());

                                            continue;
                                        }else if(!map.get("Date3").toString().trim().equals("0") && design(map.get("Date3").toString()).equals(converted)){

                                            appendTextView(textView,map.get("Username").toString().trim());
                                            appendTextView(textView1,map.get("Reading3").toString().trim());
                                            appendTextView(textView2,map.get("Amount3").toString().trim());

                                            continue;
                                        }else if(!map.get("Date4").toString().trim().equals("0") && design(map.get("Date4").toString()).equals(converted)){


                                            appendTextView(textView,map.get("Username").toString().trim());
                                            appendTextView(textView1,map.get("Reading4").toString().trim());
                                            appendTextView(textView2,map.get("Amount4").toString().trim());

                                            continue;
                                        }else if(!map.get("Date5").toString().trim().equals("0") &&  design(map.get("Date5").toString()).equals(converted)){


                                            appendTextView(textView,map.get("Username").toString().trim());
                                            appendTextView(textView1,map.get("Reading5").toString().trim());
                                            appendTextView(textView2,map.get("Amount5").toString().trim());

                                            continue;
                                        }else if(!map.get("Date6").toString().trim().equals("0") && design(map.get("Date6").toString()).equals(converted)){


                                            appendTextView(textView,map.get("Username").toString().trim());
                                            appendTextView(textView1,map.get("Reading6").toString().trim());
                                            appendTextView(textView2,map.get("Amount6").toString().trim());

                                            continue;
                                        }else if(!map.get("Date7").toString().trim().equals("0") && design(map.get("Date7").toString()).equals(converted)){


                                            appendTextView(textView,map.get("Username").toString().trim());
                                            appendTextView(textView1,map.get("Reading7").toString().trim());
                                            appendTextView(textView2,map.get("Amount7").toString().trim());

                                            continue;
                                        }else if(!map.get("Date8").toString().trim().equals("0") && design(map.get("Date8").toString()).equals(converted)){

                                            appendTextView(textView,map.get("Username").toString().trim());
                                            appendTextView(textView1,map.get("Reading8").toString().trim());
                                            appendTextView(textView2,map.get("Amount8").toString().trim());

                                            continue;
                                        }else if(!map.get("Date9").toString().trim().equals("0") && design(map.get("Date9").toString()).equals(converted)){


                                            appendTextView(textView,map.get("Username").toString().trim());
                                            appendTextView(textView1,map.get("Reading9").toString().trim());
                                            appendTextView(textView2,map.get("Amount9").toString().trim());

                                            continue;
                                        }else if(!map.get("Date10").toString().trim().equals("0") && design(map.get("Date10").toString()).equals(converted)){


                                            appendTextView(textView,map.get("Username").toString().trim());
                                            appendTextView(textView1,map.get("Reading10").toString().trim());
                                            appendTextView(textView2,map.get("Amount10").toString().trim());

                                            continue;
                                        }else if(!map.get("Date11").toString().trim().equals("0") && design(map.get("Date11").toString()).equals(converted)){

                                            appendTextView(textView,map.get("Username").toString().trim());
                                            appendTextView(textView1,map.get("Reading11").toString().trim());
                                            appendTextView(textView2,map.get("Amount11").toString().trim());

                                            continue;
                                        }else if(!map.get("Date12").toString().trim().equals("0") && design(map.get("Date12").toString()).equals(converted)){

                                            appendTextView(textView,map.get("Username").toString().trim());
                                            appendTextView(textView1,map.get("Reading12").toString().trim());
                                            appendTextView(textView2,map.get("Amount12").toString().trim());

                                            continue;
                                        }


//                                count+=1;

                                    }
                                }
//                        Toast.makeText(getApplicationContext(),String.valueOf(count),Toast.LENGTH_LONG).show();

                            } else {
                                Toast.makeText(getApplicationContext(), "Sorry can't find the user in the database", Toast.LENGTH_LONG).show();

                            }

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }});
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void appendTextView(TextView a, String b){
        a.append(b + "\n\n");
    }

    public String design(String a){
        String ans = "";
        ans = ans + a.charAt(3) + a.charAt(4);
        return ans;
    }

    public String convert(String month){
        if(month.equals("January")){
            return "01";
        }
        else if(month.equals("February")) {
            return "02";
        }
        else if(month.equals("March")) {
            return "03";
        }
        else if(month.equals("April")) {
            return "04";
        }
        else if(month.equals("May")) {
            return "05";
        }
        else if(month.equals("June")) {
            return "06";
        }
        else if(month.equals("July")) {
            return "07";
        }
        else if(month.equals("August")) {
            return "08";
        }
        else if(month.equals("September")) {
            return "09";
        }
        else if(month.equals("October")) {
            return "10";
        }
        else if(month.equals("November")) {
            return "11";
        }
        return "12";
    }

}


