package automationcraft.testcreation.G6.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.G6.pages.JetSmartHomePage;
import automationcraft.testcreation.G6.pages.JetSmartHotelesPage;
import automationcraft.testcreation.G6.pages.JetSmartVerDisponibilidadHoteles;
import automationcraft.testcreation.G6.pages.JetSmartVuelosPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepsModuloHotelesJsmartG6 {

    JetSmartHomePage HomePage;
    JetSmartHotelesPage HotelesPage;
    JetSmartVerDisponibilidadHoteles VerDisponibilidadHoteles;
    String datosInt = "";

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
        datosInt = HotelesPage.seleccionFiltroMayorPrecio();
    }

    @When("selecciono filtro desayuno incluido")
    public void selecciono_filtro_desayuno_incluido() throws InterruptedException {
        HotelesPage.seleccionarFiltroDesayuno();
    }

    @Then("la pagina los resultados con los filtros")
    public void la_pagina_los_resultados_con_los_filtros() {
        HotelesPage.validacionPrecioDesayuno();
    }

    //-------------------Caso 5 ------------------------------
    @When("quiero cambiar el parametro lugar de destino por {string}")
    public void quiero_cambiar_el_parametro_lugar_de_destino_por(String string) throws InterruptedException {
        HotelesPage.modificacionBusqueda();
    }

    @Then("la pagina muestra los resultados con el parametro nuevo")
    public void la_pagina_muestra_los_resultados_con_el_parametro_nuevo() {
        String result=HotelesPage.validacionDeBusqueda(datosInt,"Arica");
        System.out.println(result);
    }

    //----------------- Caso 6 -------------------------------
    @When("selecciono cancelacion gratis")
    public void selecciono_cancelacion_gratis() throws InterruptedException {
        HotelesPage.filtroCancelacionGratis();
    }

    @When("presiono boton ver disponibilidad")
    public void presiono_boton_ver_disponibilidad() throws InterruptedException {
        HotelesPage.clickBtnVerDisponibilidad();
        HotelesPage.switchToPestana(0,1);
    }

    @When("presiono reservar ahora")
    public void presiono_reservar_ahora() throws InterruptedException {
        VerDisponibilidadHoteles = new JetSmartVerDisponibilidadHoteles(DriverFactory.getDriver());
        VerDisponibilidadHoteles.reservar();
    }

    @When("selecciono {string} habitacion en pagina ver disponibilidad")
    public void selecciono_habitacion_en_pagina_ver_disponibilidad(String string) {
        VerDisponibilidadHoteles.numeroDeHabitaciones("1");
    }

    @When("presiono boton reservare")
    public void presiono_boton_reservare() {
        VerDisponibilidadHoteles.clickReservare();
    }

    @When("relleno formulario")
    public void relleno_formulario() {
        VerDisponibilidadHoteles.rellenarFormulario("juanito","perez","asdas@gmail.com");
    }

    @Then("la pagina muestra formulario para rellenar con numero de telefono")
    public void la_pagina_muestra_formulario_para_rellenar_con_numero_de_telefono() {
        String resul=VerDisponibilidadHoteles.validacionFinal();
        System.out.println(resul);
    }
}
