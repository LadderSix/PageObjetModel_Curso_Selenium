package Test;

import Pages.HomePage;
import Pages.MiServipagPage;
import Pages.PerfilPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuiteServipag extends TestBase{
    private HomePage homePage;
    private MiServipagPage miServipagPage;
    private PerfilPage perfilPage;

    @Test
    public void ATC01_IniciarSesion(){
        homePage.iniciarSesion();
        miServipagPage.irAlPerfil();
        Assert.assertEquals(perfilPage.getTextTituloPerfil(),"Hola Matias");
    }

}
