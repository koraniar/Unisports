/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.desktop.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.unisports.bl.AuthBL;
import com.unisports.bl.UserBL;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Pair;

/**
 *
 * @author danielmontana
 */
public class AccountController implements Initializable {

    @FXML
    private StackPane registerDialogContent;
    
    @FXML
    private StackPane signInDialogContent;

    @FXML
    private TextField registerEmail;

    @FXML
    private TextField registerPassword;

    @FXML
    private TextField registerConfirmPassword;

    @FXML
    private TextField signInEmail;

    @FXML
    private TextField signInPassword;

    @FXML
    private void onRegister(ActionEvent event) {
        UserBL userService = new UserBL();
        Pair<Boolean, String> result = userService.createUser(registerEmail.getText(), registerPassword.getText(), registerConfirmPassword.getText());

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

    @FXML
    public void onSignIn(ActionEvent event) {
        
        AuthBL authService = new AuthBL();

        Pair<Boolean, String> result = authService.validateCredentials(signInEmail.getText(), signInPassword.getText());

        if (result.getKey()) {
            JFXDialogLayout dialogContent = new JFXDialogLayout();
            Text textHeading = new Text("Unisports");
            textHeading.setFont(Font.font("Roboto", 22));
            dialogContent.setHeading(textHeading);
            Text textBody = new Text("Has entrado");
            textBody.setFont(Font.font("Roboto", 20));
            dialogContent.setBody(textBody);

            JFXDialog dialog = new JFXDialog(signInDialogContent, dialogContent, JFXDialog.DialogTransition.CENTER);

            JFXButton acceptButton = new JFXButton("Aceptar");
            acceptButton.setStyle("-fx-font: 18 Roboto;");
            acceptButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    signInDialogContent.setDisable(true);
                    dialog.close();
                }
            });

            dialogContent.setActions(acceptButton);

            signInDialogContent.setDisable(false);
            dialog.show();
        } else {
            JFXDialogLayout dialogContent = new JFXDialogLayout();
            Text textHeading = new Text("Error");
            textHeading.setFont(Font.font("Roboto", 22));
            dialogContent.setHeading(textHeading);
            Text textBody = new Text(result.getValue());
            textBody.setFont(Font.font("Roboto", 20));
            dialogContent.setBody(textBody);

            JFXDialog dialog = new JFXDialog(signInDialogContent, dialogContent, JFXDialog.DialogTransition.CENTER);

            JFXButton acceptButton = new JFXButton("Aceptar");
            acceptButton.setStyle("-fx-font: 18 Roboto;");
            acceptButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    signInDialogContent.setDisable(true);
                    dialog.close();
                }
            });

            dialogContent.setActions(acceptButton);

            signInDialogContent.setDisable(false);
            dialog.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
