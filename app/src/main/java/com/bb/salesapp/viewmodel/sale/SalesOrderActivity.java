package com.bb.salesapp.viewmodel.sale;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bb.salesapp.R;
import com.bb.salesapp.adapter.ListCustomerAdapter;
import com.bb.salesapp.database.DatabaseHelper;
import com.bb.salesapp.databinding.ActivitySalesOrderBinding;
import com.bb.salesapp.model.CustomerModel;
import com.bb.salesapp.model.SaleModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SalesOrderActivity extends AppCompatActivity {

    private ActivitySalesOrderBinding binding;
    int minteger = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_order);

        findViewById(R.id.add_sales_back).setOnClickListener( v -> finish());

        findViewById(R.id.sale_save_btn).setOnClickListener( v -> {
            DatabaseHelper databaseHelper = new DatabaseHelper(this);
            SaleModel saleModel = new SaleModel();
            saleModel.setSale_cust_name(Objects.requireNonNull(binding.salesCustName.getText()).toString());
            saleModel.setSale_product_name(Objects.requireNonNull(binding.salesProductName.getText()).toString());
            saleModel.setSale_product_qty(Objects.requireNonNull(binding.salesProductName.getText()).toString());
            saleModel.setSale_product_discount(Objects.requireNonNull(binding.salesDiscount.getText()).toString());
            saleModel.setSale_product_total(Objects.requireNonNull(binding.salesTotal.getText()).toString());
            saleModel.setSale_status(Objects.requireNonNull(binding.salesTotal.getText()).toString());
            databaseHelper.insertSale(saleModel);
        });

    }

    public void increaseQuantity(View view) {
        minteger = minteger + 1;
        display(minteger);

    }

    public void decreaseQuantity(View view) {
        minteger = minteger - 1;
        display(minteger);
    }

    @SuppressLint("SetTextI18n")
    private void display(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.sales_number);
        displayInteger.setText("" + number);
    }
}