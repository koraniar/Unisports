/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.test;

import com.unisports.dao.EventDAO;
import com.unisports.dao.SportDAO;
import com.unisports.dao.UserDAO;
import com.unisports.entities.Event;
import com.unisports.entities.Sport;
import com.unisports.entities.User;
import com.unisports.enums.EventState;
import com.unisports.enums.SportType;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author koraniar
 */
public class DatabaseTest {

    public static void main(String[] args) {
        
        DatabaseTest thisTest =  new DatabaseTest(); 
        //thisTest.Sport();
        //thisTest.Event();
        //thisTest.User();

    }
    
    public void Sport(){
        SportDAO sportDao = new SportDAO();
        Sport sport = new Sport();
        
        //Create
        sport.setName("basquet a");        
        sport.setType(SportType.Futbol);
        
        System.out.println("Sport created: " + sportDao.createSport(sport));
        
        
        //Get
        Sport sp = sportDao.getSportById(sport.getId());
        if (sp != null) {
            System.out.println("Sport Entity by ID ----\n" + sp.getId() + "\n" + sp.getName() + "\n" + sp.getType() + "\n------------");
        }else{
            System.out.println("none Sport get by ID");
        }
        
        //Update
        sp.setName("updated n");
        
        System.out.println("Sport updated: " + sportDao.updateSport(sp));        
        
        //System.out.println(sportDao.deleteSport(UUID.fromString("b8c3406b-7268-4f3d-bbe4-848017b90036")));
        
        
        //GetAllSports
        List<Sport> sps = sportDao.getAllSports();
        
        if (sps != null && !sps.isEmpty()) {
            System.out.println("All Sports " + sps.size());
        }else{
            System.out.println("no there sports");
        }
        
        
        //GetByType
        List<Sport> sps2 = sportDao.getSportsByType(SportType.Basquetball);
        
        if (sps2 != null && !sps2.isEmpty()) {
            System.out.println("Sports Basquet type " + sps2.size());
        }else{
            System.out.println("none sports by type");
        }
    }
    
    public void Event(){
        EventDAO eventDao = new EventDAO();
        
        Event event = new Event();
        event.setDate(new Date(System.currentTimeMillis()));
        event.setDescription("This is a description");
        event.setPositionX(4.3672);
        event.setPositionY(86.2323);
        event.setState(EventState.Created);
        event.setCreatedDate(null);
        event.setCreatorUserId(UUID.fromString("33712837-7ace-4f32-8c03-42b81415d98f"));
        event.setSportId(UUID.fromString("0840ac4a-6ea7-41ce-9bf6-7ac6e0765cb4"));
        
        System.out.println("\nCreate Event: " + eventDao.createEvent(event));
        
        Event ev = eventDao.getEventById(event.getId());
        if (ev != null) {
            System.out.println("\nEvent by ID -------\n" + ev.getId() + "\n" + ev.getDescription()+ "\n" + ev.getDate()+ "\n" + ev.getPositionX()+ "\n" + ev.getPositionY()+ "\n" 
                    + ev.getState()+ "\n" + ev.getCreatedDate()+ "\n" + ev.getCreatorUserId()+ "\n" + ev.getSportId()+ "\n--------------");
        }else{
            System.out.println("\nNo event by Id");
        }
        
        ev.setState(EventState.Canceled);
        
        //eventDao.deleteEvent(UUID.fromString("275d5ac1-33ac-4574-8733-91989094e7c6"));
        
        //System.out.println("\nEvent updated: " + eventDao.updateEvent(ev));
        
        List<Event> events = eventDao.getAllEvents();
        if (events != null && !events.isEmpty()) {
            System.out.println("\nAll Events " + events.size());
        } else {
            System.out.println("\nNo there events");
        }
    }
    
    public void User(){
        UserDAO userDao = new UserDAO();
        
        User user = new User();
        user.setAddress("Calle 80");
        user.setBadAverage(0);
        user.setEmail("admin@unisports.com");
        user.setExcellentAverage(0);
        user.setLastName("Last");
        user.setName("Namhe");
        user.setNonAttendanceAverage(0);
        user.setOveralRate(0);
        user.setPassword("password");
        user.setRegularAverage(0);
        user.setbornDate(new Date());
        user.setcontactPhone("3123588923");
        
        System.out.println("User created: " + userDao.createUser(user));
        
        User us = userDao.getUserById(user.getId());
        if (us != null) {
            System.out.println("\nUser entity by Id --------\n" + user.getId() + "\n" + user.getName()+ "\n" + user.getLastName()+ "\n" + user.getEmail()+ "\n" + user.getcontactPhone() + 
                    "\n" + user.getAddress()+ "\n" + user.getbornDate()+ "\n" + user.getPassword()+ "\n" + user.getOveralRate()+ "\n" + user.getExcellentAverage()+ 
                    "\n" + user.getRegularAverage()+ "\n" + user.getBadAverage()+ "\n" + user.getNonAttendanceAverage());
        }
        
        us.setName("real");
        
        System.out.println("\nUser updated: " + userDao.updateUser(us));
        
        //System.out.println("\nUser deleted: " + userDao.deleteUser(UUID.fromString("742bbd1a-4f66-43c3-b405-98ef451cec26")));

        List<User> users = userDao.getAllUsers();
        if (users != null && !users.isEmpty()) {
            System.out.println("\nAll users " + users.size());
        } else {
            System.out.println("\nNo there users");
        }
        
        List<User> usersp = userDao.getUserByPartOfName("re");
        if (usersp != null && !usersp.isEmpty()) {
            System.out.println("\nAll users " + usersp.size());
        } else {
            System.out.println("\nNo there users by name");
        }
    }
}
