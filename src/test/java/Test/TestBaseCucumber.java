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
    private MiServipagPage miServipagPage;
    private PerfilPage perfilPage;
    private InscribirCuentaPage inscribirCuentaPage;
    private PagoRapidoPage pagoRapidoPage;
    private CartolaPage cartolaPage;
    private PresupuestoPage presupuestoPage;
    private String browser;
    private String propertyDriver;
    private String rutaDriver;

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

        String url = PropertiesDriven.getProperty("url");
        homePage.cargarSitio(url);
        homePage.maximizarBrowser();
    }
    @AfterMethod
    public void posTests(){
        homePage.cerrarBrowser();
    }
}
