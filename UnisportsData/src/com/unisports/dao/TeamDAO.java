/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.dao;

import com.unisports.database.context.Database;
import com.unisports.entities.Team;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class TeamDAO {
    
    private Database _database;
    private Connection _connection; 
    
    public TeamDAO(){
        _database = new Database();
        
        try {
            _connection = _database.connect();
        } catch (SQLException ex) {
            Logger.getLogger(TeamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean createTeam(Team team){
        
        try {
            PreparedStatement statement = _connection.prepareStatement("INSERT INTO Team (Id, Name, Logo, Motto, Description, Sport_Id) VALUES (?, ?, ?, ?, ?, ?);");
            statement.setString(1, team.getId().toString());
            statement.setString(2, team.getName());
            statement.setString(3, team.getLogo());
            
            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(SportDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public boolean updateTeam(Team team){
        return true;
    }
    
    public boolean getTeamById(UUID Id){
        return true;
    }
   
    public List<Team> getAllTeam(){
        return new ArrayList<Team>();
    }
    
     public List<Team> getTeamByPartOfName(String word){
        return new ArrayList<Team>();
    }
    
     public boolean deleteTeam(UUID Id){
        return true;
    }
}
