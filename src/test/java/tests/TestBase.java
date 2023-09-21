package tests;

import utils.ConfigurationReader;
import utils.Driver;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    @BeforeMethod
    public void setUp() {
        try {
            driver = Driver.getDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            actions = new Actions(driver);
            wait = new WebDriverWait(driver, 15);
            driver.get(ConfigurationReader.get("url"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

