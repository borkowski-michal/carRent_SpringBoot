package selenium.tests.model;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.tests.config.WebDrivenTests;

public class FillForms {

    WebDriver driver = WebDrivenTests.getDriver();
    private final Faker faker = new Faker();

    public void fillInWrongLoginForm(){
        WebElement login = driver.findElement(By.id("email"));
        login.sendKeys(faker.name().firstName());
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys(faker.name().firstName());
    }

    public void fillInCorrectLoginForm(String login, String password) throws InterruptedException {
        WebElement log = driver.findElement(By.id("email"));
        log.sendKeys(login);
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("div.container:nth-child(2) > button:nth-child(5)")).click();

    }

    public void fillInRegistrationForm(){
        //TODO
    }

    public void checkValidEmailInRegistrationForm(){
        //TODO
    }

    public void checkValidPasswordInRegistrationForm(){
        //TODO
    }

    public void checkValidPhoneInRegistrationForm(){
        //TODO
    }

    public void checkValidFirstNameInRegistrationForm(){
        //TODO
    }

    public void checkValidLastNameInRegistrationForm(){
        //TODO
    }

}
