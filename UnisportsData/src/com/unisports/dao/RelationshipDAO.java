package com.unisports.dao;

import com.unisports.database.context.Database;
import com.unisports.entities.Relationship;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.unisports.enums.RelationshipState;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RelationshipDAO {
    private Database _database;
    private Connection _connection; 
    
    public RelationshipDAO(){
        _database = new Database();
        
        try {
            _connection = _database.connect();
        } catch (SQLException ex) {
            Logger.getLogger(RelationshipDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Relationship> getAllFriendsByUserId(UUID userId){
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM Relationship;");
            
            ResultSet result = statement.executeQuery();
            
            List<Relationship> relationships = new ArrayList<Relationship>();
            
            while(result.next()){
                Relationship relationship = new Relationship(UUID.fromString(result.getString("Id")));
                relationship.setConfirmedDate(result.getDate("ConfirmedDate"));
                relationship.setState(RelationshipState.values()[result.getInt("State")]);
                relationship.setUserId(UUID.fromString(result.getString("UserId")));
                relationship.setUserRelatedId(UUID.fromString(result.getString("UserRelatedId")));
                relationships.add(relationship);
            }
            
            result.close();
            statement.close();
            //_database.Disconnect();
            return relationships;
        } catch (SQLException ex) {
            Logger.getLogger(TeamDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Relationship getRelationshipById(UUID id){
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM relationship WHERE Id=?;");
            statement.setString(1, id.toString());
            
            ResultSet result = statement.executeQuery();
            
            Relationship relationship = null;
            
            if(result.first()){
                relationship = new Relationship(UUID.fromString(result.getString("Id")));
                relationship.setConfirmedDate(result.getDate("ConfirmedDate"));
                relationship.setState(RelationshipState.values()[result.getInt("State")]);
                relationship.setUserId(UUID.fromString(result.getString("UserId")));
                relationship.setUserRelatedId(UUID.fromString(result.getString("UserRelatedId")));
                   
            }
            
            result.close();
            statement.close();
            //_database.Disconnect();
            return relationship;
        } catch (SQLException ex) {
            Logger.getLogger(NotificationDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean createRelationship(Relationship relationship){
        try {
            PreparedStatement statement = _connection.prepareStatement("INSERT INTO Relationship (Id, ConfirmedDate, State, Users_Id, UserRelatedId) VALUES (?, ?, ?, ?, ?);");
            statement.setString(1, relationship.getId().toString());
            statement.setTimestamp(2, new Timestamp(relationship.getConfirmedDate().getTime()));
            statement.setInt(3, (relationship.getState()).getHashCode());
            statement.setString(4, relationship.getUserId().toString());
            statement.setString(5, relationship.getUserRelatedId().toString());
            
            
            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(RelationshipDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean updateRelationship(Relationship relationship){
        try {
            PreparedStatement statement = _connection.prepareStatement("UPDATE Relationship SET ConfirmedDate = ?, State = ?, UserId = ?, UserRelatedId = ? WHERE Id = ?;");
            statement.setTimestamp(1, new Timestamp(relationship.getConfirmedDate().getTime()));
            statement.setInt(2, (relationship.getState()).getHashCode());
            statement.setString(3, relationship.getUserId().toString());
            statement.setString(4, relationship.getUserRelatedId().toString());
            statement.setString(1, relationship.getId().toString());
            
            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(RelationshipDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean deleteRelationship(UUID id){
        try {
            PreparedStatement statement = _connection.prepareStatement("DELETE FROM Relationship WHERE Id = ?;");
            statement.setString(1, id.toString());
            
            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(RelationshipDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
