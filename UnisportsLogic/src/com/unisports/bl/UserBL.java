package com.unisports.bl;

import com.unisports.dao.NotificationDAO;
import com.unisports.dao.UserDAO;
import com.unisports.entities.Notification;
import com.unisports.entities.User;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserBL {
    
    UserDAO _userDao;
    NotificationDAO _notificationDao;
    
    public UserBL(){
        _userDao = new UserDAO();
        _notificationDao = new NotificationDAO();
    }

    public User getUserById(UUID userId) {

        return new User();
    }

    public boolean saveUser(User user) {

        return true;
    }

    public boolean restorePassword(String email) {
        //email service
        return true;
    }
    
    public boolean changePassword(String password, String paswordConfirmation) {
        //email service
        return true;
    }
    
    public boolean updateUser(User user) {
        return true;
    }
    
    public boolean updateUserPhoto(String photo) {
        //Photo service
        return true;
    }
    
    public List<User> getUsersByName(String name) {
        return new ArrayList<User>();
    }
    
    public boolean disableUser(UUID userId) {
        return true;
    }
    
    public boolean sendEmailConfirmation(UUID userId) {
        return true;
    }
    
    public List<Notification> getAllNotificationsByUserId(UUID userId) {
        
        return new ArrayList<Notification>();
    }
}
