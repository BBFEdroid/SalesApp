package com.bb.salesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.bb.salesapp.databinding.ActivityMainBinding;
import com.bb.salesapp.viewmodel.product.AddProductActivity;
import com.bb.salesapp.viewmodel.sale.DetailSalesOrderActivity;
import com.bb.salesapp.viewmodel.customer.ListCustomerActivity;
import com.bb.salesapp.viewmodel.sale.SalesOrderActivity;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.mainCustomer.setOnClickListener(v -> {
            Intent intent = new Intent(this, ListCustomerActivity.class);
            startActivity(intent);
        });

        binding.mainProduct.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddProductActivity.class);
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