package Steps;

import Pages.ProfilePageObject;

public class ProfileSteps {

    public void OpenUserProfile(){

        ProfilePageObject profile = new ProfilePageObject();
        profile.openProfileWindow();

    }
}
