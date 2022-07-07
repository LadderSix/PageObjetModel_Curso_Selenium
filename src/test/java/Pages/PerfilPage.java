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

    //Definir las acciones de la Página
    public void getTextTituloPerfil(){
        WebElement miTituloPerfil = driver.findElement(tituloPerfil);
        miTituloPerfil.getText();
    }

}
