/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.dao;

import com.unisports.database.context.Database;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author danielmontana
 */
public class NotificationDAO {
    
    private Database _database;
    
    public NotificationDAO(){
        _database = new Database();
    }
    
    public boolean createNotification(Notification notification){
        return true;
    }
    
    public boolean updateNotification(Notification notification){
        return true;
    }
    
    public List<Notification> getAllNotifications(){
        return new ArrayList<Notification>();
    }
    
    public Notification getNotificationById(UUID Id){
        return new Notification();
    }
    
    public Notification getAllNotificationsByUserId(UUID Id){
        return new Notification();
    }
    
}
