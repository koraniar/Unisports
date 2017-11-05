/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.desktop.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.unisports.cross.Constants;
import com.unisports.entities.User;
import java.io.IOException;
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
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;
import unisportsdesktop.Request;

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

        Pair<Boolean, String> result = new Pair<>(true, "");
        String email = registerEmail.getText().trim();
        String password = registerPassword.getText().trim();
        String passwordConfirmation = registerConfirmPassword.getText().trim();

        if (email.isEmpty() || !email.contains("@") || !email.contains(".")) {
            result = new Pair<>(false, "El correo no es valido");
        } else if (password.length() < Constants.passwordMinLength) {
            result = new Pair<>(false, "La contraseña debe contener minimo " + Constants.passwordMinLength + " caracteres");
        } else if (!passwordConfirmation.equals(password)) {
            result = new Pair<>(false, "Las contraseñas no coinciden");
        }

        if (result.getKey()) {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setBadAverage(0);
            user.setExcellentAverage(0);
            user.setLastName("");
            user.setName("");
            user.setNonAttendanceAverage(0);
            user.setOveralRate(0);
            user.setRegularAverage(0);

            ObjectMapper mapper = new ObjectMapper();

            try {
                String body = mapper.writeValueAsString(user);
                
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

    @FXML
    public void onSignIn(ActionEvent event) {

        //AuthBL authService = new AuthBL();

        //Pair<Boolean, String> result = authService.validateCredentials(signInEmail.getText(), signInPassword.getText());
        
        Pair<Boolean, String> result = new Pair<>(false, "no service");

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
