package pages.inventory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import drivers.DriverFactory;

public class ElementsInventory {
    public WebDriver driver;
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") public WebElement buttónAddSauceLabsBackpack;
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']") public WebElement buttónAddSauceLabsBikeLight;
    @FindBy(xpath = "//a[@class='shopping_cart_link']") public WebElement aLinkShoppingCart;

    public ElementsInventory() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }
}
