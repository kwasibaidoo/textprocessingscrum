module com.textprocessingscrum {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;

    opens com.textprocessingscrum to javafx.fxml;
    opens com.textprocessingscrum.controllers to javafx.fxml;
    opens com.textprocessingscrum.models to javafx.base;
    exports com.textprocessingscrum;
    exports com.textprocessingscrum.controllers;
    exports com.textprocessingscrum.models;
}
