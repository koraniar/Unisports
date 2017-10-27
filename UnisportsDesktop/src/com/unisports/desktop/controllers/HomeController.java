/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.desktop.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author koraniar
 */
public class HomeController implements Initializable {

    //@FXML
    private JFXPopup Popup;

    @FXML
    private Pane ContentPane;

    @FXML
    private Button accountInformationButton;

    @FXML
    private Button createEventButton;

    @FXML
    private Button createTeamButton;

    @FXML
    private Button signInButton;

    @FXML
    private Button registerButton;

    @FXML
    public void onHomeAction() {

    }

    @FXML
    public void onAccountInformtionAction(ActionEvent event) {
        Button db = (Button) event.getSource();
        Popup.show(db, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT);
    }

    @FXML
    public void onStatisticsAction(ActionEvent event) {
    }

    @FXML
    public void onCreateEventAction(ActionEvent event) {

    }

    @FXML
    public void onCreateTeam(ActionEvent event) {
    }

    @FXML
    public void onSignIn(ActionEvent event) {
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
    public void onRegiter(ActionEvent event) {
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
            Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("com/unisports/desktop/views/Profile.fxml"));
            ContentPane.getChildren().add(root);

            initializePopup();

        } catch (IOException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initializePopup() {
        JFXButton option1 = new JFXButton("Notificaciones");
        JFXButton option2 = new JFXButton("Perfil");
        JFXButton option3 = new JFXButton("Mis Equipos");
        JFXButton option4 = new JFXButton("Mis Amigos");
        JFXButton option5 = new JFXButton("Salir");

        option1.setPadding(new Insets(10));
        option2.setPadding(new Insets(10));
        option3.setPadding(new Insets(10));
        option4.setPadding(new Insets(10));
        option5.setPadding(new Insets(10));
        //option2.setStyle("width: 100px;");

        option1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Popup.hide();
            }
        });

        option2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Popup.hide();
            }
        });

        option3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Popup.hide();
            }
        });

        option4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Popup.hide();
            }
        });

        option5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Popup.hide();
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
                Pane root = null;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("com/unisports/desktop/views/Home.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                }
                ContentPane.getChildren().add(root);
            }
        });

        VBox vb = new VBox(option1, option2, option3, option4, option5);
        Popup = new JFXPopup();
        Popup.setPopupContent(vb);
    }
}
