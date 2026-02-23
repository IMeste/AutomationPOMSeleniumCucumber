package pages.marmelab.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class LoginPage extends BasePage {

    private final By inputUsername = By.cssSelector("input[name='username']");
    private final By inputPassword = By.cssSelector("input[name='password']");
    private final By buttonSignIn = By.cssSelector("button[type='submit']");
    private final By logo = By.cssSelector(".RaLogin-avatar");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoDisplayed() {
        return isElementVisible(logo);
    }

    public By getByLogo() {
        return logo;
    }

    public void ingresarUsername(String username) {
        type(inputUsername, username, "Input Username");
    }

    public void ingresarPassword(String password) {
        type(inputPassword, password, "Input Password");
    }

    public void presionarSignIn() {
        click(buttonSignIn, "Botón Sign In");
    }
}
