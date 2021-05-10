package bctsoft.g6.testcases;

import bctsoft.g6.pageobject.pages.JetSmartHomePage;
import bctsoft.g6.pageobject.pages.JetSmartTrasladosPage;
import bctsoft.testcases.TestBase;
import org.testng.annotations.Test;

public class atc10_busquedaDeTraslado extends TestBase {

    protected JetSmartHomePage jsHomePage;
    protected JetSmartTrasladosPage jetSmartTrasladosPage;

    @Test
    public void ATC10_busquedaDeTraslado () throws InterruptedException {
        jsHomePage = new JetSmartHomePage(driver);
        jetSmartTrasladosPage = new JetSmartTrasladosPage(driver);

        jsHomePage.goToUrl("https://jetsmart.com/cl/es/");
        jsHomePage.cerrarModuloSuscribete();
        jsHomePage.lugarOrigenTraslados("Buenos Aires");
        jsHomePage.lugarDestinoTraslados("Bariloche");
        jsHomePage.fechaIdaTraslados();
        jsHomePage.seleccionarHoraTraslados();
        jsHomePage.seleccionarPasajeros();
        jsHomePage.botonBuscarTraslados();
        jsHomePage.switchToPestana(0,1);
        String resul = jetSmartTrasladosPage.validacionResultado();
        System.out.println(resul);

    }
}
