package com.bb.salesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.bb.salesapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.mainCustomer.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddCustomerActivity.class);
            startActivity(intent);
        });

        binding.mainSalesOrder.setOnClickListener(v -> {
            Intent intent = new Intent(this, SalesOrderActivity.class);
            startActivity(intent);
        });

        binding.mainDetailSalesOrder.setOnClickListener(v -> {
            Intent intent = new Intent(this, DetailSalesOrderActivity.class);
            startActivity(intent);
        });
    }
}