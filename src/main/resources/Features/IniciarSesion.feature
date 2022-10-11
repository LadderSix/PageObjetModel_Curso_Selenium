Feature: Servipag Inicio de Sesion
  Scenario: Validar inicio de sesion en mi servipag

    Given el usuario se encuentra en la pagina de servipag
    When el usuario presiona en boton Mi Servipag
    And el usuario ingreso rut y password
    Then el usuario puede ver su informacion