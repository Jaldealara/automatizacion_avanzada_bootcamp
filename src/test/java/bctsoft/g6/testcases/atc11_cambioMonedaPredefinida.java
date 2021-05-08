package bctsoft.g6.testcases;

import bctsoft.g6.pageobject.pages.JetSmartHomePage;
import bctsoft.g6.pageobject.pages.JetSmartTrasladosPage;
import bctsoft.testcases.TestBase;
import org.testng.annotations.Test;

public class atc11_cambioMonedaPredefinida extends TestBase {
    protected JetSmartHomePage jsHomePage;
    protected JetSmartTrasladosPage jetSmartTrasladosPage;

    @Test
    public void ATC11_cambioMonedaPredefinida() throws InterruptedException {
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

        jetSmartTrasladosPage.cierrePopUp();
        jetSmartTrasladosPage.seleccionMoneda("USD");
        jetSmartTrasladosPage.btnBuscar();
        String resultado=jetSmartTrasladosPage.monedaPrecioTraslado();
        System.out.println(resultado);
    }
}
