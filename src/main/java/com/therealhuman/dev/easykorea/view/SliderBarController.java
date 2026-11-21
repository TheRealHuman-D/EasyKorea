package com.therealhuman.dev.easykorea.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import com.therealhuman.dev.easykorea.navigator.Navigator;
import com.therealhuman.dev.easykorea.navigator.View;

public class SliderBarController implements Initializable {

    @FXML
    private Button dashboardButton;
    @FXML
    private Button vocabularyButton;
    @FXML
    private Button testCenterButton;
    @FXML
    private Button myProgressButton;
    @FXML
    private Button collapseSidebarButton;
    @FXML
    private Button settingButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Container has loaded");
    }

    @FXML
    private void handleOnVocabularyButton(ActionEvent event) {
        try {
            Scene scene = testCenterButton.getScene();
            BorderPane pane = (BorderPane) ((BorderPane) scene.getRoot()).getCenter();
            StackPane stackPane = (StackPane) pane.getCenter();
            Navigator navigator = Navigator.get();
            navigator.switchTo(stackPane);
            navigator.navigate(View.MY_COURSE_VIEW_VIEW);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void handleOnDashboardButton(ActionEvent event) {
        try {
            Scene scene = testCenterButton.getScene();
            BorderPane pane = (BorderPane) ((BorderPane) scene.getRoot()).getCenter();
            StackPane stackPane = (StackPane) pane.getCenter();
            Navigator navigator = Navigator.get();
            navigator.switchTo(stackPane);
            navigator.navigate(View.DASHBOARD_VIEW);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
