package com.unisports.entities;

import java.util.UUID;


public class UserInscription {
    private UUID id;
    private boolean confirmed;
    private UUID userId;
    private UUID teamInscriptionId;
    
    public UserInscription(){
        this.id = UUID.randomUUID();
    }
    
    public UserInscription(UUID id){
        this.id = id;
    }
    
    public UUID getId(){
        return this.id;
    }
    
    public void setConfirmed(boolean confirmed){
        this.confirmed = confirmed;
    }
    
    public boolean getConfirmed(){
        return this.confirmed;
    }
    
    public void setUserId(UUID userId){
        this.userId = userId;
    }
    
    public UUID getUserId(){
        return this.userId;
    }
    
    public void setTeamInscriptionId(UUID inscriptionId){
        this.teamInscriptionId = inscriptionId;
    }
    
    public UUID getTeamInscriptionId(){
        return this.teamInscriptionId;
    }
}
