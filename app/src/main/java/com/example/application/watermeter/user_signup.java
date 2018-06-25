package com.example.application.watermeter;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class user_signup extends AppCompatActivity {

    private EditText user_flat;
    private EditText user_signup_mobile_number;
    private EditText user_balance_amt;

    private NumberPicker numberPicker1;
    private NumberPicker numberPicker2;
    private NumberPicker numberPicker3;
    private NumberPicker numberPicker4;
    private NumberPicker numberPicker5;
    private NumberPicker numberPicker6;
    private NumberPicker numberPicker7;
    private NumberPicker numberPicker8;
    private NumberPicker numberPicker9;
    private TextView selectDate;
    private ImageView cal;

    private Button user_signed_up;

    private DatabaseReference mDatabase;

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signup);

        user_flat = (EditText)findViewById(R.id.user_flat);
        user_signed_up = (Button)findViewById(R.id.user_signed_up);
        user_signup_mobile_number = (EditText)findViewById(R.id.user_signup_mobile_number);
        user_balance_amt = (EditText) findViewById(R.id.bal_amt);

        selectDate = (TextView) findViewById(R.id.sdate);
        cal = (ImageView) findViewById(R.id.calendar);

        numberPicker1 = (NumberPicker) findViewById(R.id.meter1);
        numberPicker2 = (NumberPicker) findViewById(R.id.meter2);
        numberPicker3 = (NumberPicker) findViewById(R.id.meter3);
        numberPicker4 = (NumberPicker) findViewById(R.id.meter4);
        numberPicker5 = (NumberPicker) findViewById(R.id.meter5);
        numberPicker6 = (NumberPicker) findViewById(R.id.meter6);
        numberPicker7 = (NumberPicker) findViewById(R.id.meter7);
        numberPicker8 = (NumberPicker) findViewById(R.id.meter8);
        numberPicker9 = (NumberPicker) findViewById(R.id.meter9);

        numberPicker1.setMinValue(0);
        numberPicker1.setMaxValue(9);

        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(9);

        numberPicker3.setMinValue(0);
        numberPicker3.setMaxValue(9);

        numberPicker4.setMinValue(0);
        numberPicker4.setMaxValue(9);

        numberPicker5.setMinValue(0);
        numberPicker5.setMaxValue(9);

        numberPicker6.setMinValue(0);
        numberPicker6.setMaxValue(9);

        numberPicker7.setMinValue(0);
        numberPicker7.setMaxValue(9);

        numberPicker8.setMinValue(0);
        numberPicker8.setMaxValue(9);

        numberPicker9.setMinValue(0);
        numberPicker9.setMaxValue(9);

        numberPicker1.setWrapSelectorWheel(true);
        numberPicker2.setWrapSelectorWheel(true);
        numberPicker3.setWrapSelectorWheel(true);
        numberPicker4.setWrapSelectorWheel(true);
        numberPicker5.setWrapSelectorWheel(true);
        numberPicker6.setWrapSelectorWheel(true);
        numberPicker7.setWrapSelectorWheel(true);
        numberPicker8.setWrapSelectorWheel(true);
        numberPicker9.setWrapSelectorWheel(true);

        mDatabase = FirebaseDatabase.getInstance().getReference();


        final Calendar myCalendar = Calendar.getInstance();

        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        String currentDateTimeString = sdf.format(new Date());

        selectDate.setText(currentDateTimeString);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            private void updateLabel() {
                String myFormat = "dd/MM/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                selectDate.setText(sdf.format(myCalendar.getTime()));
            }

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                new DatePickerDialog(user_signup.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(user_signup.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        user_signed_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String username = user_flat.getText().toString().trim();
                final String mobile = user_signup_mobile_number.getText().toString().trim();
                final String balance = user_balance_amt.getText().toString().trim();
                final String date = selectDate.getText().toString().trim();



                if(TextUtils.isEmpty(username)) {
                    Toast.makeText(user_signup.this,"Please enter the flat Number",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(balance)) {
                    Toast.makeText(user_signup.this,"Please enter the balance amount",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(mobile)) {
                    Toast.makeText(user_signup.this,"Please enter the mobile Number",Toast.LENGTH_SHORT).show();
                    return;
                }

                String reading1 = "";
                reading1 = reading1 + numberPicker1.getValue() + numberPicker2.getValue() + numberPicker3.getValue() + numberPicker4.getValue() + numberPicker5.getValue() + numberPicker6.getValue() + "." + numberPicker7.getValue() + numberPicker8.getValue() + numberPicker9.getValue();

                Float reading = Float.valueOf(reading1);
                Intent intent = getIntent();

                final String Area = intent.getStringExtra("Area");
                final String Cost = intent.getStringExtra("Cost");
                final String Discount = intent.getStringExtra("Discount");
                final String Method = intent.getStringExtra("Method");
                final String Password = intent.getStringExtra("Password");
                final String Pincode = intent.getStringExtra("Pincode");
                final String Society = intent.getStringExtra("Society");
                final String Username = intent.getStringExtra("Username");
                final String City = intent.getStringExtra("City");
                final String username_password = intent.getStringExtra("username_password");


                Query query = mDatabase
                        .child("Admin").child(username)
                        .orderByChild("username")
                        .equalTo(username);

                final String finalReading = String.valueOf(reading);
                query.addListenerForSingleValueEvent(new ValueEventListener(){
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        final String flat = user_flat.getText().toString().trim();
                        final String password = user_signup_mobile_number.getText().toString().trim();

                        if(dataSnapshot.getValue()!=null) {
                            Toast.makeText(getApplicationContext(),"Username already taken",Toast.LENGTH_LONG).show();
                            return;
                        }else{

                            if(TextUtils.isEmpty(password)) {
                                Toast.makeText(user_signup.this,"Please enter your phone number",Toast.LENGTH_SHORT).show();
                                return;
                            }

                            if (password.isEmpty() || password.length() != 10   ) {  user_signup_mobile_number.setError("Phone numbers should be of length 10!"); return;
                            }

                            if(TextUtils.isEmpty(flat)){
                                Toast.makeText(user_signup.this,"Please enter your flat",Toast.LENGTH_SHORT).show();
                                return;
                            }


                            HashMap<String, String> userData = new HashMap<String, String>();

                            final String y = username + "_" + password;

                            userData.put("Username", username);
                            userData.put("Password",password);
                            userData.put("Mobile Number",password);
                            userData.put("username_password",y);
                            userData.put("Flat", flat);
                            userData.put("Society",Society);
                            userData.put("Area",Area);
                            userData.put("City",City);
                            userData.put("Pincode",Pincode);
                            userData.put("Method",Method);
                            userData.put("Cost",Cost);
                            userData.put("Discount",Discount);
                            userData.put("Reading0", finalReading);
                            userData.put("Final_Reading",finalReading);
                            userData.put("Reading1", "0");
                            userData.put("Reading2", "0");
                            userData.put("Reading3", "0");
                            userData.put("Reading4", "0");
                            userData.put("Reading5", "0");
                            userData.put("Reading6", "0");
                            userData.put("Reading7", "0");
                            userData.put("Reading8", "0");
                            userData.put("Reading9", "0");
                            userData.put("Reading10", "0");
                            userData.put("Reading11", "0");
                            userData.put("Reading12", "0");
                            userData.put("Date0",date);
                            userData.put("Date1","0");
                            userData.put("Date2","0");
                            userData.put("Date3","0");
                            userData.put("Date4","0");
                            userData.put("Date5","0");
                            userData.put("Date6","0");
                            userData.put("Date7","0");
                            userData.put("Date8","0");
                            userData.put("Date9","0");
                            userData.put("Date10","0");
                            userData.put("Date11","0");
                            userData.put("Date12","0");
                            userData.put("Amount0","0");
                            userData.put("Amount1","0");
                            userData.put("Amount2","0");
                            userData.put("Amount3","0");
                            userData.put("Amount4","0");
                            userData.put("Amount5","0");
                            userData.put("Amount6","0");
                            userData.put("Amount7","0");
                            userData.put("Amount8","0");
                            userData.put("Amount9","0");
                            userData.put("Amount10","0");
                            userData.put("Amount11","0");
                            userData.put("Amount12","0");
                            userData.put("Final Amount","0");
                            userData.put("Balance",balance);

                            mDatabase.child("Admin").child(Username).push().setValue(userData);


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