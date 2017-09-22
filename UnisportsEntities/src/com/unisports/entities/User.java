package com.unisports.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;


public class User {
    private UUID id;
    private String name;
    private String lastName;
    private String email;
    private String contactPhone;
    private String address;
    private Date bornDate;
    private String password;
    private double overalRate;
    private double excellentAverage;
    private double regularAverage;
    private double badAverage;
    private List<Team> teamList;
    private List<UserInscription> userinscriptionList;
    private List<Relationship> relationshipList;
    private List<String> notificationList;

    public User(){
        this.id = UUID.randomUUID();
    }
    
    public UUID getId() {
        return this.id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setcontactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getcontectPhone() {
        return this.contactPhone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setbornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public Date getbornDate() {
        return this.bornDate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setOveralRate(double overalRate) {
        this.overalRate = overalRate;
    }

    public double getOveralRate() {
        return this.overalRate;
    }

    public void setExcellentAverage(double excellentAverage) {
        this.excellentAverage = excellentAverage;
    }

    public double getExcellentAverage() {
        return this.excellentAverage;
    }

    public void setRegularAverage(double regularAverage) {
        this.regularAverage = regularAverage;
    }

    public double getRegularAverage() {
        return this.regularAverage;
    }

    public void setBadAverage(double badAverage) {
        this.badAverage = badAverage;
    }

    public double getBadAverage() {
        return this.badAverage;
    }
}
