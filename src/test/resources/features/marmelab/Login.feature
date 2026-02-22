@env:qa
Feature: Flujo Login Marmelab

  @smoke @pr @critical
  Scenario: Login exitoso en React Admin Demo
    Given Ingreso a la pagina de Marmelab
    When Ingresar username "demo"
    And Ingresar password "demo"
    And Presionar botón SIGN IN
    Then Se redirige a "https://marmelab.com/react-admin-demo/#/"
