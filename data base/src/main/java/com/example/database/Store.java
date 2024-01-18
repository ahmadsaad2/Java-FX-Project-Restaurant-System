package com.example.database;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Store {

    private final IntegerProperty storeID;
    private final StringProperty location;
    private final StringProperty phoneNO;
    private final StringProperty email;

    public Store() {
        this.storeID = new SimpleIntegerProperty();
        this.location = new SimpleStringProperty();
        this.phoneNO = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
    }

    public Store(int storeIdd, String location, String phoneNO, String email) {
        this();
        setstoreID(storeIdd);
        setLocation(location);
        setPhoneNO(phoneNO);
        setEmail(email);
    }

    public int getstoreID() {
        return storeID.get();
    }

    public IntegerProperty storeIddProperty() {
        return storeID;
    }

    public void setstoreID(int storeIdd) {
        this.storeID.set(storeIdd);
    }

    public String getLocation() {
        return location.get();
    }

    public StringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public String getPhoneNO() {
        return phoneNO.get();
    }

    public StringProperty phoneNOProperty() {
        return phoneNO;
    }

    public void setPhoneNO(String phoneNO) {
        this.phoneNO.set(phoneNO);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public void displayStoreInfo() {
        System.out.println("Store ID: " + getstoreID());
        System.out.println("Location: " + getLocation());
        System.out.println("Phone Number: " + getPhoneNO());
        System.out.println("Email: " + getEmail());
    }
}
