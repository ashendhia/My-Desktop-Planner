package tp.javafx.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class loginController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label AppName;
    @FXML
    private Label title;
    @FXML
    private Button logIn;
    @FXML
    private Button signUp;

    @FXML
    private Button createNew;

    @FXML
    private Pane logPane;

    @FXML
    private Pane signUpPane;

    @FXML
    private void handleSignUp( ActionEvent event) {
    }


    @FXML
    private void handleLogIn( ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("/tp/javafx/home.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleCreateNew(ActionEvent event) {
        signUpPane.toFront();
    }

    @FXML
    private void handleGoBack (ActionEvent event) {
        logPane.toFront();
    }

}