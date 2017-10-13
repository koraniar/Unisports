/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisportd.test;

import com.unisports.dao.TeamDAO;
import com.unisports.entities.Team;
import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author danielmontana
 */
public class DataBaseTest {

    

    public DataBaseTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void before() {

        System.out.println("After()");

    }

    @After
    public void tearDown() {
    }

    @Test
    public void createTeam() {
        TeamDAO teamDao = new TeamDAO();
        Team team = new Team();
        
        team.setName("TeamOne");
        team.setName("Nuevo evento");
        team.setLogo("Logo1");
        team.setMotto("Motto1");
        team.setDescription("Description1");
        team.setSportId(UUID.fromString("0840ac4a-6ea7-41ce-9bf6-7ac6e0765cb4"));
        
        boolean result = teamDao.createTeam(team);
        
        assertEquals(true, result);
        
        if (!result) {
            fail("We cannot create the team");
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
