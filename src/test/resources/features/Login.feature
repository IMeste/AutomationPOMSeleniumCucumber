@env:qa
Feature: Swag Labs Login Scenarios

  Background:
    Given Ingreso a la pagina de Swag Labs

  @PrioridadAlta
  Scenario: Login Exitoso
    When Ingreso el usuario "standard_user"
    When Ingreso la clave "secret_sauce"
    When Click sobre el botón de login
    Then Sistema redirecciona a la url "https://www.saucedemo.com/inventory.html"

  @PrioridadBaja
  Scenario: Login fallido por usuario bloqueado
    When Ingreso el usuario "locked_out_user"
    When Ingreso la clave "secret_sauce"
    When Click sobre el botón de login
    Then Sistema responde el error "Epic sadface: Sorry, this user has been locked out."

  @PrioridadBaja
  Scenario: Login fallido por usuario incorrecto
    When Ingreso el usuario "no_existo"
    When Ingreso la clave "secret_sauce"
    When Click sobre el botón de login
    Then Sistema responde el error "Epic sadface: Username and password do not match any user in this service"

  @PrioridadBaja
  Scenario: Login fallido por clave incorrecta
    When Ingreso el usuario "standard_user"
    When Ingreso la clave "claveIncorrecta"
    When Click sobre el botón de login
    Then Sistema responde el error "Epic sadface: Username and password do not match any user in this service"