Feature: Swag Labs Login Scenarios

  @Login01
  Scenario: Login Exitoso
    Given Ingreso a la pagina de Swag Labs
    When Ingreso el usuario "standard_user"
    When Ingreso la clave "secret_sauce"
    When Click sobre el botón de login
    Then Redirecciona a la url "https://www.saucedemo.com/inventory.html"