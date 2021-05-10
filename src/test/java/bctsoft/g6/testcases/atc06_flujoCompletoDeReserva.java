package bctsoft.g6.testcases;

import bctsoft.g6.pageobject.pages.JetSmartHomePage;
import bctsoft.g6.pageobject.pages.JetSmartHotelesPage;
import bctsoft.g6.pageobject.pages.JetSmartVerDisponibilidadHoteles;
import bctsoft.testcases.TestBase;
import org.testng.annotations.Test;

public class atc06_flujoCompletoDeReserva extends TestBase {
    protected JetSmartHomePage jsHomePage;
    protected JetSmartHotelesPage jsHotelesPage;
    protected JetSmartVerDisponibilidadHoteles jetSmartVerDisponibilidadHoteles;

    @Test
    public void ATC_06flujoCompletoDeReserva() throws InterruptedException {
        jsHomePage = new JetSmartHomePage(driver);
        jsHotelesPage = new JetSmartHotelesPage(driver);
        jetSmartVerDisponibilidadHoteles = new JetSmartVerDisponibilidadHoteles(driver);
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
        jsHotelesPage.seleccionFiltroMayorPrecio();
        jsHotelesPage.filtroCancelacionGratis();
        jsHotelesPage.clickBtnVerDisponibilidad();
        jsHotelesPage.switchToPestana(0,1);
        jetSmartVerDisponibilidadHoteles.reservar();
        jetSmartVerDisponibilidadHoteles.numeroDeHabitaciones("1");
        jetSmartVerDisponibilidadHoteles.clickReservare();
        jetSmartVerDisponibilidadHoteles.rellenarFormulario("juanito","perez","asdas@gmail.com");
        String resul=jetSmartVerDisponibilidadHoteles.validacionFinal();
        System.out.println(resul);


    }
}
