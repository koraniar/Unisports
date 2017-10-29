/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.bl;

import com.unisports.dao.EventDAO;
import com.unisports.entities.Event;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author danielmontana
 */
public class EventBL {
    
    EventDAO eventdao;
    
    public EventBL(){
        
        eventdao = new EventDAO();
        
    };
    
    

    public boolean GetEventById(UUID id) {
        return true;
    }

    public boolean SaveEvent(Event event) {
        return true;
    }

    public boolean UpdateEvent(Event event) {
        return true;
    }

    public List<Event> GetAllRecentEvents() {
        
        eventdao.getAllEvents();
        
        List<Event> Events = eventdao.getAllEvents();
        if (Events != null && !Events.isEmpty()) {
            System.out.println("\nAll Team Inscriptions " + Events.size());
        } else {
            System.out.println("\nNo there team inscriptions");
        }
        
        return Events;
    }

    public boolean DisableOrDeleteEvent(UUID id) {
        return true;
    }

    public boolean AddResultToEvent(UUID eventId, UUID teamInscriptionId, int result) {
        return true;
    }

    public boolean AddTeamToEvent(UUID eventId, UUID teamId) {
        return true;
    }

    private boolean SendNotificationEmail(UUID userId, String subject, String body) {
        return true;
    }

}
