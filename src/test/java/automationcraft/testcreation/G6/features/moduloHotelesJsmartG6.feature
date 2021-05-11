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