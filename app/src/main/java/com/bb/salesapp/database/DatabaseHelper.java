package com.bb.salesapp.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.bb.salesapp.model.CustomerModel;
import com.bb.salesapp.model.ProductModel;
import com.bb.salesapp.model.SaleModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Currency;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME ="sales_db";
    private static final String table_customer= "customer";
    private static final String table_product= "product";
    private static final String table_sale= "sale";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
//        Create Tables
        String customer = "CREATE TABLE "+table_customer+"(id INTEGER PRIMARY KEY AUTOINCREMENT, cust_name TEXT, cust_contact TEXT, cust_address TEXT)";
        String product = "CREATE TABLE "+table_product+"(id INTEGER PRIMARY KEY AUTOINCREMENT, product_name TEXT, product_stock TEXT, product_price TEXT)";
        String sale = "CREATE TABLE "+table_sale+"(id INTEGER PRIMARY KEY AUTOINCREMENT, sale_cust_name TEXT, sale_product_name TEXT, sale_product_qty INETEGER, sale_product_discount INTEGER, sale_product_total INTEGER, sale_status TEXT)";
        db.execSQL(customer);
        db.execSQL(product);
        db.execSQL(sale);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        Drop Existing Table
        db.execSQL("DROP TABLE IF EXISTS "+table_customer);
        db.execSQL("DROP TABLE IF EXISTS "+table_product);
        db.execSQL("DROP TABLE IF EXISTS "+table_sale);
        onCreate(db);

    }

    public boolean insertCustomer(CustomerModel customerModel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues  = new ContentValues();
        contentValues.put("cust_name", customerModel.getCust_name());
        contentValues.put("cust_contact", customerModel.getCust_contact());
        contentValues.put("cust_address", customerModel.getCust_address());
        sqLiteDatabase.insert(table_customer, null, contentValues);
        return true;
    }

    public boolean insertProduct(ProductModel productModel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues  = new ContentValues();
        contentValues.put("product_name", productModel.getProduct_name());
        contentValues.put("product_stock", productModel.getProduct_stock());
        contentValues.put("product_price", productModel.getProduct_price());
        sqLiteDatabase.insert(table_product, null, contentValues);
        return true;
    }

    public boolean insertSale(SaleModel saleModel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues  = new ContentValues();
        contentValues.put("sale_cust_name", saleModel.getSale_cust_name());
        contentValues.put("sale_product_name", saleModel.getSale_product_name());
        contentValues.put("sale_product_qty", saleModel.getSale_product_qty());
        contentValues.put("sale_product_discount", saleModel.getSale_product_discount());
        contentValues.put("sale_product_total", saleModel.getSale_product_total());
        contentValues.put("sale_status", saleModel.getSale_status());
        sqLiteDatabase.insert(table_sale, null, contentValues);
        return true;
    }

    @SuppressLint("Range")
    public ArrayList<CustomerModel> getAllCustomers() {
        ArrayList<CustomerModel> list = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + table_customer;
        try (SQLiteDatabase db = this.getReadableDatabase()) {
            try (Cursor cursor = db.rawQuery(selectQuery, null)) {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        CustomerModel customerModel = new CustomerModel();
                        customerModel.setId(cursor.getInt(0));
                        customerModel.setCust_name(cursor.getString(cursor.getColumnIndex("cust_name")));
                        customerModel.setCust_contact(cursor.getString(cursor.getColumnIndex("cust_contact")));
                        customerModel.setCust_address(cursor.getString(cursor.getColumnIndex("cust_address")));
                        list.add(customerModel);
                    } while (cursor.moveToNext());
                }

            }

        }


        return list;
    }

    @SuppressLint("Range")
    public ArrayList<ProductModel> getAllProducts() {
        ArrayList<ProductModel> list = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + table_product;
        try (SQLiteDatabase db = this.getReadableDatabase()) {
            try (Cursor cursor = db.rawQuery(selectQuery, null)) {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        ProductModel productModel = new ProductModel();
                        productModel.setId(cursor.getInt(0));
                        productModel.setProduct_name(cursor.getString(cursor.getColumnIndex("product_name")));
                        productModel.setProduct_stock(cursor.getString(cursor.getColumnIndex("product_stock")));
                        productModel.setProduct_price(cursor.getString(cursor.getColumnIndex("product_price")));
                        list.add(productModel);
                    } while (cursor.moveToNext());
                }

            }

        }

        return list;
    }

    @SuppressLint("Range")
    public ArrayList<SaleModel> getAllSales() {
        ArrayList<SaleModel> list = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + table_sale;
        try (SQLiteDatabase db = this.getReadableDatabase()) {
            try (Cursor cursor = db.rawQuery(selectQuery, null)) {
                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        SaleModel saleModel = new SaleModel();
                        saleModel.setId(cursor.getInt(0));
                        saleModel.setSale_cust_name(cursor.getString(cursor.getColumnIndex("sale_cust_name")));
                        saleModel.setSale_product_name(cursor.getString(cursor.getColumnIndex("sale_product_name")));
                        saleModel.setSale_product_qty(cursor.getInt(cursor.getColumnIndex("sale_product_qty")));
                        saleModel.setSale_product_discount(cursor.getInt(cursor.getColumnIndex("sale_product_discount")));
                        saleModel.setSale_product_total(cursor.getInt(cursor.getColumnIndex("sale_product_total")));
                        saleModel.setSale_status(cursor.getString(cursor.getColumnIndex("sale_status")));
                        list.add(saleModel);
                    } while (cursor.moveToNext());
                }

            }

        }

        return list;
    }

}