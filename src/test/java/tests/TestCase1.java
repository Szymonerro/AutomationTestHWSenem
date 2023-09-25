package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.Driver;


public class TestCase1 extends TestBase{

    HomePage homePage = new HomePage();

    @Test
    @Description("Test case 1")
    @BeforeMethod
    public void test(){
        Assert.assertTrue(homePage.isHomePageVisible(), "Home page is not visible");
        homePage.signupLoginButton.click();
        Assert.assertTrue(driver.findElement(By.className("signup-form")).isDisplayed(), "New User Signup! is not visible");
    }
}
