package com.example.demo;

public class CustomerController {
    int customerAge;
    String customerName, customerGender,customerAddress;
    public CustomerController() {
    }

    public CustomerController(int customerAge, String customerName, String customerGender, String customerAddress) {
        this.customerAge = customerAge;
        this.customerName = customerName;
        this.customerGender = customerGender;
        this.customerAddress = customerAddress;
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
}
