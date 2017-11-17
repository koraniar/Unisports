/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.desktop.controllers;

import com.jfoenix.controls.JFXComboBox;
import com.unisports.entities.Sport;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.util.Pair;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import unisportsdesktop.Request;

/**
 * FXML Controller class
 *
 * @author koraniar
 */
public class EventController implements Initializable {
    
    private LayoutController mainController;
    private String _token;
    
    @FXML
    private JFXComboBox createEventSport;
    
    @FXML
    private Button deleteEventButton;
    
    @FXML
    private Button deleteEventButtonA;
    
    public void setLayoutController(LayoutController controller, String token) {
        mainController = controller;
        _token = token;
    }
    
    @FXML
    private void onCreateEvent(ActionEvent event) {
        //save event
    }
    
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
        ObservableList<String> list = FXCollections.observableArrayList();
        Request request = new Request();
        
        Pair<Boolean, String> result = request.get("Sport/GetAll");
        if (result.getKey()) {
            ObjectMapper mapper = new ObjectMapper();
        List<Sport> sports = null;
            
            try {
                sports = mapper.readValue(result.getValue(), mapper.getTypeFactory().constructCollectionType(List.class, Sport.class));
            } catch (IOException ex) {
                Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (sports != null && sports.size() > 0) {
                for (Iterator<Sport> i = sports.iterator(); i.hasNext();) {
                    Sport item = i.next();
                    list.add(item.getName());
                }
            }
        }
        
        
        
        createEventSport.setItems(list);
    }    
    
}
