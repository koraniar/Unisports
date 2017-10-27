/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.desktop.controllers;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author koraniar
 */
public class TeamController implements Initializable {

    @FXML
    private Button ConfirmAddButton;
    
    @FXML
    private Text SearchText;
    
    @FXML
    private JFXTextField UserSearchField;
    
    @FXML
    private Button AddUserToTeamButton;
    
    @FXML
    public void addUserToNewTeam(ActionEvent event){
        AddUserToTeamButton.setOpacity(0);
        AddUserToTeamButton.setDisable(true);
        UserSearchField.setOpacity(1);
        UserSearchField.setDisable(false);
        SearchText.setOpacity(1);
        SearchText.setDisable(false);
        ConfirmAddButton.setOpacity(1);
        ConfirmAddButton.setDisable(false);
    }
    
    @FXML
    public void confirmAddAction(ActionEvent event){
        AddUserToTeamButton.setOpacity(1);
        AddUserToTeamButton.setDisable(false);
        UserSearchField.setOpacity(0);
        UserSearchField.setDisable(true);        
        UserSearchField.setText("");
        SearchText.setOpacity(0);
        SearchText.setDisable(true);
        ConfirmAddButton.setOpacity(0);
        ConfirmAddButton.setDisable(true);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
