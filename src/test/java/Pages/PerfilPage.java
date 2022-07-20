package Pages;

import Base.BaseSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PerfilPage extends BaseSelenium {
    public PerfilPage(WebDriver driver){
        super(driver);
    }
    //Centralizar los localizadores
    By tituloPerfil = By.xpath("//h4[contains(text(),'Hola Matias')]");
    By miRut = By.cssSelector("#rut");
    By miNombre = By.xpath("//input[@id='validationCustom01']");
    By miApellido = By.xpath("//input[@id='validationCustom02']");
    By listaPerfil = By.xpath("//button[@id='button-basic']");
    By btnCerrarSesion = By.xpath("//a[contains(text(),'Cerrar Sesión')]");

    //Definir las acciones de la Página
    public String getTextTituloPerfil(){
        return obtenerTexto(tituloPerfil);
    }
    public void cerrarSesion(){
        click(esperaExplicita(listaPerfil));
        click(btnCerrarSesion);
    }

}
