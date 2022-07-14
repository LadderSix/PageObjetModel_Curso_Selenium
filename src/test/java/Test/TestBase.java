package Test;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class TestBase {
    private WebDriver driver;
    private WebDriverWait wait;
    private String url;
    private HomePage homePage;
    private MiServipagPage miServipagPage;
    private PerfilPage perfilPage;


    @BeforeTest
    public void preparacion(){
        String browser = "chrome";
        String propertyDriver = "webdriver.chrome.driver";
        String path = Paths.get(System.getProperty("user.dir"),"//src//main//resources//drivers//chromedriver.exe").toString();

        homePage = new HomePage(driver);
        homePage.conexionDriver(browser,path,propertyDriver);
        miServipagPage = new MiServipagPage(homePage.getDriver());
        perfilPage = new PerfilPage(miServipagPage.getDriver());
    }
    @BeforeMethod
    public void precondicionesTests() throws InterruptedException {
        url = "https://www.servipag.com";
        homePage.cargarSitio(url);
        Thread.sleep(2000);
        homePage.maximizarBrowser();
    }
    @AfterMethod
    public void posTests(){
        homePage.cerrarBrowser();
    }

    @Test
    public void ATC01_iniciarSesion(){
        homePage.iniciarSesion();
        miServipagPage.esperarXSegundos(3000);
        miServipagPage.irAlPerfil();
        perfilPage.esperarXSegundos(2000);
        Assert.assertEquals(perfilPage.getTextTituloPerfil(),"Hola Matias");
    }
    @Test
    public  void ATC02_registrarCuenta(){
        homePage.iniciarSesion();
        miServipagPage.inscribirCuenta();
    }
}
