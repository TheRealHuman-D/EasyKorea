package com.therealhuman.dev.easykorea.app;

import java.util.Objects;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.therealhuman.dev.easykorea.config.AppConfig;
import com.therealhuman.dev.easykorea.config.ConfigService;
import com.therealhuman.dev.easykorea.navigator.View;

public class EasyKoreaApplication extends Application {

    @Override
    public void start(Stage stage) {
        try {
            ConfigService.load();
            FXMLLoader fxmlLoader =
                    new FXMLLoader(EasyKoreaApplication.class
                            .getResource(View.MAIN_SHELL_VIEW.viewPath()));
            Parent root = fxmlLoader.load();
            root.getStyleClass().add("theme-light");
            Scene scene = new Scene(root, 800, 500);
            scene.getStylesheets().add(Objects.requireNonNull(EasyKoreaApplication.class
                    .getResource("/com/therealhuman/dev/easykorea/css/app.css")).toExternalForm());
            stage.setTitle("Easy Korea");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        try {
            ConfigService.save(new AppConfig());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
