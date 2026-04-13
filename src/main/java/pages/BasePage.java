package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Clase base abstracta que proporciona métodos comunes para interactuar con elementos de la página web.
 * Esta clase contiene operaciones básicas de Selenium como clic, escritura, selección, etc.
 */
public abstract class BasePage {

    protected WebDriver driver;

    /**
     * Constructor de la clase BasePage.
     *
     * @param driver Instancia del WebDriver para controlar el navegador.
     */
    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Verifica si un elemento es visible en la página.
     *
     * @param locator Localizador del elemento a verificar.
     * @return true si el elemento es visible, false en caso contrario.
     */
    protected boolean isElementVisible(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return !elements.isEmpty() && elements.get(0).isDisplayed();
    }

    /**
     * Hace clic en un elemento de la página.
     *
     * @param locator Localizador del elemento a clickear.
     * @param elementName Nombre descriptivo del elemento (para mensajes de error).
     * @throws AssertionError si ocurre algún error al hacer clic en el elemento.
     */
    protected void click(By locator, String elementName) {
        try {
            driver.findElement(locator).click();
        } catch (Exception e) {
            throw new AssertionError(
                    String.format(
                            "[ACTION FAILED] Element: %s | Locator: %s | Action: click | Error: %s",
                            elementName,
                            locator,
                            e.getClass().getSimpleName()
                    )
            );
        }
    }

    /**
     * Escribe texto en un campo de entrada.
     *
     * @param locator Localizador del campo de texto.
     * @param text Texto a escribir en el campo.
     * @param elementName Nombre descriptivo del elemento (para mensajes de error).
     * @throws AssertionError si ocurre algún error al escribir en el elemento.
     */
    protected void type(By locator, String text, String elementName) {
        try {
            WebElement element = driver.findElement(locator);
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            throw new AssertionError(String.format(
                    "[ACTION FAILED] Element: %s | Locator: %s | Action: type | Error: %s",
                    elementName,
                    locator,
                    e.getClass().getSimpleName()
            ), e);
        }
    }

    /**
     * Obtiene el texto de un elemento.
     *
     * @param locator Localizador del elemento del cual obtener el texto.
     * @return El texto del elemento o null si el elemento no existe.
     */
    protected String getText(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        if (elements.isEmpty()){
            return null;
        }else {
            return elements.get(0).getText();
        }
    }

    /**
     * Selecciona una opción en un dropdown por su texto visible.
     *
     * @param locator Localizador del elemento select.
     * @param text Texto visible de la opción a seleccionar.
     * @param elementName Nombre descriptivo del elemento (para mensajes de error).
     * @throws AssertionError si ocurre algún error al seleccionar la opción.
     */
    protected void selectByVisibleText(By locator, String text, String elementName) {
        try {
            WebElement element = driver.findElement(locator);
            Select select = new Select(element);
            select.selectByVisibleText(text);
        } catch (Exception e) {
            throw new AssertionError(String.format(
                    "[ACTION FAILED] Element: %s | Locator: %s | Action: selectByVisibleText | Value: %s | Error: %s",
                    elementName,
                    locator,
                    text,
                    e.getClass().getSimpleName()
            ), e);
        }
    }

    /**
     * Selecciona una opción en un dropdown por su valor.
     *
     * @param locator Localizador del elemento select.
     * @param value Valor de la opción a seleccionar.
     * @param elementName Nombre descriptivo del elemento (para mensajes de error).
     * @throws AssertionError si ocurre algún error al seleccionar la opción.
     */
    protected void selectByValue(By locator, String value, String elementName) {
        try {
            WebElement element = driver.findElement(locator);
            Select select = new Select(element);
            select.selectByValue(value);
        } catch (Exception e) {
            throw new AssertionError(String.format(
                    "[ACTION FAILED] Element: %s | Locator: %s | Action: selectByValue | Value: %s | Error: %s",
                    elementName,
                    locator,
                    value,
                    e.getClass().getSimpleName()
            ), e);
        }
    }

    /**
     * Selecciona una opción en un dropdown por su índice.
     *
     * @param locator Localizador del elemento select.
     * @param index Índice de la opción a seleccionar (comenzando desde 0).
     * @param elementName Nombre descriptivo del elemento (para mensajes de error).
     * @throws AssertionError si ocurre algún error al seleccionar la opción.
     */
    protected void selectByIndex(By locator, int index, String elementName) {
        try {
            WebElement element = driver.findElement(locator);
            Select select = new Select(element);
            select.selectByIndex(index);
        } catch (Exception e) {
            throw new AssertionError(String.format(
                    "[ACTION FAILED] Element: %s | Locator: %s | Action: selectByIndex | Index: %d | Error: %s",
                    elementName,
                    locator,
                    index,
                    e.getClass().getSimpleName()
            ), e);
        }
    }

    /**
     * Presiona una tecla específica en un elemento.
     *
     * @param locator Localizador del elemento donde se presionará la tecla.
     * @param key Tecla a presionar (ejemplo: Keys.ENTER, Keys.TAB, etc.).
     * @param elementName Nombre descriptivo del elemento (para mensajes de error).
     * @throws AssertionError si ocurre algún error al presionar la tecla.
     */
    protected void pressKey(By locator, Keys key, String elementName) {
        try {
            WebElement element = driver.findElement(locator);
            element.sendKeys(key);
        } catch (Exception e) {
            throw new AssertionError(String.format(
                    "[ACTION FAILED] Element: %s | Locator: %s | Action: pressKey | Key: %s | Error: %s",
                    elementName,
                    locator,
                    key.name(),
                    e.getClass().getSimpleName()
            ), e);
        }
    }
}