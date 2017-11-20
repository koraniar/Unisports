package com.unisports.dao;

import com.unisports.database.context.Database;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.unisports.entities.TeamInscription;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeamInscriptionDAO {

    private Database _database;
    private Connection _connection;

    public TeamInscriptionDAO() {
        _database = new Database();
        try {
            _connection = _database.connect();
        } catch (SQLException ex) {
            Logger.getLogger(TeamInscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean createTeamInscription(TeamInscription inscription) {
        try {
            PreparedStatement statement = _connection.prepareStatement("INSERT INTO TeamInscription (Id, Points, Event_Id) VALUES (?, ?, ?);");
            statement.setString(1, inscription.getId().toString());
            statement.setInt(2, inscription.getPoints());
            statement.setString(3, inscription.getEventId().toString());

            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TeamInscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateTeamInscription(TeamInscription inscription) {
        try {
            PreparedStatement statement = _connection.prepareStatement("UPDATE TeamInscription SET Points = ?, Event_Id = ? WHERE Id = ?;");
            statement.setInt(1, inscription.getPoints());
            statement.setString(2, inscription.getEventId().toString());
            statement.setString(3, inscription.getId().toString());

            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TeamInscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deleteTeamInscription(UUID id) {
        try {
            PreparedStatement statement = _connection.prepareStatement("DELETE FROM TeamInscription WHERE Id = ?;");
            statement.setString(1, id.toString());

            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TeamInscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public TeamInscription getTeamInscriptionById(UUID id) {
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM TeamInscription WHERE Id=?;");
            statement.setString(1, id.toString());

            ResultSet result = statement.executeQuery();

            TeamInscription tInscription = null;

            if (result.next()) {
                tInscription = new TeamInscription(UUID.fromString(result.getString("Id")));
                tInscription.setPoints(result.getInt("Points"));
                tInscription.setEventId(UUID.fromString(result.getString("Event_Id")));
            }

            result.close();
            statement.close();
            //_database.Disconnect();
            return tInscription;
        } catch (SQLException ex) {
            Logger.getLogger(TeamInscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<TeamInscription> getAllTeamInscriptions() {
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM TeamInscription;");

            ResultSet result = statement.executeQuery();

            List<TeamInscription> inscriptions = new ArrayList<TeamInscription>();

            while (result.next()) {
                TeamInscription tInscription = new TeamInscription(UUID.fromString(result.getString("Id")));
                tInscription.setPoints(result.getInt("Points"));
                tInscription.setEventId(UUID.fromString(result.getString("Event_Id")));
                inscriptions.add(tInscription);
            }

            result.close();
            statement.close();
            //_database.Disconnect();
            return inscriptions;
        } catch (SQLException ex) {
            Logger.getLogger(TeamInscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<TeamInscription> getAllTeamInscriptionsByEventId(UUID id) {
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM TeamInscription WHERE Event_Id = ?;");
            statement.setString(1, id.toString());

            ResultSet result = statement.executeQuery();

            List<TeamInscription> inscriptions = new ArrayList<TeamInscription>();

            while (result.next()) {
                TeamInscription tInscription = new TeamInscription(UUID.fromString(result.getString("Id")));
                tInscription.setPoints(result.getInt("Points"));
                tInscription.setEventId(UUID.fromString(result.getString("Event_Id")));
                inscriptions.add(tInscription);
            }

            result.close();
            statement.close();
            //_database.Disconnect();
            return inscriptions;
        } catch (SQLException ex) {
            Logger.getLogger(TeamInscriptionDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
