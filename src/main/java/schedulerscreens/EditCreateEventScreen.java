package schedulerscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Event;

public class EditCreateEventScreen extends BaseScreen {
    public EditCreateEventScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public HomeScreen createNewEvent(Event event){
        // fill form  + click AddButton ----> HomeScreen

        return  new HomeScreen(driver);
    }

}


