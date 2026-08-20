package pages.marmelab.customers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class CustomerEditPage extends BasePage {

    private final By loading = By.cssSelector(".MuiCardContent-root.css-1op5rrm");

    private final By inputFirstName = By.cssSelector("input[name='first_name']");
    private final By inputLastName = By.cssSelector("input[name='last_name']");
    private final By inputEmail = By.cssSelector("input[name='email']");
    private final By inputBirthday = By.cssSelector("input[name='birthday']");
    private final By inputAddress = By.cssSelector("textarea[name='address']");
    private final By inputCity = By.cssSelector("input[name='city']");
    private final By inputState = By.cssSelector("input[name='stateAbbr']");
    private final By inputZipcode = By.cssSelector("input[name='zipcode']");
    private final By inputPassword = By.cssSelector("input[name='password']");
    private final By inputConfirmPassword = By.cssSelector("input[name='confirm_password']");

    private final By selectSegment = By.xpath("(//div[@role='combobox'])[1]");
    private final By toggleHasNewsletter = By.xpath("(//div[@role='combobox'])[2]");

    private final By buttonSave = By.cssSelector("button[aria-label='Save']");

    private final By labelFirstSeen = By.xpath("(//span[@class='MuiTypography-root MuiTypography-body2 css-135m6i8'])[1]");
    private final By labelLastSeen  = By.xpath("(//span[@class='MuiTypography-root MuiTypography-body2 css-135m6i8'])[2]");

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
        selectReactOptionByText(selectSegment, segment, "Segment (Edit)");
        pressKeyGeneric(Keys.ESCAPE);
        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(
                        By.cssSelector("ul[role='listbox'] li")
                ));
    }

    public void typeEmail(String value) {
        type(inputEmail, value, "Email (Edit)");
    }

    public void setHasNewsletter(String value) {
        selectReactOptionByText(toggleHasNewsletter, value, "Has Newsletter (Toggle)");
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

    public boolean isButtonSaveDisplayed() {
        return isElementVisible(buttonSave);
    }

    public By getButtonSave() {
        return buttonSave;
    }

    public boolean isLabelFirstSeenDisplayed() {
        return isElementVisible(labelFirstSeen);
    }

    public String getTextLabelFirstSeen() {
        return getText(labelFirstSeen);
    }

    public By getByLabelFirstSeen() {
        return labelFirstSeen;
    }

    public boolean isLabelLastSeenDisplayed() {
        return isElementVisible(labelLastSeen);
    }

    public String getTextLabelLastSeen() {
        return getText(labelLastSeen);
    }

    public By getByLabelLastSeen() {
        return labelLastSeen;
    }
}