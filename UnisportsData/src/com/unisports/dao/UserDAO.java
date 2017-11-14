package com.unisports.dao;

import com.unisports.database.context.Database;
import com.unisports.entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserDAO {
    private Database _database;
    private Connection _connection;
    
    public UserDAO(){
        _database = new Database();
        try {
            _connection = _database.connect();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean createUser(User user){
        try {
            PreparedStatement statement = _connection.prepareStatement("INSERT INTO User (Id, Name, LastName, Email, ContactPhone, Address, BornDate, Password, OverallRate," + 
                    " ExcellentAverage, RegularAverage, BadAverage, NonAttendanceAverage) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
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
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean updateUser(User user){
        try {
            PreparedStatement statement = _connection.prepareStatement("UPDATE User SET Name = ?, LastName = ?, Email = ?, ContactPhone = ?, Address = ?, BornDate = ?," + 
                    " Password = ?, OverallRate = ?, ExcellentAverage = ?, RegularAverage = ?, BadAverage = ?, NonAttendanceAverage = ? WHERE Id = ?");
            
            statement.setString(1, user.getName());
            statement.setString(2, user.getLastName());  
            statement.setString(3, user.getEmail()); 
            
            if (user.getcontactPhone()!= null) {
                statement.setString(4, user.getcontactPhone());
            }else{
                statement.setNull(4, java.sql.Types.INTEGER);
            }
            
            if (user.getAddress()!= null) {
                statement.setString(5, user.getAddress());
            }else{
                statement.setNull(5, java.sql.Types.INTEGER);
            }
            
            if (user.getbornDate()!= null) {
                statement.setTimestamp(6, new Timestamp(user.getbornDate().getTime()));
            }else{
                statement.setNull(6, java.sql.Types.INTEGER);
            }
            
            statement.setString(7, user.getPassword());
            statement.setDouble(8, user.getOveralRate());
            statement.setDouble(9, user.getExcellentAverage());
            statement.setDouble(10, user.getRegularAverage());
            statement.setDouble(11, user.getBadAverage());
            statement.setDouble(12, user.getNonAttendanceAverage());
            statement.setString(13, user.getId().toString());

            
            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean deleteUser(UUID id){
        try {
            PreparedStatement statement = _connection.prepareStatement("DELETE FROM User WHERE Id = ?;");
            statement.setString(1, id.toString());
            
            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public User getUserById(UUID id){
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM User WHERE Id=?;");
            statement.setString(1, id.toString());
            
            ResultSet result = statement.executeQuery();
            
            User user = null;
            
            if(result.next()){
                user = new User(UUID.fromString(result.getString("Id")));
                user.setName(result.getString("Name"));
                user.setLastName(result.getString("LastName"));
                user.setEmail(result.getString("Email"));
                user.setcontactPhone(result.getString("ContactPhone"));
                user.setAddress(result.getString("Address"));
                user.setbornDate(result.getDate("BornDate"));
                user.setPassword(result.getString("Password"));
                user.setOveralRate(result.getDouble("OverallRate"));
                user.setExcellentAverage(result.getDouble("ExcellentAverage"));
                user.setRegularAverage(result.getDouble("RegularAverage"));
                user.setBadAverage(result.getDouble("BadAverage"));
                user.setNonAttendanceAverage(result.getDouble("NonAttendanceAverage"));
            }
            
            result.close();
            statement.close();
            //_database.Disconnect();
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<User> getAllUsers(){
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM User;");
            
            ResultSet result = statement.executeQuery();
            
            List<User> users = new ArrayList<User>();
            
            while(result.next()){
                User user = new User(UUID.fromString(result.getString("Id")));
                user.setName(result.getString("Name"));
                user.setLastName(result.getString("LastName"));
                user.setEmail(result.getString("Email"));
                user.setcontactPhone(result.getString("ContactPhone"));
                user.setAddress(result.getString("Address"));
                user.setbornDate(result.getDate("BornDate"));
                user.setPassword(result.getString("Password"));
                user.setOveralRate(result.getDouble("OverallRate"));
                user.setExcellentAverage(result.getDouble("ExcellentAverage"));
                user.setRegularAverage(result.getDouble("RegularAverage"));
                user.setBadAverage(result.getDouble("BadAverage"));
                user.setNonAttendanceAverage(result.getDouble("NonAttendanceAverage"));
                users.add(user);
            }
            
            result.close();
            statement.close();
            //_database.Disconnect();
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<User> getUserByPartOfName(String word){
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM User WHERE LOWER(Name) LIKE ?;");
            statement.setString(1, "%" + word.toLowerCase() + "%");
            
            ResultSet result = statement.executeQuery();
            
            List<User> users = new ArrayList<User>();
            
            while(result.next()){
                User user = new User(UUID.fromString(result.getString("Id")));
                user.setName(result.getString("Name"));
                user.setLastName(result.getString("LastName"));
                user.setEmail(result.getString("Email"));
                user.setcontactPhone(result.getString("ContactPhone"));
                user.setAddress(result.getString("Address"));
                user.setbornDate(result.getDate("BornDate"));
                user.setPassword(result.getString("Password"));
                user.setOveralRate(result.getDouble("OverallRate"));
                user.setExcellentAverage(result.getDouble("ExcellentAverage"));
                user.setRegularAverage(result.getDouble("RegularAverage"));
                user.setBadAverage(result.getDouble("BadAverage"));
                user.setNonAttendanceAverage(result.getDouble("NonAttendanceAverage"));
                users.add(user);
            }
            
            result.close();
            statement.close();
            //_database.Disconnect();
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public User getUserByEmail(String email){
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM User WHERE Email=?;");
            statement.setString(1, email);
            
            ResultSet result = statement.executeQuery();
            
            User user = null;
            
            if(result.next()){
                user = new User(UUID.fromString(result.getString("Id")));
                user.setName(result.getString("Name"));
                user.setLastName(result.getString("LastName"));
                user.setEmail(result.getString("Email"));
                user.setcontactPhone(result.getString("ContactPhone"));
                user.setAddress(result.getString("Address"));
                user.setbornDate(result.getDate("BornDate"));
                user.setPassword(result.getString("Password"));
                user.setOveralRate(result.getDouble("OverallRate"));
                user.setExcellentAverage(result.getDouble("ExcellentAverage"));
                user.setRegularAverage(result.getDouble("RegularAverage"));
                user.setBadAverage(result.getDouble("BadAverage"));
                user.setNonAttendanceAverage(result.getDouble("NonAttendanceAverage"));
            }
            
            result.close();
            statement.close();
            //_database.Disconnect();
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
