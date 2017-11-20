package com.unisports.desktop.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.unisports.cross.Constants;
import com.unisports.entities.User;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Pair;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import unisportsdesktop.Request;

public class AccountController implements Initializable {

    private LayoutController mainController;
    private String _token;
    private boolean _isComplete;
    private User _user;

    @FXML
    private StackPane dialogLayoutContent;
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
    private TextField editProfileName;
    @FXML
    private TextField editProfileLastName;
    @FXML
    private TextField editProfileAddress;
    @FXML
    private TextField editProfilePhone;
    @FXML
    private JFXDatePicker editProfileDate;
    @FXML
    private Text profileValueName;
    @FXML
    private Text profileValueLastName;
    @FXML
    private Text profileValueDirecction;
    @FXML
    private Text profileValuePhone;
    @FXML
    private Text profileValueDate;

    public void setLayoutController(LayoutController controller, String token, boolean isComplete) {
        mainController = controller;
        _token = token;
        _isComplete = isComplete;

        afterInitialize();
    }

    @FXML
    public void goToResetPassword() {
        mainController.goToAccountControllerView("RecoverPassword");
    }

    @FXML
    public void goToCreateAccount() {
        mainController.goToAccountControllerView("Register");
    }

    @FXML
    public void goToLogin() {
        mainController.goToAccountControllerView("Login");
    }

