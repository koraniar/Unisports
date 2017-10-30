package com.unisports.bl;

import com.unisports.cross.Constants;
import com.unisports.dao.NotificationDAO;
import com.unisports.dao.UserDAO;
import com.unisports.entities.Notification;
import com.unisports.entities.User;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javafx.util.Pair;

public class UserBL {
    
    UserDAO _userDao;
    NotificationDAO _notificationDao;
    
    public UserBL(){
        _userDao = new UserDAO();
        _notificationDao = new NotificationDAO();
    }
    
    public Pair<Boolean, String> createUser(String email, String password, String passwordConfirmation){
        if (email.trim().isEmpty() || !email.contains("@") || !email.contains(".")) {
            return new Pair<>(false, "El correo no es valido");
        }
        if (password.trim().isEmpty() || password.length() < Constants.passwordMinLength) {
            return new Pair<>(false, "La contraseña debe contener minimo " + Constants.passwordMinLength + " caracteres");
        }
        if (passwordConfirmation.trim().isEmpty() || !passwordConfirmation.equals(password)) {
            return new Pair<>(false, "Las contraseñas no coinciden");
        }
        
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setBadAverage(0);
        user.setExcellentAverage(0);
        user.setLastName("");
        user.setName("");
        user.setNonAttendanceAverage(0);
        user.setOveralRate(0);
        user.setRegularAverage(0);
        
        UserDAO userDao = new UserDAO();
        
        if (userDao.createUser(user)) {
            return new Pair<>(true, "El usuario fue creado");
        }
        return new Pair<>(true, "Error inesperado, no se pudo guardar el nuevo usuario");
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
