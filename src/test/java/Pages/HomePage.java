package Pages;

import Base.BaseSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BaseSelenium {
    public HomePage(WebDriver driver){
        super(driver);
    }
    //Centralizar los localizadores
    By rut = By.name("username");
    By password = By.xpath("/html/body/modal-container/div/div/login-modal-login/div/div[2]/form/section/div[2]/input");
    By btnIngresar = By.xpath("/html/body/modal-container/div/div/login-modal-login/div/div[2]/form/section/button");
    By btnMiServipag = By.xpath("//a[contains(text(),'Mi Servipag')]");

    //Definir las acciones de la Página
    public void iniciarSesion(String miRut,String pass){
        click(esperaExplicita(btnMiServipag));
        esperarXSegundos(1000);

        agregarTexto(rut,miRut);
        agregarTexto(password,pass);

        click(esperaExplicita(btnIngresar));
    }

}
