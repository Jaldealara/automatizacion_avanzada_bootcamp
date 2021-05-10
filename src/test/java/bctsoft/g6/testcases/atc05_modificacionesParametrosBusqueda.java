package bctsoft.g6.testcases;

import bctsoft.g6.pageobject.pages.JetSmartHomePage;
import bctsoft.g6.pageobject.pages.JetSmartHotelesPage;
import bctsoft.testcases.TestBase;
import org.testng.annotations.Test;

public class atc05_modificacionesParametrosBusqueda extends TestBase {
    protected JetSmartHomePage jsHomePage;
    protected JetSmartHotelesPage jsHotelesPage;

    @Test
    public void ATC05_modificacionParametrosBusqueda() throws InterruptedException {
        jsHomePage = new JetSmartHomePage(driver);
        jsHotelesPage = new JetSmartHotelesPage(driver);
        jsHomePage.goToUrl("https://jetsmart.com/cl/es/");
        jsHomePage.cerrarModuloSuscribete();
        jsHomePage.lugarDeDestinoHoteles("Santiago");
        jsHomePage.fechaDeIngresoHoteles("13-junio-2021");
        jsHomePage.fechaDeSalidaHoteles("3-julio-2021");
        jsHomePage.seleccionarNroHabitaciones("1");
        jsHomePage.seleccionarNroAdultos("2");
        jsHomePage.seleccionarNroNinos("1");
        jsHomePage.btnBusquedaHotel();
        jsHotelesPage.switchToPestana(0,1);
        String datosInt = jsHotelesPage.seleccionFiltroMayorPrecio();
        jsHotelesPage.modificacionBusqueda();
        String result=jsHotelesPage.validacionDeBusqueda(datosInt,"Arica");
        System.out.println(result);
    }
}
