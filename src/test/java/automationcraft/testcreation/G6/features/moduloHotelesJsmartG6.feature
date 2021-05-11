Feature:modulo Hoteles JetSmart

  @G6 @caso4
  Scenario: Busqueda de hotel con filtro
    Given que soy un usuario que ingreso a jetSmart en la seccion hoteles
    When quiero reservar un hotel en "Santiago"
    And selecciono una fecha de ingreso
    And selecciono una fecha de salida del hotel
    And selecciono "1" habitacion
    And selecciono "2" adultos
    And selecciono "1" niño
    And presiono el boton Busqueda Smart
    And selecciono filtro de mayor precio
    And selecciono filtro desayuno incluido
    Then la pagina los resultados con los filtros

  @G6 @caso5
  Scenario: Modificacion de parametros de busqueda
    Given que soy un usuario que ingreso a jetSmart en la seccion hoteles
    When quiero reservar un hotel en "Santiago"
    And selecciono una fecha de ingreso
    And selecciono una fecha de salida del hotel
    And selecciono "1" habitacion
    And selecciono "2" adultos
    And selecciono "1" niño
    And presiono el boton Busqueda Smart
    And selecciono filtro de mayor precio
    And quiero cambiar el parametro lugar de destino por "Arica"
    Then la pagina muestra los resultados con el parametro nuevo

  @G6 @caso6
  Scenario: flujo completo de reserva hasta formulario numero de telefono
    Given que soy un usuario que ingreso a jetSmart en la seccion hoteles
    When quiero reservar un hotel en "Santiago"
    And selecciono una fecha de ingreso
    And selecciono una fecha de salida del hotel
    And selecciono "1" habitacion
    And selecciono "2" adultos
    And selecciono "1" niño
    And presiono el boton Busqueda Smart
    And selecciono filtro de mayor precio
    And selecciono cancelacion gratis
    And presiono boton ver disponibilidad
    And presiono reservar ahora
    And selecciono "1" habitacion en pagina ver disponibilidad
    And presiono boton reservare
    And relleno formulario
    Then la pagina muestra formulario para rellenar con numero de telefono
