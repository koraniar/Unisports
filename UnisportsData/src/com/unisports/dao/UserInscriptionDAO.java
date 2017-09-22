/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.dao;

import com.unisports.database.context.Database;
import com.unisports.entities.UserInscription;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author danielmontana
 */
public class UserInscriptionDAO {
    
    private Database _database;
    
    public UserInscriptionDAO(){
        _database = new Database();
    }
    
    public boolean createUserInscription(UserInscription inscription){
        return true;
    }
    
    public boolean updateTeamInscription(UserInscription inscription){
        return true;
    }
    
    public List<UserInscription> getAllUserInscriptions(){
        return new ArrayList<UserInscription>();
    }
    
    public UserInscription getUserInscriptionById(UUID Id){
        return new UserInscription();
    }
    
    public UserInscription getAllUserInscriptionsByUserId(UUID userId){
        return new UserInscription();
    }
    
    public UserInscription getAllUserInscriptionsByTeamInscriptionId(UUID teamInscriptionId){
        return new UserInscription();
    }
    
    public UserInscription getAllUserInscriptions(UUID teamInscriptionId){
        return new UserInscription();
    }
    
}
