package com.unisports.bl;

import com.unisports.dao.EventDAO;
import com.unisports.entities.Event;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javafx.util.Pair;

public class EventBL {

    EventDAO eventdao;

    public EventBL() {

        eventdao = new EventDAO();
    }
    

    public Event GetEventById(UUID id) {
        Event event = new Event();
        return eventdao.getEventById(event.getId());
    }

    public Pair<Boolean, String> SaveEvent(Event event) {
        if (event.getDate().before(new Date())) {
            return new Pair<>(false, "La fecha no puede ser anterior a este momento");
        }
        
        if (event.getCreatorUserId() == null) {
            return new Pair<>(false, "Error asociando el evento");
        }
        if (event.getSportId() == null) {
            return new Pair<>(false, "El deporte no es valido");
        }
        
        if (eventdao.createEvent(event)) {
            return new Pair<>(true, "El evento fue creado");
        }
        return new Pair<>(false, "Error creando el evento");
    }

    public boolean UpdateEvent(Event event) {
        return true;
    }

    public List<Event> GetAllRecentEvents() {
        return eventdao.getAllEvents();
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
