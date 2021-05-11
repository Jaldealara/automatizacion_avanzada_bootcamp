package automationcraft.testcreation.G6.steps;


import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.G6.pages.JetSmartHomePage;
import automationcraft.testcreation.G6.pages.JetSmartVuelosPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class stepsModuloVuelosJsmartG6 {

    WebDriver driver;
    JetSmartHomePage HomePage;
    JetSmartVuelosPage VuelosPage;

    @Given("que soy un usuario que ingreso a jetSmart en la seccion vuelos")
    public void que_soy_un_usuario_que_ingreso_a_jet_smart_en_la_seccion_vuelos() throws InterruptedException {
        HomePage = new JetSmartHomePage(DriverFactory.getDriver());
        HomePage.goToUrl("https://jetsmart.com/cl/es/");
        HomePage.cerrarModuloSuscribete();

    }

    @When("quiero seleccionar una cantidad de pasajeros mayor a {int}")
    public void quiero_seleccionar_una_cantidad_de_pasajeros_mayor_a(Integer int1) throws InterruptedException {
        HomePage.cantidadPasajeros();
    }

    @Then("la pagina muestra un mensaje de advertencia")
    public void la_pagina_muestra_un_mensaje_de_advertencia() throws InterruptedException {
        String result = HomePage.cantidadPasajeros();
        System.out.println(result);

    }

    //------------------escenario2---------------------


    @When("quiero reservar un vuelo con {string} como origen")
    public void quiero_reservar_un_vuelo_con_como_origen(String string) {
        HomePage.ingresarOrigenVuelos("Santiago");
    }

    @When("{string} como destino")
    public void como_destino(String string) {
        HomePage.ingresarDestinoVuelos("Arica");
    }

    @When("selecciono una fecha de ida")
    public void selecciono_una_fecha_de_ida() throws InterruptedException {
        Thread.sleep(2000);
        HomePage.ingresarFechaIda();

    }

    @When("selecciono fecha de vuelta el año siguiente")
    public void selecciono_fecha_de_vuelta_el_año_siguiente() throws InterruptedException {
        Thread.sleep(2000);
        HomePage.ingresarFechaVuelta();


    }
    @When("hago click en busqueda Smart")
    public void hago_click_en_busqueda_smart() {

        HomePage.boton_Search();

    }
    @Then("la pagina muestra los resultados")
    public void la_pagina_muestra_los_resultados(){
        VuelosPage = new JetSmartVuelosPage(DriverFactory.getDriver());
        VuelosPage.validacionBusqueda();
        String resultado=VuelosPage.validacionBusqueda();
        System.out.println(resultado);
    }

    //-------------------ESCENARIO3---------------------


    @When("reservo un vuelo con {string} como origen")
    public void reservo_un_vuelo_con_como_origen(String string) {

        HomePage.ingresarOrigenVuelos("Santiago");
    }

    @When("selecciono {string} como destino")
    public void selecciono_como_destino(String string) {
        HomePage.ingresarDestinoVuelos("Arica");
    }
    @When("presiono ticket solo ida")
    public void presiono_ticket_solo_ida() {

        HomePage.clickSoloIdaVuelos();

    }
    @When("sumo {string} adulto y sumo {string} ninio en cantidad de pasajeros")
    public void sumo_adulto_y_sumo_ninio_en_cantidad_de_pasajeros(String string, String string2) throws InterruptedException {
        HomePage.sumarPasajerosVuelos();

    }
    @When("hago click en boton precios sin descuentos")
    public void hago_click_en_boton_precios_sin_descuentos() throws InterruptedException {
        VuelosPage = new JetSmartVuelosPage(DriverFactory.getDriver());

        VuelosPage.clickBotonPrecio();
    }
    @When("selecciono paquete full")
    public void selecciono_paquete_full() throws InterruptedException {
        Thread.sleep(2000);
        VuelosPage.seleccionPaquetesFull();

    }
    @When("presiono continuar")
    public void presiono_continuar() throws InterruptedException {
        VuelosPage.btnContinuarDatosPasajeros();

    }
    @When("relleno datos de los pasajeros {string} {string} y {string}")
    public void relleno_datos_de_los_pasajeros_y(String string, String string2, String string3) {
        VuelosPage.rellenarFormulario("Fernando","Cavenaghi","Marcelo","Gallardo","Pity","Martinezgaal");

    }
    @When("selecciono fecha de nacimiento del ninio")
    public void selecciono_fecha_de_nacimiento_del_ninio() {
        VuelosPage.fechaNNinos();

    }
    @When("hago click en continuar")
    public void hago_click_en_continuar() {
        VuelosPage.clickBtnContinuar();

    }
    @Then("el sistema muestra la pagina de equipaje")
    public void el_sistema_muestra_la_pagina_de_equipaje() throws InterruptedException {
        Thread.sleep(2000);
        String resultado=VuelosPage.validacionTitulo();
        System.out.println(resultado);
    }


}