package tests;

import Pages.EditPreferencesObject;
import Pages.LoginPageObject;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class CheckEditPreferences {


    @BeforeClass
    public void setup() {
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
    }

    @Test(priority = 1)
    public void Login() {
        String pageTitle = "/html/head/title";
        //String pageTitle = "//*[@title = 'System Dashboard - Hillel IT School JIRA']";
        open("http://jira.hillel.it:8080/login.jsp");
        LoginPageObject loginPage = new LoginPageObject();
        loginPage.LoginToJira("webinar5", "webinar5");
        assertEquals($(By.xpath(pageTitle)).innerText(), "System Dashboard - Hillel IT School JIRA");

    }

    @Test(priority = 2)
    public void checkEditPreferences() {

        EditPreferencesObject checkEditPreferences = new EditPreferencesObject();
        checkEditPreferences.checkEditPreferencesButton();
        assertEquals($(By.xpath("//*[@class='jira-dialog-heading']/*")).getText(), "Update User Preferences");

    }
}





