/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.test;

import com.unisports.dao.EventDAO;
import com.unisports.dao.NotificationDAO;
import com.unisports.dao.RelationshipDAO;
import com.unisports.dao.SportDAO;
import com.unisports.dao.TeamDAO;
import com.unisports.dao.TeamInscriptionDAO;
import com.unisports.dao.UserDAO;
import com.unisports.dao.UserInscriptionDAO;
import com.unisports.entities.Event;
import com.unisports.entities.Notification;
import com.unisports.entities.Relationship;
import com.unisports.entities.Sport;
import com.unisports.entities.Team;
import com.unisports.entities.TeamInscription;
import com.unisports.entities.User;
import com.unisports.entities.UserInscription;
import com.unisports.enums.EventState;
import com.unisports.enums.NotificationType;
import com.unisports.enums.RelationshipState;
import com.unisports.enums.SportType;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author koraniar
 */
public class DatabaseTest {

    public static void main(String[] args) {

        DatabaseTest thisTest = new DatabaseTest();
        //thisTest.Sport();
        thisTest.Event();
        //thisTest.User();
        //thisTest.Notification();
        //thisTest.Team();
        //thisTest.TeamInscription();
        //thisTest.UserInscription();
        //thisTest.Relationship();
    }

    public void Sport() {
        SportDAO sportDao = new SportDAO();
        Sport sport = new Sport();

        //Create
        sport.setName("basquet a");
        sport.setType(SportType.Futbol);
        System.out.println("Sport created: " + sportDao.createSport(sport));

        //Get
//        Sport sp = sportDao.getSportById(sport.getId());
//        if (sp != null) {
//            System.out.println("Sport Entity by ID ----\n" + sp.getId() + "\n" + sp.getName() + "\n" + sp.getType() + "\n------------");
//        } else {
//            System.out.println("none Sport get by ID");
//        }

        //Update
//        sp.setName("updated n");
//        System.out.println("Sport updated: " + sportDao.updateSport(sp));

        //System.out.println(sportDao.deleteSport(UUID.fromString("b8c3406b-7268-4f3d-bbe4-848017b90036")));
        //GetAllSports
        List<Sport> sps = sportDao.getAllSports();

        if (sps != null && !sps.isEmpty()) {
            System.out.println("All Sports " + sps.size());
        } else {
            System.out.println("no there sports");
        }

        //GetByType
        List<Sport> sps2 = sportDao.getSportsByType(SportType.Basquetball);

        if (sps2 != null && !sps2.isEmpty()) {
            System.out.println("Sports Basquet type " + sps2.size());
        } else {
            System.out.println("none sports by type");
        }
    }

    public void Event() {
        EventDAO eventDao = new EventDAO();

//        Event event = new Event();
//        event.setDate(new Date(System.currentTimeMillis()));
//        event.setDescription("This is a description");
//        event.setPositionX(4.3672);
//        event.setPositionY(86.2323);
//        event.setState(EventState.Created);
//        event.setCreatedDate(null);
//        event.setCreatorUserId(UUID.fromString("33712837-7ace-4f32-8c03-42b81415d98f"));
//        event.setSportId(UUID.fromString("0840ac4a-6ea7-41ce-9bf6-7ac6e0765cb4"));
//
//        System.out.println("\nCreate Event: " + eventDao.createEvent(event));

        Event ev = eventDao.getEventById(UUID.fromString("aca4defb-7a7e-48d0-a023-71808551b804"));
        if (ev != null) {
            System.out.println("\nEvent by ID -------\n" + ev.getId() + "\n" + ev.getDescription() + "\n" + ev.getDate() + "\n" + ev.getPositionX() + "\n" + ev.getPositionY() + "\n"
                    + ev.getState() + "\n" + ev.getCreatedDate() + "\n" + ev.getCreatorUserId() + "\n" + ev.getSportId() + "\n--------------");
        } else {
            System.out.println("\nNo event by Id");
        }

//        ev.setState(EventState.Canceled);
//
//        //eventDao.deleteEvent(UUID.fromString("275d5ac1-33ac-4574-8733-91989094e7c6"));
//        //System.out.println("\nEvent updated: " + eventDao.updateEvent(ev));
//        List<Event> events = eventDao.getAllEvents();
//        if (events != null && !events.isEmpty()) {
//            System.out.println("\nAll Events " + events.size());
//        } else {
//            System.out.println("\nNo there events");
//        }
    }

