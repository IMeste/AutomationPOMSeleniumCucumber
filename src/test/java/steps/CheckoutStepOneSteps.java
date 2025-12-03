package steps;

import io.cucumber.java.en.When;
import pages.checkoutStepOne.ActionsCheckoutStepOne;
import support.ActionsCommon;

public class CheckoutStepOneSteps {
    private final ActionsCommon actionsCommon;
    private final ActionsCheckoutStepOne actionsCheckoutStepOne;

    public CheckoutStepOneSteps(ActionsCommon actionsCommon, ActionsCheckoutStepOne actionsCheckoutStepOne){
        this.actionsCommon = actionsCommon;
        this.actionsCheckoutStepOne = actionsCheckoutStepOne;
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
