package steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.checkoutComplete.ActionsCheckoutComplete;
import support.ActionsCommon;

public class CheckoutCompleteSteps {
    private final ActionsCommon actionsCommon;
    private final ActionsCheckoutComplete actionsCheckoutComplete;

    public CheckoutCompleteSteps(ActionsCommon actionsCommon, ActionsCheckoutComplete actionsCheckoutComplete){
        this.actionsCommon = actionsCommon;
        this.actionsCheckoutComplete = actionsCheckoutComplete;
    }

    @Then("Sistema confirma el pago de la orden {string}")
    public void sistema_confirma_el_pago_de_la_orden(String mensaje) {
        Assert.assertEquals("No se visualiza la confirmación del pago.", mensaje, actionsCheckoutComplete.getTextCheckoutComplete());
    }


}
