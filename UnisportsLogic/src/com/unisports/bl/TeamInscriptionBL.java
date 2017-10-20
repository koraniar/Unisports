/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.bl;

import com.unisports.entities.TeamInscription;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author koraniar
 */
public class TeamInscriptionBL {
    
    public TeamInscriptionBL(){
        
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
    
}
