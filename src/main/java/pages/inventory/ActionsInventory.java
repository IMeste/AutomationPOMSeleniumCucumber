package pages.inventory;

import org.openqa.selenium.WebDriver;

public class ActionsInventory {

    private final ElementsInventory elementsInventory;

    public ActionsInventory(WebDriver driver) {
        elementsInventory = new ElementsInventory(driver);
    }

    public void addSauceLabsBackpack(){
        elementsInventory.buttonAddSauceLabsBackpack.click();
    }

    public void addSauceLabsBikeLight(){
        elementsInventory.buttonAddSauceLabsBikeLight.click();
    }

    public void viewShoppingCart(){
        elementsInventory.aLinkShoppingCart.click();
    }
}
