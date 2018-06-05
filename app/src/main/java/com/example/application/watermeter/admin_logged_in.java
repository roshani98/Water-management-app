package com.example.application.watermeter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class admin_logged_in extends AppCompatActivity {

    private TextView admin_username;
    private Button change;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_logged_in);
//        change = (Button)findViewById(R.id.change);
//        Intent intent = getIntent();
//        String username = intent.getStringExtra("Username");
//        String password = intent.getStringExtra("Password");
//        String society = intent.getStringExtra("Society");
//        String cost = intent.getStringExtra("Cost");

//        admin_username = (TextView) findViewById(R.id.admin_username);
//        admin_username.setText("Welcome to your dashboard\n");

//        change.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
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
    }

    @Override
    public void onBackPressed() {
        //super.activity();
        //super.onBackPressed();
        finish();
    }

    public void choosen_add_user(View view) {

//        Intent intent = getIntent();
//        String Area = intent.getStringExtra("Area");
//        String Cost = intent.getStringExtra("Cost");
//        String Discount = intent.getStringExtra("Discount");
//        String Method = intent.getStringExtra("Method");
//        String Password = intent.getStringExtra("Password");
//        String Pincode = intent.getStringExtra("Pincode");
//        String Society = intent.getStringExtra("Society");
//        String Username = intent.getStringExtra("Username");
//        String City = intent.getStringExtra("City");
//        String username_password = intent.getStringExtra("username_password");
//        String username = intent.getStringExtra("username");
//        String password = intent.getStringExtra("password");
////      String society = intent.getStringExtra("society");
//        String cost = intent.getStringExtra("cost");

        Intent i = new Intent(getApplicationContext(), user_signup.class);
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
//        i.putExtra("username", username);
//        i.putExtra("password", password);
//        i.putExtra("society",society);
//        i.putExtra("cost",cost);
        startActivity(i);
        finish();
    }

    public void choosen_add_user_data(View view){

//        Intent intent = getIntent();
//        String username = intent.getStringExtra("username");
//        String password = intent.getStringExtra("password");
//        String society = intent.getStringExtra("society");
//        String Area = intent.getStringExtra("Area");
//        String Cost = intent.getStringExtra("Cost");
//        String Discount = intent.getStringExtra("Discount");
//        String Method = intent.getStringExtra("Method");
//        String Password = intent.getStringExtra("Password");
//        String Pincode = intent.getStringExtra("Pincode");
//        String Society = intent.getStringExtra("Society");
//        String Username = intent.getStringExtra("Username");
//        String City = intent.getStringExtra("City");
//        String username_password = intent.getStringExtra("username_password");

        Intent i = new Intent(getApplicationContext(), add_user_data.class);
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
//        i.putExtra("username", username);
//        i.putExtra("password", password);
//        i.putExtra("society",society);
        startActivity(i);
        finish();
    }
}