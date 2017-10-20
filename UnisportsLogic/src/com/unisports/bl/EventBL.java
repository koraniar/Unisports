/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.bl;

import com.unisports.entities.Event;
import java.util.UUID;

/**
 *
 * @author danielmontana
 */
public class EventBL {

    public boolean GetEventById(UUID id) {
        return true;
    }

    public boolean SaveEvent(Event event) {
        return true;
    }

    public boolean UpdateEvent(Event event) {
        return true;
    }

    public boolean GetAllRecentEvent() {
        return true;
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
