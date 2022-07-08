package com.bb.salesapp.viewmodel.customer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bb.salesapp.database.DatabaseHelper;
import com.bb.salesapp.databinding.ActivityAddCustomerBinding;
import com.bb.salesapp.model.CustomerModel;

import java.util.Objects;

public class AddCustomerActivity extends AppCompatActivity {
    private ActivityAddCustomerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddCustomerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addCustBack.setOnClickListener( v -> finish());
        binding.addSaveBtn.setOnClickListener( v -> {
            DatabaseHelper databaseHelper = new DatabaseHelper(this);
            CustomerModel customerModel = new CustomerModel();
            customerModel.setCust_name(Objects.requireNonNull(binding.addCustName.getText()).toString());
            customerModel.setCust_contact(Objects.requireNonNull(binding.addCustContact.getText()).toString());
            customerModel.setCust_address(Objects.requireNonNull(binding.addCustAddress.getText()).toString());
            databaseHelper.insertCustomer(customerModel);
        });
    }
}