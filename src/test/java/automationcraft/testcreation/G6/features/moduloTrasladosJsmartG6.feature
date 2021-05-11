Feature:modulo traslados JetSmart

  @G6 @caso10
  Scenario: busqueda de traslado
    Given que soy un usuario que ingreso a jetSmart en la seccion traslados

Feature:modulo Traslados JetSmart

  @G6 @caso10
  Scenario: busqueda de traslado
    Given que soy un usuario que ingreso a jetSmart en la seccion traslados
    When selecciono lugar de origen "Buenos Aires"
    And selecciono lugar de destino "Bariloche"
    And clickeo solo ida
    And selecciono fecha de traslado
    And selecciono horario de traslado
    And selecciono "1" pasajero
    And presiono el boton Busqueda
    Then el sistema muestra resultados de traslado

  @G6 @caso11
  Scenario: Cambio de moneda predefinida en busqueda
    Given que soy un usuario que ingreso a jetSmart en la seccion traslados
    When selecciono lugar de origen "Buenos Aires"
    And selecciono lugar de destino "Bariloche"
    And clickeo solo ida
    And selecciono fecha de traslado
    And selecciono horario de traslado
    And selecciono "1" pasajero
    And presiono el boton Busqueda
    And cierro PopUp
    And selecciono "USD" como moneda
    And presiono busqueda
    Then la pagina muestra los resultados con la nueva moneda

  @G6 @caso12
  Scenario: Fallo en Nro de vuelo en formulario final
    Given que soy un usuario que ingreso a jetSmart en la seccion traslados
    When selecciono como lugar de origen "Buenos Aires-Ministro Pistarini"
    And selecciono como lugar de destino "Estadio Monumental"
    And clickeo solo ida
    And selecciono fecha de traslado
    And selecciono horario de traslado
    And selecciono "1" pasajero
    And presiono el boton Busqueda
    And presiono boton reservar ahora
    And relleno de formulario de datos del pasajero
    And introduzco nro de vuelo incorrecto
    Then la pagina muestra mensaje de error
