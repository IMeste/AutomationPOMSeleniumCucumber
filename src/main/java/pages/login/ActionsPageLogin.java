package pages.login;

import org.openqa.selenium.WebDriver;
import drivers.DriverFactory;

public class ActionsPageLogin {

    private final WebDriver driver;
    private final ElementsPageLogin elementsPageLogin;

    public ActionsPageLogin() {
        driver = DriverFactory.getDriver();
        elementsPageLogin = new ElementsPageLogin();
    }

    public void sendUsername (String username){
        elementsPageLogin.inputUsername.sendKeys(username);
    }

    public void sendPassword (String password){
        elementsPageLogin.inputPassword.sendKeys(password);
    }

    public void clickButtonLogin(){
        elementsPageLogin.buttonLogin.click();
    }

    public String getTextMessageError(){
        return elementsPageLogin.messageError.getText();
    }
}
