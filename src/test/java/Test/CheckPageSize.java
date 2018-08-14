package Test;

import Pages.EditPreferencesObject;
import Pages.ProfilePageObject;
import Pages.UpdateUserPreferencesPage;
import Steps.LoginSteps;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

public class CheckPageSize {

    @BeforeTest
    public void Setup() {
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";

        LoginSteps login = new LoginSteps();
        login.LoginToJira();

        ProfilePageObject openUserProfile = new ProfilePageObject();
        openUserProfile.openProfileWindow();
    }

    @Test(priority = 1)
    public void PageSizeCheck() throws InterruptedException {

        String successMessage = "//*[@id='userprofile-notify']/text()[normalize-space()]";

        EditPreferencesObject checkEditPreferences = new EditPreferencesObject();
        checkEditPreferences.clickOnEditPreferencesButton();

        UpdateUserPreferencesPage updateUserPreferencesPage = new UpdateUserPreferencesPage();
        updateUserPreferencesPage.pageSize("100");

        String pageSizeViewMode = "//*[@id = 'up-p-pagesize']";
        Thread.sleep(1000);
        assertEquals($(By.xpath(pageSizeViewMode)).waitUntil(Condition.visible, 3000).getText(), "100");
    }

    @AfterTest
    public void returnPageSizeValue() {
        EditPreferencesObject editPreferences = new EditPreferencesObject();
        editPreferences.clickOnEditPreferencesButton();
        UpdateUserPreferencesPage updateUserPreferencesPage = new UpdateUserPreferencesPage();
        updateUserPreferencesPage.pageSize("50");
    }

}
