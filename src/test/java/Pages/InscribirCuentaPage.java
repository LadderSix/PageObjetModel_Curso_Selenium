package Pages;

import Base.BaseSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InscribirCuentaPage extends BaseSelenium {
    public InscribirCuentaPage(WebDriver driver){
        super(driver);
    }
    //Centralizar los localizadores
    By buscarCuenta = By.xpath("//body/modal-container[1]/div[1]/div[1]/modal-content[1]/div[1]/div[2]/app-add-account[1]/div[1]/div[1]/div[1]/div[1]/search-searchinput[1]/div[1]/div[1]/input[1]");
    By numeroCuenta = By.tagName("input");
    By agregar = By.xpath("//button[contains(text(),'Agregar')]");
    By continuar = By.xpath("//a[contains(text(),'Continuar')]");
    By titulo = By.xpath("//h3[contains(text(),'Excelente!')]");
    By sigueAgregando = By.xpath("//a[contains(text(),'Sigue agregando tus cuentas')]");
    By aceptar = By.xpath("//button[contains(text(),'Aceptar')]");

    //Definir las acciones de la Página
}
