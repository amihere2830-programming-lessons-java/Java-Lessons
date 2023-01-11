package com.example.javafxapplication;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

public class Controller {
    @FXML
    private Label label;
    @FXML
    private Label label2;
    @FXML
    private Button button2;
    @FXML
    private GridPane gridPane;
    @FXML
    private WebView webView;


    public void initialize(){
        button2.setEffect(new DropShadow());
    }

    @FXML
    public void handleMouseEnter(){
        //Zoom label
        label.setScaleX(2.0);
        label.setScaleY(2.0);

    }

    @FXML
    private void handleClick(){

        //Choose file
        FileChooser fileChooser = new FileChooser();
//        File file = fileChooser.showOpenDialog(gridPane.getScene().getWindow());
//        if (file != null){
//            System.out.println(file.getPath());
//            System.out.println(file.getName());
//        } else {
//            System.out.println("Chooser was cancelled");
//        }
        //Save dialog
        fileChooser.setTitle("Save Application File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text","*.txt"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("All Files", "*.*"),
                new FileChooser.ExtensionFilter("Image Files", "*.jpg","*.png","*.gif")
                );
        List<File> file = fileChooser.showOpenMultipleDialog(gridPane.getScene().getWindow());
        if (file != null){
            for (int i=0;i<file.size();i++){
                System.out.println(file.get(i));
            }
        } else {
            System.out.println("Chooser was cancelled");
        }


        //Choose folder
//        DirectoryChooser directoryChooser = new DirectoryChooser();
//        File folder = directoryChooser.showDialog(gridPane.getScene().getWindow());
//        if (folder != null){
//            System.out.println(folder.getPath());
//            System.out.println(folder.getName());
//        } else {
//            System.out.println("Chooser was cancelled");
//        }

    }

    @FXML
    public void handleMouseExit(){

        //Zoom label (return to regular size)
        label.setScaleX(1.0);
        label.setScaleY(1.0);
    }

    @FXML
    public void handleKeyExit () {
        Platform.exit();
    }

    @FXML
    public void handleKeyEvent(KeyEvent keyEvent){

        //Exit app with keys (Ctrl + Q)
        if (keyEvent.getCode() == KeyCode.Q && keyEvent.isControlDown()) {
            handleKeyExit ();
        }
    }

    @FXML
    private void handleLinkClicked(){

////        System.out.println("Link clicked");
//        try {
//            Desktop.getDesktop().browse(new URI("https://openjfx.io/"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }catch (URISyntaxException e){
//            e.printStackTrace();
//        }

        WebEngine engine = webView.getEngine();
        engine.load("https://openjfx.io/");
    }


}