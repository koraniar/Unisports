package com.unisports.dao;

import com.unisports.database.context.Database;
import com.unisports.entities.Sport;
import com.unisports.enums.SportType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SportDAO {
    private Database _database;
    private Connection _connection;
    
    public SportDAO() {
        _database = new Database();
        try {
            _connection = _database.connect();
        } catch (SQLException ex) {
            Logger.getLogger(SportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean createSport(Sport sport) {
        try {
            PreparedStatement statement = _connection.prepareStatement("INSERT INTO Sport (Id, Name, Type) VALUES (?, ?, ?);");
            statement.setString(1, sport.getId().toString());
            statement.setString(2, sport.getName());
            statement.setInt(3, (sport.getType()).getHashCode());
            
            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(SportDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean updateSport(Sport sport){
        try {
            PreparedStatement statement = _connection.prepareStatement("UPDATE Sport SET Name = ?, Type = ? WHERE Id = ?;");
            statement.setString(1, sport.getName());
            statement.setInt(2, (sport.getType()).getHashCode());
            statement.setString(3, sport.getId().toString());
            
            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(SportDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Sport getSportById(UUID id){
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM Sport WHERE Id=?;");
            statement.setString(1, id.toString());
            
            ResultSet result = statement.executeQuery();
            
            Sport sport = null;
            
            if(result.first()){
                sport = new Sport(UUID.fromString(result.getString("Id")));
                sport.setName(result.getString("Name"));             
                sport.setType(SportType.values()[result.getInt("Type")]);
            }
            
            result.close();
            statement.close();
            //_database.Disconnect();
            return sport;
        } catch (SQLException ex) {
            Logger.getLogger(SportDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<Sport> getAllSports(){
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM Sport;");
            
            ResultSet result = statement.executeQuery();
            
            List<Sport> sports = new ArrayList<Sport>();
            
            while(result.next()){
                Sport sport = new Sport(UUID.fromString(result.getString("Id")));
                sport.setName(result.getString("Name"));           
                sport.setType(SportType.values()[result.getInt("Type")]);
                sports.add(sport);
            }
            
            result.close();
            statement.close();
            //_database.Disconnect();
            return sports;
        } catch (SQLException ex) {
            Logger.getLogger(SportDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean deleteSport(UUID id){
        try {
            PreparedStatement statement = _connection.prepareStatement("DELETE FROM Sport WHERE Id = ?;");
            statement.setString(1, id.toString());
            
            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(SportDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Sport> getSportsByType(SportType type){
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM Sport WHERE Type = ?;");
            statement.setInt(1, type.getHashCode());
            
            ResultSet result = statement.executeQuery();
            
            List<Sport> sports = new ArrayList<Sport>();
            
            while(result.next()){
                Sport sport = new Sport(UUID.fromString(result.getString("Id")));
                sport.setName(result.getString("Name"));               
                sport.setType(SportType.values()[result.getInt("Type")]);
                sports.add(sport);
            }
            
            result.close();
            statement.close();
            //_database.Disconnect();
            return sports;
        } catch (SQLException ex) {
            Logger.getLogger(SportDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
