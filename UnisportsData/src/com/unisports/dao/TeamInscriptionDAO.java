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
<<<<<<< HEAD
     private Connection _connection; 
    
    public TeamInscriptionDAO(){
        _database = new Database();
        
=======
     private Connection _connection;
    
    public TeamInscriptionDAO(){
        _database = new Database();
>>>>>>> a15ab44bf081930d625fc11a8c41266c19969d75
        try {
            _connection = _database.connect();
        } catch (SQLException ex) {
            Logger.getLogger(TeamInscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean createTeamInscription(TeamInscription inscription){
        try {
<<<<<<< HEAD
            PreparedStatement statement = _connection.prepareStatement("INSERT INTO TeamInscription (Id, Points, EventId) VALUES (?, ?, ?);");
            statement.setString(1, inscription.getId().toString());
            statement.setInt(2, inscription.getPoints());
            statement.setString(3, (inscription.getEventId()).toString());
=======
            PreparedStatement statement = _connection.prepareStatement("INSERT INTO TeamInscription (Id, Points, Event_Id) VALUES (?, ?, ?);");
            statement.setString(1, inscription.getId().toString());
            statement.setInt(2, inscription.getPoints());
            statement.setString(3, inscription.getEventId().toString());
>>>>>>> a15ab44bf081930d625fc11a8c41266c19969d75
            
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
<<<<<<< HEAD
            PreparedStatement statement = _connection.prepareStatement("UPDATE TeamInscription SET Id = ?, Points = ?, EventId = ? WHERE Id = ?;");
            statement.setString(1, inscription.getId().toString());
            statement.setInt(2, inscription.getPoints());
            statement.setString(3, (inscription.getEventId()).toString());
=======
            PreparedStatement statement = _connection.prepareStatement("UPDATE TeamInscription SET Points = ?, Event_Id = ? WHERE Id = ?;");
            statement.setInt(1, inscription.getPoints());
            statement.setString(2, inscription.getEventId().toString());
            statement.setString(3, inscription.getId().toString());
>>>>>>> a15ab44bf081930d625fc11a8c41266c19969d75
            
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
            
<<<<<<< HEAD
            List<TeamInscription> teamInscriptions = new ArrayList<TeamInscription>();
            
            while(result.next()){
                TeamInscription teamInscription = new TeamInscription(UUID.fromString(result.getString("Id")));
                teamInscription.setPoints(result.getInt("Subject"));
                teamInscription.setEventId(UUID.fromString(result.getString("EventId")));
                teamInscriptions.add(teamInscription);
=======
            List<TeamInscription> inscriptions = new ArrayList<TeamInscription>();
            
            while(result.next()){
                TeamInscription tInscription = new TeamInscription(UUID.fromString(result.getString("Id")));
                tInscription.setPoints(result.getInt("Points"));             
                tInscription.setEventId(UUID.fromString(result.getString("Event_Id")));
                inscriptions.add(tInscription);
>>>>>>> a15ab44bf081930d625fc11a8c41266c19969d75
            }
            
            result.close();
            statement.close();
            //_database.Disconnect();
<<<<<<< HEAD
            return teamInscriptions;
=======
            return inscriptions;
>>>>>>> a15ab44bf081930d625fc11a8c41266c19969d75
        } catch (SQLException ex) {
            Logger.getLogger(TeamInscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
<<<<<<< HEAD
    }
    
    public TeamInscription getTeamInscriptionById(UUID Id){
        return new TeamInscription();
=======
>>>>>>> a15ab44bf081930d625fc11a8c41266c19969d75
    }
    
    public TeamInscription getTeamInscriptionById(UUID id){
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM TeamInscription WHERE Id=?;");
            statement.setString(1, id.toString());
            
            ResultSet result = statement.executeQuery();
            
            TeamInscription tInscription = null;
            
            if(result.first()){
                tInscription = new TeamInscription(UUID.fromString(result.getString("Id")));
                tInscription.setPoints(result.getInt("Points"));             
                tInscription.setEventId(UUID.fromString(result.getString("Event_Id")));
            }
            
            result.close();
            statement.close();
            //_database.Disconnect();
            return tInscription;
        } catch (SQLException ex) {
            Logger.getLogger(TeamInscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<TeamInscription> getAllTeamInscriptionsByEventId(UUID id){
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM TeamInscription WHERE Event_Id = ?;");
            statement.setString(1, id.toString());
            
            ResultSet result = statement.executeQuery();
            
            List<TeamInscription> inscriptions = new ArrayList<TeamInscription>();
            
            while(result.next()){
                TeamInscription tInscription = new TeamInscription(UUID.fromString(result.getString("Id")));
                tInscription.setPoints(result.getInt("Points"));             
                tInscription.setEventId(UUID.fromString(result.getString("Event_Id")));
                inscriptions.add(tInscription);
            }
            
            result.close();
            statement.close();
            //_database.Disconnect();
            return inscriptions;
        } catch (SQLException ex) {
            Logger.getLogger(TeamInscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
