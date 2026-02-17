package steps.saucedemo;

import config.ConfigReader;
import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import pages.saucedemo.inventory.InventoryPage;
import support.ActionsCommon;
import pages.saucedemo.login.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import support.CustomAssertions;

public class LoginSteps {

    private final ActionsCommon actionsCommon;
    private final LoginPage loginPage;
    private final InventoryPage inventoryPage;

    public LoginSteps() {
        WebDriver driver = DriverFactory.getDriver();
        this.loginPage = new LoginPage(driver);
        this.inventoryPage = new InventoryPage(driver);
        this.actionsCommon = new ActionsCommon(driver);
    }

    @Given("Ingreso a la pagina de Swag Labs")
    public void ingreso_a_la_pagina_de_Swag_Labs() {
        actionsCommon.navigateTo(ConfigReader.get("base.url"));
        CustomAssertions.assertElementVisible(loginPage.isLogoDisplayed(), loginPage.getByLogo(), "Login Logo");
    }

    @When("Inicio sesión exitoso")
    public void inicio_sesion_exitoso(){
        loginPage.inicioSesionExitoso();
        CustomAssertions.assertElementVisible(inventoryPage.isTitleDisplayed(), inventoryPage.getByTitle(), "Titulo del inventario");
    }

    @When("Ingreso el usuario {string}")
    public void ingreso_el_usuario(String username) {
        loginPage.sendUsername(username);
    }

    @When("Ingreso la clave {string}")
    public void ingreso_la_clave(String password) {
        loginPage.sendPassword(password);
    }

    @When("Click sobre el botón de login con credenciales validas")
    public void click_sobre_el_boton_de_login_credenciales_validas() {
        loginPage.clickButtonLogin();
        CustomAssertions.assertElementVisible(inventoryPage.isTitleDisplayed(), inventoryPage.getByTitle(), "Titulo del inventario");
    }

    @When("Click sobre el botón de login")
    public void click_sobre_el_boton_de_login() {
        loginPage.clickButtonLogin();
    }

    @Then("Sistema redirecciona a la url {string}")
    public void sistema_redirecciona_a_la_url(String expectedUrl) {
        String actualUrl = actionsCommon.getCurrentUrl();
        CustomAssertions.assertEqualsUrl(expectedUrl, actualUrl, "Home Url");
    }
    @Then("Sistema responde el error {string}")
    public void sistema_responde_el_error(String error){
        CustomAssertions.assertEqualsText(error, loginPage.getByErrorMessage(), loginPage.getTextMessageError(), "Mensaje de error");
    }
}