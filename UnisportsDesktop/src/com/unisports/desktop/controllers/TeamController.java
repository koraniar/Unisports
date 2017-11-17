/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.desktop.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import com.unisports.entities.Team;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Pair;
import org.codehaus.jackson.map.ObjectMapper;
import unisportsdesktop.Request;

/**
 * FXML Controller class
 *
 * @author koraniar
 */
public class TeamController implements Initializable {

    private LayoutController mainController;
    private String _token;
    
    @FXML
    private Button ConfirmAddButton;
    
    @FXML
    private StackPane registerDialogContent;
    
    @FXML
    private Text SearchText;
    
    @FXML
    private JFXTextField UserSearchField;
    
    @FXML
    private Button AddUserToTeamButton;
    
    @FXML
    private TextField createName;
    
    public void setLayoutController(LayoutController controller, String token) {
        mainController = controller;
        _token = token;
    }
    
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

    @FXML
    public void createTeam(ActionEvent event){
        Pair<Boolean, String> result = new Pair<>(true, "");
        String name = createName.getText().trim();
    
        if (name.isEmpty()) {
            result = new Pair<>(false, "Campo vacio");
        }
        
        if (result.getKey()) {
            Team team = new Team();
            team.setName(name);
            team.setLogo(name);
            team.setMotto(name);
            team.setDescription(name);
            //team.setSportId(sportId);
           

            ObjectMapper mapper = new ObjectMapper();

            try {
                String body = mapper.writeValueAsString(team);

                Request request = new Request();
                result = request.post(body, "Account/Register");

            } catch (IOException ex) {
                result = new Pair<>(false, "Unexpected error");
            }
        }
        
        JFXDialogLayout dialogContent = new JFXDialogLayout();
        Text textHeading = new Text(result.getKey() ? "Unisports" : "Error");
        textHeading.setFont(Font.font("Roboto", 22));
        dialogContent.setHeading(textHeading);
        Text textBody = new Text(result.getValue());
        textBody.setFont(Font.font("Roboto", 20));
        dialogContent.setBody(textBody);

        JFXDialog dialog = new JFXDialog(registerDialogContent, dialogContent, JFXDialog.DialogTransition.CENTER);

        JFXButton acceptButton = new JFXButton("Aceptar");
        acceptButton.setStyle("-fx-font: 18 Roboto;");
        acceptButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                registerDialogContent.setDisable(true);
                dialog.close();
            }
        });

        dialogContent.setActions(acceptButton);

        registerDialogContent.setDisable(false);
        dialog.show();
    }
    }
    

