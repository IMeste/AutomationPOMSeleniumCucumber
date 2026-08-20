package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase utilitaria para operaciones de fecha y hora.
 */
public class DateUtils {

    private DateUtils() {
    }

    /**
     * Retorna la fecha y hora actual formateada según el patrón indicado.
     *
     * @param pattern el patrón de formato de fecha y hora (ej. "dd/MM/yyyy", "yyyy-MM-dd HH:mm:ss")
     * @return un String con la fecha/hora actual en el formato especificado
     * @throws IllegalArgumentException si el patrón es nulo, vacío o inválido
     */
    public static String getCurrentDate(String pattern) {
        if (pattern == null || pattern.isBlank()) {
            throw new IllegalArgumentException("El patrón de formato no puede ser nulo ni vacío.");
        }

        DateTimeFormatter formatter;
        try {
            formatter = DateTimeFormatter.ofPattern(pattern);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Patrón de formato inválido: \"" + pattern + "\"", e);
        }

        return LocalDateTime.now().format(formatter);
    }

    /**
     * Convierte una fecha de un formato a otro.
     *
     * @param dateString la cadena de fecha que se va a convertir
     * @param currentPattern el patrón actual de la cadena de fecha (ej. "dd/MM/yyyy", "yyyy-MM-dd HH:mm:ss")
     * @param newPattern el nuevo patrón para la cadena de fecha (ej. "MM/dd/yyyy", "HH:mm:ss yyyy-MM-dd")
     * @return una cadena con la fecha en el nuevo formato
     * @throws IllegalArgumentException si alguno de los patrones es nulo, vacío o inválido
     */
    public static String convertDateFormat(String dateString, String currentPattern, String newPattern) {
        if (dateString == null || dateString.isBlank()) {
            throw new IllegalArgumentException("La fecha no puede ser nula ni vacía.");
        }
        if (currentPattern == null || currentPattern.isBlank()) {
            throw new IllegalArgumentException("El patrón de formato actual no puede ser nulo ni vacío.");
        }
        if (newPattern == null || newPattern.isBlank()) {
            throw new IllegalArgumentException("El nuevo patrón de formato no puede ser nulo ni vacío.");
        }

        DateTimeFormatter currentFormatter;
        try {
            currentFormatter = DateTimeFormatter.ofPattern(currentPattern);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Patrón de formato actual inválido: \"" + currentPattern + "\"", e);
        }

        DateTimeFormatter newFormatter;
        try {
            newFormatter = DateTimeFormatter.ofPattern(newPattern);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Nuevo patrón de formato inválido: \"" + newPattern + "\"", e);
        }

        LocalDateTime dateTime = LocalDateTime.parse(dateString, currentFormatter);
        return dateTime.format(newFormatter);
    }
}
