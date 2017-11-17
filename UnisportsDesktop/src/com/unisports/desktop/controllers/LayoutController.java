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
public class LayoutController implements Initializable {

    private String userToken = null;
    private JFXPopup profilePopuo;

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
        try {
            Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("com/unisports/desktop/views/Home.fxml"));
            ContentPane.getChildren().remove(0);
            ContentPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(LayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void onAccountInformtionAction(ActionEvent event) {
        Button db = (Button) event.getSource();
        profilePopuo.show(db, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT);
    }

    @FXML
    public void onStatisticsAction(ActionEvent event) {

    }

    @FXML
    public void onCreateEventAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("com/unisports/desktop/views/CreateEvent.fxml"));
            Pane root = loader.load();

            EventController controller = loader.getController();
            controller.setLayoutController(this, userToken);

            ContentPane.getChildren().remove(0);
            ContentPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(LayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void onCreateTeam(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("com/unisports/desktop/views/CreateTeam.fxml"));
            Pane root = loader.load();

            TeamController controller = loader.getController();
            controller.setLayoutController(this, userToken);

            ContentPane.getChildren().remove(0);
            ContentPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(LayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void onSignIn(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("com/unisports/desktop/views/Login.fxml"));
            Pane root = loader.load();

            AccountController controller = loader.getController();
            controller.setLayoutController(this, userToken);

            ContentPane.getChildren().remove(0);
            ContentPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(LayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void onRegiter(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("com/unisports/desktop/views/Register.fxml"));
            Pane root = loader.load();

            AccountController controller = loader.getController();
            controller.setLayoutController(this, userToken);

            ContentPane.getChildren().remove(0);
            ContentPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(LayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initializeProfilePopup(LayoutController thisController) {
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
                profilePopuo.hide();
            }
        });

        option2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                profilePopuo.hide();
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getClassLoader().getResource("com/unisports/desktop/views/Profile.fxml"));
                    Pane root = loader.load();

                    AccountController controller = loader.getController();
                    controller.setLayoutController(thisController, userToken);

                    ContentPane.getChildren().remove(0);
                    ContentPane.getChildren().add(root);
                } catch (IOException ex) {
                    Logger.getLogger(LayoutController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        option3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                profilePopuo.hide();
                try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getClassLoader().getResource("com/unisports/desktop/views/MyTeams.fxml"));
                    Pane root = loader.load();

                    TeamController controller = loader.getController();
                    controller.setLayoutController(thisController, userToken);

                    ContentPane.getChildren().remove(0);
                    ContentPane.getChildren().add(root);
                } catch (IOException ex) {
                    Logger.getLogger(LayoutController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        option4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                profilePopuo.hide();
            }
        });

        option5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                userToken = null;
                profilePopuo.hide();
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
                try {
                    Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("com/unisports/desktop/views/Home.fxml"));
                    ContentPane.getChildren().remove(0);
                    ContentPane.getChildren().add(root);
                } catch (IOException ex) {
                    Logger.getLogger(LayoutController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        VBox vb = new VBox(option1, option2, option3, option4, option5);
        profilePopuo = new JFXPopup();
        profilePopuo.setPopupContent(vb);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("com/unisports/desktop/views/Home.fxml"));
            ContentPane.getChildren().add(root);

            initializeProfilePopup(this);

        } catch (IOException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onEnterValidCredentials(String token) {
        userToken = token;
        try {
            if (!userToken.trim().isEmpty() && userToken != null) {
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

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("com/unisports/desktop/views/Home.fxml"));
            Pane root = loader.load();

            //AccountController controller = loader.getController();
            //controller.setLayoutController(this, userToken);
            ContentPane.getChildren().remove(0);
            ContentPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(LayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
