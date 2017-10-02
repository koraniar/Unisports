package com.unisports.dao;

import com.unisports.database.context.Database;
import com.unisports.entities.Event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EventDAO {
    private Database _database;
    private Connection _connection;
    
    public EventDAO() {
        _database = new Database();
        try {
            _connection = _database.connect();
        } catch (SQLException ex) {
            Logger.getLogger(SportDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean createEvent(Event event){
        try {
            PreparedStatement statement = _connection.prepareStatement("INSERT INTO Event (Id, Date, Description, PositionX, PositionY, State, CreatedDate, CreatorUserId, Sport_Id) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
            statement.setString(1, event.getId().toString());
            statement.setDate(2, new java.sql.Date(event.getDate().getTime()));
            statement.setString(3, event.getDescription());  
            statement.setDouble(4, event.getPositionX());            
            statement.setDouble(5, event.getPositionY());
            statement.setInt(5, (event.getState()).getHashCode());
            statement.setDate(6, new java.sql.Date(event.getCreatedDate().getTime()));
            statement.setString(7, event.getCreatorUserId().toString());
            statement.setString(8, event.getSportId().toString());

            
            boolean result = statement.execute();
            statement.close();
            //_database.Disconnect();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(SportDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean updateEvent(Event event){
        try {
            PreparedStatement statement = _connection.prepareStatement("INSERT INTO Event (Id, Date, Description, PositionX, PositionY, State, CreatedDate, CreatorUserId, Sport_Id) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
            statement.setString(1, event.getId().toString());
            statement.setDate(2, new java.sql.Date(event.getDate().getTime()));
            statement.setString(3, event.getDescription());  
            statement.setDouble(4, event.getPositionX());            
            statement.setDouble(5, event.getPositionY());
            statement.setInt(5, (event.getState()).getHashCode());
            statement.setDate(6, new java.sql.Date(event.getCreatedDate().getTime()));
            statement.setString(7, event.getCreatorUserId().toString());
            statement.setString(8, event.getSportId().toString());

            
            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(SportDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean deleteEvent(UUID Id){
        return true;
    }
    
    public Event getEventById(UUID Id){
        return new Event();
    }
    
    public List<Event> getAllEvents(){
        return new ArrayList<Event>();
    }
    
    public List<Event> getEventByPartOfName(String word){
        return new ArrayList<Event>();
    }
}
