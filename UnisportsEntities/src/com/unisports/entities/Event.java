package com.unisports.entities;

import com.unisports.enums.EventState;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "Event")
public class Event implements Serializable {
    @Id
    private String id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    private String description;
    private double positionX;    
    private double positionY;
    private EventState state;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate;
    private String creatorUserId;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "event", fetch = FetchType.LAZY)
    //private List<TeamInscription> teamInscriptionList;
    @Column(name = "Sport_Id")
    private String sportId;
    @JoinColumn(name = "Sport_Id", referencedColumnName = "Id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sport sport;
    
    public Event(UUID id)
    {
        this.id = id.toString();
    }
    
    public Event()
    {
        this.id = UUID.randomUUID().toString();
    }
    
    public String getId()
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
        this.positionX = pointX;
    }
    
    public double getPositionX()
    {
        return this.positionX;
    }
    
    public void setPositionY(Double pointY)
    {
        this.positionY = pointY;
    }
    
    public double getPositionY()
    {
        return this.positionY;
    }
    
    public void setState(EventState state)
    {
        this.state = state;
    }
    
    public EventState getState()
    {
        return this.state;
    }
    
//    public void addItemToTeamInscriptionList(TeamInscription team)
//    {
//        this.teamInscriptionList.add(team);
//    }
//    
//    public void deleteItemFromTeamInscriptionList(TeamInscription team)
//    {
//        this.teamInscriptionList.remove(team);
//    }
    
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
        this.creatorUserId = id.toString();
    }
    
    public String getCreatorUserId()
    {
        return this.creatorUserId;
    }
    
//    public List<TeamInscription> getTeamInscriptionList()
//    {
//        return this.teamInscriptionList;
//    }
    
    public void setSportId(UUID id)
    {
        this.sportId = id.toString();
    }
    
    public String getSportId()
    {
        return this.sportId;
    }
}