    @FXML
    public void onRegister(ActionEvent event) {
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
        textHeading.setFont(Font.font("Roboto Regular", 22));
        dialogContent.setHeading(textHeading);
        Text textBody = new Text(result.getValue());
        textBody.setFont(Font.font("Roboto Regular", 20));
        dialogContent.setBody(textBody);

        JFXDialog dialog = new JFXDialog(dialogLayoutContent, dialogContent, JFXDialog.DialogTransition.CENTER);

        JFXButton acceptButton = new JFXButton("Aceptar");
        acceptButton.setStyle("-fx-font: 18 Roboto Regular;");
        acceptButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                dialogLayoutContent.setDisable(true);
                dialog.close();
            }
        });

        dialogContent.setActions(acceptButton);

        dialogLayoutContent.setDisable(false);
        dialog.show();
    }

    @FXML
    public void onSignIn(ActionEvent event) {
        String email = signInEmail.getText().trim();
        String password = signInPassword.getText().trim();
        Pair<Boolean, String> result = new Pair<>(false, "Los datos no son válidos");
        String initials = "";
        boolean complete = false;

        if (!email.isEmpty() && !password.isEmpty()) {
            Request request = new Request();
            result = request.get("Auth/Login?email=" + email + "&password=" + password);

            if (result.getKey()) {
                ObjectMapper mapper = new ObjectMapper();
                try {
                    JsonNode nodeResponse = mapper.readTree(result.getValue());
                    result = new Pair<>(nodeResponse.get("result").asBoolean(), nodeResponse.get("message").asText());
                    if (result.getKey()) {
                        initials = nodeResponse.get("initials").asText();
                        complete = nodeResponse.get("complete").asBoolean();
                    }
                } catch (IOException ex) {
                    result = new Pair<>(false, "Error durante el envio de datos");
                }
            }
        }

        if (result.getKey()) {
            mainController.onEnterValidCredentials(result.getValue(), complete);
            mainController.changeInitialsAndComplete(initials, complete);
        } else {
            JFXDialogLayout dialogContent = new JFXDialogLayout();
            Text textHeading = new Text("Error");
            textHeading.setFont(Font.font("Roboto Regular", 22));
            dialogContent.setHeading(textHeading);
            Text textBody = new Text(result.getValue());
            textBody.setFont(Font.font("Roboto Regular", 20));
            dialogContent.setBody(textBody);

            JFXDialog dialog = new JFXDialog(dialogLayoutContent, dialogContent, JFXDialog.DialogTransition.CENTER);

            JFXButton acceptButton = new JFXButton("Aceptar");
            acceptButton.setStyle("-fx-font: 18 Roboto Regular;");
            acceptButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    dialogLayoutContent.setDisable(true);
                    dialog.close();
                }
            });

            dialogContent.setActions(acceptButton);

            dialogLayoutContent.setDisable(false);
            dialog.show();
        }
    }

    @FXML
    public void onEditProfile(ActionEvent event) {
        mainController.goToAccountControllerView("EditProfile");
    }

    @FXML
    public void onSaveEditProfile(ActionEvent event) {
        Pair<Boolean, String> result = new Pair<>(true, "");
        String name = editProfileName.getText().trim();
        String lastName = editProfileLastName.getText().trim();
        String address = editProfileAddress.getText().trim();
        String phone = editProfilePhone.getText().trim();
        LocalDate localDate = editProfileDate.getValue();
        Date date = null;

        if (localDate != null) {
            date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        }

        if (name.isEmpty()) {
            result = new Pair<>(false, "El Nombre es requerido");
        } else if (lastName.isEmpty()) {
            result = new Pair<>(false, "El Apellido es requerido");
        } else if (phone.isEmpty()) {
            result = new Pair<>(false, "El Telefono es requerido");
        }

        if (result.getKey()) {
            try {
                _user.setName(name);
                _user.setLastName(lastName);
                _user.setAddress(address);
                _user.setContactPhone(phone);
                _user.setBornDate(date);

                ObjectMapper mapper = new ObjectMapper();
                String content = mapper.writeValueAsString(_user);

                Request request = new Request();
                result = request.post(content, "Account/EditUser");
            } catch (IOException ex) {
                Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (result.getKey()) {
            mainController.changeInitialsAndComplete(name.substring(0, 1) + lastName.substring(0, 1), true);
            if (_isComplete) {
                mainController.goToAccountControllerView("Profile");
            }else{
                mainController.goToHomeControllerView("Home");
            }
        } else {
            JFXDialogLayout dialogContent = new JFXDialogLayout();
            Text textHeading = new Text("Error");
            textHeading.setFont(Font.font("Roboto Regular", 22));
            dialogContent.setHeading(textHeading);
            Text textBody = new Text(result.getValue());
            textBody.setFont(Font.font("Roboto Regular", 20));
            dialogContent.setBody(textBody);

            JFXDialog dialog = new JFXDialog(dialogLayoutContent, dialogContent, JFXDialog.DialogTransition.CENTER);

            JFXButton acceptButton = new JFXButton("Aceptar");
            acceptButton.setStyle("-fx-font: 18 Roboto Regular;");
            acceptButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    dialogLayoutContent.setDisable(true);
                    dialog.close();
                }
            });

            dialogContent.setActions(acceptButton);

            dialogLayoutContent.setDisable(false);
            dialog.show();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void afterInitialize() {
        if (editProfileName != null || profileValueName != null) {
            Request request = new Request();
            Pair<Boolean, String> result = request.get("Account/GetUser?id=" + _token);

            if (result.getKey()) {
                ObjectMapper mapper = new ObjectMapper();
                try {
                    JsonNode nodeResponse = mapper.readTree(result.getValue());
                    _user = mapper.readValue(nodeResponse.get("user").asText(), User.class);

                    if (editProfileName != null) {
                        if (_user.getName() != null && !_user.getName().isEmpty()) {
                            editProfileName.setText(_user.getName());
                        }
                        if (_user.getLastName() != null && !_user.getLastName().isEmpty()) {
                            editProfileLastName.setText(_user.getLastName());
                        }
                        if (_user.getAddress() != null && !_user.getAddress().isEmpty()) {
                            editProfileAddress.setText(_user.getAddress());
                        }
                        if (_user.getContactPhone() != null && !_user.getContactPhone().isEmpty()) {
                            editProfilePhone.setText(_user.getContactPhone());
                        }
                        if (_user.getBornDate() != null) {
                            editProfileDate.setValue(_user.getBornDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                        }
                    } else if (profileValueName != null) {
                        profileValueName.setText(_user.getName());
                        profileValueLastName.setText(_user.getLastName());

                        if (_user.getAddress() != null && !_user.getAddress().isEmpty()) {
                            profileValueDirecction.setText(_user.getAddress());
                        } else {
                            profileValueDirecction.setText("N/A");
                        }
                        if (_user.getContactPhone() != null && !_user.getContactPhone().isEmpty()) {
                            profileValuePhone.setText(_user.getContactPhone());
                        } else {
                            profileValuePhone.setText("N/A");
                        }
                        if (_user.getBornDate() != null) {
                            profileValueDate.setText(_user.getBornDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString());
                        } else {
                            profileValueDate.setText("N/A");
                        }
                    }
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                mainController.goToAccountControllerView("Login");
            }
        }
    }
}
