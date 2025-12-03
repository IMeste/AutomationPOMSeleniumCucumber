package steps;

import io.cucumber.java.en.When;
import pages.checkoutStepTwo.ActionsCheckoutStepTwo;
import support.ActionsCommon;

public class CheckoutStepTwoSteps {
    private final ActionsCommon actionsCommon;
    private final ActionsCheckoutStepTwo actionsCheckoutStepTwo;

    public CheckoutStepTwoSteps(ActionsCommon actionsCommon, ActionsCheckoutStepTwo actionsCheckoutStepTwo){
        this.actionsCommon = actionsCommon;
        this.actionsCheckoutStepTwo = actionsCheckoutStepTwo;
    }

    @When("Click sobre el boton de confirmacion de la información del carro y el pago")
    public void click_sobre_el_boton_de_confirmacion_carro_y_pago() {
        actionsCheckoutStepTwo.clickFinish();
    }

}
