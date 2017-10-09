/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.dao;

import com.unisports.database.context.Database;
import com.unisports.entities.Notification;
import com.unisports.enums.NotificationType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danielmontana
 */
public class NotificationDAO {
    
    private Database _database;
    private Connection _connection; 
    
    public NotificationDAO(){
        _database = new Database();
        
        try {
            _connection = _database.connect();
        } catch (SQLException ex) {
            Logger.getLogger(NotificationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean createNotification(Notification notification){
        try {
            PreparedStatement statement = _connection.prepareStatement("INSERT INTO Notifications (Id, Subject, Type, User_Id) VALUES (?, ?, ?, ?);");
            statement.setString(1, notification.getId().toString());
            statement.setString(2, notification.getSubject());
            statement.setInt(3, (notification.getType()).getHashCode());
            statement.setString(4, notification.getUserId().toString());
            
            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(NotificationDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean updateNotification(Notification notification){
        try {
            PreparedStatement statement = _connection.prepareStatement("UPDATE Notifications SET Subject = ?, Type = ?, User_Id = ? WHERE Id = ?;");
            statement.setString(1, notification.getSubject());
            statement.setInt(2, (notification.getType()).getHashCode());
            statement.setString(3, notification.getUserId().toString());
            statement.setString(4, notification.getId().toString());
            
            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(NotificationDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Notification> getAllNotifications(){
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM Notifications;");
            
            ResultSet result = statement.executeQuery();
            
            List<Notification> notifications = new ArrayList<Notification>();
            
            while(result.next()){
                Notification notification = new Notification(UUID.fromString(result.getString("Id")));
                notification.setSubject(result.getString("Subject"));
                notification.setType(NotificationType.values()[result.getInt("Type")]);
                notification.setUserId(UUID.fromString(result.getString("User_Id")));
                notifications.add(notification);
            }
            
            result.close();
            statement.close();
            //_database.Disconnect();
            return notifications;
        } catch (SQLException ex) {
            Logger.getLogger(NotificationDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Notification getNotificationById(UUID id){
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM notifications WHERE Id=?;");
            statement.setString(1, id.toString());
            
            ResultSet result = statement.executeQuery();
            
            Notification notification = null;
            
            if(result.first()){
                notification = new Notification(UUID.fromString(result.getString("Id")));
                notification.setSubject(result.getString("Subject"));
                notification.setType(NotificationType.values()[result.getInt("Type")]);
                notification.setUserId(UUID.fromString(result.getString("User_Id")));
                   
            }
            
            result.close();
            statement.close();
            //_database.Disconnect();
            return notification;
        } catch (SQLException ex) {
            Logger.getLogger(NotificationDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    //Tengo duda sobre este metodo
    
    public List<Notification> getAllNotificationsByUserId(UUID UserId){
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM notifications WHERE User_Id = ?;");
            statement.setString(1, UserId.toString());
            
            ResultSet result = statement.executeQuery();
            
            List<Notification> notifications = new ArrayList<Notification>();
            
            while(result.next()){
                Notification notification = new Notification(UUID.fromString(result.getString("Id")));
                notification.setSubject(result.getString("Subject"));
                notification.setType(NotificationType.values()[result.getInt("Type")]);
                notification.setUserId(UUID.fromString(result.getString("User_Id")));
                notifications.add(notification);
            }
            
            result.close();
            statement.close();
            //_database.Disconnect();
            return notifications;
        } catch (SQLException ex) {
            Logger.getLogger(NotificationDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
