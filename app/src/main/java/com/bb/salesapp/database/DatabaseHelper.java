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
    private static final String DATABASE_NAME = "sales_db";
    private static final String table_customer = "customer";
    private static final String table_product = "product";
    private static final String table_sale = "sale";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        Create Tables
        String customer = "CREATE TABLE " + table_customer + "(id INTEGER PRIMARY KEY AUTOINCREMENT, cust_name TEXT, cust_contact TEXT, cust_address TEXT)";
        String product = "CREATE TABLE " + table_product + "(id INTEGER PRIMARY KEY AUTOINCREMENT, product_name TEXT, product_stock TEXT, product_price TEXT)";
        String sale = "CREATE TABLE " + table_sale + "(id INTEGER PRIMARY KEY AUTOINCREMENT, sale_cust_name TEXT, sale_product_name TEXT, sale_product_qty INETEGER, sale_product_discount INTEGER, sale_product_total INTEGER, sale_status TEXT)";
        db.execSQL(customer);
        db.execSQL(product);
        db.execSQL(sale);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        Drop Existing Table
        db.execSQL("DROP TABLE IF EXISTS " + table_customer);
        db.execSQL("DROP TABLE IF EXISTS " + table_product);
        db.execSQL("DROP TABLE IF EXISTS " + table_sale);
        onCreate(db);

    }

    public boolean insertCustomer(CustomerModel customerModel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cust_name", customerModel.getCust_name());
        contentValues.put("cust_contact", customerModel.getCust_contact());
        contentValues.put("cust_address", customerModel.getCust_address());
        sqLiteDatabase.insert(table_customer, null, contentValues);
        return true;
    }

    public boolean insertProduct(ProductModel productModel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("product_name", productModel.getProduct_name());
        contentValues.put("product_stock", productModel.getProduct_stock());
        contentValues.put("product_price", productModel.getProduct_price());
        sqLiteDatabase.insert(table_product, null, contentValues);
        return true;
    }

    public boolean insertSale(SaleModel saleModel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
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
        ArrayList<CustomerModel> custlist = new ArrayList<>();
        // Select All Query
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + table_customer, null);
        while (cursor.moveToNext()) {
            String cust_name = cursor.getString(0);
            String cust_contact = cursor.getString(1);
            String cust_addres = cursor.getString(2);

            CustomerModel customerModel = new CustomerModel(cust_name, cust_contact, cust_addres);
            custlist.add(customerModel);
        }
        return custlist;

    }

    @SuppressLint("Range")
    public ArrayList<ProductModel> getAllProducts() {
        ArrayList<ProductModel> productlist = new ArrayList<>();
        // Select All Query
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + table_product, null);
        while (cursor.moveToNext()) {
            String product_name = cursor.getString(0);
            String product_stock = cursor.getString(1);
            String product_price = cursor.getString(2);

            ProductModel productModel = new ProductModel(product_name, product_stock, product_price);
            productlist.add(productModel);
        }
        return productlist;

    }

    @SuppressLint("Range")
    public ArrayList<SaleModel> getAllSales() {
        ArrayList<SaleModel> salelist = new ArrayList<>();
        // Select All Query
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + table_sale, null);
        while (cursor.moveToNext()) {
            String sale_cust_name = cursor.getString(0);
            String sale_product_name = cursor.getString(1);
            String sale_product_qty = cursor.getString(2);
            String sale_product_discount = cursor.getString(3);
            String sale_product_total = cursor.getString(4);
            String sale_status = cursor.getString(5);

            SaleModel saleModel = new SaleModel(sale_cust_name,sale_product_name,sale_product_qty,sale_product_discount,sale_product_total,sale_status);
            salelist.add(saleModel);
        }
        return salelist;

    }

}