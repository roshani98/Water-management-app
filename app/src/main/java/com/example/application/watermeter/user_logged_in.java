package com.example.application.watermeter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class user_logged_in extends AppCompatActivity {

    private String admin;
    private String Amount0;
    private String Amount1;
    private String Amount2;
    private String Amount3;
    private String Amount4;
    private String Amount5;
    private String Amount6;
    private String Amount7;
    private String Amount8;
    private String Amount9;
    private String Amount10;
    private String Amount11;
    private String Amount12;
    private String Area;
    private String City;
    private String Cost;
    private String Date0;
    private String Date1;
    private String Date2;
    private String Date3;
    private String Date4;
    private String Date5;
    private String Date6;
    private String Date7;
    private String Date8;
    private String Date9;
    private String Date10;
    private String Date11;
    private String Date12;
    private String Discount;
    private String Final_Amount;
    private String Flat;
    private String Method;
    private String Mobile_Number;
    private String Password;
    private String Pincode;
    private String Reading0;
    private String Reading1;
    private String Reading2;
    private String Reading3;
    private String Reading4;
    private String Reading5;
    private String Reading6;
    private String Reading7;
    private String Reading8;
    private String Reading9;
    private String Reading10;
    private String Reading11;
    private String Reading12;
    private String Society;
    private String Username;
    private String username_password;
    private String final_reading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_logged_in);

        Intent intent = getIntent();

        Amount0 = intent.getStringExtra("Amount0");
        Amount1 = intent.getStringExtra("Amount1");
        Amount2 = intent.getStringExtra("Amount2");
        Amount3 = intent.getStringExtra("Amount3");
        Amount4 = intent.getStringExtra("Amount4");
        Amount5 = intent.getStringExtra("Amount5");
        Amount6 = intent.getStringExtra("Amount6");
        Amount7 = intent.getStringExtra("Amount7");
        Amount8 = intent.getStringExtra("Amount8");
        Amount9 = intent.getStringExtra("Amount9");
        Amount10 = intent.getStringExtra("Amount10");
        Amount11 = intent.getStringExtra("Amount11");
        Amount12 = intent.getStringExtra("Amount12");
        Area = intent.getStringExtra("Area");
        City = intent.getStringExtra("Area");
        Cost = intent.getStringExtra("Area");
        Date0 = intent.getStringExtra("Date0");
        Date1 = intent.getStringExtra("Date1");
        Date2 = intent.getStringExtra("Date2");
        Date3 = intent.getStringExtra("Date3");
        Date4 = intent.getStringExtra("Date4");
        Date5 = intent.getStringExtra("Date5");
        Date6 = intent.getStringExtra("Date6");
        Date7 = intent.getStringExtra("Date7");
        Date8 = intent.getStringExtra("Date8");
        Date9 = intent.getStringExtra("Date9");
        Date10 = intent.getStringExtra("Date10");
        Date11 = intent.getStringExtra("Date11");
        Date12 = intent.getStringExtra("Date12");
        Discount = intent.getStringExtra("Discount");
        Final_Amount = intent.getStringExtra("Final_Amount");
        Flat = intent.getStringExtra("Flat");
        Method = intent.getStringExtra("Method");
        Mobile_Number = intent.getStringExtra("Mobile_Number");
        Password = intent.getStringExtra("Password");
        Pincode = intent.getStringExtra("Pincode");
        Reading0 = intent.getStringExtra("Reading0");
        Reading1 = intent.getStringExtra("Reading1");
        Reading2 = intent.getStringExtra("Reading2");
        Reading3 = intent.getStringExtra("Reading3");
        Reading4 = intent.getStringExtra("Reading4");
        Reading5 = intent.getStringExtra("Reading5");
        Reading6 = intent.getStringExtra("Reading6");
        Reading7 = intent.getStringExtra("Reading7");
        Reading8 = intent.getStringExtra("Reading8");
        Reading9 = intent.getStringExtra("Reading9");
        Reading10 = intent.getStringExtra("Reading10");
        Reading11 = intent.getStringExtra("Reading11");
        Reading12 = intent.getStringExtra("Reading12");
        Society = intent.getStringExtra("Society");
        Username = intent.getStringExtra("Username");
        username_password = intent.getStringExtra("username_password");
        admin = intent.getStringExtra("Admin");
        final_reading = intent.getStringExtra("Final_Reading");

        String info = "Hello " + Username + ", \n\n" ;
        info = info + "Society Name :\t \t \t " + Society + "\n\n";
        info = info + "Flat Number :\t \t \t " + Flat + "\n\n";
        info = info + "Cost per unit :\t \t \t " + Cost + "\n\n";
        info = info + "Date \t \t \t \t Reading \t \t \t \t Amount \n\n";

        String date = "";
        String month = "";
        String year = "";

        int a = 0;
        info = info + "Final Amount : \t \t \t" + Final_Amount + "\n\n";

    }



    public void choosen_change_password(View view){

        Intent i = new Intent(getApplicationContext(), user_change_password.class);

        i.putExtra("Admin",admin);
        i.putExtra("Amount0",Amount0);
        i.putExtra("Amount1",Amount1);
        i.putExtra("Amount2",Amount2);
        i.putExtra("Amount3",Amount3);
        i.putExtra("Amount4",Amount4);
        i.putExtra("Amount5",Amount5);
        i.putExtra("Amount6",Amount6);
        i.putExtra("Amount7",Amount7);
        i.putExtra("Amount8",Amount8);
        i.putExtra("Amount9",Amount9);
        i.putExtra("Amount10",Amount10);
        i.putExtra("Amount11",Amount11);
        i.putExtra("Amount12",Amount12);
        i.putExtra("Area",Area);
        i.putExtra("City",City);
        i.putExtra("Cost",Cost);
        i.putExtra("Date0",Date0);
        i.putExtra("Date1",Date1);
        i.putExtra("Date2",Date2);
        i.putExtra("Date3",Date3);
        i.putExtra("Date4",Date4);
        i.putExtra("Date5",Date5);
        i.putExtra("Date6",Date6);
        i.putExtra("Date7",Date7);
        i.putExtra("Date8",Date8);
        i.putExtra("Date9",Date9);
        i.putExtra("Date10",Date10);
        i.putExtra("Date11",Date11);
        i.putExtra("Date12",Date12);
        i.putExtra("Discount",Discount);
        i.putExtra("Final_Amount",Final_Amount);
        i.putExtra("Flat",Flat);
        i.putExtra("Method",Method);
        i.putExtra("Mobile_Number",Mobile_Number);
        i.putExtra("Password",Password);
        i.putExtra("Pincode",Pincode);
        i.putExtra("Reading0",Reading0);
        i.putExtra("Reading1",Reading1);
        i.putExtra("Reading2",Reading2);
        i.putExtra("Reading3",Reading3);
        i.putExtra("Reading4",Reading4);
        i.putExtra("Reading5",Reading5);
        i.putExtra("Reading6",Reading6);
        i.putExtra("Reading7",Reading7);
        i.putExtra("Reading8",Reading8);
        i.putExtra("Reading9",Reading9);
        i.putExtra("Reading10",Reading10);
        i.putExtra("Reading11",Reading11);
        i.putExtra("Reading12",Reading12);
        i.putExtra("Society",Society);
        i.putExtra("Username",Username);
        i.putExtra("username_password",username_password);
        i.putExtra("Final_Reading",final_reading);
        startActivity(i);
    }

    public void choosen_generate_bill(View view){
        Intent i = new Intent(this,bill.class);
        i.putExtra("Admin",admin);
        i.putExtra("Amount0",Amount0);
        i.putExtra("Amount1",Amount1);
        i.putExtra("Amount2",Amount2);
        i.putExtra("Amount3",Amount3);
        i.putExtra("Amount4",Amount4);
        i.putExtra("Amount5",Amount5);
        i.putExtra("Amount6",Amount6);
        i.putExtra("Amount7",Amount7);
        i.putExtra("Amount8",Amount8);
        i.putExtra("Amount9",Amount9);
        i.putExtra("Amount10",Amount10);
        i.putExtra("Amount11",Amount11);
        i.putExtra("Amount12",Amount12);
        i.putExtra("Area",Area);
        i.putExtra("City",City);
        i.putExtra("Cost",Cost);
        i.putExtra("Date0",Date0);
        i.putExtra("Date1",Date1);
        i.putExtra("Date2",Date2);
        i.putExtra("Date3",Date3);
        i.putExtra("Date4",Date4);
        i.putExtra("Date5",Date5);
        i.putExtra("Date6",Date6);
        i.putExtra("Date7",Date7);
        i.putExtra("Date8",Date8);
        i.putExtra("Date9",Date9);
        i.putExtra("Date10",Date10);
        i.putExtra("Date11",Date11);
        i.putExtra("Date12",Date12);
        i.putExtra("Discount",Discount);
        i.putExtra("Final_Amount",Final_Amount);
        i.putExtra("Flat",Flat);
        i.putExtra("Method",Method);
        i.putExtra("Mobile_Number",Mobile_Number);
        i.putExtra("Password",Password);
        i.putExtra("Pincode",Pincode);
        i.putExtra("Reading0",Reading0);
        i.putExtra("Reading1",Reading1);
        i.putExtra("Reading2",Reading2);
        i.putExtra("Reading3",Reading3);
        i.putExtra("Reading4",Reading4);
        i.putExtra("Reading5",Reading5);
        i.putExtra("Reading6",Reading6);
        i.putExtra("Reading7",Reading7);
        i.putExtra("Reading8",Reading8);
        i.putExtra("Reading9",Reading9);
        i.putExtra("Reading10",Reading10);
        i.putExtra("Reading11",Reading11);
        i.putExtra("Reading12",Reading12);
        i.putExtra("Society",Society);
        i.putExtra("Username",Username);
        i.putExtra("username_password",username_password);
        i.putExtra("Final_Reading",final_reading);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}