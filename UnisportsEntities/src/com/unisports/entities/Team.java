package com.unisports.entities;

import java.util.List;
import java.util.UUID;


public class Team {
    
    private UUID id;
    private String name;
    private String logo;
    private String motto;
    private String description;
    private UUID sportId;
    private List<User> userList;
    
    public Team (){
        this.id = UUID.randomUUID();
    }
    
    public Team(UUID id){
        this.id = id;
    }
    
    public UUID getId(){
        return this.id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setLogo(String path){
        this.logo = path;
    }
    
    public String getLogo(){
        return this.logo;
    }
    
    public void setMotto(String motto){
        this.motto = motto;
    }
    
    public String getMotto(){
        return this.motto;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public void setSportId(UUID sportId){
        this.sportId = sportId;
    }
    
    public UUID getSportId(){
        return this.sportId;
    }
    
    public void addItemToUserList(User user){
        this.userList.add(user);
    }
    
    public void deleteItemFromUserList(User user){
        this.userList.remove(user);
    }
    
    public List<User> getUserList(){
        return this.userList;
    }
}
