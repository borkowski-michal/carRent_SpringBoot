package selenium.tests.config;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.tests.model.FillForms;

import java.util.concurrent.TimeUnit;


public class WebDrivenTests {
    public static WebDriver driver;

    FillForms fillForms = new FillForms();



    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public static void setUp() {
        String baseUrl = "http://localhost:8080/carRent/login";
        System.setProperty("webdriver.chrome.driver","C:\\JavaStart\\Moje\\carRent_SpringBoot\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().setSize(new Dimension(1295,730));
        driver.navigate().to(baseUrl);
        driver.manage().deleteAllCookies();
        driver.get(baseUrl);

    }

    @Before
    public void tearBefore(){
        String baseUrl = "http://localhost:8080/carRent/login";
        driver.navigate().to(baseUrl);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void checkUrl() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("http://localhost:8080/carRent/login",
                currentUrl);
    }

    @Test
    public void findEmailString() {
        WebElement mainPage = driver.findElement(By.cssSelector("div.container:nth-child(2) > label:nth-child(1) > b:nth-child(1)"));
        String element = mainPage.getText();
        Assert.assertEquals("Email",element);
    }

    @Test
    public void tryToLoginWithInvalidCredentials() {
        fillForms.fillInWrongLoginForm();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("http://localhost:8080/carRent/login",
                currentUrl);
    }

    @Test
    public void tryToLoginWithValidCredentials() throws InterruptedException {
        fillForms.fillInCorrectLoginForm("bor@op.pl","borkowski1");
        Thread.sleep(1000);
        WebElement description = driver.findElement(By.tagName("h1"));
        String str = description.getText();
        Assert.assertEquals("Strona do wynajmu w budowie!", str);
    }

}
