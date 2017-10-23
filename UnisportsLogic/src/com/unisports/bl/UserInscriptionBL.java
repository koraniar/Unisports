package com.unisports.bl;

import com.unisports.entities.UserInscription;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class UserInscriptionBL {
    
    
    
    public UserInscriptionBL(){
        
    }
    
    public boolean createInscription(UUID userId, UUID teamInscriptionId){
        
        return true;
    }
    
    public boolean updateInscription(UserInscription inscription){
        
        return true;
    }
    
    public UserInscription getInscriptionById(UUID inscripcionId){
        
        return new UserInscription();
    }
    
    public List<UserInscription> getAllInscriptions(){
        
        return new ArrayList<UserInscription>();
    }
    
    public List<UserInscription> getAllInscriptionsByUserId(UUID userId){
        
        return new ArrayList<UserInscription>();
    }
    
    public List<UserInscription> getAllInscriptionsByTeamInscriptionId(UUID teamInscriptionId){
        
        return new ArrayList<UserInscription>();
    }
    
    private boolean sendNotificationEmail(UUID userId, String subject, String body){
        //Email Service
        return true;
    }
}
