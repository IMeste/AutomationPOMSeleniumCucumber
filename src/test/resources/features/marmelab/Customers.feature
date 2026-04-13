@env:qa
Feature: Marmelab React Admin - CRUD Customers

  Background: Login exitoso
    Given Ingreso a la pagina de Marmelab
    When Ingresar username "demo"
    And Ingresar password "demo"
    And Presionar botón SIGN IN
    Then Se redirige a "https://marmelab.com/react-admin-demo/#/"

  @regression @pr @high @crudcustomers
  Scenario: CRUD Costumers
    When Click sobre el menú de customers
    And Agrego un customer
    Then Se visualiza la cabecera de creación de customers
    When Ingreso first name "QA"
    And Ingreso last name "Automation"
    And Ingreso email "qa@qa.cl"
    And Ingreso birthday "15-07-1992"
    And Ingreso address "Address"
    And Ingreso city "Santiago"
    And Ingreso state "RM"
    And Ingreso zipcode "8420000"
    And Ingreso password customer "Pass1234"
    And Ingreso confirm password customer "Pass1234"
    And Click en el botón SAVE customer
    Then Se visualiza el historial del customer recien creado
    And Click sobre el menú de customers
    And Se realiza una busqueda del customer "QA Automation"
    Then Se validan las columnas de la tabla de resultados
    Then Se valida el customer recien creado