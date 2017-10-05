package com.unisports.entities;

import com.unisports.enums.EventState;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class Event {
    private UUID id;
    private Date date;
    private String description;
    private double positioinX;    
    private double positioinY;
    private EventState state;
    private Date createdDate;
    private UUID creatorUserId;
    private List<TeamInscription> teamInscriptionList;
    private UUID sportId;
    
    public Event(UUID id)
    {
        this.id = id;
    }
    
    public Event()
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
    
    public void addItemToTeamInscriptionList(TeamInscription team)
    {
        this.teamInscriptionList.add(team);
    }
    
    public void deleteItemFromTeamInscriptionList(TeamInscription team)
    {
        this.teamInscriptionList.remove(team);
    }
    
    public void setCreatedDate(Date date)
    {
        this.createdDate = date;
    }
    
    public Date getCreatedDate()
    {
        return this.createdDate;
    }
    
    public void setCreatorUserId(UUID id)
    {
        this.creatorUserId = id;
    }
    
    public UUID getCreatorUserId()
    {
        return this.creatorUserId;
    }
    
    public List<TeamInscription> getTeamInscriptionList()
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
