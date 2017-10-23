package com.unisports.bl;

import com.unisports.dao.UserDAO;
import com.unisports.entities.User;


public class AuthBL {
    
    UserDAO _userDao;
    
    public AuthBL(){
        _userDao = new UserDAO();
    }
    
    public boolean validateCredentials(String email, String password){
        
        return true;
    }
    
    public User getUserFromToken(String token){
        
        return new User();
    }
    
    private boolean createToken(User user){
        
        return true;
    }
}
