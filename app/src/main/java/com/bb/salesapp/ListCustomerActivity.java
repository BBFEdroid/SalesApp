package com.bb.salesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bb.salesapp.database.DatabaseHelper;

public class ListCustomerActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_customer);

        databaseHelper = new DatabaseHelper(this);
    }
}