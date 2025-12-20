package pages.login;

import config.ConfigReader;
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

    public void inicioSesionExitoso(){
        elementsPageLogin.inputUsername.sendKeys(ConfigReader.get("usuario"));
        elementsPageLogin.inputPassword.sendKeys(ConfigReader.get("clave"));
        elementsPageLogin.buttonLogin.click();
    }
}
