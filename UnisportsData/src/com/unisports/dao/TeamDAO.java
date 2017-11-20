package com.unisports.dao;

import com.unisports.database.context.Database;
import com.unisports.entities.Team;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeamDAO {

    private Database _database;
    private Connection _connection;

    public TeamDAO() {
        _database = new Database();

        try {
            _connection = _database.connect();
        } catch (SQLException ex) {
            Logger.getLogger(TeamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean createTeam(Team team) {

        try {
            PreparedStatement statement = _connection.prepareStatement("INSERT INTO Team (Id, Name, Logo, Motto, Description, Sport_Id) VALUES (?, ?, ?, ?, ?, ?);");
            statement.setString(1, team.getId().toString());
            statement.setString(2, team.getName());
            statement.setString(3, team.getLogo());
            statement.setString(4, team.getMotto());
            statement.setString(5, team.getDescription());
            statement.setString(6, team.getSportId().toString());

            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TeamDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean updateTeam(Team team) {
        try {
            PreparedStatement statement = _connection.prepareStatement("UPDATE Team SET Name = ?, Logo = ?, Motto = ?, Description = ?, Sport_Id = ? WHERE Id = ?;");
            statement.setString(1, team.getName());
            statement.setString(2, team.getLogo());
            statement.setString(3, team.getMotto());
            statement.setString(4, team.getDescription());
            statement.setString(5, team.getSportId().toString());
            statement.setString(6, team.getId().toString());

            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TeamDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Team getTeamById(UUID id) {
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM team WHERE Id=?;");
            statement.setString(1, id.toString());

            ResultSet result = statement.executeQuery();

            Team team = null;

            if (result.next()) {
                team = new Team(UUID.fromString(result.getString("Id")));
                team.setName(result.getString("Name"));
                team.setLogo(result.getString("Logo"));
                team.setMotto(result.getString("Motto"));
                team.setDescription(result.getString("Description"));
                team.setSportId(UUID.fromString(result.getString("Sport_Id")));

            }

            result.close();
            statement.close();
            //_database.Disconnect();
            return team;
        } catch (SQLException ex) {
            Logger.getLogger(TeamDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Team> getAllTeam() {
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM Team;");

            ResultSet result = statement.executeQuery();

            List<Team> teams = new ArrayList<Team>();

            while (result.next()) {
                Team team = new Team(UUID.fromString(result.getString("Id")));
                team.setName(result.getString("Name"));
                team.setLogo(result.getString("Logo"));
                team.setMotto(result.getString("Motto"));
                team.setDescription(result.getString("Description"));
                team.setSportId(UUID.fromString(result.getString("Sport_Id")));
                teams.add(team);
            }

            result.close();
            statement.close();
            //_database.Disconnect();
            return teams;
        } catch (SQLException ex) {
            Logger.getLogger(TeamDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public List<Team> getTeamByPartOfName(String word) {
        try {
            PreparedStatement statement = _connection.prepareStatement("SELECT * FROM Team WHERE LOWER(Name) LIKE ?;");
            statement.setString(1, "%" + word.toLowerCase() + "%");

            ResultSet result = statement.executeQuery();

            List<Team> teams = new ArrayList<Team>();

            while (result.next()) {
                Team team = new Team(UUID.fromString(result.getString("Id")));
                team.setName(result.getString("Name"));
                team.setLogo(result.getString("Logo"));
                team.setMotto(result.getString("Motto"));
                team.setDescription(result.getString("Description"));
                team.setSportId(UUID.fromString(result.getString("Sport_Id")));
                teams.add(team);
            }

            result.close();
            statement.close();
            //_database.Disconnect();
            return teams;
        } catch (SQLException ex) {
            Logger.getLogger(TeamDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean deleteTeam(UUID id) {
        try {
            PreparedStatement statement = _connection.prepareStatement("DELETE FROM Team WHERE Id = ?;");
            statement.setString(1, id.toString());

            int result = statement.executeUpdate();
            statement.close();
            //_database.Disconnect();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TeamDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
