package com.bb.salesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.bb.salesapp.adapter.ListCustomerAdapter;
import com.bb.salesapp.database.DatabaseHelper;
import com.bb.salesapp.model.CustomerModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListCustomerActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_cust_btn;

    DatabaseHelper databaseHelper;
    ArrayList<String> cust_name, cust_contact, cust_address;
    ListCustomerAdapter listCustomerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_customer);


        add_cust_btn = findViewById(R.id.list_cust_add_btn);
        add_cust_btn.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddCustomerActivity.class);
            startActivity(intent);
        });

        databaseHelper = new DatabaseHelper(this);
        cust_name = new ArrayList<>();
        cust_contact = new ArrayList<>();
        cust_address = new ArrayList<>();

        listCustomerAdapter = new ListCustomerAdapter();
        recyclerView = findViewById(R.id.list_cust_wrapper);
        recyclerView.setLayoutManager(new LinearLayoutManager(ListCustomerActivity.this));
        recyclerView.setAdapter(listCustomerAdapter);
        displayData();
    }

    void displayData () {
        for(CustomerModel customerModel: databaseHelper.getAllCustomers()) {

            cust_name.add(customerModel.getCust_name());
            cust_contact.add(customerModel.getCust_contact());
            cust_address.add(customerModel.getCust_address());
        }
//        Cursor cursor = (Cursor) databaseHelper.getAllCustomers();
//        if (cursor.getCount() == 0) {
//            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
//        }else {
//            while (cursor.moveToNext()) {
//                cust_name.add(cursor.getString(0));
//                cust_contact.add(cursor.getString(1));
//                cust_address.add(cursor.getString(2));
//            }
//        }

    }
}