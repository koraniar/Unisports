/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.bl;

import com.unisports.dao.EventDAO;
import com.unisports.entities.Event;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author danielmontana
 */
public class EventBL {

    EventDAO eventdao;

    public EventBL() {

        eventdao = new EventDAO();
    }
    

    public Event GetEventById(UUID id) {

        Event event = new Event();

        Event ev = eventdao.getEventById(event.getId());
        if (ev != null) {
            return ev;
        } else {
            return null;
        }
    }

    public boolean SaveEvent(Event event) {
        return true;
    }

    public boolean UpdateEvent(Event event) {
        return true;
    }

    public List<Event> GetAllRecentEvents() {

        List<Event> Events = eventdao.getAllEvents();
        if (Events != null && !Events.isEmpty()) {
            return Events;
        } else {
            return null;
        }
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
