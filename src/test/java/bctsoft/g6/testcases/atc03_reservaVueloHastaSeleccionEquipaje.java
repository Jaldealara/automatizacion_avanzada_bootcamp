package bctsoft.g6.testcases;

import bctsoft.g6.pageobject.pages.JetSmartHomePage;
import bctsoft.g6.pageobject.pages.JetSmartVuelosPage;
import bctsoft.testcases.TestBase;
import org.testng.annotations.Test;

public class atc03_reservaVueloHastaSeleccionEquipaje extends TestBase {
    protected JetSmartHomePage jsHomePage;
    protected JetSmartVuelosPage jsVuelosPage;

    @Test
    public void ATC03_reservaVueloHastaSeleccionEquipaje()throws InterruptedException{
        jsHomePage = new JetSmartHomePage(driver);
        jsVuelosPage = new JetSmartVuelosPage(driver);
        jsHomePage.goToUrl("https://jetsmart.com/cl/es/");
        jsHomePage.cerrarModuloSuscribete();
        jsHomePage.ingresarOrigenVuelos("Santiago");
        jsHomePage.ingresarDestinoVuelos("Arica");
        jsHomePage.ingresarFechaIda();
        jsHomePage.clickSoloIdaVuelos();
        jsHomePage.sumarPasajerosVuelos();
        jsHomePage.boton_Search();
        jsVuelosPage.clickBotonPrecio();
        jsVuelosPage.seleccionPaquetesFull();
        jsVuelosPage.btnContinuarDatosPasajeros();
        jsVuelosPage.rellenarFormulario("Fernando","Cavenaghi","Marcelo","Gallardo","Pity","Martinezgaal");
        jsVuelosPage.fechaNNinos();
        jsVuelosPage.clickBtnContinuar();

        String resultado=jsVuelosPage.validacionTitulo();
        System.out.println(resultado);

    }
}
