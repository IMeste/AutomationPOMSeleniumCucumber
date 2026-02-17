@env:qa
Feature: Swag Labs Cart Scenarios

  Background:
    Given Ingreso a la pagina de Swag Labs
    When Ingreso el usuario "standard_user"
    When Ingreso la clave "secret_sauce"
    When Click sobre el botón de login con credenciales validas

  @PrioridadAlta
  Scenario: Añadir producto al carro
    When Añadir "Sauce Labs Backpack" al carro de compra
    When Añadir "Sauce Labs Bike Light" al carro de compra
    When Click sobre el carro de compra
    Then Sistema redirecciona a la url "https://www.saucedemo.com/cart.html"