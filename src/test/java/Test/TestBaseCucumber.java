package Test;

import Base.PropertiesDriven;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.nio.file.Paths;
import java.util.ArrayList;

public class TestBaseCucumber {
    private WebDriver driver;
    private HomePage homePage;
    private String browser;
    private String propertyDriver;
    private String rutaDriver;
    private MiServipagPage miServipag;
    private PerfilPage miperfil;

    @BeforeTest
    public void preparacion(){
        browser = PropertiesDriven.getProperty("browser");
        propertyDriver = PropertiesDriven.getProperty("propertyDriver");
        rutaDriver = Paths.get(System.getProperty("user.dir"),PropertiesDriven.getProperty("rutaDriver")).toString();
    }

    @BeforeMethod
    public void precondicionesTests() {
        homePage = new HomePage(driver);
        homePage.conexionDriver(browser,rutaDriver,propertyDriver);
        miServipag = new MiServipagPage(homePage.getDriver());
        miperfil = new PerfilPage(miServipag.getDriver());

        String url = PropertiesDriven.getProperty("url");
        homePage.cargarSitio(url);
        homePage.maximizarBrowser();
    }
    @AfterMethod
    public void posTests(){
        homePage.cerrarBrowser();
    }
}
