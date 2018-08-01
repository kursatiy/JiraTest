import Pages.EditPreferencesObject;
import Pages.LoginPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class CheckEditPreferences {

    public WebDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                DesiredCapabilities.chrome());

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void Login() {

        driver.get("http://jira.hillel.it:8080/login.jsp");
        LoginPageObject loginPage = new LoginPageObject(driver);
        loginPage.LoginToJira("webinar5", "webinar5");
        assertEquals("System Dashboard - Hillel IT School JIRA", driver.getTitle());

    }

    @Test(priority = 2)
    public void checkEditPreferences() {

        EditPreferencesObject checkEditPreferences = new EditPreferencesObject(driver);
        checkEditPreferences.checkEditPreferencesButton();
        assertEquals("Update User Preferences", driver.findElement(By.xpath(".//*[@class='jira-dialog-heading']/*")).getText());

    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}





