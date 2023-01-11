package com.example.helloworldfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        String name = "Samuel";
        welcomeText.setText(name + ", Welcome to JavaFX Application!");
    }
}