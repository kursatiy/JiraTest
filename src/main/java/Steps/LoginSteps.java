package Steps;

import Pages.LoginPageObject;
import Properties.ConfigProperties;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;

public class LoginSteps {

    String login;
    String password;

    public void loginToJira() {
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
        ConfigProperties config = new ConfigProperties();
        login = config.DataFromPropertiesFile("login");
        password = config.DataFromPropertiesFile("password");
        open("http://jira.hillel.it:8080/login.jsp");
        LoginPageObject loginPage = new LoginPageObject();
        loginPage.LoginToJira(login, password);


    }

}
