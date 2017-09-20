/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.entities;

import com.unisports.enums.EventState;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ESTUDIANTE1220T
 */
public class Event {
    private UUID id;
    private Date date;
    private String description;
    private double positioinX;    
    private double positioinY;
    private EventState state;
    private List<String> teamInscriptionList;
    private UUID sportId;
    
    private void setId()
    {
        this.id = UUID.randomUUID();
    }
    
    public UUID getId()
    {
        return this.id;
    }
    
    public void setDate(Date date)
    {
        this.date = date;
    }
    
    public Date getDate()
    {
        return this.date;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public String getDescription()
    {
        return this.description;
    }
    
    public void setPositionX(Double pointX)
    {
        this.positioinX = pointX;
    }
    
    public double getPositionX()
    {
        return this.positioinX;
    }
    
    public void setPositionY(Double pointY)
    {
        this.positioinY = pointY;
    }
    
    public double getPositionY()
    {
        return this.positioinY;
    }
    
    public void setState(EventState state)
    {
        this.state = state;
    }
    
    public EventState getState()
    {
        return this.state;
    }
    
    public void addItemToTeamInscriptionList(String team)
    {
        this.teamInscriptionList.add(team);
    }
    
    public void deleteItemToTeamInscriptionList(String team)
    {
        this.teamInscriptionList.remove(team);
    }
    
    public List<String> getTeamInscriptionList()
    {
        return this.teamInscriptionList;
    }
    
    public void setSportId(UUID id)
    {
        this.sportId = id;
    }
    
    public UUID getSportId()
    {
        return this.sportId;
    }
}
