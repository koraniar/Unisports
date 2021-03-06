package com.unisports.dao;

import com.unisports.database.context.Database;
import com.unisports.entities.Event;
import com.unisports.enums.EventState;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventDAO {

    private Database _database;
    private Connection _connection;

    public EventDAO() {
        _database = new Database();
        try {
            _connection = _database.connect();
        } catch (SQLException ex) {
            Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean createEvent(Event event) {
        try {
            PreparedStatement statement = _connection.prepareStatement("INSERT INTO Event (Id, Date, Description, PositionX, PositionY, State, CreatedDate, CreatorUserId, Sport_Id) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
            statement.setString(1, event.getId().toString());
            statement.setTimestamp(2, new Timestamp(event.getDate().getTime()));
            statement.setString(3, event.getDescription());
            statement.setDouble(4, event.getPositionX());
            statement.setDouble(5, event.getPositionY());
            statement.setInt(6, (event.getState()).getHashCode());
            if (event.getCreatedDate() != null) {
                statement.setTimestamp(7, new Timestamp(event.getCreatedDate().getTime()));
            } else {
                statement.setNull(7, java.sql.Types.DATE);
            }
            statement.setString(8, event.getCreatorUserId().toString());
            statement.setString(9, event.getSportId().toString());

            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateEvent(Event event) {
        try {
            PreparedStatement statement = _connection.prepareStatement("UPDATE Event SET Date = ?, Description = ?, PositionX = ?, PositionY = ?, State = ?, "
                    + "CreatedDate = ?, CreatorUserId = ?, Sport_Id = ? WHERE Id = ?;");
            statement.setTimestamp(1, new Timestamp(event.getDate().getTime()));
            statement.setString(2, event.getDescription());
            statement.setDouble(3, event.getPositionX());
            statement.setDouble(4, event.getPositionY());
            statement.setInt(5, (event.getState()).getHashCode());
            if (event.getCreatedDate() != null) {
                statement.setTimestamp(6, new Timestamp(event.getCreatedDate().getTime()));
            } else {
                statement.setNull(6, java.sql.Types.DATE);
            }
            statement.setString(7, event.getCreatorUserId().toString());
            statement.setString(8, event.getSportId().toString());
            statement.setString(9, event.getId().toString());

            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deleteEvent(UUID id) {
        try {
            PreparedStatement statement = _connection.prepareStatement("DELETE FROM Event WHERE Id = ?;");
            statement.setString(1, id.toString());

            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Event getEventById(UUID id) {
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM Event WHERE Id=?;");
            statement.setString(1, id.toString());

            ResultSet result = statement.executeQuery();

            Event event = null;

            if (result.next()) {
                event = new Event(UUID.fromString(result.getString("Id")));
                event.setDate(result.getTimestamp("Date"));
                event.setDescription(result.getString("Description"));
                event.setPositionX(result.getDouble("PositionX"));
                event.setPositionY(result.getDouble("PositionY"));
                event.setState(EventState.values()[result.getInt("State")]);
                event.setCreatedDate(result.getTimestamp("CreatedDate"));
                event.setCreatorUserId(UUID.fromString(result.getString("CreatorUserId")));
                event.setSportId(UUID.fromString(result.getString("Sport_Id")));
            }

            result.close();
            statement.close();
            //_database.Disconnect();
            return event;
        } catch (SQLException ex) {
            Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Event> getAllEvents() {
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM Event;");

            ResultSet result = statement.executeQuery();

            List<Event> events = new ArrayList<Event>();

            while (result.next()) {
                Event event = new Event(UUID.fromString(result.getString("Id")));
                event.setDate(result.getTimestamp("Date"));
                event.setDescription(result.getString("Description"));
                event.setPositionX(result.getDouble("PositionX"));
                event.setPositionY(result.getDouble("PositionY"));
                event.setState(EventState.values()[result.getInt("State")]);
                event.setCreatedDate(result.getTimestamp("CreatedDate"));
                event.setCreatorUserId(UUID.fromString(result.getString("CreatorUserId")));
                event.setSportId(UUID.fromString(result.getString("Sport_Id")));
                events.add(event);
            }

            result.close();
            statement.close();
            //_database.Disconnect();
            return events;
        } catch (SQLException ex) {
            Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
