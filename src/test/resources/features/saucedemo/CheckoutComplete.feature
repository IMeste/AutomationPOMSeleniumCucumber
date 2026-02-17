@env:qa
Feature: Swag Labs Payments Scenarios

  Background:
    Given Ingreso a la pagina de Swag Labs
    When Inicio sesión exitoso

  @PrioridadAlta
  Scenario: Pagar dos productos
    When Genero el carro con 2 productos
    And Ingreso datos de usuario en el checkout
    Then Validar el resumen de pago de los 2 productos
    When Presiono el botón para finalizar el flujo de pago
    Then Sistema confirma el pago de la orden
    When Presiono el botón para volver al home
    Then Validar que el sistema redirecciono al home "https://www.saucedemo.com/inventory.html"