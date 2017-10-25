/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.desktop.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author koraniar
 */
public class EventController implements Initializable {
    
    @FXML
    private Button deleteEventButton;
    
    @FXML
    private Button deleteEventButtonA;
    
    @FXML
    private void onDeleteEvent(ActionEvent event) {
        System.out.println("works");
        //Button db = (Button) event.getSource();
        //db.setText("hola");
        deleteEventButton.setDisable(true);
        deleteEventButton.setOpacity(0);
        deleteEventButtonA.setDisable(false);
        deleteEventButtonA.setOpacity(1);
    }
    
    @FXML
    private void onDeleteEvent2(ActionEvent event) {
        System.out.println("works 2");
        deleteEventButton.setDisable(false);
        deleteEventButton.setOpacity(1);
        deleteEventButtonA.setDisable(true);
        deleteEventButtonA.setOpacity(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
