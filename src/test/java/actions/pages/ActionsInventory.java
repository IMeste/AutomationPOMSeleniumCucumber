package actions.pages;

import elements.pages.ElementsInventory;
import org.openqa.selenium.WebDriver;
import steps.CommonSteps;

public class ActionsInventory {

    private final WebDriver driver;
    private final ElementsInventory elementsInventory;

    public ActionsInventory(CommonSteps commonSteps) {
        driver = CommonSteps.getDriver();
        elementsInventory = new ElementsInventory(commonSteps);
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
