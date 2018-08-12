package Steps;

import Pages.EditPreferencesObject;
import Pages.ProfilePageObject;

public class EditPreferencesSteps {

    public void OpenEdirPreferences() {
        ProfilePageObject openUserProfile = new ProfilePageObject();
        openUserProfile.openProfileWindow();
        EditPreferencesObject checkEditPreferences = new EditPreferencesObject();
        checkEditPreferences.clickOnEditPreferencesButton();
    }
}
