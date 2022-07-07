package Pages;

import Base.BaseSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MiServipagPage extends BaseSelenium {
    public MiServipagPage(WebDriver driver){
        super(driver);
    }
    //Centralizar los localizadores

    // locators para eliminar cuenta
    By listadoCuenta = By.xpath("//div[@class=\"id col-3 text-break\"]");
    By borrar = By.xpath("//li[@class=\"delete\"]");
    By eliminar = By.xpath("//button[contains(text(),'Eliminar')]");
    By tituloEliminacion = By.xpath("//p[contains(text(),'Su cuenta ha sido eliminada')]");
    By entendido = By.xpath("//button[contains(text(),'Entendido')]");
    By btnInscribirCuenta = By.xpath("//a[contains(text(),'Inscribir cuentas')]");

    //Definir las acciones de la Página
    public void inscribirCuenta(){
        click(btnInscribirCuenta);
    }

    public void IrAlPerfil(){
        driver.get("https://portal.servipag.com/private/profile");
        esperarXSegundos(15);
    }
    public void eliminarCuenta(){

    }

}
