/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.bl;

import com.unisports.dao.TeamDAO;
import com.unisports.entities.Team;
import java.util.List;
import java.util.UUID;
import javafx.util.Pair;

/**
 *
 * @author danielmontana
 */
public class TeamBL {
    
    TeamDAO _teamDao;
    
    
    public TeamBL(){
        _teamDao = new TeamDAO();
    }

    public Team GetTeamById(UUID id) {
        Team team = new Team();
        return  _teamDao.getTeamById(team.getId());
    }

   
    public boolean SaveTeam(Team team) {
        return true;
    }

    public boolean UpdateTeam(Team team) {
        return true;
    }

    public List<Team> GetAllTeamsByUserId(UUID id) {
        List<Team> Teams = _teamDao.getAllTeam();
         if (Teams != null && !Teams.isEmpty()) {
            return Teams;
        } else {
            return null;
        }
                
        
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
