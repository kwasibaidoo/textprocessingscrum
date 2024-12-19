module com.textprocessingscrum {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.textprocessingscrum to javafx.fxml;
    exports com.textprocessingscrum;
}
