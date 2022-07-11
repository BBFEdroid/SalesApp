package com.bb.salesapp.model;

public class SaleModel {
    int Id;
    String sale_cust_name;
    String sale_product_name;
    String sale_product_qty;
    String sale_product_discount;
    String sale_product_total;
    String sale_status;

    public SaleModel(String sale_cust_name, String sale_product_name, String sale_product_qty, String sale_product_discount, String sale_product_total, String sale_status) {
    }

    public SaleModel() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getSale_cust_name() {
        return sale_cust_name;
    }

    public void setSale_cust_name(String sale_cust_name) {
        this.sale_cust_name = sale_cust_name;
    }

    public String getSale_product_name() {
        return sale_product_name;
    }

    public void setSale_product_name(String sale_product_name) {
        this.sale_product_name = sale_product_name;
    }

    public String getSale_product_qty() {
        return sale_product_qty;
    }

    public void setSale_product_qty(String sale_product_qty) {
        this.sale_product_qty = sale_product_qty;
    }

    public String getSale_product_discount() {
        return sale_product_discount;
    }

    public void setSale_product_discount(String sale_product_discount) {
        this.sale_product_discount = sale_product_discount;
    }

    public String getSale_product_total() {
        return sale_product_total;
    }

    public void setSale_product_total(String sale_product_total) {
        this.sale_product_total = sale_product_total;
    }

    public String getSale_status() {
        return sale_status;
    }

    public void setSale_status(String sale_status) {
        this.sale_status = sale_status;
    }
}
