package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Driver;

public class HomePage extends BasePage {

    @FindBy(xpath= "//*[@href=\"/login\"]")
    public WebElement signupLoginButton;


    public boolean isHomePageVisible() {
        WebDriver driver = Driver.getDriver();
        String pageTitle = driver.getTitle();
        boolean isHomePageVisible = pageTitle.contains("Automation Exercise");
        if (!isHomePageVisible) {
            System.out.println("Home page is not visible.");
        }
        return isHomePageVisible;
    }
}
