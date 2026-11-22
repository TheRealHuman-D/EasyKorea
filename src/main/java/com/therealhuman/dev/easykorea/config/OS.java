package com.therealhuman.dev.easykorea.config;

import java.nio.file.Path;
import java.util.function.UnaryOperator;
import lombok.Getter;

@Getter 
public enum OS {
    LINUX("Linux", "XDG_CONFIG_HOME", "XDG_DATA_HOME", home -> home
            .resolve(".config"), (Path home) -> home.resolve(".local/share")),
    MACOS("MaxOS", null, null, home -> home.resolve("Library/Application Support"), home -> home
            .resolve("Library/Application Support")),
    WINDOW("Window", "APPDATA", "LOCALAPPDATA", home -> home.resolve(
            "AppData/Roaming"), home -> home.resolve("AppData/Local"));

    private final String osName;
    private final String envConfig;
    private final String envData;
    private final UnaryOperator<Path> configFallback;
    private final UnaryOperator<Path> dataFallback;

    OS(String name, String envConfig, String envData, UnaryOperator<Path> configFallback,
            UnaryOperator<Path> dataFallback) {
        this.osName = name;
        this.envConfig = envConfig;
        this.envData = envData;
        this.configFallback = configFallback;
        this.dataFallback = dataFallback;
    }
}
