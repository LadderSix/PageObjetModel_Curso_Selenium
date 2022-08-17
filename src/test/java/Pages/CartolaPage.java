package Pages;

import Base.BaseSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
    By listaServicio = By.xpath("(//select[@name=\"cbCategory\"])[1]");
    By listaEmpresa = By.xpath("(//select[@name=\"cbCompany\"])[1]");
    By btnBuscar =  By.xpath("(//button[contains(text(),'Buscar')])[1]");

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
    public void seleccionarServicio(String miServicio){
        if(estaHabilitado(listaServicio)){
            esperarXSegundos(1500);
            Select option = new Select(driver.findElement(listaServicio));
            System.out.println(option);
            option.selectByVisibleText(miServicio);
        }else {
            System.out.println("Error en la operación");
        }
    }
    public void seleccionarEmpresa(String miEmpresa){
        if(estaHabilitado(listaEmpresa)){
            esperarXSegundos(1500);
            Select option2 = new Select(driver.findElement(listaEmpresa));
            System.out.println(option2);
            option2.selectByVisibleText(miEmpresa);
        }else {
            System.out.println("Error en la operación");
        }
    }

    public void buscar(){
        click(esperaExplicita(btnBuscar));
    }
}
