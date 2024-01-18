package com.example.database;

import javafx.beans.property.*;

public class Employee {
    private final IntegerProperty employeeID;
    private final IntegerProperty storeID;
    private final StringProperty name;
    private final StringProperty gender;
    private final StringProperty phone;
    private final StringProperty jobTitle;
    private final DoubleProperty salary;

    public Employee() {
        this.employeeID = new SimpleIntegerProperty();
        this.storeID = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.gender = new SimpleStringProperty();
        this.phone = new SimpleStringProperty();
        this.jobTitle = new SimpleStringProperty();
        this.salary = new SimpleDoubleProperty();
    }

    public Employee(int employeeID, int storeID, String name, String gender, String phone, String jobTitle, double salary) {
        this();
        setEmployeeID(employeeID);
        setStoreID(storeID);
        setName(name);
        setGender(gender);
        setPhone(phone);
        setJobTitle(jobTitle);
        setSalary(salary);
    }

    public int getEmployeeID() {
        return employeeID.get();
    }

    public IntegerProperty employeeIDProperty() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID.set(employeeID);
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

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getJobTitle() {
        return jobTitle.get();
    }

    public StringProperty jobTitleProperty() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle.set(jobTitle);
    }

    public double getSalary() {
        return salary.get();
    }

    public DoubleProperty salaryProperty() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary.set(salary);
    }
}
