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
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * FXML Controller class
 *
 * @author koraniar
 */
public class LayoutController implements Initializable {

    private String userToken = null;
    private boolean userIsComplete = false;
    private JFXPopup profilePopup;

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
        goToHomeControllerView("Home");
    }

    @FXML
    public void onAccountInformtionAction(ActionEvent event) {
        Button db = (Button) event.getSource();
        profilePopup.show(db, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.RIGHT);
    }

    @FXML
    public void onStatisticsAction(ActionEvent event) {

    }

    @FXML
    public void onCreateEventAction(ActionEvent event) {
        goToEventControllerView("CreateEvent");
    }

    @FXML
    public void onCreateTeam(ActionEvent event) {
        goToTeamControllerView("CreateTeam");
    }

    @FXML
    public void onSignIn(ActionEvent event) {
        goToAccountControllerView("Login");
    }

    @FXML
    public void onRegiter(ActionEvent event) {
        goToAccountControllerView("Register");
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
        
        option1.setFont(Font.font("Roboto Regular", 16));        
        option2.setFont(Font.font("Roboto Regular", 16));
        option3.setFont(Font.font("Roboto Regular", 16));
        option4.setFont(Font.font("Roboto Regular", 16));
        option5.setFont(Font.font("Roboto Regular", 16));

        option1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                profilePopup.hide();
            }
        });

        option2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                profilePopup.hide();
                goToAccountControllerView("Profile");
            }
        });

        option3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                profilePopup.hide();
                goToTeamControllerView("MyTeams");
            }
        });

        option4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                profilePopup.hide();
            }
        });

        option5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                userToken = null;
                userIsComplete = false;
                profilePopup.hide();
                accountInformationButton.setOpacity(0);
                accountInformationButton.setDisable(true);
                accountInformationButton.setText("UN");
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
        profilePopup = new JFXPopup();
        profilePopup.setPopupContent(vb);
    }

    public void changeInitialsAndComplete(String initials, boolean complete) {
        userIsComplete = complete;
        accountInformationButton.setText(initials.toUpperCase().substring(0, 2));
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

    //go to views
    public void goToHomeControllerView(String viewName) {
        if (!userIsComplete && userToken != null) {
            onEnterValidCredentials(userToken, userIsComplete);
        } else {
            try {
                Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("com/unisports/desktop/views/" + viewName + ".fxml"));
                ContentPane.getChildren().remove(0);
                ContentPane.getChildren().add(root);
            } catch (IOException ex) {
                Logger.getLogger(LayoutController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void goToEventControllerView(String viewName) {
        if (!userIsComplete && userToken != null) {
            onEnterValidCredentials(userToken, userIsComplete);
        } else {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getClassLoader().getResource("com/unisports/desktop/views/" + viewName + ".fxml"));
                Pane root = loader.load();

                EventController controller = loader.getController();
                controller.setLayoutController(this, userToken);

                ContentPane.getChildren().remove(0);
                ContentPane.getChildren().add(root);
            } catch (IOException ex) {
                Logger.getLogger(LayoutController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void goToAccountControllerView(String viewName) {
        if (!userIsComplete && userToken != null) {
            onEnterValidCredentials(userToken, userIsComplete);
        } else {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getClassLoader().getResource("com/unisports/desktop/views/" + viewName + ".fxml"));
                Pane root = loader.load();

                AccountController controller = loader.getController();
                controller.setLayoutController(this, userToken, userIsComplete);

                ContentPane.getChildren().remove(0);
                ContentPane.getChildren().add(root);
            } catch (IOException ex) {
                Logger.getLogger(LayoutController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void goToTeamControllerView(String viewName) {
        if (!userIsComplete && userToken != null) {
            onEnterValidCredentials(userToken, userIsComplete);
        } else {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getClassLoader().getResource("com/unisports/desktop/views/" + viewName + ".fxml"));
                Pane root = loader.load();

                TeamController controller = loader.getController();
                controller.setLayoutController(this, userToken);

                ContentPane.getChildren().remove(0);
                ContentPane.getChildren().add(root);
            } catch (IOException ex) {
                Logger.getLogger(LayoutController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void onEnterValidCredentials(String token, boolean isComplete) {
        userToken = token;
        userIsComplete = isComplete;
        try {
            if (userToken != null && !userToken.trim().isEmpty()) {
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

//            Node a = ContentPane.getChildren().get(0);
//            System.out.println(a.getClass().geti());            
//            System.out.println(a.getClass().getSuperclass().getSimpleName());
//            System.out.println(a.getClass().getPackage().getName());

                    
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("com/unisports/desktop/views/" + (userIsComplete ? "Home" : "EditProfile") + ".fxml"));
            Pane root = loader.load();

            if (!userIsComplete) {
                AccountController controller = loader.getController();
                controller.setLayoutController(this, userToken, userIsComplete);
            }
            ContentPane.getChildren().remove(0);
            ContentPane.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(LayoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
