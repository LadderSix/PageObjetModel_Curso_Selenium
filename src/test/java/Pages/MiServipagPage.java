package Pages;

import Base.BaseSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

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
    By listaPerfil = By.xpath("//button[@id='button-basic']");
    By btnIrAPerfil = By.xpath("//a[contains(text(),'Ir a perfil')]");
    By btnCerrarSesion = By.xpath("//a[contains(text(),'Cerrar Sesión')]");

    //Definir las acciones de la Página
    public void inscribirCuenta(){
        esperarXSegundos(1500);
        click(esperaExplicita(btnInscribirCuenta));
    }

    public void irAlPerfil(){
        click(esperaExplicita(listaPerfil));
        click(btnIrAPerfil);

    }
    public String getTituloEliminacion(){
        return obtenerTexto(tituloEliminacion);
    }

    public void eliminarCuenta(){
        esperarXSegundos(4000);
        List<WebElement> misCuentas = driver.findElements(listadoCuenta);

        for (int i = 0; i < misCuentas.size(); i++ ) {
            if (misCuentas.get(i).getText().equals("562267260251")) {
                System.out.println(misCuentas.get(i).getText());
                esperarXSegundos(1000);
                click(esperaExplicita(borrar));
                esperarXSegundos(1000);
                click(esperaExplicita(eliminar));
                break;
            } else {
                System.out.println(misCuentas.get(i).getText());
                System.out.println("Error dato no es correcto");
            }
        }
    }
    public void btnEntendido(){
        esperarXSegundos(1000);
        click(esperaExplicita(entendido));
        System.out.println("Cuenta Eliminada");
    }
}
