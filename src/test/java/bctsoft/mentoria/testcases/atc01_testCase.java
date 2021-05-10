<<<<<<< HEAD:src/test/java/bctsoft/mentoria/testcases/atc01_testCase.java
package bctsoft.mentoria.testcases;

import bctsoft.mentoria.pageobject.pages.JetSmartHomePage;
import org.testng.annotations.Test;


=======
package bctsoft.testcases;
import bctsoft.pageobject.pages.JetSmartHomePage;
import org.testng.annotations.Test;
>>>>>>> a94a18f (Separacion de los casos de prueba):src/test/java/bctsoft/testcases/atc01_testCase.java
public class atc01_testCase extends TestBase{
    protected JetSmartHomePage jsHomePage;
    @Test
    public void atc01_test(){
        jsHomePage = new JetSmartHomePage(driver);
        jsHomePage.goToUrl("https://jetsmart.com/cl/es/");
        jsHomePage.cerrarModuloSuscribete();
    }

}
