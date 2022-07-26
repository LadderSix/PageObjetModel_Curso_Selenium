package Pages;

import Base.BaseSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PagoRapidoPage extends BaseSelenium {
    public PagoRapidoPage(WebDriver driver){
        super(driver);
    }
    //Centralizar los localizadores
    By btnPagoRapido = By.xpath("//a[contains(text(),'Pago Rápido')]");
    By servicios = By.tagName("lib-payment-card");
    By categoria = By.tagName("app-category");
    By continuar = By.xpath("//a[contains(text(),'Continuar')]");
    By aceptar = By.xpath("//button[contains(text(),'Aceptar')]");


    //Definir las acciones de la Página
    public void btnPagoRapido(){
        click(esperaExplicita(btnPagoRapido));
    }

    public void buscarServicio(String miServicio){
        List<WebElement> listaServicios = driver.findElements(By.tagName("lib-payment-card"));

        for (int i = 0; i < listaServicios.size(); i++ ) {
            if (listaServicios.get(i).getText().equals(miServicio)) {
                System.out.println(listaServicios.get(i).getText());
                click(esperaExplicita(categoria));
                System.out.println(".......!");
                break;
            } else {
                System.out.println(listaServicios.get(i).getText());
                System.out.println("Error");
            }
        }
    }
    public void seleccionarEmpresa(){

    }

    public void enviaCuenta(String cuenta){

    }
}
