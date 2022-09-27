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

    By btnCartola = By.xpath("//a[contains(text(),' Cartola Histórica ')]");
    // locators para eliminar cuenta
    By listadoCuenta = By.xpath("//div[@class=\"id col-3 text-break\"]");
    By borrar = By.xpath("//li[@class=\"delete\"]");
    By eliminar = By.xpath("//button[contains(text(),'Eliminar')]");
    By tituloEliminacion = By.xpath("//p[contains(text(),'Su cuenta ha sido eliminada')]");
    By entendido = By.xpath("//button[contains(text(),'Entendido')]");
    By btnInscribirCuenta = By.xpath("//a[contains(text(),'Inscribir cuentas')]");
    By menu = By.xpath("//button[@id='button-basic']");
    By btnIrAPerfil = By.xpath("//a[contains(text(),'Ir a perfil')]");
    By btnCerrarSesion = By.xpath("//a[contains(text(),'Cerrar Sesión')]");
    By tituloCuentaEliminada = By.xpath("//h3[contains(text(),'Movistar Hogar/Negocio Internet')]");
    By linkPresupuesto = By.xpath("(//a[@href=\"/private/budget\"])[1]");


    //Definir las acciones de la Página
    public void inscribirCuenta(){
        esperarXSegundos(1500);
        click(esperaExplicita(btnInscribirCuenta));
    }
    public void irAlPerfil(){
        click(esperaExplicita(menu));
        click(btnIrAPerfil);
    }
    public void irACartola(){
        esperarXSegundos(1500);
        click(esperaExplicita(btnCartola));
    }
    public void irAPresupuesto(){
        esperarXSegundos(1500);
        click(esperaExplicita(linkPresupuesto));
    }

    public String getTituloEliminacion(){
        return obtenerTexto(tituloEliminacion);
    }

    public void eliminarCuenta(String idCuenta){
        esperarXSegundos(4000);
        List<WebElement> misCuentas = driver.findElements(listadoCuenta);

        for (int i = 0; i < misCuentas.size(); i++ ) {
            if (misCuentas.get(i).getText().equals(idCuenta)) {
                System.out.println(misCuentas.get(i).getText());
                esperarXSegundos(2000);
                click(esperaExplicita(borrar));
                if(estaDesplegado(tituloCuentaEliminada)){
                    esperarXSegundos(3000);
                    click(esperaExplicita(eliminar));
                    break;
                }
            } else {
                System.out.println(misCuentas.get(i).getText());
                System.out.println("Error dato no es correcto");
            }
        }
    }
    public void btnEntendido(){
        esperarXSegundos(2000);
        click(esperaExplicita(entendido));
        System.out.println("Cuenta Eliminada");
    }
}
