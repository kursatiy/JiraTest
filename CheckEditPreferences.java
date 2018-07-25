import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class CheckEditPreferences {

    private static WebDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test (priority = 1)
    public void Login() {


        driver.get("http://jira.hillel.it:8080/login.jsp");
        WebElement loginTextBox = driver.findElement(By.id("login-form-username"));
        loginTextBox.click();
        loginTextBox.sendKeys("webinar5");
        WebElement passwordTextBox = driver.findElement(By.id("login-form-password"));
        passwordTextBox.click();
        passwordTextBox.sendKeys("webinar5");
        WebElement submitButton = driver.findElement(By.id("login-form-submit"));
        submitButton.click();
        assertEquals("System Dashboard - Hillel IT School JIRA", driver.getTitle());

        //LoginPageObject Login = new LoginPageObject();
        //Login.LoginToJira("webinar5", "webinar5");
        //assertEquals("System Dashboard - Hillel IT School JIRA", driver.getTitle());

    }
    @Test (priority = 2)
    public void checkEditPreferencesButton() {
        WebElement userDetailsButton = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("header-details-user-fullname")));
            userDetailsButton.click();

        WebElement viewProfile = driver.findElement(By.id("view_profile"));
        viewProfile.click();
            WebElement editPrefLink = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("edit_prefs_lnk")));
            editPrefLink.click();

            assertEquals("Update User Preferences" ,driver.findElement(By.xpath(".//*[@class='jira-dialog-heading']/*")).getText());

        }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }

}


