package com.unisports.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class User{

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
    private double nonAttendanceAverage;
    private List<Team> teamList;
    private List<UserInscription> userInscriptionList;
    private List<Relationship> relationshipList;
    private List<Notification> notificationList;

    public User() {
        this.id = UUID.randomUUID();
    }
    
    public User(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }
    
    public void setId(UUID id) {
        this.id = id;
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

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactPhone() {
        return this.contactPhone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public Date getBornDate() {
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
    
    public void setNonAttendanceAverage(double average) {
        this.nonAttendanceAverage = average;
    }

    public double getNonAttendanceAverage() {
        return this.nonAttendanceAverage;
    }

    public void addTeamToTeamList(Team team) {
        this.teamList.add(team);
    }

    public void deleteTeamFromTeamList(Team team) {
        this.teamList.remove(team);
    }

    public List<Team> getTeamList() {
        return this.teamList;
    }

    public void addItemToUserInscriptionList(UserInscription inscription) {
        this.userInscriptionList.add(inscription);
    }

    public void deleteItemFromUserInscriptionList(UserInscription userInscriptionId) {
        this.userInscriptionList.remove(userInscriptionId);
    }

    public List<UserInscription> getUserInscriptionList() {
        return this.userInscriptionList;
    }

    public void addItemToRelationshipList(Relationship relationship) {
        this.relationshipList.add(relationship);
    }

    public void deleteItemFromRelationshipList(Relationship relationship) {
        this.relationshipList.remove(relationship);
    }

    public List<Relationship> getRelationshipList() {
        return this.relationshipList;
    }
    
    public void addItemToNotificationList (Notification notification){ //Error.
    this.notificationList.add(notification);
    }

    public void deleteItemFromNotificationList(Notification notification) {
        this.notificationList.remove(notification);
    }

    public List<Notification> getNotificationList() {
        return this.notificationList;
    }

}
