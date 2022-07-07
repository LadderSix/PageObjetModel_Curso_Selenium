package Pages;

import Base.BaseSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PerfilPage extends BaseSelenium {
    public PerfilPage(WebDriver driver){
        super(driver);
    }
    //Centralizar los localizadores
    By tituloPerfil = By.xpath("//h4[contains(text(),'Hola Matias')]");
    By miRut = By.cssSelector("#rut");
    By miNombre = By.xpath("//input[@id='validationCustom01']");
    By miApellido = By.xpath("//input[@id='validationCustom02']");
    By inscribirCuenta = By.xpath("//a[contains(text(),'Inscribir cuentas')]");

    // locators para eliminar cuenta
    By listadoCuenta = By.xpath("//div[@class=\"id col-3 text-break\"]");
    By borrar = By.xpath("//li[@class=\"delete\"]");
    By eliminar = By.xpath("//button[contains(text(),'Eliminar')]");
    By tituloEliminacion = By.xpath("//p[contains(text(),'Su cuenta ha sido eliminada')]");
    By entendido = By.xpath("//button[contains(text(),'Entendido')]");

    //Definir las acciones de la Página
}
