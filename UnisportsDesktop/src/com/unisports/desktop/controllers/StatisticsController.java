package com.unisports.desktop.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class StatisticsController implements Initializable {

    private LayoutController mainController;
    private String _token;
    
    public void setLayoutController(LayoutController controller, String token) {
        mainController = controller;
        _token = token;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
