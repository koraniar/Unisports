/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.dao;

import com.unisports.database.context.Database;
import com.unisports.entities.User;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author danielmontana
 */
public class UserDAO {
    private Database _database;
    
    public UserDAO(){
        _database = new Database();
    }
    
    public boolean createUser(User user){
        return true;
    }
    
    public boolean updateUser(User user){
        return true;
    }
    
    public boolean deleteUser(UUID Id){
        return true;
    }
    
    public User getUserById(UUID Id){
        return new User();
    }
    
    public List<User> getAllUsers(){
        return new ArrayList<User>();
    }
    
    public List<User> getUserByPartOfName(String word){
        return new ArrayList<User>();
    }
    
}