    public void User() {
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
            System.out.println("\nUser entity by Id --------\n" + user.getId() + "\n" + user.getName() + "\n" + user.getLastName() + "\n" + user.getEmail() + "\n" + user.getcontactPhone()
                    + "\n" + user.getAddress() + "\n" + user.getbornDate() + "\n" + user.getPassword() + "\n" + user.getOveralRate() + "\n" + user.getExcellentAverage()
                    + "\n" + user.getRegularAverage() + "\n" + user.getBadAverage() + "\n" + user.getNonAttendanceAverage());
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

    public void Notification() {

        NotificationDAO notificationDao = new NotificationDAO();
        Notification notification = new Notification();

        //Create
//        notification.setSubject("Nuevo evento");        
//        notification.setType(NotificationType.Created);
//        notification.setUserId(UUID.fromString("5b302d9e-106c-4d6c-a2c7-640f64d1a15f"));
//        System.out.println("Notification created: " + notificationDao.createNotification(notification));
        //Get
//        Notification nt = notificationDao.getNotificationById(notification.getId());
//        if (nt != null) {
//            System.out.println("Notification Entity by ID ----\n" + nt.getId() + "\n" + nt.getSubject() + "\n" + nt.getType() + "\n------------");
//        }else{
//            System.out.println("none Notification get by ID");
//        }
        //Update
//        nt.setSubject("update a"); 
//        System.out.println("Notification updated: " + notificationDao.updateNotification(nt));  
        //Get all notifications
        List<Notification> notifications = notificationDao.getAllNotifications();
        if (notifications != null && !notifications.isEmpty()) {
            System.out.println("\nAll notifications " + notifications.size());
        } else {
            System.out.println("\nNo there notifications");
        }

        //Get notification by id
        List<Notification> notificationsA = notificationDao.getAllNotificationsByUserId(UUID.fromString("5b302d9e-106c-4d6c-a2c7-640f64d1a15f"));
        if (notificationsA != null && !notificationsA.isEmpty()) {
            System.out.println("\nAll Notification by user " + notificationsA.size());
        } else {
            System.out.println("\nNo there Notification by user");
        }

    }

    public void Team() {

        TeamDAO teamDao = new TeamDAO();
        Team team = new Team();

        //Create
//        team.setName("Nuevo evento");        
//        team.setLogo("Logo1");
//        team.setMotto("Motto1");
//        team.setDescription("Description1");
//        team.setSportId(UUID.fromString("5d0c14fa-daf7-4ec1-8624-9121988a673a"));
//        
//        System.out.println("Team created: " + teamDao.createTeam(team));
        //Get
        Team tm = teamDao.getTeamById(team.getId());
        if (tm != null) {
            System.out.println("Notification Entity by ID ----\n" + tm.getId() + "\n" + tm.getName() + "\n" + tm.getLogo() + "\n" + tm.getMotto() + "\n" + tm.getDescription() + "\n------------");
        } else {
            System.out.println("none Notification get by ID");
        }

//        //Update
//        tm.setName("updated n");
//        System.out.println("Notification updated: " + teamDao.updateTeam(tm)); 
        //Get all team
        List<Team> teams = teamDao.getAllTeam();
        if (teams != null && !teams.isEmpty()) {
            System.out.println("\nAll teams " + teams.size());
        } else {
            System.out.println("\nNo there teams");
        }

        //Get team by part of name
        List<Team> teamsp = teamDao.getTeamByPartOfName("da");
        if (teamsp != null && !teamsp.isEmpty()) {
            System.out.println("\nAll teams " + teamsp.size());
        } else {
            System.out.println("\nNo there teams by name");
        }

        //Delete team
        teamDao.deleteTeam(UUID.fromString("ed5f2435-aba4-4d40-92ec-fc8fad6035e1"));

//        System.out.println("\nTeam updated: " + teamDao.updateTeam(tm));
    }

    public void TeamInscription() {
        TeamInscriptionDAO teamInsDAO = new TeamInscriptionDAO();

        TeamInscription teamIns = new TeamInscription();
        teamIns.setPoints(4);
        teamIns.setEventId(UUID.fromString("aca4defb-7a7e-48d0-a023-71808551b804"));

        System.out.println("TeamIns created: " + teamInsDAO.createTeamInscription(teamIns));

        TeamInscription tins = teamInsDAO.getTeamInscriptionById(teamIns.getId());
        if (tins != null) {
            System.out.println("Team Inscription Entity ---------\n" + tins.getId() + "\n" + tins.getPoints() + "\n" + tins.getEventId());
        } else {
            System.out.println("No team inscription by ID");
        }

        tins.setPoints(16);

        System.out.println("TeamIns updated: " + teamInsDAO.updateTeamInscription(tins));

        //System.out.println("TeamIns deleted: " + teamInsDAO.deleteTeamInscription(UUID.fromString("ca855017-112a-49b6-ba01-8a4a730902a0")));
        List<TeamInscription> teamInscriptions = teamInsDAO.getAllTeamInscriptions();
        if (teamInscriptions != null && !teamInscriptions.isEmpty()) {
            System.out.println("\nAll Team Inscriptions " + teamInscriptions.size());
        } else {
            System.out.println("\nNo there team inscriptions");
        }

        List<TeamInscription> teamInscriptionsA = teamInsDAO.getAllTeamInscriptionsByEventId(UUID.fromString("aca4defb-7a7e-48d0-a023-71808551b804"));
        if (teamInscriptionsA != null && !teamInscriptionsA.isEmpty()) {
            System.out.println("\nAll Team Inscriptions by event " + teamInscriptionsA.size());
        } else {
            System.out.println("\nNo there team inscriptions by event");
        }
    }

    public void UserInscription() {
        UserInscriptionDAO userInsDAO = new UserInscriptionDAO();

        UserInscription userIns = new UserInscription();
        userIns.setConfirmed(false);
        userIns.setTeamInscriptionId(UUID.fromString("23ecc70b-1cc6-4002-87fb-34bae3d20efa"));
        userIns.setUserId(UUID.fromString("33712837-7ace-4f32-8c03-42b81415d98f"));

        System.out.println("User created: " + userInsDAO.createUserInscription(userIns));

        UserInscription usIns = userInsDAO.getUserInscriptionById(userIns.getId());
        if (usIns != null) {
            System.out.println("User inscription entity by Id --------\n" + usIns.getId() + "\n" + usIns.getConfirmed() + "\n" + usIns.getTeamInscriptionId() + "\n" + usIns.getUserId());
        } else {
            System.out.println("No user inscription by ID");
        }

        usIns.setConfirmed(true);

        System.out.println("User incription updated: " + userInsDAO.updateUserInscription(usIns));

        //System.out.println("User inscription deleted: " + userInsDAO.deleteUserInscription(UUID.fromString("")));
        List<UserInscription> userInscriptions = userInsDAO.getAllUserInscriptions();
        if (userInscriptions != null && !userInscriptions.isEmpty()) {
            System.out.println("\nAll User Inscriptions " + userInscriptions.size());
        } else {
            System.out.println("\nNo there user inscriptions");
        }

        List<UserInscription> userInscriptionsA = userInsDAO.getAllUserInscriptionsByUserId(userIns.getUserId());
        if (userInscriptionsA != null && !userInscriptionsA.isEmpty()) {
            System.out.println("\nAll User Inscriptions by user " + userInscriptionsA.size());
        } else {
            System.out.println("\nNo there user inscriptions by user");
        }

        List<UserInscription> userInscriptionsB = userInsDAO.getAllUserInscriptionsByTeamInscriptionId(userIns.getTeamInscriptionId());
        if (userInscriptionsB != null && !userInscriptionsB.isEmpty()) {
            System.out.println("\nAll User Inscriptions by team inscription " + userInscriptionsB.size());
        } else {
            System.out.println("\nNo there user inscriptions by team inscription");
        }

    }

    public void Relationship() {

        RelationshipDAO relationshipDao = new RelationshipDAO();
        Relationship relationship = new Relationship();
        
        //Create
        relationship.setConfirmedDate(new Date());
        relationship.setState(RelationshipState.Accepted);
        relationship.setUserId(UUID.fromString("5b302d9e-106c-4d6c-a2c7-640f64d1a15f"));
        relationship.setUserRelatedId(UUID.fromString("ce159082-edc4-46af-a664-c9aa48e203cc"));
        System.out.println("Relationship created: " + relationshipDao.createRelationship(relationship)); 
        
    }
}
