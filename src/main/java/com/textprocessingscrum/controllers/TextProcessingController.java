package com.textprocessingscrum.controllers;

import java.io.IOException;
import java.util.List;


import com.textprocessingscrum.App;
import com.textprocessingscrum.models.CollectionDAO;
import com.textprocessingscrum.models.DataCollection;
import com.textprocessingscrum.textutils.MatcherUtil;
import com.textprocessingscrum.textutils.SearchUtil;
import com.textprocessingscrum.utils.NotificationToast;
import com.textprocessingscrum.utils.ValidationResult;
import com.textprocessingscrum.utils.Validator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class TextProcessingController {

    private NotificationToast notificationToast = new NotificationToast();
    private CollectionDAO dao = CollectionDAO.getInstance();

    @FXML
    private CheckBox case_sensitive;

    @FXML
    private Button add_to_collection;

    @FXML
    private Button view_collection;

    @FXML
    private Label error_query;

    @FXML
    private Label error_regex;

    @FXML
    private Label error_text;

    @FXML
    private Button match;

    @FXML
    private TextField query;

    @FXML
    private TextField regex;

    @FXML
    private Button replace;

    @FXML
    private Button search;

    @FXML
    private TextArea text;

    @FXML
    private TextFlow searchResult;

    @FXML
    void addToCollection(MouseEvent event) {
        ValidationResult textVal = Validator.validate(text.getText(), "not_null");

        if (!textVal.isSuccess()) {
            error_text.setText(textVal.getMessage());
        } else {
            error_text.setText("");
            DataCollection entry = new DataCollection();
            entry.setData(text.getText());
            entry.setId(dao.getNextId());
            dao.save(entry);

            notificationToast.showNotification(AlertType.INFORMATION, "Success", "Text added to collection.");
        }
    }

    @FXML
    void viewCollection(MouseEvent event) {
        // pass the data to viewcontroller
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("viewcollection.fxml"));
            Parent root = fxmlLoader.load();
            ViewCollectionController controller = fxmlLoader.getController();
            controller.setDataCollection(dao.findAll());
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("View Collection");
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            notificationToast.showNotification(AlertType.ERROR, "Error while loading window", e.getMessage());
        }
    }

    @FXML
    void match(MouseEvent event) {
        ValidationResult regexVal = Validator.validate(regex.getText(), "not_null", "regex");
        ValidationResult textVal = Validator.validate(text.getText(), "not_null");

        if (!regexVal.isSuccess() || !textVal.isSuccess()) {
            error_regex.setText(regexVal.getMessage());
            error_text.setText(textVal.getMessage());
        } else {
            error_regex.setText("");
            error_text.setText("");
            error_query.setText("");

            boolean success = MatcherUtil.match(regex.getText(), text.getText(), case_sensitive.isSelected());
            if (success) {
                notificationToast.showNotification(AlertType.CONFIRMATION, "Match Found", "There is a match for the string '" + text.getText() + "'");
            } else {
                notificationToast.showNotification(AlertType.CONFIRMATION, "No Match Found", "There is no match for the string '" + text.getText() + "'");
            }
        }
    }

    @FXML
    void replace(MouseEvent event) {
        ValidationResult regexVal = Validator.validate(regex.getText(), "not_null", "regex");
        ValidationResult textVal = Validator.validate(text.getText(), "not_null");
        ValidationResult queryVal = Validator.validate(text.getText(), "not_null");

        if (!regexVal.isSuccess() || !textVal.isSuccess() || !queryVal.isSuccess()) {
            error_regex.setText(regexVal.getMessage());
            error_text.setText(textVal.getMessage());
            error_query.setText(queryVal.getMessage());
        } else {
            error_regex.setText("");
            error_text.setText("");
            error_query.setText("");

            List<List<Integer>> results = SearchUtil.search(regex.getText(), text.getText(), case_sensitive.isSelected());
            searchResult.getChildren().clear();
            int lastEnd = 0;
            for (List<Integer> list : results) {
                String beforeMatch = text.getText().substring(lastEnd, list.get(0));
                if (!beforeMatch.isEmpty()) {
                    searchResult.getChildren().add(new Text(beforeMatch));
                }

                String matchText = text.getText().substring(list.get(0), list.get(1));
                Rectangle background = new Rectangle(0, 0, matchText.length() * 7, 15);
                background.setFill(Color.BLACK);
                Text matchTextNode = new Text(matchText);
                matchTextNode.setFill(Color.WHITE);
                matchTextNode.setFont(Font.font("Arial", 12));
                matchTextNode.setText(query.getText());

                StackPane matchContainer = new StackPane(background, matchTextNode);
                // matchContainer.setSpacing(0);
                searchResult.getChildren().add(matchContainer);

                lastEnd = list.get(1);
            }
            String remainingText = text.getText().substring(lastEnd);
            if (!remainingText.isEmpty()) {
                searchResult.getChildren().add(new Text(remainingText));
            }
        }
    }

    @FXML
    void search(MouseEvent event) {
        ValidationResult regexVal = Validator.validate(regex.getText(), "not_null", "regex");
        ValidationResult textVal = Validator.validate(text.getText(), "not_null");

        if (!regexVal.isSuccess() || !textVal.isSuccess()) {
            error_regex.setText(regexVal.getMessage());
            error_text.setText(textVal.getMessage());
        } else {
            error_regex.setText("");
            error_text.setText("");
            error_query.setText("");

            List<List<Integer>> results = SearchUtil.search(regex.getText(), text.getText(), case_sensitive.isSelected());
            searchResult.getChildren().clear();
            int lastEnd = 0;
            for (List<Integer> list : results) {
                String beforeMatch = text.getText().substring(lastEnd, list.get(0));
                if (!beforeMatch.isEmpty()) {
                    searchResult.getChildren().add(new Text(beforeMatch));
                }

                String matchText = text.getText().substring(list.get(0), list.get(1));
                Rectangle background = new Rectangle(0, 0, matchText.length() * 7, 15);
                background.setFill(Color.BLACK);
                Text matchTextNode = new Text(matchText);
                matchTextNode.setFill(Color.WHITE);
                matchTextNode.setFont(Font.font("Arial", 12));

                StackPane matchContainer = new StackPane(background, matchTextNode);
                // matchContainer.setSpacing(0);
                searchResult.getChildren().add(matchContainer);

                lastEnd = list.get(1);
            }
            String remainingText = text.getText().substring(lastEnd);
            if (!remainingText.isEmpty()) {
                searchResult.getChildren().add(new Text(remainingText));
            }
        }
    }
}