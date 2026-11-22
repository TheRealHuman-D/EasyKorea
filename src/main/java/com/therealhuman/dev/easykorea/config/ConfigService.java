package com.therealhuman.dev.easykorea.config;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.function.UnaryOperator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.toml.TomlMapper;

public class ConfigService {
    private static final String DIR_NAME = "easy-korea";
    private static final String FILE_NAME = "config.toml";
    private static final Path HOME = Path.of(System.getProperty("user.home"));
    private static final OS OS_NAME;
    private static final TomlMapper mapper = (TomlMapper) new TomlMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    static {
        String osNameProperty = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        if (osNameProperty.contains("linux")) {
            OS_NAME = OS.LINUX;
        } else if (osNameProperty.contains("mac")) {
            OS_NAME = OS.MACOS;
        } else {
            OS_NAME = OS.WINDOW;
        }
    }

    public static OS getOS() {
        return OS_NAME;
    }

    public static AppConfig load() throws Exception {
        Path path = getConfigPath();
        if (!Files.exists(path)) {
            return new AppConfig();
        }
        return mapper.readValue(path.toFile(), AppConfig.class);
    }

    public static void save(AppConfig config) throws Exception {
        Path path = getConfigPath();
        if (!Files.exists(path.getParent())) {
            Files.createDirectories(path.getParent());
        }
        mapper.writeValue(path.toFile(), config);
    }

    private static Path getConfigPath() {
        return resolve(OS_NAME.getEnvConfig(), OS_NAME.getConfigFallback()).resolve(DIR_NAME)
                .resolve(FILE_NAME);
    }

    private static Path resolve(String envVar, UnaryOperator<Path> fallback) {
        if (envVar != null) {
            String env = System.getenv(envVar);
            if (env != null && !env.isBlank()) {
                Path path = Path.of(env);
                if (path.isAbsolute()) {
                    return path;
                }
            }
        }
        return fallback.apply(HOME);
    }
}
