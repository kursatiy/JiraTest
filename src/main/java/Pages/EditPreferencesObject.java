package Pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Selenide.$;

public class EditPreferencesObject {
    private static final Logger LOGGER = LogManager.getLogger(EditPreferencesObject.class.getName());
    String editPrefLink = "//*[@id='edit_prefs_lnk']";


    public void clickOnEditPreferencesButton() {
        //$(By.xpath(userDetailsButton)).waitUntil(Condition.visible, 3000).click();
        //$(By.xpath(viewProfile)).waitUntil(Condition.visible, 3000).click();

        LOGGER.info("Start finding editPrefLink element");
        $(By.xpath(editPrefLink)).waitUntil(Condition.appear, 3000).click();
    }


}



