package config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();
    private static boolean initialized = false;

    public static void init() {
        if (initialized) return;

        try {
            // Lee el ambiente desde el parámetro Maven o variable del sistema
            String environment = System.getProperty("environment", "qa").toLowerCase();

            // Construye el nombre del archivo
            String fileName = "environment/" + environment + ".properties";

            // Intenta cargar el archivo
            InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(fileName);

            if (input == null) {
                throw new RuntimeException(
                        "No se encontró el archivo de ambiente: " + fileName +
                                "\nAsegúrate de que esté en src/test/resources/environment/"
                );
            }

            // 4) Cargar properties
            properties.load(input);
            initialized = true;

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
        if (!initialized) init();
        return properties.getProperty(key, defaultValue);
    }
}
