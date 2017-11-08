package com.unisports.entities;

import com.unisports.enums.SportType;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;


@Entity
public class Sport implements Serializable {
    @Id
    private String id;
    private String name;
    private SportType type;
    
    public Sport(){
        this.id = UUID.randomUUID().toString();
    }
    
    public Sport(UUID id){
        this.id = id.toString();
    }
    
    public String getId(){
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
