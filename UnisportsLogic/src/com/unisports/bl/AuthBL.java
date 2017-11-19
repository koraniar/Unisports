package com.unisports.bl;

import com.unisports.dao.UserDAO;
import com.unisports.entities.User;
import javafx.util.Pair;


public class AuthBL {
    
    UserDAO _userDao;
    
    public AuthBL(){
        _userDao = new UserDAO();
    }
    
    public Pair<User, String> validateCredentials(String email, String password){
        User user = email.isEmpty() ? null : _userDao.getUserByEmail(email);
        if (user == null) {
            return new Pair<>(null, "El usuario no existe");
        }
        if (!user.getPassword().equals(password)) {
            return new Pair<>(null, "La conbinacion de usuario y contraseña no es valida");
        }
        return new Pair<>(user, createToken(user));
    }
    
    public User getUserFromToken(String token){
        
        return new User();
    }
    
    private String createToken(User user){
        
        return user.getId().toString();
    }
}
