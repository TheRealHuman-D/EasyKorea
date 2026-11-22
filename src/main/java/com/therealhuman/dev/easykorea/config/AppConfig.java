package com.therealhuman.dev.easykorea.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppConfig {
    private final Ui ui = new Ui();

    @Getter
    @Setter
    private static class Ui {
        private String theme = "Light";
    }
}
