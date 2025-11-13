package steps;

import actions.pages.ActionsCommon;
import actions.pages.ActionsInventory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class InventorySteps {
    private final ActionsCommon actionsCommon;
    private final ActionsInventory actionsInventory;

    public InventorySteps(ActionsCommon actionsCommon, ActionsInventory actionsInventory) {
        this.actionsCommon = actionsCommon;
        this.actionsInventory = actionsInventory;
    }

    @When("Añadir {string} al carro de compra")
    public void añadir_producto_al_carro(String nombreProducto) {
        switch (nombreProducto){
            case "Sauce Labs Backpack":
                actionsInventory.addSauceLabsBackpack();
                break;
            case "Sauce Labs Bike Light":
                actionsInventory.addSauceLabsBikeLight();
        }
    }

    @When("Click sobre el carro de compra")
    public void click_sobre_el_carro() {
        actionsInventory.viewShoppingCart();
    }


}


