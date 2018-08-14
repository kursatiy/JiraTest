package Test;

import Pages.EditPreferencesObject;
import Pages.ProfilePageObject;
import Steps.LoginSteps;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertEquals;

public class CheckEditPreferences {


    @BeforeTest
    public void setup() {
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";

        LoginSteps login = new LoginSteps();
        login.LoginToJira();

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
}





