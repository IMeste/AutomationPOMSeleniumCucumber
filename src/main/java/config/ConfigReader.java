package config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();
    private static boolean initialized = false;
    private static final Logger log = LoggerFactory.getLogger(ConfigReader.class);

    public static void init() {
        if (initialized) return;

        try {
            String environment = System.getProperty("environment", "qa").toLowerCase();

            String fileName = "environment/" + environment + ".properties";

            InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(fileName);

            if (input == null) {
                throw new RuntimeException(
                        "No se encontró el archivo de ambiente: " + fileName
                );
            }

            properties.load(input);
            initialized = true;

            log.info("ConfigReader cargado correctamente para el ambiente {}",
                    environment);
        } catch (Exception e) {
            throw new RuntimeException("Error cargando configuración: " + e.getMessage(), e);
        }
    }

    public static String get(String key) {
        if (!initialized) init();
        String value = properties.getProperty(key);

        if (value == null) {
            throw new RuntimeException("Llave no encontrada en el properties: " + key);
        }

        return value;
    }

    public static String get(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
