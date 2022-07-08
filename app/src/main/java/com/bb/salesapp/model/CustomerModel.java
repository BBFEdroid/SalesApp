package com.bb.salesapp.model;

public class CustomerModel {
    int Id;
    String cust_name;
    String cust_contact;
    String cust_address;

    public CustomerModel(String cust_name, String cust_contact, String cust_addres) {

    }

    public CustomerModel() {

    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_contact() {
        return cust_contact;
    }

    public void setCust_contact(String cust_contact) {
        this.cust_contact = cust_contact;
    }

    public String getCust_address() {
        return cust_address;
    }

    public void setCust_address(String cust_address) {
        this.cust_address = cust_address;
    }
}
