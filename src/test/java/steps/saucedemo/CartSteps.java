package steps.saucedemo;

import drivers.DriverFactory;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.saucedemo.cart.CartPage;
import pages.saucedemo.checkout.CheckoutStepOnePage;
import pages.saucedemo.inventory.InventoryPage;
import support.CustomAssertions;

public class CartSteps {

    private final CartPage cartPage;
    private final InventoryPage inventoryPage;
    private final CheckoutStepOnePage checkoutStepOnePage;

    public CartSteps() {
        WebDriver driver = DriverFactory.getDriver();
        this.cartPage = new CartPage(driver);
        this.inventoryPage = new InventoryPage(driver);
        this.checkoutStepOnePage = new CheckoutStepOnePage(driver);
    }

    @When("Genero el carro con 2 productos")
    public void anadir_dos_productos_al_carro() {
        inventoryPage.addSauceLabsBackpack();
        inventoryPage.addSauceLabsBikeLight();
        inventoryPage.viewShoppingCart();
        CustomAssertions.assertElementVisible(cartPage.isTituloDisplayed(), cartPage.getTitulo(), "Titulo del carro");
        // Validar que se muestre el primer item correctamente
        CustomAssertions.assertEqualsText("Sauce Labs Backpack", cartPage.getNameBy(), cartPage.getTextNameCartItem(0), "Nombre del producto del carro");
        CustomAssertions.assertEqualsText("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                cartPage.getDescriptionBy(), cartPage.getTextDescriptionCartItem(0), "Descripción del producto del carro");
        CustomAssertions.assertEqualsText("$29.99", cartPage.getPriceBy(), cartPage.getTextPriceCartItem(0), "Precio del producto del carro");
        CustomAssertions.assertEqualsText("1", cartPage.getQuantityBy(), cartPage.getTextQuantityCartItem(0), "Cantidad del producto del carro");
        // Validar que se muestre el segundo item correctamente
        CustomAssertions.assertEqualsText("Sauce Labs Bike Light", cartPage.getNameBy(), cartPage.getTextNameCartItem(1), "Nombre del producto del carro");
        CustomAssertions.assertEqualsText("A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
                cartPage.getDescriptionBy(), cartPage.getTextDescriptionCartItem(1), "Descripción del producto del carro");
        CustomAssertions.assertEqualsText("$9.99", cartPage.getPriceBy(), cartPage.getTextPriceCartItem(1), "Precio del producto del carro");
        CustomAssertions.assertEqualsText("1", cartPage.getQuantityBy(), cartPage.getTextQuantityCartItem(1), "Cantidad del producto del carro");
        cartPage.clickCheckout();
        CustomAssertions.assertElementVisible(checkoutStepOnePage.isTituloDisplayed(), checkoutStepOnePage.getTitulo(), "Titulo del Checkout");
    }

    @When("Añadir {string} al carro de compra")
    public void anadir_producto_al_carro(String nombreProducto) {
        switch (nombreProducto){
            case "Sauce Labs Backpack":
                inventoryPage.addSauceLabsBackpack();
                break;
            case "Sauce Labs Bike Light":
                inventoryPage.addSauceLabsBikeLight();
        }
    }

    @When("Click sobre el carro de compra")
    public void click_sobre_el_carro() {
        inventoryPage.viewShoppingCart();
    }

    @When("Click sobre el boton de Checkout")
    public void click_sobre_el_boton_de_checkout() {
        cartPage.clickCheckout();
    }
}


