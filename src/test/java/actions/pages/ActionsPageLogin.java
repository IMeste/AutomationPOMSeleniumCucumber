package actions.pages;

import elements.pages.ElementsPageLogin;
import org.openqa.selenium.WebDriver;
import steps.CommonSteps;

public class ActionsPageLogin {

    private final WebDriver driver;
    private final ElementsPageLogin elementsPageLogin;

    public ActionsPageLogin(CommonSteps commonSteps) {
        driver = CommonSteps.getDriver();
        elementsPageLogin = new ElementsPageLogin(commonSteps);
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
}
