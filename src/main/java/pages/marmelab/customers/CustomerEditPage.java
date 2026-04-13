package pages.marmelab.customers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class CustomerEditPage extends BasePage {

    private final By loading = By.cssSelector(".MuiCardContent-root.css-1op5rrm"); 

    private final By inputFirstName = By.cssSelector("input[id=':r24:']"); 
    private final By inputLastName = By.cssSelector("input[id=':r26:']"); 
    private final By selectSegment = By.cssSelector("div[id=':r2q:']");
    private final By inputEmail = By.cssSelector("input[id=':r28:']"); 
    private final By toggleHasNewsletter = By.cssSelector("div[id=':r2s:']"); 
    private final By inputBirthday = By.cssSelector("input[id=':r2a:']"); 
    private final By inputAddress = By.cssSelector("textarea[id=':r2c:']");
    private final By inputCity = By.cssSelector("input[id=':r2e:']");
    private final By inputState = By.cssSelector("input[id=':r2g:']");
    private final By inputZipcode = By.cssSelector("input[id=':r2i:']");
    private final By inputPassword = By.cssSelector("input[id=':r2k:']");
    private final By inputConfirmPassword = By.cssSelector("input[id=':r2n:']");

    private final By buttonSave = By.cssSelector("button[aria-label='Save']");

    public CustomerEditPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHeaderDisplayed() {
        return isElementVisible(loading);
    }

    public By getByHeader() {
        return loading;
    }

    public void typeFirstName(String value) {
        type(inputFirstName, value, "First Name (Edit)");
    }

    public void typeLastName(String value) {
        type(inputLastName, value, "Last Name (Edit)");
    }

    public void selectSegment(String segment) {
        selectByVisibleText(selectSegment, segment, "Segment (Edit)");
    }

    public void typeEmail(String value) {
        type(inputEmail, value, "Email (Edit)");
    }

    public void setHasNewsletter(String value) {
        selectByVisibleText(toggleHasNewsletter, value, "Has Newsletter (Toggle)");
    }

    public void typeBirthday(String value) {
        type(inputBirthday, value, "Birthday (Edit)");
    }

    public void typeAddress(String value) {
        type(inputAddress, value, "Address (Edit)");
    }

    public void typeCity(String value) {
        type(inputCity, value, "City (Edit)");
    }

    public void typeState(String value) {
        type(inputState, value, "State (Edit)");
    }

    public void typeZipcode(String value) {
        type(inputZipcode, value, "Zipcode (Edit)");
    }

    public void typePassword(String value) {
        type(inputPassword, value, "Password (Edit)");
    }

    public void typeConfirmPassword(String value) {
        type(inputConfirmPassword, value, "Confirm Password (Edit)");
    }

    public void clickSave() {
        click(buttonSave, "Botón SAVE (Edit)");
    }
}