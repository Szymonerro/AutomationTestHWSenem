package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Driver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GoDaddy_Tests {

    public WebDriver driver;
    public final String GO_DADDY_URL = "https://godaddy.com/";

    @BeforeMethod
    public void setUp() {
        try {
            driver = Driver.getDriver();
            driver.manage().window().maximize();
            driver.get(GO_DADDY_URL);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

    @Test
    public void verifyCorrectSite(){
        assertTrue(driver.getCurrentUrl().contains(GO_DADDY_URL.split("//")[1]),"Wrong URL!");
    }

    @Test
    public void printTitleAndURL(){
        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());
    }

    @Test
    public void validatePageTitle(){
        String title = driver.getTitle();
        String URL = driver.getCurrentUrl();
        assertEquals("Nazwy domen, witryny, hosting i narzędzia do marketingu internetowego – GoDaddy PL", title);
        verifyCorrectSite();
        String source = driver.getPageSource();
        assertTrue(source.contains(title), "Page source doesn't contain title!");
    }

    @Test
    public void automateLink(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@aria-label='Open Menu']")).click();
        driver.findElement(By.xpath("(//ul/li/button)[1]")).click();
        driver.findElement(By.xpath("//a[@data-track-name='domains_search_for_domain_names2']")).click();
        String expected = "Wyszukiwarka domen GoDaddy – kup i zarejestruj dostępne nazwy domen";
        assertTrue(new WebDriverWait(driver,6).until(ExpectedConditions.titleIs(expected)));
    }

    @Test
    public void automateAllMenuLinks(){
        int menuItemsNr = driver.findElements(By.xpath("ble")).size();
        List<String> titles = Arrays.asList(
                "Wyszukiwarka domen GoDaddy – kup i zarejestruj dostępne nazwy domen",
                "");
    }

}
