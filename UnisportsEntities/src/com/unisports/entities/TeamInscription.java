package com.unisports.entities;

import java.util.List;
import java.util.UUID;


class TeamInscription {
    private UUID id;
    private int points;
    private UUID eventId;
    private List<String> userInscriptionList;
    
    public TeamInscription(){
        this.id = UUID.randomUUID();
    }
    
    public UUID getId(){
        return this.id;
    }
    
    public void setPoints (int points){
        this.points = points;
    }
    
    public UUID getEventId(){
        return this.eventId;
    }
    
    public void setEventId(UUID eventId){
        this.eventId = eventId;
    }
    
    public void addItemToUserInscriptionList(String user)
    {
        this.userInscriptionList.add(user);
    }
    
    public void deleteItemFromUserInscriptionList(String user)
    {
        this.userInscriptionList.remove(user);
    }
    
    public List<String> getUserInscriptionList()
    {
        return this.userInscriptionList;
    }
}
    
