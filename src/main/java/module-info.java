module com.therealhuman.dev.easykorea {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    requires static lombok;
    requires com.fasterxml.jackson.dataformat.toml;
    requires com.fasterxml.jackson.databind;

    exports com.therealhuman.dev.easykorea;
    exports com.therealhuman.dev.easykorea.view;
    exports com.therealhuman.dev.easykorea.navigator;
    exports com.therealhuman.dev.easykorea.app;

    opens com.therealhuman.dev.easykorea
            to javafx.fxml;
    opens com.therealhuman.dev.easykorea.app to javafx.fxml;
    opens com.therealhuman.dev.easykorea.view to javafx.fxml;
    opens com.therealhuman.dev.easykorea.config
            to com.fasterxml.jackson.databind, com.fasterxml.jackson.dataformat.toml;
}

