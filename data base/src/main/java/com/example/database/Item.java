package com.example.database;

import javafx.beans.property.*;
public class Item {
    private StringProperty item;
    private IntegerProperty qunt;
    private DoubleProperty price;
    private StringProperty supplier;

    public Item(String item, int qunt, double price, String supplier) {
        this.item = new SimpleStringProperty(item);
        this.qunt = new SimpleIntegerProperty(qunt);
        this.price = new SimpleDoubleProperty(price);
        this.supplier = new SimpleStringProperty(supplier);
    }

    public String getItem() {
        return item.get();
    }

    public void setItem(String item) {
        this.item.set(item);
    }

    public int getQunt() {
        return qunt.get();
    }

    public void setQunt(int qunt) {
        this.qunt.set(qunt);
        this.qunt.set(qunt);
    }

    public double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public String getSupplier() {
        return supplier.get();
    }

    public void setSupplier(String supplier) {
        this.supplier.set(supplier);
    }
}
