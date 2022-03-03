package advancedscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DragScreen extends BaseScreenAD{
    public DragScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

 @FindBy (xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/button'][2]")
    MobileElement selectDraggable;

    @FindBy (xpath = "//*[@content-desc='Swipe']")
    MobileElement swipe;

    public SwipeScreen selectSwipe(){
        swipe.click();
        return new SwipeScreen(driver);
    }


    public DraggableBasicScreen selectDraggableBasic(){
        selectDraggable.click();
        return  new DraggableBasicScreen(driver);
    }

}
