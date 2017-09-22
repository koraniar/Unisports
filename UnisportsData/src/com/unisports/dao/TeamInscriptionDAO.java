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

/**
 *
 * @author danielmontana
 */
public class TeamInscriptionDAO {
    
     private Database _database;
    
    public TeamInscriptionDAO(){
        _database = new Database();
    }
    
    public boolean createTeamInscription(TeamInscription inscription){
        return true;
    }
    
    public boolean updateTeamInscription(TeamInscription inscription){
        return true;
    }
    
    public List<TeamInscription> getAllTeamInscriptions(){
        return new ArrayList<TeamInscription>();
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
