package com.example.demo;

import java.time.LocalDateTime;

public class CustomerDate<E> {

    private String msg;
    private E customers;
    private String status;
    private LocalDateTime time;



    public CustomerDate() {
    }

    public CustomerDate(String msg, E customers, String status, LocalDateTime time) {
        this.msg = msg;
        this.customers = customers;
        this.status = status;
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public E getCustomers() {
        return customers;
    }

    public void setCustomers(E customers) {
        this.customers = customers;
    }
}
