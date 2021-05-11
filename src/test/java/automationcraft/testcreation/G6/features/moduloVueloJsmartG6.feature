Feature:modulo Vuelo JetSmart


  @G6
  Scenario:Cantidad maxima de pasajeros mayor a 10
    Given que soy un usuario que ingreso a jetSmart en la seccion vuelos
    When quiero seleccionar una cantidad de pasajeros mayor a 10
    Then la pagina muestra un mensaje de advertencia

  @G6 @caso2
  Scenario: busqueda de vuelo con fecha de vuelta año siguiente
    Given que soy un usuario que ingreso a jetSmart en la seccion vuelos
    When quiero reservar un vuelo con "Santiago" como origen
    And  "Arica" como destino
    And  selecciono una fecha de ida
    And  selecciono fecha de vuelta el año siguiente
    And  hago click en busqueda Smart
    Then la pagina muestra los resultados


  @G6 @caso3
  Scenario:Reserva completa de vuelo hasta seleccion de equipaje
    Given que soy un usuario que ingreso a jetSmart en la seccion vuelos
    When reservo un vuelo con "Buenos Aires" como origen
    And   selecciono "Santiago" como destino
    And  selecciono una fecha de ida
    And  presiono ticket solo ida
    And  sumo "1" adulto y sumo "1" ninio en cantidad de pasajeros
    And  hago click en busqueda Smart
    And  hago click en boton precios sin descuentos
    And  selecciono paquete full
    And  presiono continuar
    And  relleno datos de los pasajeros "1" "2" y "3"
    And  selecciono fecha de nacimiento del ninio
    And  hago click en continuar
    Then el sistema muestra la pagina de equipaje

