package com.example.database;

import javafx.beans.property.*;

public class Order {
    private final IntegerProperty storeID;
    private final IntegerProperty orderID;
    private final IntegerProperty CUSTOMERIDS;
    private final StringProperty orderDate;

    public Order(int storeID, int orderID, int customerID, String orderDate) {
        this.storeID = new SimpleIntegerProperty(storeID);
        this.orderID = new SimpleIntegerProperty(orderID);
        this.CUSTOMERIDS = new SimpleIntegerProperty(customerID);
        this.orderDate = new SimpleStringProperty(orderDate);
    }

    public int getStoreID() {
        return storeID.get();
    }

    public IntegerProperty storeIDProperty() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID.set(storeID);
    }

    public int getOrderID() {
        return orderID.get();
    }

    public IntegerProperty orderIDProperty() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID.set(orderID);
    }

    public int getCustomerID() {
        return CUSTOMERIDS.get();
    }

    public IntegerProperty customerIDProperty() {
        return CUSTOMERIDS;
    }

    public void setCustomerID(int customerID) {
        this.CUSTOMERIDS.set(customerID);
    }

    public String getOrderDate() {
        return orderDate.get();
    }

    public StringProperty orderDateProperty() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate.set(orderDate);
    }
}
