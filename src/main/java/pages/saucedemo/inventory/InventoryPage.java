package pages.saucedemo.inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class InventoryPage extends BasePage {

    private final By buttonAddSauceLabsBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By buttonAddSauceLabsBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private final By linkShoppingCart = By.cssSelector(".shopping_cart_link");
    private final By titulo = By.cssSelector(".title");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleDisplayed() {
        return isElementVisible(titulo);
    }

    public By getByTitle() {
        return titulo;
    }

    public void addSauceLabsBackpack(){
        click(buttonAddSauceLabsBackpack, "Botón Añadir Sauce Labs Back Pack");
    }

    public void addSauceLabsBikeLight(){
        click(buttonAddSauceLabsBikeLight, "Botón Añadir Sauce Labs Bike Light");
    }

    public void viewShoppingCart(){
        click(linkShoppingCart, "Enlace a la página de Carrito de Compras");
    }
}
