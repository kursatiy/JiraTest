package Test;

import Pages.LoginPageObject;
import Properties.ConfigProperties;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.AssertJUnit.assertEquals;

public class CheckLogin {

    String login;
    String password;
    String jiraUrl;

    @BeforeTest
    public void Setup() {
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
        ConfigProperties config = new ConfigProperties();
        jiraUrl = config.DataFromPropertiesFile("jiraUrl");
        login = config.DataFromPropertiesFile("login");
        password = config.DataFromPropertiesFile("password");
    }

    @Test(priority = 1)
    public void LoginCheck() {

        String pageTitle = "/html/head/title";
        open(jiraUrl);
        LoginPageObject loginPage = new LoginPageObject();
        loginPage.LoginToJira(login, password);
        assertEquals($(By.xpath(pageTitle)).innerText(), "System Dashboard - Hillel IT School JIRA");
    }

}