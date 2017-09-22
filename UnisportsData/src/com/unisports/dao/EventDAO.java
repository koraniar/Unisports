package com.unisports.dao;

import com.unisports.database.context.Database;
import com.unisports.entities.Event;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class EventDAO {
    private Database _database;
    
    public EventDAO(){
        _database = new Database();
    }
    
    public boolean createEvent(Event event){
        return true;
    }
    
    public boolean updateEvent(Event event){
        return true;
    }
    
    public boolean deleteEvent(UUID Id){
        return true;
    }
    
    public Event getEventById(UUID Id){
        return new Event();
    }
    
    public List<Event> getAllEvents(){
        return new ArrayList<Event>();
    }
    
    public List<Event> getEventByPartOfName(String word){
        return new ArrayList<Event>();
    }
}
