/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisportd.test;

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

    Team team = new Team();

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
        team.setName("TeamOne");
        team.setName("Nuevo evento");
        team.setLogo("Logo1");
        team.setMotto("Motto1");
        team.setDescription("Description1");
        team.setSportId(UUID.fromString("5d0c14fa-daf7-4ec1-8624-9121988a673a"));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
