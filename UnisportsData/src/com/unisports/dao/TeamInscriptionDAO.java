/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.dao;

import com.unisports.database.context.Database;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.unisports.entities.TeamInscription;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danielmontana
 */
public class TeamInscriptionDAO {
    
     private Database _database;
     private Connection _connection; 
    
    public TeamInscriptionDAO(){
        _database = new Database();
        
        try {
            _connection = _database.connect();
        } catch (SQLException ex) {
            Logger.getLogger(TeamInscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean createTeamInscription(TeamInscription inscription){
        try {
            PreparedStatement statement = _connection.prepareStatement("INSERT INTO TeamInscription (Id, Points, EventId) VALUES (?, ?, ?);");
            statement.setString(1, inscription.getId().toString());
            statement.setInt(2, inscription.getPoints());
            statement.setString(3, (inscription.getEventId()).toString());
            
            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TeamInscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean updateTeamInscription(TeamInscription inscription){
        try {
            PreparedStatement statement = _connection.prepareStatement("UPDATE TeamInscription SET Id = ?, Points = ?, EventId = ? WHERE Id = ?;");
            statement.setString(1, inscription.getId().toString());
            statement.setInt(2, inscription.getPoints());
            statement.setString(3, (inscription.getEventId()).toString());
            
            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TeamInscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<TeamInscription> getAllTeamInscriptions(){
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM TeamInscription;");
            
            ResultSet result = statement.executeQuery();
            
            List<TeamInscription> teamInscriptions = new ArrayList<TeamInscription>();
            
            while(result.next()){
                TeamInscription teamInscription = new TeamInscription(UUID.fromString(result.getString("Id")));
                teamInscription.setPoints(result.getInt("Subject"));
                teamInscription.setEventId(UUID.fromString(result.getString("EventId")));
                teamInscriptions.add(teamInscription);
            }
            
            result.close();
            statement.close();
            //_database.Disconnect();
            return teamInscriptions;
        } catch (SQLException ex) {
            Logger.getLogger(TeamInscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public TeamInscription getTeamInscriptionById(UUID Id){
        return new TeamInscription();
    }
    
    public TeamInscription getAllTeamInscriptionsByUserId(UUID Id){
        return new TeamInscription();
    }
    
    public TeamInscription getAllTeamInscriptionsByEventId(UUID Id){
        return new TeamInscription();
    }
    
}
