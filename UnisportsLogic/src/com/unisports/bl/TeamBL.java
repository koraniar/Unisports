package com.unisports.bl;

import com.unisports.dao.TeamDAO;
import com.unisports.entities.Team;
import java.util.List;
import java.util.UUID;
import javafx.util.Pair;

public class TeamBL {
    
    TeamDAO _teamDao;
    
    
    public TeamBL(){
        _teamDao = new TeamDAO();
    }

    public Team GetTeamById(UUID id) {
        Team team = new Team();
        return  _teamDao.getTeamById(team.getId());
    }

   
    public Pair<Boolean, String> SaveTeam(Team team) {
        if (team.getName().isEmpty()) {
            return new Pair<>(false, "El nombre es requerido");
        } else if (team.getSportId() == null){
            return new Pair<>(false, "El deporte es requerido");
        }
        
        if (_teamDao.createTeam(team)) {
            return new Pair<>(true, "");
        }
        return new Pair<>(false, "Error guardando el equipo");
    }

    public boolean UpdateTeam(Team team) {
        return true;
    }

    public List<Team> GetAllTeamsByUserId(UUID id) {
        return _teamDao.getAllTeam();
    }

    public boolean GetTeamsByName(String word) {
        return true;
    }

    public boolean UploadTeamPhoto(String photo) {
        return true;
    }

    public boolean DeleteTeam(UUID teamId) {
        return true;
    }

    public boolean GetAllUserInscriptionByUserId(UUID id) {
        return true;
    }

    private boolean SendConfirmationEmail(UUID userId) {
        return true;
    }

}
