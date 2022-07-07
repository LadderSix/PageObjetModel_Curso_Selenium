package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    private WebDriver driver;
    private WebDriverWait wait;
    private String url;

    @BeforeClass
    public void preparacionClase(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\matias.rojas\\Documents\\chromedriver.exe");
    }

    @BeforeMethod
    public void precondicionesTests() throws InterruptedException {
        driver = new ChromeDriver();
        url = "https://www.servipag.com";
        driver.get(url);
        Thread.sleep(2000);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,30);
    }
    @AfterMethod
    public void posTests(){
        driver.close();
    }
}
