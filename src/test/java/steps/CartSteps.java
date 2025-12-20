package steps;

import io.cucumber.java.en.When;
import pages.cart.ActionsCart;
import pages.inventory.ActionsInventory;

public class CartSteps {
    private final ActionsCart actionsCart;
    private final ActionsInventory actionsInventory;

    public CartSteps(ActionsCart actionsCart, ActionsInventory actionsInventory) {
        this.actionsCart = actionsCart;
        this.actionsInventory = actionsInventory;
    }

    @When("Genero el carro con 2 productos")
    public void añadir_dos_productos_al_carro() {
        actionsInventory.addSauceLabsBackpack();
        actionsInventory.addSauceLabsBikeLight();
        actionsInventory.viewShoppingCart();
        actionsCart.clickCheckout();
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

    @When("Click sobre el boton de Checkout")
    public void click_sobre_el_boton_de_checkout() {
        actionsCart.clickCheckout();
    }


}


