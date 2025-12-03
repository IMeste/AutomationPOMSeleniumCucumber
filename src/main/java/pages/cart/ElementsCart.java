package pages.cart;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsCart {
    public WebDriver driver;
    @FindBy(xpath = "//button[@id='checkout']") public WebElement buttonCheckout;

    public ElementsCart() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }
}
