package Test;

import Pages.ChangePasswordPopUp;
import Pages.LoginToJiraPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JiraChangePassword {
@Test
    public void JiraChangePassword() {
    System.setProperty("webdriver.chrome.driver", "C:\\server\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    LoginToJiraPage loginPage = new LoginToJiraPage(driver);
    ChangePasswordPopUp changePassword = new ChangePasswordPopUp(driver);

    driver.get("http://jira.hillel.it:8080/login.jsp");
    loginPage.enterUserName("webinar5");
    loginPage.enterPassword("webinar5");
    loginPage.clickSendButton();

    if(!loginPage.onPage()){
        Assert.fail("Not on page!!!");
    }


    changePassword.clickOnfulHeaderButtonId();
    changePassword.clickOnProfileButton();
    changePassword.clickOnChangePassLink();
    changePassword.enterCurrentPass("webinar5");
    changePassword.enterNewPass("webinar5");
    changePassword.enterNewPassForConfirm("webinar5");
    changePassword.clickOnupdateButton();
    }
}