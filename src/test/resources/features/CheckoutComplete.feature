@env:qa
Feature: Swag Labs Payments Scenarios

  Background:
    Given Ingreso a la pagina de Swag Labs
    When Inicio sesión exitoso

  @PrioridadAlta
  Scenario: Pagar dos productos
    When Genero el carro con 2 productos
    When Realizo el pago
    Then Sistema confirma el pago de la orden "Thank you for your order!"