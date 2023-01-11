module com.example.scenbuilder {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.scenbuilder to javafx.fxml;
    exports com.example.scenbuilder;
}