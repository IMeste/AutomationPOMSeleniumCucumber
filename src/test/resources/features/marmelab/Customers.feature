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
    And Ingreso birthday "1992-07-15"
    And Ingreso address "Address"
    And Ingreso city "Santiago"
    And Ingreso state "RM"
    And Ingreso zipcode "8420000"
    And Ingreso password customer "Pass1234"
    And Ingreso confirm password customer "Pass1234"
    And Click en el botón SAVE customer
    Then Se visualiza el historial del customer recien creado
    And Click sobre el menú de customers
    # Validar la visualización del customer recien creado
    And Se realiza una busqueda del customer "QA Automation"
    Then Se validan las columnas de la tabla de resultados
    Then Se valida el customer recien creado
    # Modificar el customer recien creado
    When Se presiona el nombre del usuario del registro 0
    And Ingreso first name modificado "QA Edit"
    And Ingreso last name modificado "Automation Edit"
    And Selecciono segment "Regular"
    And Ingreso email modificado "qaedit@qaedit.cl"
    And Selecciono has newsletter "Yes"
    And Ingreso birthday modificado "1993-07-15"
    And Ingreso address modificado "Address Edit"
    And Ingreso city modificado "Florida"
    And Ingreso state modificado "PA"
    And Ingreso zipcode modificado "953123123"
    And Ingreso password customer modificado "PassEdit1234"
    And Ingreso confirm password customer modificado "PassEdit1234"
    And Click en el botón SAVE edit customer
    # Validar la visualización del customer recien modificado
    And Se realiza una busqueda del customer "QA Automation"
    Then Se valida el customer recien modificado
    # Eliminar el customer recien modificado
    When Se selecciona el Customer 0
    And Se presiona el botón DELETE
    # Validar que el customer ya no se visualiza
    When Se realiza una busqueda del customer "QA Automation"
    Then Se visualiza un mensaje informando que no se encontro el customer