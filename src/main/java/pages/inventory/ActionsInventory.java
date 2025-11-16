package pages.inventory;

import org.openqa.selenium.WebDriver;
import drivers.DriverFactory;

public class ActionsInventory {

    private final WebDriver driver;
    private final ElementsInventory elementsInventory;

    public ActionsInventory() {
        driver = DriverFactory.getDriver();
        elementsInventory = new ElementsInventory();
    }

    public void addSauceLabsBackpack(){
        elementsInventory.buttónAddSauceLabsBackpack.click();
    }

    public void addSauceLabsBikeLight(){
        elementsInventory.buttónAddSauceLabsBikeLight.click();
    }

    public void viewShoppingCart(){
        elementsInventory.aLinkShoppingCart.click();
    }
}
