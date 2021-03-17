package com.example.splash.Models;

public class OrdersModel {

    int orderimage;
    String ordername;

    public int getOrderimage() {
        return orderimage;
    }

    public void setOrderimage(int orderimage) {
        this.orderimage = orderimage;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public String getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(String orderprice) {
        this.orderprice = orderprice;
    }

    String orderprice;

    public OrdersModel(int orderimage, String ordername, String orderprice) {
        this.orderimage = orderimage;
        this.ordername = ordername;
        this.orderprice = orderprice;
    }
}
