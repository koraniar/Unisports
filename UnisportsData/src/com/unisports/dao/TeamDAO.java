/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.dao;

import com.unisports.database.context.Database;
import com.unisports.entities.Team;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author danielmontana
 */
public class TeamDAO {
    
    private Database _database;
    
    public TeamDAO(){
        _database = new Database();
    }
    
    public boolean createTeam(Team team){
        return true;
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
