package automationcraft.testcreation.G6.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.G6.pages.JetSmartHomePage;
import automationcraft.testcreation.G6.pages.JetSmartHotelesPage;
import automationcraft.testcreation.G6.pages.JetSmartVuelosPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepsModuloHotelesJsmartG6 {

    JetSmartHomePage HomePage;
    JetSmartHotelesPage HotelesPage;

    @Given("que soy un usuario que ingreso a jetSmart en la seccion hoteles")
    public void que_soy_un_usuario_que_ingreso_a_jet_smart_en_la_seccion_hoteles() throws InterruptedException {
        HomePage = new JetSmartHomePage(DriverFactory.getDriver());
        HotelesPage = new JetSmartHotelesPage(DriverFactory.getDriver());
        HomePage.goToUrl("https://jetsmart.com/cl/es/");
        HomePage.cerrarModuloSuscribete();
        HomePage.popUP2Close();
        HomePage.clickIconoHoteles();
    }

    @When("quiero reservar un hotel en {string}")
    public void quiero_reservar_un_hotel_en(String string) throws InterruptedException {
        HomePage.lugarDeDestinoHoteles("Santiago");
    }

    @When("selecciono una fecha de ingreso")
    public void selecciono_una_fecha_de_ingreso() throws InterruptedException {
        HomePage.fechaDeIngresoHoteles("13-junio-2021");
    }

    @When("selecciono una fecha de salida del hotel")
    public void selecciono_una_fecha_de_salida_del_hotel() throws InterruptedException {
        HomePage.fechaDeSalidaHoteles("3-julio-2021");
    }

    @When("selecciono {string} habitacion")
    public void selecciono_habitacion(String string) {
        HomePage.seleccionarNroHabitaciones("1");
    }

    @When("selecciono {string} adultos")
    public void selecciono_adultos(String string) {
        HomePage.seleccionarNroAdultos("2");
    }

    @When("selecciono {string} niño")
    public void selecciono_ninio(String string) {
        HomePage.seleccionarNroNinos("1");
    }

    @When("presiono el boton Busqueda Smart")
    public void presiono_el_boton_busqueda_smart() throws InterruptedException {
        HomePage.btnBusquedaHotel();
        HotelesPage.switchToPestana(0,1);
    }

    @When("selecciono filtro de mayor precio")
    public void selecciono_filtro_de_mayor_precio() throws InterruptedException {
        HotelesPage.seleccionFiltroMayorPrecio();
    }

    @When("selecciono filtro desayuno incluido")
    public void selecciono_filtro_desayuno_incluido() throws InterruptedException {
        HotelesPage.seleccionarFiltroDesayuno();
    }

    @Then("la pagina los resultados con los filtros")
    public void la_pagina_los_resultados_con_los_filtros() {
        HotelesPage.validacionPrecioDesayuno();
    }
}
