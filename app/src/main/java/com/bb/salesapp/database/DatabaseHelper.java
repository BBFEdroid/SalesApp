package com.bb.salesapp.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.bb.salesapp.model.CustomerModel;
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
        String product = "CREATE TABLE "+table_product+"(id INTEGER PRIMARY KEY AUTOINCREMENT, product_name TEXT, product_price TEXT, product_discount TEXT)";
        String sale = "CREATE TABLE "+table_sale+"(id INTEGER PRIMARY KEY AUTOINCREMENT)";
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

    @SuppressLint("Range")
    public ArrayList<CustomerModel> getAllElements() {

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
                        list.add(customerModel);
                    } while (cursor.moveToNext());
                }

            }

        }

        return list;
    }

}
