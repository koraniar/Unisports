/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.bl;

import com.unisports.dao.TeamInscriptionDAO;
import com.unisports.entities.TeamInscription;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author koraniar
 */
public class TeamInscriptionBL {
    
    TeamInscriptionDAO _teamInscriptionDao;
    
    public TeamInscriptionBL(){
        _teamInscriptionDao = new TeamInscriptionDAO();
    }
    
    public boolean createInscription(UUID teamId, UUID eventId){
        
        return true;
    }
    
    public boolean updateInscription(TeamInscription inscription){
        
        return true;
    }
    
    public TeamInscription getInscriptionById(UUID inscriptionId){
        
        return new TeamInscription();
    }
    
    public List<TeamInscription> getAllTeamInscription(){
        
        return new ArrayList<TeamInscription>();
    }
    
    public List<TeamInscription> getAllInscriptionsByUserId(UUID userId){
        
        return new ArrayList<TeamInscription>();
    }
    
    public List<TeamInscription> getAllInscriptionsByEventId(UUID eventId){
        
        return new ArrayList<TeamInscription>();
    }
}
