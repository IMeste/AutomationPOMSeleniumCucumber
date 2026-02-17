package pages.saucedemo.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class CartPage extends BasePage {

    private final By titulo = By.cssSelector(".title");
    private final By buttonCheckout = By.id("checkout");
    private final By cartItemDiv = By.cssSelector(".cart_item");
    private final By nameItemCart = By.cssSelector(".inventory_item_name");
    private final By descriptionItemCart = By.cssSelector(".inventory_item_desc");
    private final By priceItemCart = By.cssSelector(".inventory_item_price");
    private final By quantityItemCart = By.cssSelector(".cart_quantity");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTituloDisplayed() {
        return isElementVisible(titulo);
    }

    public By getTitulo(){
        return titulo;
    }

    public WebElement getCartItemDivInWebElement(int posicion) {
        List<WebElement> items = driver.findElements(cartItemDiv);
        if (items.isEmpty()) {
            return null;
        }
        if (posicion < 0 || posicion >= items.size()) {
            return null;
        }
        return items.get(posicion);
    }

    public String getTextNameCartItem(int posicion) {
        WebElement cartItem = getCartItemDivInWebElement(posicion);
        if (cartItem != null) {
            List<WebElement> tituloCartItem = cartItem.findElements(nameItemCart);
            return tituloCartItem.isEmpty() ? null : tituloCartItem.get(0).getText();
        }else{
            return null;
        }
    }

    public By getNameBy(){
        return nameItemCart;
    }

    public String getTextDescriptionCartItem(int posicion) {
        WebElement cartItem = getCartItemDivInWebElement(posicion);
        if (cartItem != null) {
            List<WebElement> tituloCartItem = cartItem.findElements(descriptionItemCart);
            return tituloCartItem.isEmpty() ? null : tituloCartItem.get(0).getText();
        }else{
            return null;
        }
    }

    public By getDescriptionBy(){
        return descriptionItemCart;
    }

    public String getTextPriceCartItem(int posicion) {
        WebElement cartItem = getCartItemDivInWebElement(posicion);
        if (cartItem != null) {
            List<WebElement> tituloCartItem = cartItem.findElements(priceItemCart);
            return tituloCartItem.isEmpty() ? null : tituloCartItem.get(0).getText();
        }else{
            return null;
        }
    }

    public By getPriceBy(){
        return priceItemCart;
    }

    public String getTextQuantityCartItem(int posicion) {
        WebElement cartItem = getCartItemDivInWebElement(posicion);
        if (cartItem != null) {
            List<WebElement> tituloCartItem = cartItem.findElements(quantityItemCart);
            return tituloCartItem.isEmpty() ? null : tituloCartItem.get(0).getText();
        }else{
            return null;
        }
    }

    public By getQuantityBy(){
        return quantityItemCart;
    }

    public void clickCheckout(){
        click(buttonCheckout, "Botón Checkout");
    }


}
