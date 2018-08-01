package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditPreferencesObject {
    String userDetailsButton = "//*[@id='header-details-user-fullname']";
    String viewProfile = "//*[@id='view_profile']";
    String editPrefLink = "//*[@id='edit_prefs_lnk']";

    WebDriver driver;

    public EditPreferencesObject(WebDriver driver) {
        this.driver = driver;
    }


    public void checkEditPreferencesButton() {
        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(userDetailsButton))).click();

        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(viewProfile))).click();

        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(editPrefLink))).click();

    }


}



