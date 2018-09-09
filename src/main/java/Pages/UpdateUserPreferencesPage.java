package Pages;

import com.codeborne.selenide.Condition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class UpdateUserPreferencesPage {

    private static final Logger LOGGER = LogManager.getLogger(UpdateUserPreferencesPage.class.getName());
    private String intPageSizeValue;
    private String pageSizeXpath = "//*[@id = 'update-user-preferences-pagesize']";
    private String emailTypeXpath = "//*[@id = 'update-user-preferences-mailtype']";
    private String languageXpath = "//*[@id = 'update-user-preferences-locale']";
    private String timeZoneRegionXpath = "//*[@id = 'timeZoneRegion']";
    private String timeZoneDefaultXpath = "//*[@id = 'defaultUserTimeZone']";
    private String sharingXpath = "//*[@id = 'shareDefault']";
    private String keyboardShortcutsXpath = "//*[@id = 'update-user-preferences-keyboard-shortcuts']";
    private String autowatchXpath = "//*[@id = 'update-user-preferences-auto-watch-preference']";
    private String updateButtonXpath = "//*[@id = 'update-user-preferences-submit']";
    private String cancelButtonXpath = "//*[@id = 'update-user-preferences-cancel']";


        public void pageSize(String intPageSizeValue) {

            this.intPageSizeValue = intPageSizeValue;
            LOGGER.debug("Started finding elements");
            $(By.xpath(pageSizeXpath)).waitUntil(Condition.visible, 3000).click();
            $(By.xpath(pageSizeXpath)).clear();
            $(By.xpath(pageSizeXpath)).sendKeys(intPageSizeValue);
            $(By.xpath(updateButtonXpath)).click();
            LOGGER.debug("Finished finding elements");
        }
    }

