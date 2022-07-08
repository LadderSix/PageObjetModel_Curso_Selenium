package Test;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.nio.file.Paths;

public class TestBase {
    private WebDriver driver;
    private WebDriverWait wait;
    private String url;
    private HomePage homePage;
    private InscribirCuentaPage inscribirCuentaPage;
    private MiServipagPage miServipagPage;
    private PagoRapidoPage pagoRapidoPage;
    private PerfilPage perfilPage;

    /*@BeforeTest
    public void preparacion(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\matias.rojas\\Documents\\chromedriver.exe");
    }*/
    @BeforeTest
    public void preparacion(){
        homePage = new HomePage(driver);
        String browser = "chrome";
        String propertyDriver = "webdriver.chrome.driver";
        String path = Paths.get(System.getProperty("user.dir"),"//src//main//resources//drivers//chromedriver.exe").toString();

        homePage.conexionDriver(browser,path,propertyDriver);
        miServipagPage = new MiServipagPage(homePage.getDriver());
        inscribirCuentaPage = new InscribirCuentaPage(miServipagPage.getDriver());
        perfilPage = new PerfilPage(miServipagPage.getDriver());
        pagoRapidoPage = new PagoRapidoPage(homePage.getDriver());

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
        driver.close();
    }
}
