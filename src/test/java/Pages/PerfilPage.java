package Pages;

import Base.BaseSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PerfilPage extends BaseSelenium {
    public PerfilPage(WebDriver driver){
        super(driver);
    }
    //Centralizar los localizadores
    By tituloPerfil = By.xpath("//h4[contains(text(),'Hola Matias')]");
    By miRut = By.cssSelector("#rut");
    By miNombre = By.xpath("//input[@id='validationCustom01']");
    By miApellido = By.xpath("//input[@id='validationCustom02']");
    By menu = By.xpath("//button[@id='button-basic']");
    By listaPerfil = By.xpath("//ul[@id='dropdown-basic']/li");
    By btnCerrarSesion = By.xpath("//a[contains(text(),'Cerrar sesión')]");

    //Definir las acciones de la Página
    public String getTextTituloPerfil(){
        return obtenerTexto(tituloPerfil);
    }
    public void cerrarSesion(){
        click(esperaExplicita(menu));
        esperarXSegundos(1000);

        List<WebElement> miListado = driver.findElements(listaPerfil);

        for (int i = 0; i < miListado.size(); i++ ) {
            if (miListado.get(i).getText().equals("Cerrar sesión")) {
                System.out.println(miListado.get(i).getText());
                esperarXSegundos(1000);
                click(esperaExplicita(btnCerrarSesion));
                break;
            } else {
                System.out.println(miListado.get(i).getText());
                System.out.println("Error dato no es correcto");
            }
        }
    }

}
