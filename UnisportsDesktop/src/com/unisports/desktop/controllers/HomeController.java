/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.desktop.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author koraniar
 */
public class HomeController implements Initializable {

    @FXML
    private Pane ContentPane;
    
    @FXML
    private Text accountInformationButton;
    
    @FXML
    private Button createEventButton;
    
    @FXML
    private Button createTeamButton;
    
    @FXML
    private Button signInButton;
    
    @FXML
    private Button registerButton;
    
    
    @FXML
    public void onHomeAction(){
        accountInformationButton.setOpacity(0);
        accountInformationButton.setDisable(true);
        createEventButton.setOpacity(0);
        createEventButton.setDisable(true);
        createTeamButton.setOpacity(0);
        createTeamButton.setDisable(true);
        signInButton.setOpacity(1);
        signInButton.setDisable(false);
        registerButton.setOpacity(1);
        registerButton.setDisable(false);
    }
    
    @FXML
    public void onStatisticsAction(ActionEvent event){
    }
    
    @FXML
    public void onCreateEventAction(ActionEvent event){
    }
    
    @FXML
    public void onCreateTeam(ActionEvent event){
    }
    
    @FXML
    public void onSignIn(ActionEvent event){
        accountInformationButton.setOpacity(1);
        accountInformationButton.setDisable(false);
        createEventButton.setOpacity(1);
        createEventButton.setDisable(false);
        createTeamButton.setOpacity(1);
        createTeamButton.setDisable(false);
        signInButton.setOpacity(0);
        signInButton.setDisable(true);
        registerButton.setOpacity(0);
        registerButton.setDisable(true);
    }
    
    @FXML
    public void onRegiter(ActionEvent event){
        accountInformationButton.setOpacity(1);
        accountInformationButton.setDisable(false);
        createEventButton.setOpacity(1);
        createEventButton.setDisable(false);
        createTeamButton.setOpacity(1);
        createTeamButton.setDisable(false);
        signInButton.setOpacity(0);
        signInButton.setDisable(true);
        registerButton.setOpacity(0);
        registerButton.setDisable(true);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("com/unisports/desktop/views/Event.fxml"));
            ContentPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
