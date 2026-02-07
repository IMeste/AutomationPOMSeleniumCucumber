package pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPageLogin {

    @FindBy(xpath = "//input[@id='user-name']") public WebElement inputUsername;
    @FindBy(xpath = "//input[@id='password']") public WebElement inputPassword;
    @FindBy(xpath = "//input[@id='login-button']") public WebElement buttonLogin;
    @FindBy(css = "h3[data-test='error']") public WebElement messageError;

    public ElementsPageLogin(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
