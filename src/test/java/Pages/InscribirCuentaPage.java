package Pages;

import Base.BaseSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InscribirCuentaPage extends BaseSelenium {
    public InscribirCuentaPage(WebDriver driver){
        super(driver);
    }
    //Centralizar los localizadores
    By buscarCuenta = By.xpath("//body/modal-container[1]/div[1]/div[1]/modal-content[1]/div[1]/div[2]/app-add-account[1]/div[1]/div[1]/div[1]/div[1]/search-searchinput[1]/div[1]/div[1]/input[1]");
    By numeroCuenta = By.tagName("input");
    By agregar = By.xpath("//button[contains(text(),'Agregar')]");
    By continuar = By.xpath("//a[contains(text(),'Continuar')]");
    By confirmacion = By.xpath("//h3[contains(text(),'Excelente!')]");
    By confirmacion2 = By.xpath("//a[contains(text(),'Sigue agregando tus cuentas')]");
    By aceptar = By.xpath("//button[contains(text(),'Aceptar')]");

    //Definir las acciones de la Página
    public void agregarCuenta(String cuenta, String idCuenta){
        esperarXSegundos(3000);
        agregarTexto(buscarCuenta,cuenta);
        accionTeclado(buscarCuenta,Keys.ARROW_DOWN);
        accionTeclado(buscarCuenta,Keys.ARROW_DOWN);
        accionTeclado(buscarCuenta,Keys.ARROW_DOWN);
        accionTeclado(buscarCuenta,Keys.ENTER);
        agregarTexto(numeroCuenta,idCuenta);
        esperarXSegundos(1000);
        click(esperaExplicita(agregar));
        esperarXSegundos(1000);
        click(esperaExplicita(continuar));
        esperarXSegundos(1000);
    }

    public String getTitulo(){
        return obtenerTexto(confirmacion);
    }

    public String getTitulo2(){
        return obtenerTexto(confirmacion2);
    }

    public void btnAceptar(){
        esperarXSegundos(1500);
        click(esperaExplicita(aceptar));
    }

}
