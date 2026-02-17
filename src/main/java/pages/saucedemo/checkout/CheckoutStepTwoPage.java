package pages.saucedemo.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.util.List;

public class CheckoutStepTwoPage extends BasePage {

    private final By buttonFinish = By.id("finish");
    private final By titulo = By.cssSelector(".title");
    private final By cartItemDiv = By.cssSelector(".cart_item");

    // Dentro del cartItem
    private final By nameItemCart = By.cssSelector(".inventory_item_name");
    private final By descriptionItemCart = By.cssSelector(".inventory_item_desc");
    private final By priceItemCart = By.cssSelector(".inventory_item_price");
    private final By quantityItemCart = By.cssSelector(".cart_quantity");

    // Summary
    private final By paymentInfoValue = By.cssSelector("[data-test='payment-info-value']");
    private final By shippingInfoValue = By.cssSelector("[data-test='shipping-info-value']");
    private final By summarySubtotalLabel = By.cssSelector(".summary_subtotal_label");
    private final By summaryTaxLabel = By.cssSelector(".summary_tax_label");
    private final By summaryTotalLabel = By.cssSelector(".summary_total_label");


    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTituloDisplayed() {
        return isElementVisible(titulo);
    }

    public By getTitulo(){
        return titulo;
    }

    public WebElement getCartItemDivInWebElement(int posicion) {
        List<WebElement> items = driver.findElements(cartItemDiv);
        if (items.isEmpty()) {
            return null;
        }
        if (posicion < 0 || posicion >= items.size()) {
            return null;
        }
        return items.get(posicion);
    }

    public String getTextNameCartItem(int posicion) {
        WebElement cartItem = getCartItemDivInWebElement(posicion);
        if (cartItem != null) {
            List<WebElement> tituloCartItem = cartItem.findElements(nameItemCart);
            return tituloCartItem.isEmpty() ? null : tituloCartItem.get(0).getText();
        }else{
            return null;
        }
    }

    public By getNameBy(){
        return nameItemCart;
    }

    public String getTextDescriptionCartItem(int posicion) {
        WebElement cartItem = getCartItemDivInWebElement(posicion);
        if (cartItem != null) {
            List<WebElement> tituloCartItem = cartItem.findElements(descriptionItemCart);
            return tituloCartItem.isEmpty() ? null : tituloCartItem.get(0).getText();
        }else{
            return null;
        }
    }

    public By getDescriptionBy(){
        return descriptionItemCart;
    }

    public String getTextPriceCartItem(int posicion) {
        WebElement cartItem = getCartItemDivInWebElement(posicion);
        if (cartItem != null) {
            List<WebElement> tituloCartItem = cartItem.findElements(priceItemCart);
            return tituloCartItem.isEmpty() ? null : tituloCartItem.get(0).getText();
        }else{
            return null;
        }
    }

    public By getPriceBy(){
        return priceItemCart;
    }

    public String getTextQuantityCartItem(int posicion) {
        WebElement cartItem = getCartItemDivInWebElement(posicion);
        if (cartItem != null) {
            List<WebElement> tituloCartItem = cartItem.findElements(quantityItemCart);
            return tituloCartItem.isEmpty() ? null : tituloCartItem.get(0).getText();
        }else{
            return null;
        }
    }

    public By getQuantityBy(){
        return quantityItemCart;
    }

    public void clickFinish() {
        click(buttonFinish, "Botón Finish");
    }

    public String getTextPaymentInfoValue() {
        return getText(paymentInfoValue);
    }

    public By getByPaymentInfoValue(){
        return paymentInfoValue;
    }

    public String getTextShippingInfoValue() {
        return getText(shippingInfoValue);
    }

    public By getByShippingInfoValue(){
        return shippingInfoValue;
    }

    public String getTextSummarySubtotalLabel() {
        return getText(summarySubtotalLabel);
    }

    public By getBySummarySubtotalLabel(){
        return summarySubtotalLabel;
    }

    public String getTextSummaryTaxLabel() {
        return getText(summaryTaxLabel);
    }

    public By getBySummaryTaxLabel(){
        return summaryTaxLabel;
    }

    public String getTextSummaryTotalLabel() {
        return getText(summaryTotalLabel);
    }

    public By getBySummaryTotalLabel(){
        return summaryTotalLabel;
    }

}
