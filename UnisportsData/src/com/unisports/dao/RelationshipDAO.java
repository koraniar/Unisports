package com.unisports.dao;

import com.unisports.database.context.Database;
import com.unisports.entities.Relationship;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class RelationshipDAO {
    private Database _database;
    
    public RelationshipDAO(){
        _database = new Database();
    }
    
    public List<Relationship> getAllFriendsByUserId(UUID userId){
        return new ArrayList<Relationship>();
    }
    
    public boolean createRelationship(Relationship relationship){
        return true;
    }
    
    public boolean updateRelationship(Relationship relationship){
        return true;
    }
    
    public boolean deleteRelationship(UUID id){
        return true;
    }
}
