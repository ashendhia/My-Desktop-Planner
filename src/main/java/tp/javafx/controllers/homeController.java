package tp.javafx.controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.controlsfx.control.CheckComboBox;
import tp.javafx.Main;

public class homeController implements Initializable {

    public Pane project;

    @FXML
    public Pane settingsCustom;
    public Button custom;

    @FXML
    public CheckComboBox daysCheckBox;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Pane tasks;

    @FXML
    private Pane settings;

    @FXML
    private Pane projects;

    @FXML
    private Label date;

    @FXML
    private Label todayOrNot;

    @FXML
    private Button back;

    @FXML
    private DatePicker startDate1;

    @FXML
    private DatePicker endDate1;

    LocalDate localDate =  LocalDate.now();
    LocalDate[] dates = {
            LocalDate.now(),
            LocalDate.now(),
    };

    private String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        } else {
            return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        }
    }

    private void setDate() {
        date.setText(capitalizeFirstLetter(localDate.getDayOfWeek().toString())+" "+capitalizeFirstLetter(localDate.getMonth().toString())+" "+localDate.getDayOfMonth());
        if(localDate.equals(LocalDate.now())) {
            back.setDisable(true);
            todayOrNot.setText("Today");
        }
        else {
            back.setDisable(false);
            todayOrNot.setText("Tasks");
        }
    }

    @FXML
    private void swipeDayForward(ActionEvent event) throws IOException {
        localDate = localDate.plusDays(1);
        setDate();
    }
    @FXML
    private void swipeDayBackwards(ActionEvent event) throws IOException {
        localDate = localDate.minusDays(1);
        setDate();
    }

    @FXML
    private void switchToProjects( MouseEvent event) throws IOException {
        projects.toFront();
    }

    @FXML
    private void switchToTasks( MouseEvent event) throws IOException {
        tasks.toFront();
    }

    private void setMinimumSelectableDate(DatePicker datePicker, LocalDate minDate) {
        datePicker.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(date.isBefore(minDate));
            }
        });
    }

    @FXML
    private void switchToSettings( MouseEvent event) throws IOException {
        setMinimumSelectableDate(startDate1, dates[0]);
        startDate1.setValue(dates[0]);
        setMinimumSelectableDate(endDate1, dates[1]);
        endDate1.setValue(dates[1]);
        settings.toFront();
    }

    @FXML
    private void switchToSettings2(ActionEvent event) throws IOException {
        settings.toFront();
    }

    private List<String> getDatesInRange(LocalDate startDate, LocalDate endDate) {
        List<String> datesInRange = new ArrayList<>();
        long numOfDays = ChronoUnit.DAYS.between(startDate, endDate);

        for (int i = 0; i <= numOfDays; i++) {
            LocalDate date = startDate.plusDays(i);
            String dateItem = date.toString();
            datesInRange.add(dateItem);
        }

        return datesInRange;
    }




    @FXML
    private void switchToCustomSettings( ActionEvent event) throws IOException {
        daysCheckBox.getItems().addAll(getDatesInRange(dates[0], dates[1]));
        settingsCustom.toFront();
    }

    @FXML
    private void startDateChange(ActionEvent event) throws IOException {
        if(endDate1.getValue().compareTo(startDate1.getValue()) <= 0) {
            endDate1.setValue(startDate1.getValue());
            dates[1] = endDate1.getValue();
        }
        setMinimumSelectableDate(endDate1, startDate1.getValue());
        dates[0] = startDate1.getValue();
    }

    @FXML
    private void endDateChange(ActionEvent event) throws IOException {
        dates[1] = endDate1.getValue();
        if(endDate1.getValue().compareTo(startDate1.getValue()) > 0) {
            custom.setDisable(false);
        }
        else custom.setDisable(true);
    }

    @FXML
    private void handleSignOut( MouseEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("/tp/javafx/login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void createNew( ActionEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/tp/javafx/newTask.fxml")));

        Stage taskStage = new Stage();
        Scene taskScene = new Scene(root);
        taskStage.setTitle("Add New Task");
        taskStage.setScene(taskScene);
        taskStage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setDate();
    }
}
