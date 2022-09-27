package Test;

import Base.DataDriven;
import Base.PropertiesDriven;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.ArrayList;

public class TestBase {
    private WebDriver driver;
    private String url;
    private HomePage homePage;
    private MiServipagPage miServipagPage;
    private PerfilPage perfilPage;
    private InscribirCuentaPage inscribirCuentaPage;
    private PagoRapidoPage pagoRapidoPage;
    private CartolaPage cartolaPage;
    private PresupuestoPage presupuestoPage;
    private ArrayList<String> dataCP_01;
    private ArrayList<String> dataCP_02;
    private ArrayList<String> dataCP_03;
    private ArrayList<String> dataCP_04;
    private ArrayList<String> dataCP_05;
    private ArrayList<String> dataCP_06;
    private ArrayList<String> dataCP_07;
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
        miServipagPage = new MiServipagPage(homePage.getDriver());
        perfilPage = new PerfilPage(miServipagPage.getDriver());
        inscribirCuentaPage = new InscribirCuentaPage(miServipagPage.getDriver());
        cartolaPage = new CartolaPage(miServipagPage.getDriver());
        pagoRapidoPage = new PagoRapidoPage(homePage.getDriver());
        presupuestoPage = new PresupuestoPage(miServipagPage.getDriver());

        url = PropertiesDriven.getProperty("url");
        homePage.cargarSitio(url);
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
        inscribirCuentaPage.agregarCuenta(dataCP_02.get(1),dataCP_02.get(2));
        Assert.assertEquals(inscribirCuentaPage.getTitulo(),"Excelente!");
        Assert.assertEquals(inscribirCuentaPage.getTitulo2(),"Sigue agregando tus cuentas");
        inscribirCuentaPage.btnAceptar();
    }
    @Test
    public void ATC03_eliminarCuenta(){
        dataCP_01 = DataDriven.getData("ATC01_IniciarSesion");
        dataCP_03 = DataDriven.getData("ATC03_EliminarCuenta");

        homePage.iniciarSesion(dataCP_01.get(1),dataCP_01.get(2));
        miServipagPage.eliminarCuenta(dataCP_03.get(2));
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
    @Test
    public void ATC_05_descargarCartola6meses(){
        dataCP_05 = DataDriven.getData("ATC05_descargarCartola6meses");

        homePage.iniciarSesion(dataCP_05.get(1),dataCP_05.get(2));
        miServipagPage.irACartola();
        cartolaPage.descargarCartolaExcel();
        cartolaPage.esperarXSegundos(5000);
    }
    @Test
    public void ATC_06_descargarCartolaLuz(){
        dataCP_06 = DataDriven.getData("ATC06_descargarCartolaLuz");

        homePage.iniciarSesion(dataCP_06.get(1),dataCP_06.get(2));
        miServipagPage.irACartola();
        cartolaPage.seleccionarServicio(dataCP_06.get(3));
        cartolaPage.seleccionarEmpresa(dataCP_06.get(4));
        cartolaPage.buscar();
        cartolaPage.descargarCartolaExcel();
        cartolaPage.esperarXSegundos(5000);
    }
    @Test
    public void ATC_07_ValidaCreacionDePresupuesto(){
        dataCP_07 = DataDriven.getData("ATC07_ValidaCreacionDePresupuesto");

        homePage.iniciarSesion(dataCP_07.get(1),dataCP_07.get(2));
        miServipagPage.irAPresupuesto();
        presupuestoPage.crearPresupuesto();

    }
}
