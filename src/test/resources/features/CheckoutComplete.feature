Feature: Swag Labs Payments Scenarios

  Background:
    Given Ingreso a la pagina de Swag Labs
    When Ingreso el usuario "standard_user"
    When Ingreso la clave "secret_sauce"
    When Click sobre el botón de login

  @PrioridadAlta @env:qa
  Scenario: Pagar dos productos
    When Añadir "Sauce Labs Backpack" al carro de compra
    When Añadir "Sauce Labs Bike Light" al carro de compra
    When Click sobre el carro de compra
    When Click sobre el boton de Checkout
    When Ingreso el primero nombre "QA"
    When Ingreso el segundo nombre "Automatizacion"
    When Ingreso el codigo postal "123456789"
    When Click sobre el boton de continuar
    When Click sobre el boton de confirmacion de la información del carro y el pago
    Then Sistema confirma el pago de la orden "Thank you for your order!"