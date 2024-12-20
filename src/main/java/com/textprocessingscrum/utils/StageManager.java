package com.textprocessingscrum.utils;

import javafx.stage.Stage;
import lombok.Generated;


@Generated
public class StageManager {
    private static Stage primaryStage;

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
}