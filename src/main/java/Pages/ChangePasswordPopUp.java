package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPopUp {
    public ChangePasswordPopUp(WebDriver driver){this.driver = driver;}
        WebDriver driver;
    String fulHeaderButtonId = "//header/nav/div/div[3]/ul/li[4]/a/span/span/img";
    String profileId = "//*[@id=\"view_profile\"]";
    String changePassId = "//*[@id=\"view_change_password\"]";
    String currentPassInPopUpId = "//form/div[1]/fieldset/div[2]/input";
    String newPassInPopUpId = "//*[@id=\"change-password-new-password\"]";
    String confirmPassInPopUpId = "//*[@id=\"change-password-confirm-password\"]";
    String updateButtonId = "//*[@id=\"change-password-submit\"]";
    String settingsUpdatedNotifyPopUpId = "//section/div/div[1]/div[1]/div[2]/div";

    public  void clickOnfulHeaderButtonId(){
        driver.findElement(By.xpath(fulHeaderButtonId)).click();
    }

    public void clickOnProfileButton(){
        driver.findElement(By.xpath(profileId)).click();
    }

    public void clickOnChangePassLink(){
        driver.findElement(By.xpath(changePassId)).click();
    }

    public  void enterCurrentPass(String currentPass){driver.findElement(By.xpath(currentPassInPopUpId)).sendKeys(currentPass);   }
    public  void enterNewPass(String newPass){driver.findElement(By.xpath(newPassInPopUpId)).sendKeys(newPass);   }
    public  void enterNewPassForConfirm(String passForConfirm){driver.findElement(By.xpath(confirmPassInPopUpId)).sendKeys(passForConfirm);   }
    public void clickOnupdateButton(){driver.findElement(By.xpath(updateButtonId)).sendKeys(Keys.ENTER);}
    public boolean popUp(){return  driver.findElement(By.xpath(settingsUpdatedNotifyPopUpId)).isDisplayed();}

}
