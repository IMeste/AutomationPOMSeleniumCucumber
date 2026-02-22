package steps.marmelab;

import drivers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.marmelab.dashboard.DashboardPage;
import pages.marmelab.login.LoginPage;
import support.ActionsCommon;
import support.CustomAssertions;

public class LoginSteps {

    private final ActionsCommon actionsCommon;
    private final LoginPage loginPage;
    private final DashboardPage dashboardPage;

    public LoginSteps() {
        WebDriver driver = DriverFactory.getDriver();
        this.actionsCommon = new ActionsCommon(driver);
        this.loginPage = new LoginPage(driver);
        this.dashboardPage = new DashboardPage(driver);
    }

    @Given("Ingreso a la pagina de Marmelab")
    public void ingreso_a_la_pagina_de_marmelab() {
        actionsCommon.navigateTo("https://marmelab.com/react-admin-demo/#/login");
        CustomAssertions.assertElementVisible(loginPage.isLogoDisplayed(), loginPage.getByLogo(), "Logo Login");
    }

    @When("Ingresar username {string}")
    public void ingresarUsername(String username) {
        loginPage.ingresarUsername(username);
    }

    @When("Ingresar password {string}")
    public void ingresarPassword(String password) {
        loginPage.ingresarPassword(password);
    }

    @When("Presionar botón SIGN IN")
    public void presionarBotonSignIn() {
        loginPage.presionarSignIn();
    }

    @Then("Se redirige a {string}")
    public void seRedirigeA(String urlEsperada) {
        CustomAssertions.assertEqualsUrl(urlEsperada, actionsCommon.getCurrentUrl(), "URL Actual");
        CustomAssertions.assertElementVisible(dashboardPage.isDashboardDisplayed(), dashboardPage.getByDashboard(), "Menú Dashboard");
    }
}
