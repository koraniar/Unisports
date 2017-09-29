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
import java.util.List;
import java.util.UUID;

/**
 *
 * @author koraniar
 */
public class DatabaseTest {

    public static void main(String[] args) {
        SportDAO sportDao = new SportDAO();
        Sport sport = new Sport();
        
        sport.setName("test upd");        
        sport.setType(SportType.Basquetball);
        
        System.out.println(sportDao.createSport(sport));        
        System.out.println(sport.getId());

        
        Sport sp = sportDao.getSportById(sport.getId());
        if (sp != null) {
            System.out.println(sp.getName());            
            System.out.println(sp.getId());
            System.out.println(sp.getType());
        }else{
            System.out.println("none");
        }
        
        sp.setName("updated");
        
        //System.out.println(sportDao.updateSport(sp));        
        
        System.out.println(sportDao.deleteSport(UUID.fromString("a01f3faa-5d8b-43a3-99a9-246fd99bf7d9")));
        
        List<Sport> sps = sportDao.getAllSports();
        
        if (sps != null && !sps.isEmpty()) {
            System.out.println(sps.size());
        }else{
            System.out.println("none list");
        }
        
        List<Sport> sps2 = sportDao.getSportsByType(SportType.Basquetball);
        
        if (sps2 != null && !sps2.isEmpty()) {
            System.out.println(sps2.size());
        }else{
            System.out.println("none list 2");
        }

    }
}
