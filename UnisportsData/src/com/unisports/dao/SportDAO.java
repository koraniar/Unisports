package com.unisports.dao;

import com.unisports.database.context.Database;
import com.unisports.entities.Sport;
import com.unisports.enums.SportType;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class SportDAO {
    private Database _database;
    
    public SportDAO(){
        _database = new Database();
    }
    
    public boolean createSport(Sport sport){
        return true;
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
