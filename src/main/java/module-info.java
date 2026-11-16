module com.therealhuman.dev.easykorea {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    exports com.therealhuman.dev.easykorea;
    exports com.therealhuman.dev.easykorea.view;

    opens com.therealhuman.dev.easykorea to javafx.fxml;
    opens com.therealhuman.dev.easykorea.view to javafx.fxml;
}

