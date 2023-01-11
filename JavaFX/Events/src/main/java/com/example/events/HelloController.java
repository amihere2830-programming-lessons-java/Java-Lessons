package com.example.events;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label greetText;
    @FXML
    private Label nameText;
    @FXML
    private Label passwordText;
    @FXML
    private Label ourLabel;
    @FXML
    private TextField nameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Button byeButton;

    @FXML
    private CheckBox ourCheckBox;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void initialize(){
//        JavaFx runtime automatically calls this method when it is
//        initializing the UI
//        It can't have any parameter and
//        must be public
        loginButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    protected void onButtonClick(ActionEvent e) {
        if ((!nameField.getText().isBlank() || !nameField.getText().trim().isEmpty()) && e.getSource().equals(loginButton)){

            // Create an abstract task
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    try {
                        String s = Platform.isFxApplicationThread()? "UI Thread" : "Background Thread";
                        System.out.println("I'm going to sleep on the: "+s);
                        Thread.sleep(10000);

                        // create thread on the FX UI instead of background
                        // UI thread should only run after background is done
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("Done working in background.......");
                                String s = Platform.isFxApplicationThread()? "UI Thread" : "Background Thread";
                                System.out.println("I'm updating the label on the: "+s);
                                ourLabel.setText("We did something");
                            }
                        });

                    } catch (InterruptedException event) {
                        // we don't care about this
                    }
                }
            };
            // Run the created task
            new Thread(task).start();

            if (ourCheckBox.isSelected()){
                nameField.clear();
                passwordField.clear();
                loginButton.setDisable(true);
                byeButton.setDisable(true);
            }        }
    }

    @FXML
    public void handleKeyReleased(){
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        loginButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }

    public void handleChange(){
        System.out.println("The checkbox is "+(ourCheckBox.isSelected() ? "checked" : "not checked"));
    }
}