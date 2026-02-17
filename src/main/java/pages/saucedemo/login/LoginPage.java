package pages.saucedemo.login;

import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class LoginPage extends BasePage {

    private final By inputUsername = By.id("user-name");
    private final By inputPassword = By.id("password");
    private final By buttonLogin = By.id("login-button");
    private final By messageError = By.cssSelector("h3[data-test='error']");
    private final By logo = By.cssSelector(".login_logo");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void sendUsername (String username){
        type(inputUsername, username, "Input Username");
    }

    public void sendPassword (String password){
        type(inputPassword, password, "Input Password");
    }

    public void clickButtonLogin(){
        click(buttonLogin, "Botón Login");
    }

    public String getTextMessageError(){
        return getText(messageError);
    }

    public void inicioSesionExitoso(){
        sendUsername(ConfigReader.get("usuario"));
        sendPassword(ConfigReader.get("clave"));
        clickButtonLogin();
    }

    public boolean isLogoDisplayed() {
        return isElementVisible(logo);
    }

    public By getByLogo() {
        return logo;
    }

    public By getByErrorMessage() {
        return messageError;
    }
}
