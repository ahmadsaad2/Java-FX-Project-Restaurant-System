package com.example.database;

import javafx.beans.property.*;

public class OrderDetail {
    private final IntegerProperty orderDetailId;
    private final IntegerProperty ORDERID2;
    private final IntegerProperty PRODUCTID;
    private final IntegerProperty QUANTITY;
    private final DoubleProperty PRICE;

    public OrderDetail() {
        this.orderDetailId = new SimpleIntegerProperty();
        this.ORDERID2 = new SimpleIntegerProperty();
        this.PRODUCTID = new SimpleIntegerProperty();
        this.QUANTITY = new SimpleIntegerProperty();
        this.PRICE = new SimpleDoubleProperty();
    }

    public OrderDetail(int orderDetailId, int orderId, int productId, int quantity, double price) {
        this();
        setOrderDetailId(orderDetailId);
        setOrderId(orderId);
        setProductId(productId);
        setQuantity(quantity);
        setPrice(price);
    }

    public int getOrderDetailId() {
        return orderDetailId.get();
    }

    public IntegerProperty orderDetailIdProperty() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId.set(orderDetailId);
    }

    public int getOrderId() {
        return ORDERID2.get();
    }

    public IntegerProperty orderIdProperty() {
        return ORDERID2;
    }

    public void setOrderId(int orderId) {
        this.ORDERID2.set(orderId);
    }

    public int getProductId() {
        return PRODUCTID.get();
    }

    public IntegerProperty productIdProperty() {
        return PRODUCTID;
    }

    public void setProductId(int productId) {
        this.PRODUCTID.set(productId);
    }

    public int getQuantity() {
        return QUANTITY.get();
    }

    public IntegerProperty quantityProperty() {
        return QUANTITY;
    }

    public void setQuantity(int quantity) {
        this.QUANTITY.set(quantity);
    }

    public double getPrice() {
        return PRICE.get();
    }

    public DoubleProperty priceProperty() {
        return PRICE;
    }

    public void setPrice(double price) {
        this.PRICE.set(price);
    }
}
