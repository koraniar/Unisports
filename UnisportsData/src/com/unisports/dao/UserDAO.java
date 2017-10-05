/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.dao;

import com.unisports.database.context.Database;
import com.unisports.entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danielmontana
 */
public class UserDAO {
    private Database _database;
    private Connection _connection;
    
    public UserDAO(){
        _database = new Database();
        try {
            _connection = _database.connect();
        } catch (SQLException ex) {
            Logger.getLogger(SportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean createUser(User user){
        try {
            PreparedStatement statement = _connection.prepareStatement("INSERT INTO User (Id, Name, LastName, Email, ContactPhone, Address, BornDate, Password, OverallRate, ExcellentAverage, RegularAverage, BadAverage, NonAttendanceAverage) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            statement.setString(1, user.getId().toString());
            statement.setString(2, user.getName());
            statement.setString(3, user.getLastName());  
            statement.setString(4, user.getEmail()); 
            
            if (user.getcontactPhone()!= null) {
                statement.setString(5, user.getcontactPhone());
            }else{
                statement.setNull(5, java.sql.Types.INTEGER);
            }
            
            if (user.getAddress()!= null) {
                statement.setString(6, user.getAddress());
            }else{
                statement.setNull(6, java.sql.Types.INTEGER);
            }
            
            if (user.getbornDate()!= null) {
                statement.setTimestamp(7, new Timestamp(user.getbornDate().getTime()));
            }else{
                statement.setNull(7, java.sql.Types.INTEGER);
            }
            
            statement.setString(8, user.getPassword());
            statement.setDouble(9, user.getOveralRate());
            statement.setDouble(10, user.getExcellentAverage());
            statement.setDouble(11, user.getRegularAverage());
            statement.setDouble(12, user.getBadAverage());
            statement.setDouble(13, user.getNonAttendanceAverage());

            
            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(SportDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
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
