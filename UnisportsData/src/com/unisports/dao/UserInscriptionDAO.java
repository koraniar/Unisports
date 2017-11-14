/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.dao;

import com.unisports.database.context.Database;
import com.unisports.entities.UserInscription;
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
public class UserInscriptionDAO {
    private Database _database;
    private Connection _connection;
    
    public UserInscriptionDAO(){
        _database = new Database();
        try {
            _connection = _database.connect();
        } catch (SQLException ex) {
            Logger.getLogger(UserInscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean createUserInscription(UserInscription inscription){
        try {
            PreparedStatement statement = _connection.prepareStatement("INSERT INTO UserInscription (Id, Confirmed, Users_Id, TeamInscription_Id) VALUES (?, ?, ?, ?);");
            statement.setString(1, inscription.getId().toString());
            statement.setBoolean(2, inscription.getConfirmed());
            statement.setString(3, inscription.getUserId().toString());
            statement.setString(4, inscription.getTeamInscriptionId().toString());
            
            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UserInscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean updateUserInscription(UserInscription inscription){
        try {
            PreparedStatement statement = _connection.prepareStatement("UPDATE UserInscription SET Confirmed = ?, Users_Id = ?, TeamInscription_Id = ? WHERE Id = ?;");
            statement.setBoolean(1, inscription.getConfirmed());
            statement.setString(2, inscription.getUserId().toString());
            statement.setString(3, inscription.getTeamInscriptionId().toString());
            statement.setString(4, inscription.getId().toString());
            
            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UserInscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean deleteUserInscription(UUID id){
        try {
            PreparedStatement statement = _connection.prepareStatement("DELETE FROM UserInscription WHERE Id = ?;");
            statement.setString(1, id.toString());
            
            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TeamInscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public UserInscription getUserInscriptionById(UUID id){
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM UserInscription WHERE Id=?;");
            statement.setString(1, id.toString());
            
            ResultSet result = statement.executeQuery();
            
            UserInscription uInscription = null;
            
            if(result.next()){
                uInscription = new UserInscription(UUID.fromString(result.getString("Id")));
                uInscription.setConfirmed(result.getBoolean("Confirmed"));             
                uInscription.setUserId(UUID.fromString(result.getString("Users_Id")));
                uInscription.setTeamInscriptionId(UUID.fromString(result.getString("TeamInscription_Id")));
            }
            
            result.close();
            statement.close();
            //_database.Disconnect();
            return uInscription;
        } catch (SQLException ex) {
            Logger.getLogger(UserInscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<UserInscription> getAllUserInscriptions(){
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM UserInscription;");
            
            ResultSet result = statement.executeQuery();
            
            List<UserInscription> inscriptions = new ArrayList<UserInscription>();
            
            while(result.next()){
                UserInscription uInscription = new UserInscription(UUID.fromString(result.getString("Id")));
                uInscription.setConfirmed(result.getBoolean("Confirmed"));             
                uInscription.setUserId(UUID.fromString(result.getString("Users_Id")));
                uInscription.setTeamInscriptionId(UUID.fromString(result.getString("TeamInscription_Id")));
                inscriptions.add(uInscription);
            }
            
            result.close();
            statement.close();
            //_database.Disconnect();
            return inscriptions;
        } catch (SQLException ex) {
            Logger.getLogger(UserInscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<UserInscription> getAllUserInscriptionsByUserId(UUID userId){
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM UserInscription WHERE Users_Id = ?;");
            statement.setString(1, userId.toString());
            
            ResultSet result = statement.executeQuery();
            
            List<UserInscription> inscriptions = new ArrayList<UserInscription>();
            
            while(result.next()){
                UserInscription uInscription = new UserInscription(UUID.fromString(result.getString("Id")));
                uInscription.setConfirmed(result.getBoolean("Confirmed"));             
                uInscription.setUserId(UUID.fromString(result.getString("Users_Id")));
                uInscription.setTeamInscriptionId(UUID.fromString(result.getString("TeamInscription_Id")));
                inscriptions.add(uInscription);
            }
            
            result.close();
            statement.close();
            //_database.Disconnect();
            return inscriptions;
        } catch (SQLException ex) {
            Logger.getLogger(UserInscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<UserInscription> getAllUserInscriptionsByTeamInscriptionId(UUID teamInscriptionId){
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM UserInscription WHERE TeamInscription_Id = ?;");
            statement.setString(1, teamInscriptionId.toString());
            
            ResultSet result = statement.executeQuery();
            
            List<UserInscription> inscriptions = new ArrayList<UserInscription>();
            
            while(result.next()){
                UserInscription uInscription = new UserInscription(UUID.fromString(result.getString("Id")));
                uInscription.setConfirmed(result.getBoolean("Confirmed"));             
                uInscription.setUserId(UUID.fromString(result.getString("Users_Id")));
                uInscription.setTeamInscriptionId(UUID.fromString(result.getString("TeamInscription_Id")));
                inscriptions.add(uInscription);
            }
            
            result.close();
            statement.close();
            //_database.Disconnect();
            return inscriptions;
        } catch (SQLException ex) {
            Logger.getLogger(UserInscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
