package Base;

import org.joda.time.Seconds;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseSelenium {
    //Atributos
    protected WebDriver driver;
    protected WebDriverWait wait;

    //Accesadores y mutadores
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        this.wait = wait;
    }

    //Constructor
    public BaseSelenium(WebDriver driver) {
        this.driver = driver;
    }

    //Acciones con selenium

    //Busqueda de elementos web
    public WebElement buscarElementoWeb(By localizador){
        return this.driver.findElement(localizador);
    }

    //Cargar el sitio
    public void cargarSitio(String url){
        this.driver.get(url);
    }

    //EsperasExplicitas
    public WebElement esperaExplicita(By localizador){
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.elementToBeClickable(localizador));
    }

    //EsperasImplicitas
    public void esperarXSegundos(int milisegundos) {
        try{
            Thread.sleep(milisegundos);
        }catch(Exception e){
            System.out.println("Ocurrio un error durante la espera..");
            System.out.println(e.getStackTrace());
        }
    }

    //Click
    public void click(By localizador){
        this.driver.findElement(localizador).click();
    }

    public void click(WebElement elementoWeb){
        elementoWeb.click();
    }

    //obtenerTexto
    public String obtenerTexto(By localizador){
        return this.driver.findElement(localizador).getText();
    }

    public String obtenerTexto(WebElement elementoWeb){
        return elementoWeb.getText();
    }

    //agregarTexto
    public void agregarTexto(By localizador,String texto){
        this.driver.findElement(localizador).sendKeys(texto);
    }

    public void agregarTexto(WebElement elementoWeb,String texto){
        elementoWeb.sendKeys(texto);
    }

    //maximizarBrowser
    public void maximizarBrowser(){
        this.driver.manage().window().maximize();
    }

    //cerrarBrowser
    public void cerrarBrowser(){
        this.driver.close();
    }

    //conexionDriver
    public WebDriver conexionDriver(String browser,String rutaDriver, String propertyDriver){
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty(propertyDriver,rutaDriver);
            this.driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty(propertyDriver,rutaDriver);
            this.driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("IExplorer")){
            System.setProperty(propertyDriver,rutaDriver);
            this.driver = new InternetExplorerDriver();
        }
        return this.driver;
    }

    public boolean estaHabilitado(By localizador){
        try{
            return this.driver.findElement(localizador).isEnabled();
        }catch (Exception e){
            System.out.println("No se verifico que el elemento asociado el locator:"+localizador.toString()+" estuviera habilitado");
            return false;
        }
    }
    public boolean estaDesplegado(By localizador){
        try{
            return this.driver.findElement(localizador).isDisplayed();
        }catch (Exception e){
            System.out.println("No se verifico que el elemento asociado el locator:"+localizador.toString()+" estuviera desplegado");
            return false;
        }
    }
    public boolean estaSeleccionado(By localizador){
        try{
            return this.driver.findElement(localizador).isSelected();
        }catch (Exception e){
            System.out.println("No se verifico que el elemento asociado el locator:"+localizador.toString()+" estuviera seleccionado");
            return false;
        }
    }

    public String obtenerUrlPagina(){
        return this.driver.getCurrentUrl();
    }
    public void accionTeclado(By locator, Keys tecla){
        driver.findElement(locator).sendKeys(tecla);
    }
}
