package Pages;

import Base.BaseSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartolaPage extends BaseSelenium{
    public CartolaPage(WebDriver driver){
        super(driver);
    }

    //Centralizar los localizadores

    By radio6_meses = By.xpath("//input[@id='monthSix']");
    By radio10_meses = By.xpath("//input[@id='monthTen']");
    By botonera = By.xpath("//ul[@class=\"list-inline btn-group-cartola\"]/li");
    By descargarExcelCartola = By.xpath("(//ul[@class=\"list-inline btn-group-cartola\"]/li)[4]");

    //Definir las acciones de la Página
    public void descargarCartolaExcel(){
        esperarXSegundos(1500);
        if(estaHabilitado(botonera)){
            click(descargarExcelCartola);
        }else{
            System.out.println("Elemento no disponible");
        }

    }

    public void cartolaUlimos6Meses(){
        if(estaSeleccionado(radio6_meses)){
            System.out.println("Elemento ya seleccionado");
        }else{
            click(radio6_meses);
        }
    }
    public void cartolaUlimos10Meses(){
        if(estaSeleccionado(radio10_meses)){
            System.out.println("Elemento ya seleccionado");
        }else{
            click(radio10_meses);
        }

    }
}
