package com.unisports.dao;

import com.unisports.database.context.Database;
import com.unisports.entities.Sport;
import com.unisports.enums.SportType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class SportDAO {
    private Database _database;
    private Connection _connection;
    
    public SportDAO() throws SQLException{
        _database = new Database();
        _connection = _database.connect();
    }
    
    public boolean createSport(Sport sport) throws SQLException{
        PreparedStatement statement = _connection.prepareStatement("INSERT INTO Sport (Id, Name, Type) VALUES (?, ?, ?);");
        statement.setString(1, sport.getId().toString());        
        statement.setString(2, sport.getName());
        statement.setInt(3, sport.getType().getHashCode());

        int result = statement.executeUpdate();
        return result > 0;
    }
    
    public boolean updateSport(Sport sport){
        return true;
    }
    
    public Sport getSportById(UUID id){
        return new Sport();
    }
    
    public List<Sport> getAllSports(){
        return new ArrayList<Sport>();
    }
    
    public boolean deleteSport(UUID id){
        return true;
    }
    
    public List<Sport> getSportsByType(SportType type){
        return new ArrayList<Sport>();
    }
}
