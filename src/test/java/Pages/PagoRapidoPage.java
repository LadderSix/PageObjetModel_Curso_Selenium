package Pages;

import Base.BaseSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PagoRapidoPage extends BaseSelenium {
    public PagoRapidoPage(WebDriver driver){
        super(driver);
    }
    //Centralizar los localizadores
    By btnPagoRapido = By.xpath("//a[contains(text(),'Pago Rápido')]");
    By servicios = By.tagName("lib-payment-card");
    By categoria = By.xpath("//div[@id='7']");
    By continuar = By.xpath("//a[contains(text(),'Continuar')]");
    By aceptar = By.xpath("//button[contains(text(),'Aceptar')]");
    By listadoEmpresas = By.xpath("//body[1]/main[1]/div[1]/div[3]/payment-root[1]/app-listado-servicios[1]/div[2]/div[1]/div[1]/div[1]/div[1]/lib-payment-card[23]/app-select-company[1]/div[1]/div[1]/div[2]/form[1]/section[1]/div[1]/div[1]/div[1]/select[1]");


    //Definir las acciones de la Página
    public void btnPagoRapido(){
        click(esperaExplicita(btnPagoRapido));
    }

    public void buscarServicio(String miServicio){
        esperarXSegundos(2000);
        List<WebElement> listaServicios = driver.findElements(servicios);

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
    public void seleccionarEmpresa(String miEmpresa){
        if(estaHabilitado(listadoEmpresas)){
            esperarXSegundos(1500);
            Select option = new Select(driver.findElement(listadoEmpresas));
            System.out.println(option);
            option.selectByVisibleText(miEmpresa);
        }else {
            System.out.println("Error en la operación");
        }
    }

    public void enviaCuenta(String cuenta){

    }
}
