package support;

import org.junit.Assert;
import org.openqa.selenium.By;

/**
 * Clase de utilidad que contiene métodos personalizados para realizar afirmaciones (assertions) en las pruebas.
 * Proporciona mensajes de error detallados y formateados para facilitar la identificación de fallos en las pruebas.
 */
public final class CustomAssertions {

    /**
     * Constructor privado para evitar la instanciación de la clase.
     */
    private CustomAssertions() {}

    /**
     * Verifica si un elemento es visible en la página.
     *
     * @param actualCondition Condición booleana que indica si el elemento es visible o no.
     * @param element Localizador del elemento que se está verificando.
     * @param elementName Nombre descriptivo del elemento para incluir en el mensaje de error.
     */
    public static void assertElementVisible(boolean actualCondition, By element, String elementName) {
        if (!actualCondition) {
            String message = String.format(
                    "[VALIDATION FAILED] Element: %s | Locator: %s | Expected: visible | Actual: not visible",
                    elementName,
                    element.toString()
            );
            Assert.fail(message);
        }
    }

    /**
     * Compara el texto esperado con el texto actual de un elemento identificado por un localizador.
     *
     * @param expected Texto esperado que debería tener el elemento.
     * @param element Localizador del elemento cuyo texto se va a comparar.
     * @param actual Texto actual del elemento obtenido durante la prueba.
     * @param elementName Nombre descriptivo del elemento para incluir en el mensaje de error.
     */
    public static void assertEqualsText(String expected, By element, String actual, String elementName) {
        if (actual == null) {
            Assert.fail(String.format(
                    "[VALIDATION FAILED] Element: %s | Locator: %s | Expected text: '%s' | Actual text: <NULL> (element not found or empty)",
                    elementName, element, expected
            ));
        }

        if (expected == null) {
            Assert.fail(String.format(
                    "[ASSERT CONFIG ERROR] Expected text is NULL for element: %s | Locator: %s",
                    elementName, element
            ));
        }

        if (!expected.equals(actual)) {
            Assert.fail(String.format(
                    "[VALIDATION FAILED] Element: %s | Locator: %s | Expected text: '%s' | Actual text: '%s'",
                    elementName, element, expected, actual
            ));
        }
    }

    /**
     * Compara el texto esperado con el texto actual proporcionado directamente.
     *
     * @param expected Texto esperado que se va a comparar.
     * @param actual Texto actual que se va a comparar con el esperado.
     * @param elementName Nombre descriptivo del elemento o contexto para incluir en el mensaje de error.
     */
    public static void assertEqualsText(String expected, String actual, String elementName) {
        if (actual == null) {
            Assert.fail(String.format(
                    "[VALIDATION FAILED] Element: %s | Expected text: '%s' | Actual text: <NULL> (element not found or empty)",
                    elementName, expected
            ));
        }

        if (expected == null) {
            Assert.fail(String.format(
                    "[ASSERT CONFIG ERROR] Expected text is NULL for element: %s",
                    elementName
            ));
        }

        if (!expected.equals(actual)) {
            Assert.fail(String.format(
                    "[VALIDATION FAILED] Element: %s | Expected text: '%s' | Actual text: '%s'",
                    elementName, expected, actual
            ));
        }
    }

    /**
     * Compara la URL esperada con la URL actual.
     *
     * @param expected URL esperada que debería estar cargada en el navegador.
     * @param actual URL actual que tiene cargada el navegador.
     * @param elementName Nombre descriptivo del contexto o página para incluir en el mensaje de error.
     */
    public static void assertEqualsUrl(String expected, String actual, String elementName) {
        if (!expected.equals(actual)) {
            String message = String.format(
                    "[VALIDATION FAILED] Element: %s | Expected url: '%s' | Actual url: '%s'",
                    elementName, expected, actual
            );
            Assert.fail(message);
        }
    }

    /**
     * Verifica si el texto esperado está contenido dentro del texto actual.
     *
     * @param expected Texto esperado que debe estar contenido en el texto actual.
     * @param actual Texto actual donde se buscará el texto esperado.
     * @param elementName Nombre descriptivo del elemento o contexto para incluir en el mensaje de error.
     */
    public static void assertContainsText(String expected, String actual, String elementName) {
        if (actual == null) {
            Assert.fail(String.format(
                    "[VALIDATION FAILED] Element: %s | Expected contained text: '%s' | Actual text: <NULL> (element not found or empty)",
                    elementName, expected
            ));
        }

        if (expected == null) {
            Assert.fail(String.format(
                    "[ASSERT CONFIG ERROR] Expected contained text is NULL for element: %s",
                    elementName
            ));
        }

        if (!actual.contains(expected)) {
            Assert.fail(String.format(
                    "[VALIDATION FAILED] Element: %s | Expected contained text: '%s' | Actual text: '%s'",
                    elementName, expected, actual
            ));
        }
    }
}
