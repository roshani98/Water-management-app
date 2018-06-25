package com.example.application.watermeter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import org.w3c.dom.Text;


public class bill extends AppCompatActivity {

    private TextView discount0;
    private TextView discount1;
    private TextView discount2;
    private TextView discount3;
    private TextView discount4;
    private TextView discount5;
    private TextView discount6;
    private TextView discount7;
    private TextView discount8;
    private TextView discount9;
    private TextView discount10;
    private TextView discount11;
    private TextView discount12;

    private TextView date0;
    private TextView date1;
    private TextView date2;
    private TextView date3;
    private TextView date4;
    private TextView date5;
    private TextView date6;
    private TextView date7;
    private TextView date8;
    private TextView date9;
    private TextView date10;
    private TextView date11;
    private TextView date12;

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

    private TextView reading0;
    private TextView reading1;
    private TextView reading2;
    private TextView reading3;
    private TextView reading4;
    private TextView reading5;
    private TextView reading6;
    private TextView reading7;
    private TextView reading8;
    private TextView reading9;
    private TextView reading10;
    private TextView reading11;
    private TextView reading12;

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

    private TextView amount0;
    private TextView amount1;
    private TextView amount2;
    private TextView amount3;
    private TextView amount4;
    private TextView amount5;
    private TextView amount6;
    private TextView amount7;
    private TextView amount8;
    private TextView amount9;
    private TextView amount10;
    private TextView amount11;
    private TextView amount12;

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

    private String Discount;
    private String Final_Amount;
    private String Flat;
    private String Method;
    private String Mobile_Number;
    private String Password;
    private String Pincode;

    private String Society;
    private String Username;
    private String username_password;

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        date0 = (TextView) findViewById(R.id.textView4);
        reading0 = (TextView) findViewById(R.id.textView5);
        discount0 = (TextView) findViewById(R.id.textView6);
        amount0 = (TextView) findViewById(R.id.textView7);

        date1 = (TextView) findViewById(R.id.textView8);
        reading1 = (TextView) findViewById(R.id.textView9);
        discount1 = (TextView) findViewById(R.id.textView10);
        amount1 = (TextView) findViewById(R.id.textView11);

        date2 = (TextView) findViewById(R.id.textView12);
        reading2 = (TextView) findViewById(R.id.textView13);
        discount2 = (TextView) findViewById(R.id.textView14);
        amount2 = (TextView) findViewById(R.id.textView15);

        date3 = (TextView) findViewById(R.id.textView16);
        reading3 = (TextView) findViewById(R.id.textView17);
        discount3 = (TextView) findViewById(R.id.textView18);
        amount3 = (TextView) findViewById(R.id.textView19);

        date4 = (TextView) findViewById(R.id.textView20);
        reading4 = (TextView) findViewById(R.id.textView21);
        discount4 = (TextView) findViewById(R.id.textView22);
        amount4 = (TextView) findViewById(R.id.textView23);

        date5 = (TextView) findViewById(R.id.textView24);
        reading5 = (TextView) findViewById(R.id.textView25);
        discount5 = (TextView) findViewById(R.id.textView26);
        amount5 = (TextView) findViewById(R.id.textView27);

        date6 = (TextView) findViewById(R.id.textView28);
        reading6 = (TextView) findViewById(R.id.textView29);
        discount6 = (TextView) findViewById(R.id.textView30);
        amount6 = (TextView) findViewById(R.id.textView31);

        date7 = (TextView) findViewById(R.id.textView32);
        reading7 = (TextView) findViewById(R.id.textView33);
        discount7 = (TextView) findViewById(R.id.textView34);
        amount7 = (TextView) findViewById(R.id.textView35);

        date8 = (TextView) findViewById(R.id.textView36);
        reading8 = (TextView) findViewById(R.id.textView37);
        discount8 = (TextView) findViewById(R.id.textView38);
        amount8 = (TextView) findViewById(R.id.textView39);

        date9 = (TextView) findViewById(R.id.textView40);
        reading9 = (TextView) findViewById(R.id.textView41);
        discount9 = (TextView) findViewById(R.id.textView42);
        amount9 = (TextView) findViewById(R.id.textView43);

        date10 = (TextView) findViewById(R.id.textView44);
        reading10 = (TextView) findViewById(R.id.textView45);
        discount10 = (TextView) findViewById(R.id.textView46);
        amount10 = (TextView) findViewById(R.id.textView47);

