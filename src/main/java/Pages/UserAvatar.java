package Pages;

import Steps.LoginSteps;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class UserAvatar extends LoginSteps {

    private String userAvatar = "//*[@id=\"details-user-avatar-trigger\"]";

    public void clickOnUserAvatar() {

        $(By.xpath(userAvatar)).waitUntil(Condition.visible, 3000).click();
    }

}
