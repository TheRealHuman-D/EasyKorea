package com.therealhuman.dev.easykorea;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EasyKoreaApplication extends Application {
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader
                    .load(EasyKoreaApplication.class.getResourceAsStream("main-view.fxml"));
            Scene scene = new Scene(root, 800, 500);
            stage.setScene(scene);
            stage.setTitle("Easy Korea");
            stage.show();
        } catch (Exception ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
