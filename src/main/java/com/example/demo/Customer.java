package com.example.demo;

public class Customer {
    int customerID, customerAge;
    String customerName, customerGender,customerAddress;

    public Customer() {
    }

    public Customer(int customerAge, String customerName, String customerGender, String customerAddress) {
        this.customerAge = customerAge;
        this.customerName = customerName;
        this.customerGender = customerGender;
        this.customerAddress = customerAddress;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(int customerAge) {
        this.customerAge = customerAge;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID=" + customerID +
                ", Age=" + customerAge +
                ", Name='" + customerName + '\'' +
                ", Gender='" + customerGender + '\'' +
                ", Address='" + customerAddress + '\'' +
                '}';
    }
}
