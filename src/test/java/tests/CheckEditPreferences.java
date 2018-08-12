package tests;

import Pages.EditPreferencesObject;
import Pages.LoginPageObject;
import Pages.ProfilePageObject;
import Pages.UpdateUserPreferencesPage;
import Properties.ConfigProperties;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;

public class CheckEditPreferences {
    String login;
    String password;
    String jiraUrl;


    @BeforeClass
    public void setup() {
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
        ConfigProperties config = new ConfigProperties();
        jiraUrl = config.LoginAndPasswordFromConfigFile("jiraUrl");
        login = config.LoginAndPasswordFromConfigFile("login");
        password = config.LoginAndPasswordFromConfigFile("password");

    }

    @Test(priority = 1)
    public void Login() {
        String pageTitle = "/html/head/title";
        open(jiraUrl);
        LoginPageObject loginPage = new LoginPageObject();
        loginPage.LoginToJira(login, password);
        assertEquals($(By.xpath(pageTitle)).innerText(), "System Dashboard - Hillel IT School JIRA");
    }

    @Test(priority = 2)
    public void OpenProfileWindow(){
        ProfilePageObject openUserProfile = new ProfilePageObject();
        openUserProfile.openProfileWindow();
    }
    @Test(priority = 3)
    public void checkEditPreferences() {
        String updateUserPreferences = "//*[@class='jira-dialog-heading']/*";
        EditPreferencesObject checkEditPreferences = new EditPreferencesObject();
        checkEditPreferences.clickOnEditPreferencesButton();
        assertEquals($(By.xpath(updateUserPreferences)).getText(), "Update User Preferences");
    }
    @Test(priority = 4)
    public void checkPageSize() throws InterruptedException {

        String successMessage = "//*[@id='userprofile-notify']/text()[normalize-space()]";
        UpdateUserPreferencesPage updateUserPreferencesPage = new UpdateUserPreferencesPage();
        updateUserPreferencesPage.pageSize("100");
        String pageSizeViewMode = "//*[@id = 'up-p-pagesize']";
        Thread.sleep(1000);
        assertEquals($(By.xpath(pageSizeViewMode)).waitUntil(Condition.visible, 3000).getText(), "100");
        //assertEquals($(By.xpath(successMessage)).getValue(), "blabla");
    }


    @AfterTest
    public void returnPageSizeValue(){
        EditPreferencesObject editPreferences = new EditPreferencesObject();
        editPreferences.clickOnEditPreferencesButton();
        UpdateUserPreferencesPage updateUserPreferencesPage = new UpdateUserPreferencesPage();
        updateUserPreferencesPage.pageSize("50");
    }

}





