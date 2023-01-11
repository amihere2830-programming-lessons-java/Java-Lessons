package com.example.layout;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label birthDayText;

    private String birthDayMsg = "My birthday is on ";

    @FXML
    protected void onSamuelButtonClick() {
        birthDayText.setText("I am Samuel Amihere.\n "+birthDayMsg+" 15-Mar");
    }

    @FXML
    protected void onRebeccaButtonClick() {
        birthDayText.setText("I am Rebecca Amihere.\n "+birthDayMsg+"29-Oct");
    }

    @FXML
    protected void onJeffButtonClick() {
        birthDayText.setText("I am Jeffrey B. Amihere.\n "+birthDayMsg+"28-Mar");
    }

    @FXML
    protected void onClementButtonClick() {
        birthDayText.setText("I am Clement Amihere.\n "+birthDayMsg+"31-May");
    }
}