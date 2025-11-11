package steps;

import actions.pages.ActionsCommon;
import actions.pages.ActionsPageLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    private final ActionsCommon actionsCommon;
    private final ActionsPageLogin actionsPageLogin;

    public LoginSteps(ActionsCommon actionsCommon, ActionsPageLogin actionsPageLogin) {
        this.actionsCommon = actionsCommon;
        this.actionsPageLogin = actionsPageLogin;
    }

    @Given("Ingreso a la pagina de Swag Labs")
    public void ingreso_a_la_pagina_de_Swag_Labs() {
        actionsCommon.navigateTo("https://www.saucedemo.com");
    }

    @When("Ingreso el usuario {string}")
    public void ingreso_el_usuario(String username) {
        actionsPageLogin.sendUsername(username);
    }

    @When("Ingreso la clave {string}")
    public void ingreso_la_clave(String password) {
        actionsPageLogin.sendPassword(password);
    }

    @When("Click sobre el botón de login")
    public void click_sobre_el_boton_de_login() {
        actionsPageLogin.clickButtonLogin();
    }

    @Then("Sistema redirecciona a la url {string}")
    public void sistema_redirecciona_a_la_url(String expectedUrl) {
        String actualUrl = actionsCommon.getCurrentUrl();
        Assert.assertEquals("Urls do not match", expectedUrl, actualUrl);
    }

    @Then("Sistema responde el error {string}")
    public void sistema_responde_el_error(String error){
        Assert.assertEquals("Mensaje de error no coincide", error, actionsPageLogin.getTextMessageError());
    }
}


