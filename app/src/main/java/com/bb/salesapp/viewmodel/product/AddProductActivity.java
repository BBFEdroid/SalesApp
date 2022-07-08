package com.bb.salesapp.viewmodel.product;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bb.salesapp.database.DatabaseHelper;
import com.bb.salesapp.databinding.ActivityAddProductBinding;
import com.bb.salesapp.model.ProductModel;

import java.util.Objects;

public class AddProductActivity extends AppCompatActivity {
    private ActivityAddProductBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addProductBack.setOnClickListener( v -> finish());
        binding.addProductSaveBtn.setOnClickListener( v -> {
            DatabaseHelper databaseHelper = new DatabaseHelper(this);
            ProductModel productModel = new ProductModel();
            productModel.setProduct_name(Objects.requireNonNull(binding.addProductName.getText()).toString());
            productModel.setProduct_stock(Objects.requireNonNull(binding.addProductStock.getText()).toString());
            productModel.setProduct_price(Objects.requireNonNull(binding.addProductPrice.getText()).toString());
            databaseHelper.insertProduct(productModel);
        });
    }
}