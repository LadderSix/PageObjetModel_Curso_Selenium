package Test;

import Base.DataDriven;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.ArrayList;

public class TestBase {
    private WebDriver driver;
    private WebDriverWait wait;
    private String url;
    private HomePage homePage;
    private MiServipagPage miServipagPage;
    private PerfilPage perfilPage;
    private InscribirCuentaPage inscribirCuentaPage;
    private PagoRapidoPage pagoRapidoPage;
    private ArrayList<String> dataCP_01;
    private ArrayList<String> dataCP_02;
    private ArrayList<String> dataCP_03;
    private ArrayList<String> dataCP_04;


    @BeforeTest
    public void preparacion(){
        String browser = "chrome";
        String propertyDriver = "webdriver.chrome.driver";
        String path = Paths.get(System.getProperty("user.dir"),"//src//main//resources//drivers//chromedriver.exe").toString();

        homePage = new HomePage(driver);
        homePage.conexionDriver(browser,path,propertyDriver);
        miServipagPage = new MiServipagPage(homePage.getDriver());
        perfilPage = new PerfilPage(miServipagPage.getDriver());
        inscribirCuentaPage = new InscribirCuentaPage(miServipagPage.getDriver());
        pagoRapidoPage = new PagoRapidoPage(homePage.getDriver());

        dataCP_01 = new ArrayList<>();
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
        dataCP_01 = DataDriven.getData("ATC01_IniciarSesion");
        homePage.iniciarSesion(dataCP_01.get(1),dataCP_01.get(2));
        miServipagPage.esperarXSegundos(3000);
        miServipagPage.irAlPerfil();
        perfilPage.esperarXSegundos(2000);
        Assert.assertEquals(perfilPage.getTextTituloPerfil(),"Hola Matias");
        perfilPage.esperarXSegundos(2000);
        perfilPage.cerrarSesion();
    }
    @Test
    public void ATC02_registrarCuenta(){
        dataCP_01 = DataDriven.getData("ATC01_IniciarSesion");
        dataCP_02 = DataDriven.getData("ATC02_AgregarCuenta");

        homePage.iniciarSesion(dataCP_01.get(1),dataCP_01.get(2));
        miServipagPage.inscribirCuenta();
        inscribirCuentaPage.agregarCuenta(dataCP_02.get(2),dataCP_02.get(1));
        Assert.assertEquals(inscribirCuentaPage.getTitulo(),"Excelente!");
        Assert.assertEquals(inscribirCuentaPage.getTitulo2(),"Sigue agregando tus cuentas");
        inscribirCuentaPage.btnAceptar();
    }
    @Test
    public void ATC03_eliminarCuenta(){
        dataCP_01 = DataDriven.getData("ATC01_IniciarSesion");
        dataCP_03 = DataDriven.getData("ATC03_EliminarCuenta");

        homePage.iniciarSesion(dataCP_01.get(1),dataCP_01.get(2));
        miServipagPage.eliminarCuenta(dataCP_03.get(3));
        Assert.assertEquals(miServipagPage.getTituloEliminacion(),"Su cuenta ha sido eliminada");
        perfilPage.esperarXSegundos(3000);
        miServipagPage.btnEntendido();
    }
    @Test
    public void ATC_04_pagoRapido(){
        pagoRapidoPage.btnPagoRapido();
        pagoRapidoPage.esperarXSegundos(1500);
        pagoRapidoPage.buscarServicio("Internet");
        pagoRapidoPage.seleccionarEmpresa("Movistar Hogar/Negocio Internet");

    }
}
