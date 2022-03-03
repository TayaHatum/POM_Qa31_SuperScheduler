package advancedscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SwipeableBasicScreen extends BaseScreenAD{
    public SwipeableBasicScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/container']")
    List<MobileElement> list;



    public SwipeableBasicScreen swipeFromRightToLeft(int index){

        MobileElement element = list.get(index);
        Rectangle rect = element.getRect();
        int xFrom = rect.getX()+ (rect.getWidth()*9)/10;
        int xTo= rect.getX() + ((rect.getWidth()*1)/10);
        int y = rect.getY()+ rect.getHeight()/2;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom,y))
                .moveTo(PointOption.point(xTo,y))
                .release()
                .perform();


        return this;
    }

    public SwipeableBasicScreen swipeFromLeftToRight(int index){

        MobileElement element = list.get(index);
        Rectangle rect = element.getRect();

        int xFrom = rect.getX() + ((rect.getWidth()*1)/10);
        //int xFrom = rect.getX() + 20;
        int y = rect.getY() +rect.getHeight()/2;
        int xTo = rect.getX()+ (rect.getWidth()*9)/10;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom,y))
                .moveTo(PointOption.point(xTo,y))
                .release()
                .perform();



        return this;
    }
}