        date11 = (TextView) findViewById(R.id.textView48);
        reading11 = (TextView) findViewById(R.id.textView49);
        discount11 = (TextView) findViewById(R.id.textView50);
        amount11 = (TextView) findViewById(R.id.textView51);

        date12 = (TextView) findViewById(R.id.textView52);
        reading12 = (TextView) findViewById(R.id.textView53);
        discount12 = (TextView) findViewById(R.id.textView54);
        amount12 = (TextView) findViewById(R.id.textView55);

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

        if (Date0.length() == 1) {
            setnull(date0,reading0,discount0,amount0);
        }
        else {
            date0.setText(month(Date0));
            Float reading = Float.valueOf(Reading0);
            reading0.setText(String.valueOf(reading));
            Float final_amt = Float.valueOf(Amount0);
            amount0.setText(String.valueOf(final_amt));

            discount0.setText("0");
        }

        if (Date1.length() == 1) {
            setnull(date1,reading1,discount1,amount1);
        }
        else {
            date1.setText(month(Date1));
            Float reading = Float.valueOf(Reading1);
            reading1.setText(String.valueOf(reading));
            Float final_amt = Float.valueOf(Amount1);
            amount1.setText(String.valueOf(final_amt));

            try {
                discount1.setText(String.valueOf(discounted(Date1,Date0,Float.valueOf(Discount))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (Date2.length() == 1) {
            setnull(date2,reading2,discount2,amount2);
        }
        else {
            date2.setText(month(Date2));
            Float reading = Float.valueOf(Reading2);
            reading2.setText(String.valueOf(reading));
            Float final_amt = Float.valueOf(Amount2);
            amount2.setText(String.valueOf(final_amt));

            try {
                discount2.setText(String.valueOf(discounted(Date2,Date1,Float.valueOf(Discount))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (Date3.length() == 1){
            setnull(date3,reading3,discount3,amount3);
        } else {
            date3.setText(month(Date3));
            Float reading = Float.valueOf(Reading3);
            reading3.setText(String.valueOf(reading));
            Float final_amt = Float.valueOf(Amount3);
            amount3.setText(String.valueOf(final_amt));

            try {
                discount3.setText(String.valueOf(discounted(Date3,Date2,Float.valueOf(Discount))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (Date4.length() == 1){
            setnull(date4,reading4,discount4,amount4);
        }else {
            date4.setText(month(Date4));
            Float reading = Float.valueOf(Reading4);
            reading4.setText(String.valueOf(reading));
            Float final_amt = Float.valueOf(Amount4);
            amount4.setText(String.valueOf(final_amt));
            try {
                discount4.setText(String.valueOf(discounted(Date4,Date3,Float.valueOf(Discount))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (Date5.length() == 1){
            setnull(date5,reading5,discount5,amount5);
        }else {
            date5.setText(month(Date5));
            Float reading = Float.valueOf(Reading5);
            reading5.setText(String.valueOf(reading));
            Float final_amt = Float.valueOf(Amount5);
            amount5.setText(String.valueOf(final_amt));

            try {
                discount5.setText(String.valueOf(discounted(Date5,Date4,Float.valueOf(Discount))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (Date6.length() == 1){
            setnull(date6,reading6,discount6,amount6);
        }else {
            date6.setText(month(Date6));
            Float reading = Float.valueOf(Reading6);
            reading6.setText(String.valueOf(reading));
            Float final_amt = Float.valueOf(Amount6);
            amount6.setText(String.valueOf(final_amt));

            try {
                discount6.setText(String.valueOf(discounted(Date6,Date5,Float.valueOf(Discount))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (Date7.length() == 1){
            setnull(date7,reading7,discount7,amount7);
        }else {
            date7.setText(month(Date7));
            Float reading = Float.valueOf(Reading7);
            reading7.setText(String.valueOf(reading));
            Float final_amt = Float.valueOf(Amount7);
            amount7.setText(String.valueOf(final_amt));
            Float discount = final_amt - reading;

            try {
                discount7.setText(String.valueOf(discounted(Date7,Date6,Float.valueOf(Discount))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (Date8.length() == 1){
            setnull(date8,reading8,discount8,amount8);
        }else {
            date8.setText(month(Date2));
            Float reading = Float.valueOf(Reading8);
            reading8.setText(String.valueOf(reading));
            Float final_amt = Float.valueOf(Amount8);
            amount8.setText(String.valueOf(final_amt));

            Float discount = final_amt - reading;

            try {
                discount8.setText(String.valueOf(discounted(Date8,Date7,Float.valueOf(Discount))));
            } catch (ParseException e) {
                e.printStackTrace();
            }        }

        if (Date9.length() == 1){
            setnull(date9,reading9,discount9,amount9);
        }else {
            date9.setText(month(Date9));
            Float reading = Float.valueOf(Reading9);
            reading9.setText(String.valueOf(reading));
            Float final_amt = Float.valueOf(Amount9);
            amount9.setText(String.valueOf(final_amt));
            Float discount = final_amt - reading;

            try {
                discount9.setText(String.valueOf(discounted(Date9,Date8,Float.valueOf(Discount))));
            } catch (ParseException e) {
                e.printStackTrace();
            }        }

        if (Date10.length() == 1){
            setnull(date10,reading10,discount10,amount10);
        }else {
            date10.setText(month(Date10));
            Float reading = Float.valueOf(Reading10);
            reading10.setText(String.valueOf(reading));
            Float final_amt = Float.valueOf(Amount10);
            amount10.setText(String.valueOf(final_amt));

            Float discount = final_amt - reading;

            try {
                discount10.setText(String.valueOf(discounted(Date10,Date9,Float.valueOf(Discount))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (Date11.length() == 1){
            setnull(date11,reading11,discount7,amount11);
        }else {
            date11.setText(month(Date11));
            Float reading = Float.valueOf(Reading11);
            reading11.setText(String.valueOf(reading));
            Float final_amt = Float.valueOf(Amount11);
            amount11.setText(String.valueOf(final_amt));

            try {
                discount11.setText(String.valueOf(discounted(Date11,Date10,Float.valueOf(Discount))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (Date12.length() == 1){
            setnull(date12,reading12,discount12,amount12);
        }else {
            date12.setText(month(Date12));
            Float reading = Float.valueOf(Reading12);
            reading12.setText(String.valueOf(reading));
            Float final_amt = Float.valueOf(Amount12);
            amount12.setText(String.valueOf(final_amt));

            Float discount = final_amt - reading;
            try {
                discount12.setText(String.valueOf(discounted(Date12,Date11,Float.valueOf(Discount))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }

    public void setnull(TextView a,TextView b, TextView c,TextView d){
        a.setText("");
        b.setText("");
        c.setText("");
        d.setText("");
    }

    public String month(String a){
        if(a.charAt(3) == '0'){
            if(a.charAt(4) == '1'){
                return "January";
            }else if(a.charAt(4) == '2'){
                return "February";
            }else if(a.charAt(4) == '3'){
                return "March";
            }else if(a.charAt(4) == '4'){
                return "April";
            }else if(a.charAt(4) == '5'){
                return "May";
            }else if(a.charAt(4) == '6'){
                return "June";
            }else if(a.charAt(4) == '7'){
                return "July";
            }else if(a.charAt(4) == '8'){
                return "August";
            }else if(a.charAt(4) == '9'){
                return "September";
            }
        }else if(a.charAt(4) == '0'){
            return "October";
        }else if(a.charAt(4)=='1'){
            return "November";
        }
        return "December";
    }

    public float discounted(String date0 , String date1 , float discount) throws ParseException {
        long days;
        DateFormat format = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
        Date one = format.parse(date0);
        Date two = format.parse(date1);
        Calendar cCal = Calendar.getInstance();
        cCal.setTime(one);
        int Year0 = cCal.get(Calendar.YEAR);
        int Month0 = cCal.get(Calendar.MONTH);
        int Day0 = cCal.get(Calendar.DAY_OF_MONTH);
        Calendar eCal = Calendar.getInstance();
        eCal.setTime(two);
        int Year1 = eCal.get(Calendar.YEAR);
        int Month1 = eCal.get(Calendar.MONTH);
        int Day1 = eCal.get(Calendar.DAY_OF_MONTH);
        Calendar date2 = Calendar.getInstance();
        Calendar date3 = Calendar.getInstance();
        date2.clear();
        date2.set(Year0,Month0,Day0);
        date3.clear();
        date3.set(Year1,Month1,Day1);
        days = date2.getTimeInMillis() - date3.getTimeInMillis();
        days = days/(24 * 60 * 60 * 1000);

        return discount*days;
    }
}