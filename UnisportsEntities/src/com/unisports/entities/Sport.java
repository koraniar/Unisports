package com.unisports.entities;

import com.unisports.enums.SportType;
import java.util.UUID;


public class Sport {
    private UUID id;
    private String name;
    private SportType type;
    
    public Sport(){
        this.id = UUID.randomUUID();
    }
    
    public Sport(UUID id){
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
    
    public void setType(SportType type){
        this.type = type;
    }
    
    public SportType getType(){
        return this.type;
    }
}
