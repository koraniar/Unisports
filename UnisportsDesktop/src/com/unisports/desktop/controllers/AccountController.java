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
import javafx.scene.control.TextField;

/**
 *
 * @author danielmontana
 */
public class AccountController implements Initializable {
    
    @FXML
    private TextField registerEmail;
    
    @FXML
    private TextField registerPassword;
    
    @FXML
    private TextField registerConfirmPassword;
    
    @FXML
    private void onRegister(ActionEvent event) {
        System.out.println(registerEmail.getText());        
        System.out.println(registerPassword.getText());
        System.out.println(registerConfirmPassword.getText());

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
