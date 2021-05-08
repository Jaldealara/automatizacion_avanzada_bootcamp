package bctsoft.g6.testcases;

import bctsoft.g6.pageobject.pages.JetSmartHomePage;
import bctsoft.testcases.TestBase;
import org.testng.annotations.Test;

public class atc01_cantidadMaximaDePasajerosMayor10 extends TestBase {

    protected JetSmartHomePage jsHomePage;

    @Test
    public void ATC01_cantidadMaximaDePasajerosMayor10()throws InterruptedException{
        jsHomePage = new JetSmartHomePage(driver);
        jsHomePage.goToUrl("https://jetsmart.com/cl/es/");
        jsHomePage.cerrarModuloSuscribete();
        String result=jsHomePage.cantidadPasajeros();
        System.out.println(result);
    }


}
