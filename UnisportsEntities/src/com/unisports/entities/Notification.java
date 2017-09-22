/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.entities;

import java.util.UUID;

/**
 *
 * @author danielmontana
 */
public class Notification {
    
    private UUID id;
    private String subject;
    private String type;
    private UUID userId;
    
    public Notification()
    {
        this.id = UUID.randomUUID();
    }
    
    public UUID getId(){
        return this.id;
    }
    
    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    
    public String getSubject()
    {
        return this.subject;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getType()
    {
        return this.type;
    }
    
    public void setUserId(UUID userId)
    {
        this.userId = userId;
    }
    
    public UUID getUserId()
    {
        return this.userId;
    }
    
}
