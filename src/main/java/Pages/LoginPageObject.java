package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPageObject {
    WebDriver driver;

    String userNameXpath = "//*[@id='login-form-username']";
    String userPassXpath = "//*[@id='login-form-password']";
    String loginButtonXpath = "//*[@id='login-form-submit']";

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void LoginToJira(String login, String password) {
        driver.findElement(By.xpath(userNameXpath)).sendKeys(login);
        driver.findElement(By.xpath(userPassXpath)).sendKeys(password);
        driver.findElement(By.xpath(loginButtonXpath)).sendKeys(Keys.ENTER);

    }
}
