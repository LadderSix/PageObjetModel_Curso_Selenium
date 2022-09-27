package Pages;

import Base.BaseSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PresupuestoPage extends BaseSelenium {
    public PresupuestoPage(WebDriver driver){
        super(driver);
    }

    //Centralizar los localizadores

    By btnPresupuesto = By.xpath("//button[contains(text(),'Crear presupuesto')]");
    By modalCreacionPresupuesto = By.xpath("//div[@class=\"modal-content border-0\"]");
    By listadoCuentas = By.xpath("//div[@class=\"col-12 lista-scroll\"]");

    //Definir las acciones de la Página

    public void crearPresupuesto() {
        click(esperaExplicita(btnPresupuesto));

        esperarXSegundos(2000);
        List<WebElement> misCuentas = driver.findElements(listadoCuentas);
        for (int i = 0; i < misCuentas.size(); i++ ) {
            System.out.println(misCuentas.get(i).getText());
        }



    }
}
