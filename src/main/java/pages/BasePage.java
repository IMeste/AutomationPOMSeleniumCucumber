package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Clase base abstracta que proporciona métodos comunes para interactuar con elementos de la página web.
 * Esta clase contiene operaciones básicas de Selenium como clic, escritura, selección, etc.
 */
public abstract class BasePage {

    protected WebDriver driver;
    public final WebDriverWait wait;

    /**
     * Constructor de la clase BasePage.
     *
     * @param driver Instancia del WebDriver para controlar el navegador.
     */
    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
    protected void pressKeyInElement(By locator, Keys key, String elementName) {
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

    /**
     * Presiona una tecla específica en general.
     *
     * @param key Tecla a presionar (ejemplo: Keys.ENTER, Keys.TAB, etc.).
     * @throws AssertionError si ocurre algún error al presionar la tecla.
     */
    protected void pressKeyGeneric(Keys key) {
        try {
            Actions actions = new Actions(driver);
            actions.sendKeys(key).perform();
        } catch (Exception e) {
            throw new AssertionError(String.format(
                    "[ACTION FAILED] Action: pressKey | Key: %s | Error: %s",
                    key.name(),
                    e.getClass().getSimpleName()
            ), e);
        }
    }

    /**
     * Selecciona una opción en un componente Select personalizado de React/MUI
     * haciendo click en el dropdown y luego en la opción que coincida con el texto indicado.
     *
     * @param dropdownLocator Localizador del componente Select de React (el div que abre el menú).
     * @param optionText      Texto visible de la opción a seleccionar.
     * @param elementName     Nombre descriptivo del elemento (para mensajes de error).
     * @throws AssertionError si el dropdown no abre, la opción no existe, o ocurre cualquier error durante la acción.
     */
    protected void selectReactOptionByText(By dropdownLocator, String optionText, String elementName) {
        try {
            // Espera a que el dropdown sea clickeable y lo abre
            WebElement dropdown = wait.until(
                    ExpectedConditions.elementToBeClickable(dropdownLocator)
            );
            dropdown.click();

            // Espera a que las opciones del listbox sean visibles en el DOM
            List<WebElement> options = wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            By.cssSelector("ul[role='listbox'] li")
                    )
            );

            // Recorre las opciones buscando la que coincida con el texto (ignorando mayúsculas/minúsculas)
            boolean found = false;
            for (WebElement option : options) {
                if (option.getText().trim().equalsIgnoreCase(optionText)) {
                    option.click();
                    found = true;
                    break;
                }
            }

            // Si ninguna opción coincidió, lanza un error descriptivo
            if (!found) {
                throw new NoSuchElementException(
                        String.format("El texto '%s' no coincide con ninguna opción disponible en el listbox.", optionText)
                );
            }

        } catch (Exception e) {
            throw new AssertionError(String.format(
                    "[ACTION FAILED] Element: %s | Locator: %s | Action: selectReactOptionByText | Value: %s | Error: %s",
                    elementName,
                    dropdownLocator,
                    optionText,
                    e.getClass().getSimpleName()
            ), e);
        }
    }
}