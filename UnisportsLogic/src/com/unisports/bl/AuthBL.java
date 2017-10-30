package com.unisports.bl;

import com.unisports.dao.UserDAO;
import com.unisports.entities.User;
import javafx.util.Pair;


public class AuthBL {
    
    UserDAO _userDao;
    
    public AuthBL(){
        _userDao = new UserDAO();
    }
    
    public Pair<Boolean, String> validateCredentials(String email, String password){
        User user = _userDao.getUserByEmail(email);
        if (user == null) {
            return new Pair<>(false, "El usuario no existe");
        }
        if (!user.getPassword().equals(password)) {
            return new Pair<>(false, "La conbinacion de usuario y contraseña no es valida");
        }
        return new Pair<>(true, createToken(user));
    }
    
    public User getUserFromToken(String token){
        
        return new User();
    }
    
    private String createToken(User user){
        
        return "Token";
    }
}
