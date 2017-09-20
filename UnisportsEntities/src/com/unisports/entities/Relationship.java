/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.unisports.entities;

import com.unisports.enums.RelationshipState;
import java.util.Date;
import java.util.UUID;

public class Relationship {
    private UUID id;
    private Date confirmedDate;
    private RelationshipState state;
    private UUID userId;
    private UUID userRelatedId;
    
    public UUID getId()
    {
        return this.id;
    }
    
    private void setId()
    {
        this.userId = UUID.randomUUID();
    }
    
    public Date getConfirmedDate()
    {
        return this.confirmedDate;
    }
    
    public void setConfirmedDate(Date date)
    {
        this.confirmedDate = date;
    }
    
    public RelationshipState getState()
    {
        return this.state;
    }
    
    public void setState(RelationshipState state)
    {
        this.state = state;
    }
    
    public UUID getUserId()
    {
        return this.userId;
    }
    
    public void setUserId(UUID id)
    {
        this.userId = id;
    }
    
    public UUID getUserRelatedId()
    {
        return this.userRelatedId;
    }
    
    public void setUserRelatedId(UUID id)
    {
        this.userRelatedId = id;
    }
}

