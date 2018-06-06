package com.example.application.watermeter;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

import java.text.ParseException;
import java.util.Date;

import com.google.android.gms.tasks.Task;
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
import java.util.*;

public class add_user_data extends AppCompatActivity {

    private EditText add_user_data_username;
    private Button add_data;

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

    FirebaseDatabase fbDatabase;
    DatabaseReference fbDatabaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_data);

        add_user_data_username =(EditText)findViewById(R.id.add_user_data_username);
        add_data = (Button)findViewById(R.id.add_data);
        cal = (ImageView) findViewById(R.id.cal);

        fbDatabase = FirebaseDatabase.getInstance();
        fbDatabaseReference = fbDatabase.getReference();

        selectDate = (TextView) findViewById(R.id.sdate);
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


//        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
//            @Override
//            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
//
//            }
//        });

        final Calendar myCalendar = Calendar.getInstance();

        String currentDateTimeString = DateFormat.getDateInstance(DateFormat.LONG).format(new Date());

        selectDate.setText(currentDateTimeString);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            private void updateLabel() {
                String myFormat = "dd MM yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                selectDate.setText(sdf.format(myCalendar.getTime()));
            }

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // TODO Auto-generated method stub
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
                new DatePickerDialog(add_user_data.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                new DatePickerDialog(add_user_data.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        add_data.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String username = add_user_data_username.getText().toString();
                //String reading = add_user_data_reading.getText().toString();

//                String month = add_user_data_month.getSelectedItem().toString();

                String date = selectDate.getText().toString().trim();
//                String date = add_user_data_date.getSelectedItem().toString();

//                String month = "";
//                date = String.valueOf(date.charAt(0)) + date.charAt(1);
//                String day = "";
//                day = String.valueOf(date.charAt(2)) + date.charAt(3);
//                String year = "";
//                year = String.valueOf(date.charAt(4)) + date.charAt(5);
//
//                date = "";
//
//                date = day + " " + month + " " + year;

                String reading = "";
                reading = reading + numberPicker1.getValue() + numberPicker2.getValue() + numberPicker3.getValue() + numberPicker4.getValue() + numberPicker5.getValue() + numberPicker6.getValue() + "." + numberPicker7.getValue() + numberPicker8.getValue() + numberPicker9.getValue();

                float read = Float.valueOf(reading);

//                if(date.equals("1")){
//                    date = "01";
//                }else if(date.equals("2")){
//                    date = "02";
//                }else if(date.equals("3")){
//                    date = "03";
//                }else if(date.equals("4")){
//                    date = "04";
//                }else if(date.equals("5")){
//                    date = "05";
//                }else if(date.equals("6")){
//                    date = "06";
//                }else if(date.equals("7")){
//                    date = "07";
//                }else if(date.equals("8")){
//                    date = "08";
//                }else if(date.equals("9")){
//                    date = "09";
//                }

//                if(month.equals("January")){
//                    month = "01";
//                }else if(month.equals("February")){
//                    if(date.equals("29") || date.equals("30") || date.equals("31")){
//                        Toast.makeText(getApplicationContext(),"Invalid Date Entered",Toast.LENGTH_LONG).show();
//                        return ;
//                    }
//                    month = "02";
//                }else if(month.equals("March")){
//                    month = "03";
//                }else if(month.equals("April")){
//                    if(date.equals("31")){
//                        Toast.makeText(getApplicationContext(),"Invalid Date Entered",Toast.LENGTH_LONG).show();
//                        return ;
//                    }
//                    month = "04";
//                }else if(month.equals("May")){
//                    month = "05";
//                }else if(month.equals("June")){
//                    if(date.equals("31")){
//                        Toast.makeText(getApplicationContext(),"Invalid Date Entered",Toast.LENGTH_LONG).show();
//                        return ;
//                    }
//                    month = "06";
//                }else if(month.equals("July")){
//                    month = "07";
//                }else if(month.equals("August")){
//                    month = "08";
//                }else if(month.equals("September")){
//                    if(date.equals("31")){
//                        Toast.makeText(getApplicationContext(),"Invalid Date Entered",Toast.LENGTH_LONG).show();
//                        return ;
//                    }
//                    month = "09";
//                }else if(month.equals("October")){
//                    month = "10";
//                }else if(month.equals("November")){
//                    if(date.equals("31")){
//                        Toast.makeText(getApplicationContext(),"Invalid Date Entered",Toast.LENGTH_LONG).show();
//                        return ;
//                    }
//                    month = "11";
//                }else if(month.equals("December")) {
//                    month = "12";
//                }
//
//                final String initial_date = date + month + add_user_data_year.getSelectedItem().toString();


                if(username!=null && reading!=null){
                    fetchData(username,reading,date);
                }else if(username==null){
                    Toast.makeText(getApplicationContext(),"Enter username",Toast.LENGTH_LONG).show();
                }else if(reading==null){
                    Toast.makeText(getApplicationContext(),"Enter water meter reading",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
//        startActivity(new Intent(this,admin_logged_in.class));
//        //super.onBackPressed();
        finish();
    }

    public void fetchData(final String username, final String reading, final String date ){

        final Intent intent = getIntent();

//        String username1 = intent.getStringExtra("Username");
//        String password1 = intent.getStringExtra("Password");
//        String society1 = intent.getStringExtra("Society");

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

        Query query = fbDatabaseReference
                .child("Admin").child(Username)
                .orderByChild("Username")
                .equalTo(username);

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


                        String cost = map.get("Cost").toString();
                        String final_amount = map.get("Final Amount").toString();

                        //String password = map.get("Password").toString();
                        //String username_password = map.get("username_password").toString();

                        String reading0 = map.get("Reading0").toString();
                        String reading1 = map.get("Reading1").toString();
                        String reading2 = map.get("Reading2").toString();
                        String reading3 = map.get("Reading3").toString();
                        String reading4 = map.get("Reading4").toString();
                        String reading5 = map.get("Reading5").toString();
                        String reading6 = map.get("Reading6").toString();
                        String reading7 = map.get("Reading7").toString();
                        String reading8 = map.get("Reading8").toString();
                        String reading9 = map.get("Reading9").toString();
                        String reading10 = map.get("Reading10").toString();
                        String reading11 = map.get("Reading11").toString();
                        String reading12 = map.get("Reading12").toString();

                        //Toast.makeText(getApplicationContext(), reading0, Toast.LENGTH_LONG).show();

                        String date0 = map.get("Date0").toString().trim();
                        String date1 = map.get("Date1").toString().trim();
                        String date2 = map.get("Date2").toString().trim();
                        String date3 = map.get("Date3").toString().trim();
                        String date4 = map.get("Date4").toString().trim();
                        String date5 = map.get("Date5").toString().trim();
                        String date6 = map.get("Date6").toString().trim();
                        String date7 = map.get("Date7").toString().trim();
                        String date8 = map.get("Date8").toString().trim();
                        String date9 = map.get("Date9").toString().trim();
                        String date10 = map.get("Date10").toString().trim();
                        String date11 = map.get("Date11").toString().trim();
                        String date12 = map.get("Date12").toString().trim();

                        String amount0 = map.get("Amount0").toString();
                        String amount1 = map.get("Amount1").toString();
                        String amount2 = map.get("Amount2").toString();
                        String amount3 = map.get("Amount3").toString();
                        String amount4 = map.get("Amount4").toString();
                        String amount5 = map.get("Amount5").toString();
                        String amount6 = map.get("Amount6").toString();
                        String amount7 = map.get("Amount7").toString();
                        String amount8 = map.get("Amount8").toString();
                        String amount9 = map.get("Amount9").toString();
                        String amount10 = map.get("Amount10").toString();
                        String amount11 = map.get("Amount11").toString();
                        String amount12 = map.get("Amount12").toString();
                        String finalamount = map.get("Final Amount").toString();
                        String discount = map.get("Discount").toString();
                        String method = map.get("Method").toString();
                        Float reading_in_float = Float.parseFloat(reading);
                        Float discount_in_float = Float.parseFloat(discount);
                        //reading_in_float = reading_in_float - discount_in_float;
                        Float previous_reading;
                        Float ans = null;
                        Float cost_in_float = Float.parseFloat(cost);
                        Float finalamount_in_float = Float.parseFloat(finalamount);

                        String month = "";
                        month = String.valueOf(date.charAt(3)) + date.charAt(4);

                       // Toast.makeText(getApplicationContext(),date0,Toast.LENGTH_LONG).show();

                        boolean a;
                        int f=0;
                        int g=0;
                        a = check(date0,month);
                        if(a==true){
                            float one = Float.parseFloat(reading0);
                            float two = Float.parseFloat(reading);
                            if(two>one){
                                reading0 = "0";
                                finalamount_in_float -= Float.parseFloat(amount0);
                            }else{
                                reading0 = reading;
                                g=1;
                            }
                            f=1;
                        }
                        if(f==0) {
                            a = check(date1, month);
                            if (a == true) {
                                float one = Float.parseFloat(reading1);
                                float two = Float.parseFloat(reading);
                                if(two>one){
                                    reading1 = "0";
                                    finalamount_in_float -= Float.parseFloat(amount1);
                                }else{
                                    reading1 = reading;
                                    g=1;
                                }
                            }
                            f=1;
                        }
                        if(f==0) {
                            a = check(date2, month);
                            float one = Float.parseFloat(reading2);
                            float two = Float.parseFloat(reading);
                            if(two>one){
                                reading2 = "0";
                                finalamount_in_float -= Float.parseFloat(amount2);
                            }else{
                                reading2 = reading;
                                g=1;
                            }
                            f=1;
                        }
                        if(f==0) {
                            a = check(date3, month);
                            if (a == true) {
                                float one = Float.parseFloat(reading3);
                                float two = Float.parseFloat(reading);
                                if(two>one){
                                    reading3 = "0";
                                    finalamount_in_float -= Float.parseFloat(amount3);
                                }else{
                                    reading3 = reading;
                                    g=1;
                                }
                            }
                            f=1;
                        }
                        if(f==0) {
                            a = check(date4, month);
                            if (a == true) {
                                float one = Float.parseFloat(reading4);
                                float two = Float.parseFloat(reading);
                                if(two>one){
                                    reading4 = "0";
                                    finalamount_in_float -= Float.parseFloat(amount4);
                                }else{
                                    reading4 = reading;
                                    g=1;
                                }
                            }
                            f=1;
                        }
                        if(f==0) {
                            a = check(date5, month);
                            if (a == true) {
                                float one = Float.parseFloat(reading5);
                                float two = Float.parseFloat(reading);
                                if(two>one){
                                    reading5 = "0";
                                    finalamount_in_float -= Float.parseFloat(amount5);
                                }else{
                                    reading5 = reading;
                                    g=1;
                                }
                            }
                            f=1;
                        }
                        if(f==0) {
                            a = check(date6, month);
                            if (a == true) {
                                float one = Float.parseFloat(reading6);
                                float two = Float.parseFloat(reading);
                                if(two>one){
                                    reading6 = "0";
                                    finalamount_in_float -= Float.parseFloat(amount6);
                                }else{
                                    reading6 = reading;
                                    g=1;
                                }
                            }
                            f=1;
                        }
                        if(f==0) {
                            a = check(date7, month);
                            if (a == true) {
                                float one = Float.parseFloat(reading7);
                                float two = Float.parseFloat(reading);
                                if(two>one){
                                    reading7 = "0";
                                    finalamount_in_float -= Float.parseFloat(amount7);
                                }else{
                                    reading7 = reading;
                                    g=1;
                                }
                            }
                            f=1;
                        }
                        if(f==0) {
                            a = check(date8, month);
                            if (a == true) {
                                float one = Float.parseFloat(reading8);
                                float two = Float.parseFloat(reading);
                                if(two>one){
                                    reading8 = "0";
                                    finalamount_in_float -= Float.parseFloat(amount8);
                                }else{
                                    reading8 = reading;
                                    g=1;
                                }
                            }
                            f=1;
                        }
                        if(f==0) {
                            a = check(date9, month);
                            if (a == true) {
                                float one = Float.parseFloat(reading9);
                                float two = Float.parseFloat(reading);
                                if(two>one){
                                    reading9 = "0";
                                    finalamount_in_float -= Float.parseFloat(amount9);
                                }else{
                                    reading9 = reading;
                                    g=1;
                                }
                            }
                            f=1;
                        }
                        if(f==0) {
                            a = check(date10, month);
                            if (a == true) {
                                float one = Float.parseFloat(reading10);
                                float two = Float.parseFloat(reading);
                                if(two>one){
                                    reading10 = "0";
                                    finalamount_in_float -= Float.parseFloat(amount10);
                                }else{
                                    reading10 = reading;
                                    g=1;
                                }
                            }
                            f=1;
                        }
                        if(f==0) {
                            a = check(date11, month);
                            if (a == true) {
                                float one = Float.parseFloat(reading11);
                                float two = Float.parseFloat(reading);
                                if(two>one){
                                    reading11 = "0";
                                    finalamount_in_float -= Float.parseFloat(amount11);
                                }else{
                                    reading11 = reading;
                                    g=1;
                                }
                            }
                            f=1;
                        }
                        if(f==0) {
                            a = check(date12, month);
                            if (a == true) {
                                float one = Float.parseFloat(reading12);
                                float two = Float.parseFloat(reading);
                                if(two>one){
                                    reading12 = "0";
                                    finalamount_in_float -= Float.parseFloat(amount12);
                                }else{
                                    reading12 = reading;
                                    g=1;
                                }
                            }
                            f=1;
                        }

                        if(g==0) {
                            if (reading0.equals("0")) {
                                reading0 = reading;
                                date0 = date;
                                amount0 = "0";
                            } else if (reading1.equals("0")) {
                                reading1 = reading;
                                previous_reading = Float.parseFloat(reading0);
                                date1 = date;
                                try {
                                    reading_in_float = discounted(date1, date0, discount_in_float, reading_in_float);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                ans = (reading_in_float - previous_reading) * (cost_in_float);
                                if (ans > 0) {
                                    amount1 = String.valueOf(ans);
                                }
                            } else if (reading2.equals("0")) {
                                reading2 = reading;
                                previous_reading = Float.parseFloat(reading1);
                                date2 = date;
                                try {
                                    reading_in_float = discounted(date2, date1, discount_in_float, reading_in_float);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                ans = (reading_in_float - previous_reading) * (cost_in_float);
                                if (ans > 0) {
                                    amount2 = String.valueOf(ans);
                                }
//                            reading2 = reading;
//                            date2 = date;
//                            Float a = Float.parseFloat(reading1);
//                            Float b = Float.parseFloat(reading2);
//                            Float ans = b-a;
//                            if(ans>0) {
//                                difference = String.valueOf(ans);
//                            }else{
//                                difference = "0";
//                            }
                            } else if (reading3.equals("0")) {
                                reading3 = reading;
                                previous_reading = Float.parseFloat(reading2);
                                date3 = date;
                                try {
                                    reading_in_float = discounted(date3, date2, discount_in_float, reading_in_float);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                ans = (reading_in_float - previous_reading) * (cost_in_float);
                                if (ans > 0) {
                                    amount3 = String.valueOf(ans);
                                }
//                            reading3 = reading;
//                            date3 = date;
//                            Float a = Float.parseFloat(reading2);
//                            Float b = Float.parseFloat(reading3);
//                            Float ans = b-a;
//                            if(ans>0) {
//                                difference = String.valueOf(ans);
//                            }else{
//                                difference = "0";
//                            }
                            } else if (reading4.equals("0")) {
                                reading4 = reading;
                                previous_reading = Float.parseFloat(reading3);
                                date4 = date;
                                try {
                                    reading_in_float = discounted(date4, date3, discount_in_float, reading_in_float);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                ans = (reading_in_float - previous_reading) * (cost_in_float);
                                if (ans > 0) {
                                    amount4 = String.valueOf(ans);
                                }
//                            reading4 = reading;
//                            date4 = date;
//                            Float a = Float.parseFloat(reading3);
//                            Float b = Float.parseFloat(reading4);
//                            Float ans = b-a;
//                            if(ans>0) {
//                                difference = String.valueOf(ans);
//                            }else{
//                                difference = "0";
//                            }
                            } else if (reading5.equals("0")) {
                                reading5 = reading;
                                previous_reading = Float.parseFloat(reading4);
                                date5 = date;
                                try {
                                    reading_in_float = discounted(date5, date4, discount_in_float, reading_in_float);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                ans = (reading_in_float - previous_reading) * (cost_in_float);
                                if (ans > 0) {
                                    amount5 = String.valueOf(ans);
                                }
                                //reading5 = reading;
//                            date5 = date;
//                            Float a = Float.parseFloat(reading4);
//                            Float b = Float.parseFloat(reading5);
//                            Float ans = b-a;
//                            if(ans>0) {
//                                difference = String.valueOf(ans);
//                            }else{
//                                difference = "0";
//                            }
                            } else if (reading6.equals("0")) {
                                reading6 = reading;
                                previous_reading = Float.parseFloat(reading5);
                                date6 = date;
                                try {
                                    reading_in_float = discounted(date6, date5, discount_in_float, reading_in_float);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                ans = (reading_in_float - previous_reading) * (cost_in_float);
                                if (ans > 0) {
                                    amount6 = String.valueOf(ans);
                                }
//                            reading6 = reading;
//                            date6 = date;
//                            Float a = Float.parseFloat(reading5);
//                            Float b = Float.parseFloat(reading6);
//                            Float ans = b-a;
//                            if(ans>0) {
//                                difference = String.valueOf(ans);
//                            }else{
//                                difference = "0";
//                            }
                            } else if (reading7.equals("0")) {
                                reading7 = reading;
                                previous_reading = Float.parseFloat(reading6);
                                date7 = date;
                                try {
                                    reading_in_float = discounted(date7, date6, discount_in_float, reading_in_float);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                ans = (reading_in_float - previous_reading) * (cost_in_float);
                                if (ans > 0) {
                                    amount7 = String.valueOf(ans);
                                }
//                            reading7 = reading;
//                            date7 = date;
//                            Float a = Float.parseFloat(reading6);
//                            Float b = Float.parseFloat(reading7);
//                            Float ans = b-a;
//                            if(ans>0) {
//                                difference = String.valueOf(ans);
//                            }else{
//                                difference = "0";
//                            }
                            } else if (reading8.equals("0")) {
                                reading8 = reading;
                                previous_reading = Float.parseFloat(reading7);
                                date8 = date;
                                try {
                                    reading_in_float = discounted(date8, date7, discount_in_float, reading_in_float);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                ans = (reading_in_float - previous_reading) * (cost_in_float);
                                if (ans > 0) {
                                    amount8 = String.valueOf(ans);
                                }
//                            reading8 = reading;
//                            date8 = date;
//                            Float a = Float.parseFloat(reading7);
//                            Float b = Float.parseFloat(reading8);
//                            Float ans = b-a;
//                            if(ans>0) {
//                                difference = String.valueOf(ans);
//                            }else{
//                                difference = "0";
//                            }
                            } else if (reading9.equals("0")) {
                                reading9 = reading;
                                previous_reading = Float.parseFloat(reading8);
                                date9 = date;
                                try {
                                    reading_in_float = discounted(date9, date8, discount_in_float, reading_in_float);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                ans = (reading_in_float - previous_reading) * (cost_in_float);
                                if (ans > 0) {
                                    amount9 = String.valueOf(ans);
                                }
//                            reading9 = reading;
//                            date9 = date;
//                            Float a = Float.parseFloat(reading8);
//                            Float b = Float.parseFloat(reading9);
//                            Float ans = b-a;
//                            if(ans>0) {
//                                difference = String.valueOf(ans);
//                            }else{
//                                difference = "0";
//                            }
                            } else if (reading10.equals("0")) {
                                reading10 = reading;
                                previous_reading = Float.parseFloat(reading9);
                                date10 = date;
                                try {
                                    reading_in_float = discounted(date10, date11, discount_in_float, reading_in_float);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                ans = (reading_in_float - previous_reading) * (cost_in_float);
                                if (ans > 0) {
                                    amount10 = String.valueOf(ans);
                                }
//                            reading10 = reading;
//                            date10 = date;
//                            Float a = Float.parseFloat(reading9);
//                            Float b = Float.parseFloat(reading10);
//                            Float ans = b-a;
//                            if(ans>0) {
//                                difference = String.valueOf(ans);
//                            }else{
//                                difference = "0";
//                            }
                            } else if (reading11.equals("0")) {
                                reading11 = reading;
                                previous_reading = Float.parseFloat(reading10);
                                date11 = date;
                                try {
                                    reading_in_float = discounted(date11, date12, discount_in_float, reading_in_float);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                ans = (reading_in_float - previous_reading) * (cost_in_float);
                                if (ans > 0) {
                                    amount11 = String.valueOf(ans);
                                }
//                            reading11 = reading;
//                            date11 = date;
//                            Float a = Float.parseFloat(reading10);
//                            Float b = Float.parseFloat(reading11);
//                            Float ans = b-a;
//                            if(ans>0) {
//                                difference = String.valueOf(ans);
//                            }else{
//                                difference = "0";
//                            }
                            } else if (reading12.equals("0")) {
                                reading12 = reading;
                                previous_reading = Float.parseFloat(reading11);
                                date12 = date;
                                try {
                                    reading_in_float = discounted(date12, date11, discount_in_float, reading_in_float);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                ans = (reading_in_float - previous_reading) * (cost_in_float);
                                if (ans > 0) {
                                    amount12 = String.valueOf(ans);
                                }
//                            reading12 = reading;
//                            date12 = date;
//                            Float a = Float.parseFloat(reading11);
//                            Float b = Float.parseFloat(reading12);
//                            Float ans = b-a;
//                            if(ans>0) {
//                                difference = String.valueOf(ans);
//                            }else{
//                                difference = "0";
//                            }
                            } else {
                                reading0 = reading1;
                                reading1 = reading2;
                                reading2 = reading3;
                                reading3 = reading4;
                                reading4 = reading5;
                                reading5 = reading6;
                                reading6 = reading7;
                                reading7 = reading8;
                                reading8 = reading9;
                                reading9 = reading10;
                                reading10 = reading11;
                                reading11 = reading12;
                                reading12 = reading;
                                date0 = date1;
                                date1 = date2;
                                date2 = date3;
                                date3 = date4;
                                date4 = date5;
                                date5 = date6;
                                date6 = date7;
                                date7 = date8;
                                date8 = date9;
                                date9 = date10;
                                date10 = date11;
                                date11 = date12;
                                date12 = date;
                                previous_reading = Float.parseFloat(reading11);
                                try {
                                    reading_in_float = discounted(date12, date11, discount_in_float, reading_in_float);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                ans = (reading_in_float - previous_reading) * (cost_in_float);
                                finalamount_in_float = finalamount_in_float - Float.parseFloat(amount0);
                                amount0 = amount1;
                                amount1 = amount2;
                                amount2 = amount3;
                                amount3 = amount4;
                                amount4 = amount5;
                                amount5 = amount6;
                                amount6 = amount7;
                                amount7 = amount8;
                                amount8 = amount9;
                                amount9 = amount10;
                                amount10 = amount11;
                                amount11 = amount12;
                                if (ans > 0) {
                                    amount12 = String.valueOf(ans);
                                } else {
                                    amount12 = "0";
                                }
                            }
                        }
                            if (ans != null && ans > 0) {
                                finalamount_in_float += ans;
                                final_amount = String.valueOf(finalamount_in_float);
                            }

//                        Float float_final_amount = Float.parseFloat(final_amount);
//                        Float c = Float.parseFloat(difference);
//                        Float float_cost = Float.parseFloat(cost);
//                        Float amount = float_cost*c;
//                        float_final_amount = amount + float_final_amount;
//
//                        final_amount = String.valueOf(float_final_amount);

                        Intent intent = getIntent();

                        String username1 = intent.getStringExtra("Username");
                        String password1 = intent.getStringExtra("Password");
                        String society1 = intent.getStringExtra("Society");
                        HashMap<String, Object> userData = new HashMap<String, Object>();
                        userData.put("Reading0", reading0);
                        userData.put("Reading1", reading1);
                        userData.put("Reading2", reading2);
                        userData.put("Reading3", reading3);
                        userData.put("Reading4", reading4);
                        userData.put("Reading5", reading5);
                        userData.put("Reading6", reading6);
                        userData.put("Reading7", reading7);
                        userData.put("Reading8", reading8);
                        userData.put("Reading9", reading9);
                        userData.put("Reading10", reading10);
                        userData.put("Reading11", reading11);
                        userData.put("Reading12", reading12);
                        userData.put("Date0",date0);
                        userData.put("Date1",date1);
                        userData.put("Date2",date2);
                        userData.put("Date3",date3);
                        userData.put("Date4",date4);
                        userData.put("Date5",date5);
                        userData.put("Date6",date6);
                        userData.put("Date7",date7);
                        userData.put("Date8",date8);
                        userData.put("Date9",date9);
                        userData.put("Date10",date10);
                        userData.put("Date11",date11);
                        userData.put("Date12",date12);
                        userData.put("Amount0",amount0);
                        userData.put("Amount1",amount1);
                        userData.put("Amount2",amount2);
                        userData.put("Amount3",amount3);
                        userData.put("Amount4",amount4);
                        userData.put("Amount5",amount5);
                        userData.put("Amount6",amount6);
                        userData.put("Amount7",amount7);
                        userData.put("Amount8",amount8);
                        userData.put("Amount9",amount9);
                        userData.put("Amount10",amount10);
                        userData.put("Amount11",amount11);
                        userData.put("Amount12",amount12);
                        userData.put("Cost",cost);
                        userData.put("Final Amount",final_amount);
                        userData.put("Discount",discount);
                        userData.put("Username", username);
                        userData.put("Flat", map.get("Flat").toString());
                        userData.put("username_password",map.get("username_password").toString());
                        userData.put("Password",map.get("Password").toString());
                        userData.put("Society",map.get("Society").toString());
                        userData.put("City", map.get("City").toString());
                        userData.put("Area", map.get("Area").toString());
                        userData.put("Method", map.get("Method").toString());
                        userData.put("Mobile Number", map.get("Mobile Number").toString());
                        userData.put("Pincode", map.get("Pincode").toString());

                        //fbDatabaseReference.child(username1).orderByChild("Username").equalTo(username).removeValue();

                        //fbDatabaseReference.child("Admin").child(username1).push().updateChildren(userData);
                        fbDatabaseReference.child("Admin").child(username1).push().updateChildren(userData);


                        for(DataSnapshot areaSnapshot: dataSnapshot.getChildren()) {
                            areaSnapshot.getRef().setValue(null);
                        }


                        //dataSnapshot.getRef().child(username1).orderByChild("Username").equalTo(username).removeValue();

                        //Toast.makeText(getApplicationContext(), a.toString(), Toast.LENGTH_LONG).show();

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
                        break;

                    }

                }else {
                    Toast.makeText(getApplicationContext(), "Not a valid username", Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Log.d( "error ",databaseError.toString());
            }
        });
    }

    public boolean check(String date0, String month){
        if(!date0.equals("0")){
            String months = "";
            months = months + date0.charAt(3) + date0.charAt(4);
            if(months.equals(month)) {
                return true;
            }
        }
        return false;
    }

    public float discounted(String date0 , String date1 , float discount , float reading) throws ParseException {
//        int days = 0;
        long days;
        DateFormat format = new SimpleDateFormat("dd MM yy", Locale.ENGLISH);
        Date one = format.parse(date0);
        Date two = format.parse(date1);
        days = one.getTime() - two.getTime();
        reading = reading - (discount * days);
        return reading;
    }
}