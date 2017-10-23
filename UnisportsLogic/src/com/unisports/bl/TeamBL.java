/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.bl;

import com.unisports.entities.Team;
import java.util.UUID;

/**
 *
 * @author danielmontana
 */
public class TeamBL {

    public Team GetTeamById(UUID id) {
        return new Team();
    }

    public boolean SaveTeam(Team team) {
        return true;
    }

    public boolean UpdateTeam(Team team) {
        return true;
    }

    public boolean GetAllTeamsByUserId(UUID id) {
        return true;
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
