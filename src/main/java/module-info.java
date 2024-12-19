module com.textprocessingscrum {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    opens com.textprocessingscrum to javafx.fxml;
    exports com.textprocessingscrum;
}
