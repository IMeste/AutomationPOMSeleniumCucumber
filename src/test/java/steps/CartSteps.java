package steps;

import io.cucumber.java.en.When;
import pages.cart.ActionsCart;
import support.ActionsCommon;

public class CartSteps {
    private final ActionsCommon actionsCommon;
    private final ActionsCart actionsCart;

    public CartSteps(ActionsCommon actionsCommon, ActionsCart actionsInventory) {
        this.actionsCommon = actionsCommon;
        this.actionsCart = actionsInventory;
    }

    @When("Click sobre el boton de Checkout")
    public void click_sobre_el_boton_de_checkout() {
        actionsCart.clickCheckout();
    }


}


