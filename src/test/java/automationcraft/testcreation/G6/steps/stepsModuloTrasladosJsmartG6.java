package automationcraft.testcreation.G6.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.G6.pages.JetSmartHomePage;
import automationcraft.testcreation.G6.pages.JetSmartTrasladosPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepsModuloTrasladosJsmartG6 {

    JetSmartHomePage HomePage;
    JetSmartTrasladosPage TrasladosPage;

    @Given("que soy un usuario que ingreso a jetSmart en la seccion traslados")
    public void que_soy_un_usuario_que_ingreso_a_jet_smart_en_la_seccion_traslados() throws InterruptedException {
        HomePage = new JetSmartHomePage(DriverFactory.getDriver());
        TrasladosPage = new JetSmartTrasladosPage(DriverFactory.getDriver());

        HomePage.goToUrl("https://jetsmart.com/cl/es/");
        HomePage.cerrarModuloSuscribete();
        HomePage.clickIconoTraslado();
    }



    @When("selecciono lugar de origen {string}")
    public void selecciono_lugar_de_origen(String string) throws InterruptedException {
        HomePage.lugarOrigenTraslados("Buenos Aires");
    }

    @When("selecciono lugar de destino {string}")
    public void selecciono_lugar_de_destino(String string) throws InterruptedException {
        HomePage.lugarDestinoTraslados("Bariloche");
    }

    @When("clickeo solo ida")
    public void clickeo_solo_ida() {
        HomePage.clickSoloIda();
    }


    @When("selecciono fecha de traslado")
    public void selecciono_fecha_de_traslado() {
        HomePage.fechaIdaTraslados();
    }

    @When("selecciono horario de traslado")
    public void selecciono_horario_de_traslado() throws InterruptedException {
        HomePage.seleccionarHoraTraslados();
    }

    @When("selecciono {string} pasajero")
    public void selecciono_pasajero(String string) {
        HomePage.seleccionarPasajeros();
    }

    @When("presiono el boton Busqueda")
    public void presiono_el_boton_busqueda() throws InterruptedException {
        HomePage.botonBuscarTraslados();
        HomePage.switchToPestana(0,1);
    }

    @Then("el sistema muestra resultados de traslado")
    public void el_sistema_muestra_resultados_de_traslado() {
        String resul = TrasladosPage.validacionResultado();
        System.out.println(resul);
    }

    //----------------------------------CASO 11--------------------------------------------


    @When("cierro PopUp")
    public void cierro_PopUp() {
        TrasladosPage.cierrePopUp();
    }

    @When("selecciono {string} como moneda")
    public void selecciono_como_moneda(String string) {
        TrasladosPage.seleccionMoneda("USD");
    }

    @When("presiono busqueda")
    public void presiono_busqueda() throws InterruptedException {
        TrasladosPage.btnBuscar();
    }

    @Then("la pagina muestra los resultados con la nueva moneda")
    public void la_pagina_muestra_los_resultados_con_la_nueva_moneda() {
        String resultado=TrasladosPage.monedaPrecioTraslado();
        System.out.println(resultado);
    }

    //------------------------------CASO 12 ----------------------------------------------------

    @When("selecciono como lugar de origen {string}")
    public void selecciono_como_lugar_de_origen(String string) throws InterruptedException {
        HomePage.lugarOrigenTraslados("Buenos Aires-Ministro Pistarini");
    }

    @When("selecciono como lugar de destino {string}")
    public void selecciono_como_lugar_de_destino(String string) throws InterruptedException {
        HomePage.lugarDestinoTraslados("Estadio Monumental");
    }

    @When("presiono boton reservar ahora")
    public void presiono_boton_reservar_ahora() {
        TrasladosPage.botonReservaTraslado();
    }

    @When("relleno de formulario de datos del pasajero")
    public void relleno_de_formulario_de_datos_del_pasajero() {
        TrasladosPage.rellenarDatos("juan separado","juan12@gmail.com","972447281");
    }

    @When("introduzco nro de vuelo incorrecto")
    public void introduzco_nro_de_vuelo_incorrecto() {
        TrasladosPage.clickPage();
        TrasladosPage.nroDeVuelo("asddsdqwdqwd");
    }

    @Then("la pagina muestra mensaje de error")
    public void la_pagina_muestra_mensaje_de_error() {
        String result=TrasladosPage.confirmacion();
        System.out.println(result);
    }

}
