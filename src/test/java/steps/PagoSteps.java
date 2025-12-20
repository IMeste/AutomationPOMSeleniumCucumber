package steps;

import config.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.checkoutComplete.ActionsCheckoutComplete;
import pages.checkoutStepOne.ActionsCheckoutStepOne;
import pages.checkoutStepTwo.ActionsCheckoutStepTwo;

public class PagoSteps {
    private final ActionsCheckoutStepOne actionsCheckoutStepOne;
    private final ActionsCheckoutStepTwo actionsCheckoutStepTwo;
    private final ActionsCheckoutComplete actionsCheckoutComplete;

    public PagoSteps(ActionsCheckoutStepOne actionsCheckoutStepOne, ActionsCheckoutStepTwo actionsCheckoutStepTwo, ActionsCheckoutComplete actionsCheckoutComplete){
        this.actionsCheckoutStepOne = actionsCheckoutStepOne;
        this.actionsCheckoutStepTwo = actionsCheckoutStepTwo;
        this.actionsCheckoutComplete = actionsCheckoutComplete;
    }

    @When("Realizo el pago")
    public void realizo_pago(){
        actionsCheckoutStepOne.sendFirstName(ConfigReader.get("firstName"));
        actionsCheckoutStepOne.sendLastName(ConfigReader.get("lastName"));
        actionsCheckoutStepOne.sendPostalCode(ConfigReader.get("postalCode"));
        actionsCheckoutStepOne.clickContinue();
        actionsCheckoutStepTwo.clickFinish();
    }

    @Then("Sistema confirma el pago de la orden {string}")
    public void sistema_confirma_el_pago_de_la_orden(String mensaje) {
        Assert.assertEquals("No se visualiza la confirmación del pago.", mensaje, actionsCheckoutComplete.getTextCheckoutComplete());
    }

    @When("Ingreso el primero nombre {string}")
    public void ingreso_el_primero_nombre(String firstName) {
        actionsCheckoutStepOne.sendFirstName(firstName);
    }

    @When("Ingreso el segundo nombre {string}")
    public void ingreso_el_segundo_nombre(String lastName) {
        actionsCheckoutStepOne.sendLastName(lastName);
    }

    @When("Ingreso el codigo postal {string}")
    public void ingreso_el_codigo_postal(String postalCode) {
        actionsCheckoutStepOne.sendPostalCode(postalCode);
    }

    @When("Click sobre el boton de continuar")
    public void click_sobre_el_boton_de_continuar() {
        actionsCheckoutStepOne.clickContinue();
    }
}
