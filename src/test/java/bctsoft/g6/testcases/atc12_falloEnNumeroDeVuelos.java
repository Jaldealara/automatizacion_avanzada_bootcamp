package bctsoft.g6.testcases;

import bctsoft.g6.pageobject.pages.JetSmartHomePage;
import bctsoft.g6.pageobject.pages.JetSmartTrasladosPage;
import bctsoft.testcases.TestBase;
import org.testng.annotations.Test;

public class atc12_falloEnNumeroDeVuelos extends TestBase {
    protected JetSmartHomePage jsHomePage;
    protected JetSmartTrasladosPage jetSmartTrasladosPage;

    @Test
    public void ATC12_FalloEnNumeroDeVuelos () throws InterruptedException {
        jsHomePage = new JetSmartHomePage(driver);
        jetSmartTrasladosPage = new JetSmartTrasladosPage(driver);

        jsHomePage.goToUrl("https://jetsmart.com/cl/es/");
        jsHomePage.cerrarModuloSuscribete();
        jsHomePage.lugarOrigenTraslados("Buenos Aires - Ministro Pistarini");
        jsHomePage.lugarDestinoTraslados("Estadio monumental");
        jsHomePage.fechaIdaTraslados();
        jsHomePage.seleccionarHoraTraslados();
        jsHomePage.seleccionarPasajeros();
        jsHomePage.botonBuscarTraslados();

        jsHomePage.switchToPestana(0,1);

        jetSmartTrasladosPage.botonReservaTraslado();
        jetSmartTrasladosPage.rellenarDatos("juan separado","juan12@gmail.com","972447281");
        jetSmartTrasladosPage.clickPage();
        jetSmartTrasladosPage.nroDeVuelo("asddsdqwdqwd");
        String result=jetSmartTrasladosPage.confirmacion();
        System.out.println(result);
    }
}
