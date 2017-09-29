/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.test;

import com.unisports.dao.SportDAO;
import com.unisports.entities.Sport;
import com.unisports.enums.SportType;
import java.sql.SQLException;

/**
 *
 * @author koraniar
 */
public class DatabaseTest {

    public static void main(String[] args) {
        SportDAO sportDao = new SportDAO();
        Sport sport = new Sport();
        
        sport.setName("Futbol 5 test");        
        sport.setType(SportType.Futbol);
        
        sportDao.createSport(sport);
        
        Sport sp = sportDao.getSportById(sport.getId());
        if (sp != null) {
            System.out.println(sp.getName());            
            System.out.println(sp.getId());
            System.out.println(sp.getType());
        }else{
            System.out.println("none");
        }
    }
}