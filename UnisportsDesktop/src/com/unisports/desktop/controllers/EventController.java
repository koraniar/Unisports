package com.unisports.desktop.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import com.unisports.entities.ComboBoxItem;
import com.unisports.entities.Event;
import com.unisports.entities.Sport;
import com.unisports.enums.EventState;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
public class EventController implements Initializable {

    private LayoutController mainController;
    private String _token;

    @FXML
    private StackPane dialogLayoutContent;

    @FXML
    private JFXComboBox createEventSport;

    @FXML
    private Button deleteEventButton;

    @FXML
    private Button deleteEventButtonA;

    @FXML
    private JFXDatePicker createEventDate;

    @FXML
    private JFXTimePicker createEventTime;

    @FXML
    private JFXTextField createEventLines;

    public void setLayoutController(LayoutController controller, String token) {
        mainController = controller;
        _token = token;
    }

    @FXML
    private void onCreateEvent(ActionEvent eventCall) {
        Pair<Boolean, String> result = new Pair<>(true, "");
        LocalDate localDate = createEventDate.getValue();
        LocalTime localTime = createEventTime.getValue();
        ComboBoxItem sportSelected = (ComboBoxItem) createEventSport.getValue();
        String lines = createEventLines.getText().trim();
        Date date = null;

        if (localDate != null && localTime != null) {
            LocalDateTime localDT = localTime.atDate(localDate);
            Instant instant = Instant.from(localDT.atZone(ZoneId.systemDefault()));
            date = Date.from(instant);
        }

        if (date == null) {
            result = new Pair<>(false, "La fecha y hora no son validas");
        }
        if (sportSelected == null) {
            result = new Pair<>(false, "Debe seleccionar un deporte");
        }
        if (lines.isEmpty()) {
            result = new Pair<>(false, "Debe seleccionar la cantidad de lineas");
        }

        if (result.getKey()) {
            Event event = new Event();
            event.setCreatorUserId(UUID.fromString(_token));
            event.setDate(date);
            event.setDescription("");
            event.setPositionX(0.0);
            event.setPositionY(0.0);
            event.setSportId(sportSelected.getId());
            event.setState(EventState.Created);

            ObjectMapper mapper = new ObjectMapper();

            try {
                String body = mapper.writeValueAsString(event);

                Request request = new Request();
                result = request.post(body, "Event/Create");

            } catch (IOException ex) {
                result = new Pair<>(false, "Unexpected error");
            }
        }

        if (result.getKey()) {
            mainController.goToEventControllerView("Event");
        } else {
            JFXDialogLayout dialogContent = new JFXDialogLayout();
            Text textHeading = new Text(result.getKey() ? "Unisports" : "Error");
            textHeading.setFont(Font.font("Roboto", 22));
            dialogContent.setHeading(textHeading);
            Text textBody = new Text(result.getValue());
            textBody.setFont(Font.font("Roboto", 20));
            dialogContent.setBody(textBody);

            JFXDialog dialog = new JFXDialog(dialogLayoutContent, dialogContent, JFXDialog.DialogTransition.CENTER);

            JFXButton acceptButton = new JFXButton("Aceptar");
            acceptButton.setStyle("-fx-font: 18 Roboto;");
            acceptButton.setOnAction((ActionEvent e) -> {
                dialogLayoutContent.setDisable(true);
                dialog.close();
            });

            dialogContent.setActions(acceptButton);

            dialogLayoutContent.setDisable(false);
            dialog.show();
        }
    }

    @FXML
    private void onDeleteEvent(ActionEvent event) {
        System.out.println("works");
        //Button db = (Button) event.getSource();
        //db.setText("hola");
        deleteEventButton.setDisable(true);
        deleteEventButton.setOpacity(0);
        deleteEventButtonA.setDisable(false);
        deleteEventButtonA.setOpacity(1);
    }

    @FXML
    private void onDeleteEvent2(ActionEvent event) {
        System.out.println("works 2");
        deleteEventButton.setDisable(false);
        deleteEventButton.setOpacity(1);
        deleteEventButtonA.setDisable(true);
        deleteEventButtonA.setOpacity(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        if (createEventSport != null) {
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

//            if (list.size() < 1) {
//                list.add("None to select");
//            }
            createEventSport.setItems(list);
        }
    }

}
