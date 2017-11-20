package com.unisports.desktop.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import com.unisports.entities.ComboBoxItem;
import com.unisports.entities.Sport;
import com.unisports.entities.Team;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Pair;
import org.codehaus.jackson.map.ObjectMapper;
import unisportsdesktop.Request;

public class TeamController implements Initializable {

    private LayoutController mainController;
    private String _token;

    @FXML
    private Button ConfirmAddButton;
    @FXML
    private StackPane teamDialogContent;
    @FXML
    private Text SearchText;
    @FXML
    private JFXTextField UserSearchField;
    @FXML
    private Button AddUserToTeamButton;
    @FXML
    private TextField createName;
    @FXML
    private TextField createMotto;
    @FXML
    private TextArea createDescription;
    @FXML
    private JFXComboBox createSport;

    public void setLayoutController(LayoutController controller, String token) {
        mainController = controller;
        _token = token;
    }

    @FXML
    public void addUserToNewTeam(ActionEvent event) {
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
    public void confirmAddAction(ActionEvent event) {
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

    @FXML
    public void createTeam(ActionEvent event) {
        Pair<Boolean, String> result = new Pair<>(true, "");
        String name = createName.getText().trim();
        String motto = createMotto.getText().trim();
        String description = createDescription.getText().trim();
        ComboBoxItem sportSelected = (ComboBoxItem) createSport.getValue();

        if (name.isEmpty()) {
            result = new Pair<>(false, "El nombre es requerido");
        } else if (sportSelected == null) {
            result = new Pair<>(false, "Debe seleccionar un deporte");
        }

        if (result.getKey()) {
            Team team = new Team();
            team.setName(name);
            team.setMotto(motto);
            team.setDescription(description);
            team.setLogo("");
            team.setSportId(sportSelected.getId());

            ObjectMapper mapper = new ObjectMapper();

            try {
                String body = mapper.writeValueAsString(team);

                Request request = new Request();
                result = request.post(body, "Team/Create");

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

        JFXDialog dialog = new JFXDialog(teamDialogContent, dialogContent, JFXDialog.DialogTransition.CENTER);

        JFXButton acceptButton = new JFXButton("Aceptar");
        acceptButton.setStyle("-fx-font: 18 Roboto;");
        acceptButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                teamDialogContent.setDisable(true);
                dialog.close();
            }
        });

        dialogContent.setActions(acceptButton);

        teamDialogContent.setDisable(false);
        dialog.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if (createSport != null) {
            ObservableList<ComboBoxItem> list = FXCollections.observableArrayList();
            Request request = new Request();

            Pair<Boolean, String> result = request.get("Sport/GetAll");
            if (result.getKey()) {
                ObjectMapper mapper = new ObjectMapper();
                List<Sport> sports = null;

                try {
                    sports = mapper.readValue(result.getValue(), mapper.getTypeFactory().constructCollectionType(List.class, Sport.class));
                } catch (IOException ex) {
                    Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (sports != null && sports.size() > 0) {
                    for (Iterator<Sport> i = sports.iterator(); i.hasNext();) {
                        Sport item = i.next();
                        list.add(new ComboBoxItem(item.getId(), item.getName()));
                    }
                }
            }

            createSport.setItems(list);
        }
        
    }
}
