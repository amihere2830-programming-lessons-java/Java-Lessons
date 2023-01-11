module com.example.layoutpart2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.layoutpart2 to javafx.fxml;
    exports com.example.layoutpart2;
}