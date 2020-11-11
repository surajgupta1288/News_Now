package com.internship.newsfetcher;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {
    Button mBtnEntertainment;
    Button mBtnSports;
    Button mBtnScience;
    Button mBtnBusiness;
    Button mBtnTechnology;
    Button mBtnHealth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        mBtnEntertainment=findViewById(R.id.btn_entertainment);
        mBtnSports=findViewById(R.id.btn_sports);
        mBtnScience=findViewById(R.id.btn_science);
        mBtnBusiness=findViewById(R.id.btn_bussiness);
        mBtnTechnology=findViewById(R.id.btn_technology);
        mBtnHealth=findViewById(R.id.btn_helth);
        mBtnTechnology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this,MainActivity.class);
                intent.putExtra("TYPE","Technology");
                startActivity(intent);
            }
        });
        mBtnEntertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this,MainActivity.class);
                intent.putExtra("TYPE","Entertainment");
                startActivity(intent);
            }
        });
        mBtnSports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                intent.putExtra("TYPE", "Sports");
                startActivity(intent);

            }
        });
        mBtnScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                intent.putExtra("TYPE", "Science");
                startActivity(intent);

            }
        });
        mBtnBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                intent.putExtra("TYPE", "Business");
                startActivity(intent);

            }
        });
        mBtnHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                intent.putExtra("TYPE", "Health");
                startActivity(intent);
            }
        });
    }
}