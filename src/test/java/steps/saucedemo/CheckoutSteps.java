package steps.saucedemo;

import config.ConfigReader;
import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.saucedemo.checkout.CheckoutCompletePage;
import pages.saucedemo.checkout.CheckoutStepOnePage;
import pages.saucedemo.checkout.CheckoutStepTwoPage;
import pages.saucedemo.inventory.InventoryPage;
import support.ActionsCommon;
import support.CustomAssertions;

public class CheckoutSteps {
    private final CheckoutStepOnePage checkoutStepOnePage;
    private final CheckoutStepTwoPage checkoutStepTwoPage;
    private final CheckoutCompletePage checkoutCompletePage;
    private final InventoryPage inventoryPage;
    private final ActionsCommon actionsCommon;

    public CheckoutSteps(){
        WebDriver driver = DriverFactory.getDriver();
        this.checkoutStepOnePage = new CheckoutStepOnePage(driver);
        this.checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        this.checkoutCompletePage = new CheckoutCompletePage(driver);
        this.inventoryPage = new InventoryPage(driver);
        this.actionsCommon = new ActionsCommon(driver);
    }

    @And("Ingreso datos de usuario en el checkout")
    public void ingreso_datos_usuario_checkout(){
        checkoutStepOnePage.sendFirstName(ConfigReader.get("firstName"));
        checkoutStepOnePage.sendLastName(ConfigReader.get("lastName"));
        checkoutStepOnePage.sendPostalCode(ConfigReader.get("postalCode"));
        checkoutStepOnePage.clickContinue();
        CustomAssertions.assertElementVisible(checkoutStepTwoPage.isTituloDisplayed(), checkoutStepTwoPage.getTitulo(), "Titulo del resumen de pago");
    }

    @Then("Validar el resumen de pago de los 2 productos")
    public void validar_resumen_pago_dos_productos(){
        // Validar que se muestre el primer item correctamente
        CustomAssertions.assertEqualsText("Sauce Labs Backpack", checkoutStepTwoPage.getNameBy(), checkoutStepTwoPage.getTextNameCartItem(0), "Nombre del producto del carro");
        CustomAssertions.assertEqualsText("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
                checkoutStepTwoPage.getDescriptionBy(), checkoutStepTwoPage.getTextDescriptionCartItem(0), "Descripción del producto del carro");
        CustomAssertions.assertEqualsText("$29.99", checkoutStepTwoPage.getPriceBy(), checkoutStepTwoPage.getTextPriceCartItem(0), "Precio del producto del carro");
        CustomAssertions.assertEqualsText("1", checkoutStepTwoPage.getQuantityBy(), checkoutStepTwoPage.getTextQuantityCartItem(0), "Cantidad del producto del carro");

        // Validar que se muestre el segundo item correctamente
        CustomAssertions.assertEqualsText("Sauce Labs Bike Light", checkoutStepTwoPage.getNameBy(), checkoutStepTwoPage.getTextNameCartItem(1), "Nombre del producto del carro");
        CustomAssertions.assertEqualsText("A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
                checkoutStepTwoPage.getDescriptionBy(), checkoutStepTwoPage.getTextDescriptionCartItem(1), "Descripción del producto del carro");
        CustomAssertions.assertEqualsText("$9.99", checkoutStepTwoPage.getPriceBy(), checkoutStepTwoPage.getTextPriceCartItem(1), "Precio del producto del carro");
        CustomAssertions.assertEqualsText("1", checkoutStepTwoPage.getQuantityBy(), checkoutStepTwoPage.getTextQuantityCartItem(1), "Cantidad del producto del carro");

        // Validar los datos de resumen
        CustomAssertions.assertEqualsText("SauceCard #31337", checkoutStepTwoPage.getByPaymentInfoValue(), checkoutStepTwoPage.getTextPaymentInfoValue(), "Payment Information");
        CustomAssertions.assertEqualsText("Free Pony Express Delivery!", checkoutStepTwoPage.getByShippingInfoValue(), checkoutStepTwoPage.getTextShippingInfoValue(), "Shipping Information");
        CustomAssertions.assertEqualsText("Item total: $39.98", checkoutStepTwoPage.getBySummarySubtotalLabel(), checkoutStepTwoPage.getTextSummarySubtotalLabel(), "Summary Subtotal");
        CustomAssertions.assertEqualsText("Tax: $3.20", checkoutStepTwoPage.getBySummaryTaxLabel(), checkoutStepTwoPage.getTextSummaryTaxLabel(), "Summary Tax");
        CustomAssertions.assertEqualsText("Total: $43.18", checkoutStepTwoPage.getBySummaryTotalLabel(), checkoutStepTwoPage.getTextSummaryTotalLabel(), "Summary Total");
    }

    @When("Presiono el botón para finalizar el flujo de pago")
    public void presiono_boton_finalizar_flujo_pago(){
        checkoutStepTwoPage.clickFinish();
        CustomAssertions.assertElementVisible(checkoutCompletePage.isTituloDisplayed(), checkoutCompletePage.getTitulo(), "Titulo del comprobante de pago");
    }

    @Then("Sistema confirma el pago de la orden")
    public void sistema_confirma_el_pago_de_la_orden() {
        CustomAssertions.assertEqualsText("Thank you for your order!", checkoutCompletePage.getByPaymentHeaderLabel(), checkoutCompletePage.getTextCheckoutHeader(), "Titulo del pago finalizado");
        CustomAssertions.assertEqualsText("Your order has been dispatched, and will arrive just as fast as the pony can get there!",
                checkoutCompletePage.getByCheckoutComplete(), checkoutCompletePage.getTextCheckoutComplete(), "Descripción del pago finalizado");
    }

    @When("Presiono el botón para volver al home")
    public void presiono_el_boton_para_volver_al_home() {
        checkoutCompletePage.clickBackHome();
    }

    @Then("Validar que el sistema redirecciono al home {string}")
    public void validar_que_el_sistema_redirecciono_al_home(String url) {
        CustomAssertions.assertElementVisible(inventoryPage.isTitleDisplayed(), inventoryPage.getByTitle(), "Titulo del inventario");
        CustomAssertions.assertEqualsUrl(url, actionsCommon.getCurrentUrl(), "Home Url");
    }


    @When("Ingreso el primero nombre {string}")
    public void ingreso_el_primero_nombre(String firstName) {
        checkoutStepOnePage.sendFirstName(firstName);
    }

    @When("Ingreso el segundo nombre {string}")
    public void ingreso_el_segundo_nombre(String lastName) {
        checkoutStepOnePage.sendLastName(lastName);
    }

    @When("Ingreso el codigo postal {string}")
    public void ingreso_el_codigo_postal(String postalCode) {
        checkoutStepOnePage.sendPostalCode(postalCode);
    }

    @When("Click sobre el boton de continuar")
    public void click_sobre_el_boton_de_continuar() {
        checkoutStepOnePage.clickContinue();
    }
}
