package automationcraft.testcreation.G6.pages;

import bctsoft.g6.pageobject.base.SeleniumBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class JetSmartHotelesPage extends SeleniumBase {
    public JetSmartHotelesPage(WebDriver driver) {
        super(driver);
    }

    private By filtroMayorPrecio = By.xpath("(//div[@class='bui-checkbox__label filter_item css-checkbox'])[5]"); //a,b,c se quiere la C,  c[2]
    private By listaHoteles = By.xpath("(//div[@class='bui-checkbox__label filter_item css-checkbox'])[5]");
    private By filtroDesayuno = By.xpath("(//div[@class='bui-checkbox__label filter_item css-checkbox ']//span[contains(text(),'Desayuno incluido')])[1]");
    private By textoPrecioHotel = By.xpath("(//*[@class='bui-price-display__value prco-inline-block-maker-helper '])[1]");
    private By textoDesayuno = By.xpath("(//sup[@class='sr_room_reinforcement'])[1]");


    private By origenNuevaBusqueda = By.xpath("//input[@id='ss']");
    private By listaDelugares = By.xpath("//li[@data-i='0']");
    private By tituloBusqueda = By.xpath("(//h1)[1]");
    private By filtroCancelacióngratis = By.xpath("//span[contains(text(),'Cancelación gratis')]");
    private By btnVerDisponibilidad = By.xpath("(//a[@class='txp-cta bui-button bui-button--primary sr_cta_button'])[1]");

    public void cambioDePestana() throws InterruptedException {
        switchToPestana(0,1);
    }

    public String  seleccionFiltroMayorPrecio() throws InterruptedException {
       //WebElement ultimoValor = findElements(filtroMayorPrecio).get(findElements(filtroMayorPrecio).size()-1);
        click(filtroMayorPrecio);
        espera(3000);
        int longitud = getText(textoPrecioHotel).length();

        String [] arrayTextoPrecio = getText(textoPrecioHotel).split(" ");
        String valorTextoPrecio = arrayTextoPrecio[1];
        String [] data= valorTextoPrecio.split("\\.");
        String nroConcatenado= data[0]+data[1];

        String datosInt= String.valueOf(longitud);
        datosInt =datosInt+" "+nroConcatenado;

        return datosInt;
    }

    public void seleccionarFiltroDesayuno() throws InterruptedException{
        isDisplayed(listaHoteles);
        click(filtroDesayuno);
        espera(4000);
    }
    public void filtroCancelacionGratis() throws InterruptedException {
        isDisplayed(listaHoteles);
        click(filtroCancelacióngratis);
        espera(4000);
    }

    public String validacionPrecioDesayuno(){
        String resultado = "";
        String [] arrayTextoPrecio = getText(textoPrecioHotel).split(" ");
        String valorTextoPrecio = arrayTextoPrecio[1];
        String [] arrayTextoprecioP= valorTextoPrecio.split("\\.");
        String valorPrecio= arrayTextoprecioP[0]+arrayTextoprecioP[1]+arrayTextoprecioP[2];
        int PrecioHotel = Integer.parseInt(valorPrecio);
            try {

                if (PrecioHotel >= 171000) {
                    resultado = "Filtro de precio aplicado correctamente";
                    if (getText(textoDesayuno).equals("Desayuno incluido")) {
                        resultado = "Prueba de filtros exitosa";
                    }
                }
            }
            catch (NoSuchElementException e){
                System.out.println("filtro desayuno aplicado incorrectamente");
            }

       Assert.assertNotEquals("Prueba de ambos filtros exitosa",resultado);
        return resultado;
    }

    public void modificacionBusqueda(){
        clear(origenNuevaBusqueda);
        type("Arica",origenNuevaBusqueda);
        isDisplayed(listaDelugares);
        click(listaDelugares);
        sendKeysEnter(origenNuevaBusqueda);
    }

    public String validacionDeBusqueda(String datosInt, String busquedaNueva){
        String resultado= "";
        int longitud2 = getText(textoPrecioHotel).length();
        String [] corte=datosInt.split(" ");
        int longitud = Integer.parseInt(corte[0]);
        int nroCNA = Integer.parseInt(corte[1]);

        String [] arrayTextoPrecioNB = getText(textoPrecioHotel).split(" ");
        String valorTextoPrecio = arrayTextoPrecioNB[1];
        String [] dataNB= valorTextoPrecio.split("\\.");
        String nroConcatenadoNB= dataNB[0]+dataNB[1];
        int nroCNB= Integer.parseInt(nroConcatenadoNB);
        if(longitud2 == longitud){
            if(nroCNB<nroCNA) {
                if (!getText(tituloBusqueda).equals(busquedaNueva)) {
                    resultado = "modificacion parametros de busqueda exitosa";
                }
            }
        }
        Assert.assertEquals("modificacion parametros de busqueda exitosa",resultado);
        return resultado;
    }
    public void clickBtnVerDisponibilidad(){
        click(btnVerDisponibilidad);
    }
}
