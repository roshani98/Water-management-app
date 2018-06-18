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
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
//    private Button b;
//    private PdfPCell cell;
//    private String textAnswer;
//    ListView list;
//    private String path;
//    private File dir;
//    private File file;

    private TextView month1;
    private TextView month2;
    private TextView month3;
    private TextView month4;
    private TextView month5;
    private TextView month6;
    private TextView month7;
    private TextView month8;
    private TextView month9;
    private TextView month10;
    private TextView month11;
    private TextView month12;

    private TextView actual1;
    private TextView actual2;

    private TextView after1;

    private TextView reading1;

    private TextView cost1;

    private String Area;
    private String Cost;
    private String Discount;
    private String Method;
    private String Password;
    private String Pincode;
    private String Society;
    private String Username;
    private String City;

    private String Date0;
    private String Date1;

    EditText editText;
    Button button;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;


    private String Reading0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
//        button = (Button) findViewById(R.id.button);

        month1 = (TextView) findViewById(R.id.textView4);
        actual1 = (TextView) findViewById(R.id.textView5);
        after1 = (TextView) findViewById(R.id.textView6);
        cost1 = (TextView) findViewById(R.id.textView7);

        month2 = (TextView) findViewById(R.id.textView8);
        month3 = (TextView) findViewById(R.id.textView12);
        month4 = (TextView) findViewById(R.id.textView16);



        databaseReference = FirebaseDatabase.getInstance().getReference();

        String str = String.valueOf(databaseReference.child("Admin").orderByChild("Username"));

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
        Date0 = intent.getStringExtra("Date0");
        Date1 = intent.getStringExtra("Date1");
        Reading0 = intent.getStringExtra("Reading0");

        if(Date0.charAt(3) == '1' && Date0.charAt(2) == '0') {
            month1.setText("January");
        }
        else if (Date0.charAt(3) == '2' && Date0.charAt(2) == '0') {
            month1.setText("February");
        }
        else if (Date0.charAt(3) == '3') {
            month1.setText("March");
        }
        else if (Date0.charAt(3) == '4') {
            month1.setText("April");
        }
        else if (Date0.charAt(3) == '5') {
            month1.setText("May");
        }
        else if (Date0.charAt(3) == '6') {
            month1.setText("June");
        }
        else if (Date0.charAt(3) == '7') {
            month1.setText("July");
        }
        else if (Date0.charAt(3) == '8') {
            month1.setText("August");
        }
        else if (Date0.charAt(3) == '9') {
            month1.setText("September");
        }
        else if (Date0.charAt(3) == '0') {
            month1.setText("October");
        }
        else if (Date0.charAt(3) == '1') {
            month1.setText("November");
        }
        else if (Date0.charAt(3) == '2') {
            month1.setText("December");
        }
        else if (Date0.charAt(2) == '0' && Date0.charAt(3) == '0') {
            month1.setText("");
        }
        actual1.setText(Reading0);

        Long reading0 = Long.valueOf(Reading0) - Long.valueOf(Discount);
        after1.setText(String.valueOf(reading0));

        cost1.setText(Cost);


        if(Date1.charAt(3) == '1' && Date1.charAt(2) == '0') {
            month2.setText("January");
        }
        else if (Date1.charAt(3) == '2' && Date1.charAt(2) == '0') {
            month2.setText("February");
        }
        else if (Date1.charAt(3) == '3') {
            month2.setText("March");
        }
        else if (Date1.charAt(3) == '4') {
            month2.setText("April");
        }
        else if (Date1.charAt(3) == '5') {
            month2.setText("May");
        }
        else if (Date1.charAt(3) == '6') {
            month2.setText("June");
        }
        else if (Date1.charAt(3) == '7') {
            month2.setText("July");
        }
        else if (Date1.charAt(3) == '8') {
            month2.setText("August");
        }
        else if (Date1.charAt(3) == '9') {
            month2.setText("September");
        }
        else if (Date1.charAt(3) == '0') {
            month2.setText("October");
        }
        else if (Date1.charAt(3) == '1') {
            month2.setText("November");
        }
        else if (Date1.charAt(3) == '2') {
            month2.setText("December");
        }
        else if (Date1.charAt(2) == '0' && Date0.charAt(3) == '0') {
            month2.setText("");
        }
    }


    public void createPdf(View view) {

        Document document = new Document();
        String str = Environment.getExternalStorageDirectory() + "/myPdf.pdf";

        try {
            PdfWriter.getInstance(document,new FileOutputStream(str));
            document.open();
            document.add(new Paragraph(editText.getText().toString()));
            document.setPageSize(PageSize.A4);
            document.addCreationDate();
            document.addAuthor("Android ");
            document.addCreator("Roshani");
            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


}