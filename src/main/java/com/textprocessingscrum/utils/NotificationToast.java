package com.textprocessingscrum.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import lombok.Generated;


@Generated
public class NotificationToast {
    public void showNotification(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setContentText(message);
        alert.setTitle(title);
        alert.showAndWait();
    }
}
