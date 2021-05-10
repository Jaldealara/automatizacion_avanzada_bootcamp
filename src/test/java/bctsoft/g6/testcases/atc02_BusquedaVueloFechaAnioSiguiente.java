package bctsoft.g6.testcases;

import bctsoft.g6.pageobject.pages.JetSmartHomePage;
import bctsoft.g6.pageobject.pages.JetSmartVuelosPage;
import bctsoft.testcases.TestBase;
import org.testng.annotations.Test;

public class atc02_BusquedaVueloFechaAnioSiguiente extends TestBase {
    protected JetSmartHomePage jsHomePage;
    protected JetSmartVuelosPage jsVuelosPage;

    @Test
    public void ATC02_busquedaVueloFechaAnioSiguiente()throws InterruptedException{
        jsHomePage = new JetSmartHomePage(driver);
        jsVuelosPage = new JetSmartVuelosPage(driver);
        jsHomePage.goToUrl("https://jetsmart.com/cl/es/");
        jsHomePage.cerrarModuloSuscribete();
        jsHomePage.ingresarOrigenVuelos("Santiago");
        jsHomePage.ingresarDestinoVuelos("Arica");
        jsHomePage.ingresarFechaIda();
        jsHomePage.ingresarFechaVuelta();
        jsHomePage.boton_Search();
        jsVuelosPage.validacionBusqueda();
        String resultado=jsVuelosPage.validacionBusqueda();
        System.out.println(resultado);

    }
}
