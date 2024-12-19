package com.textprocessingscrum.controllers;

import com.textprocessingscrum.App;
import com.textprocessingscrum.utils.NotificationToast;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NavigationController {
    private NotificationToast notificationToast = new NotificationToast();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox content;

    @FXML
    private Label route_dataManipulation;

    @FXML
    private Label route_textProcessing;

    @FXML
    void navDataManipulation(MouseEvent event) {
        loadPage("data_manipulation.fxml");
    }

    @FXML
    void navTextProcessing(MouseEvent event) {
        loadPage("text_processing.fxml");
    }

    @FXML
    void initialize() {


    }


    public void loadPage(String pageName) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(pageName));
            Parent page = loader.load();
            content.getChildren().clear();
            content.getChildren().add(page);
        } catch (IOException e) {
            notificationToast.showNotification(Alert.AlertType.ERROR, "Error while loading page", e.getMessage());
        }
    }

}
