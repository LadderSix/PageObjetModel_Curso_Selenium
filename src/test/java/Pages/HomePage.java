package Pages;

import Base.BaseSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseSelenium {
    public HomePage(WebDriver driver){
        super(driver);
    }
    //Centralizar los localizadores
    By rut = By.name("username");
    By password = By.xpath("/html/body/modal-container/div/div/login-modal-login/div/div[2]/form/section/div[2]/input");
    By ingresar = By.xpath("/html/body/modal-container/div/div/login-modal-login/div/div[2]/form/section/button");
    By titulo = By.xpath("//h4[contains(text(),'Hola Matias')]");
    By miServipag = By.xpath("//a[contains(text(),'Mi Servipag')]");

    //Definir las acciones de la Página
}
