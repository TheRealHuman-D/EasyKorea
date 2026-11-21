package com.therealhuman.dev.easykorea.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class MainController implements Initializable {
    @FXML
    private Node slideBar;
    @FXML
    private Node header;
    @FXML
    private StackPane pageHost;
    @FXML
    private Node dashboard;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(MainController.class.getName());
    }

}
