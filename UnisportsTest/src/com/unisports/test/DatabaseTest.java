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
        
        DatabaseTest thisTest =  new DatabaseTest(); 
        thisTest.Sport();
        

    }
    
    public void Sport(){
        SportDAO sportDao = new SportDAO();
        Sport sport = new Sport();
        
        //Create
        sport.setName("basquet a");        
        sport.setType(SportType.Futbol);
        
        System.out.println("Create " + sportDao.createSport(sport));
        
        
        //Get
        Sport sp = sportDao.getSportById(sport.getId());
        if (sp != null) {
            System.out.println("Sport Entity ----\n" + sp.getId() + "\n" + sp.getName() + "\n" + sp.getType() + "\n------------");
        }else{
            System.out.println("none Sport get by ID");
        }
        
        //Update
        sp.setName("updated n");
        
        System.out.println("Update " + sportDao.updateSport(sp));        
        
        //System.out.println(sportDao.deleteSport(UUID.fromString("b8c3406b-7268-4f3d-bbe4-848017b90036")));
        
        
        //GetAllSports
        List<Sport> sps = sportDao.getAllSports();
        
        if (sps != null && !sps.isEmpty()) {
            System.out.println("All Sports " + sps.size());
        }else{
            System.out.println("none list");
        }
        
        
        //GetByType
        List<Sport> sps2 = sportDao.getSportsByType(SportType.Basquetball);
        
        if (sps2 != null && !sps2.isEmpty()) {
            System.out.println("Basquet type " + sps2.size());
        }else{
            System.out.println("none list 2");
        }
    }
}
