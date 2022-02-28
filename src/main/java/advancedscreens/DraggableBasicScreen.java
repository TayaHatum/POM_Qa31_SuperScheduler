package advancedscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DraggableBasicScreen extends BaseScreenAD {
    public DraggableBasicScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@resource-id ='com.h6ah4i.android.example.advrecyclerview:id/drag_handle']")
    List<MobileElement> list;

    public DraggableBasicScreen dragDown(int index){

        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        System.out.println("Width window --> "+ width);
        int height = dimension.getHeight();
        System.out.println("Height window --> "+ height);


        System.out.println(list.size());
        MobileElement element = list.get(index);
        Dimension elementSize = element.getSize();
        System.out.println(" Height of element : " + elementSize.getHeight() + "Width of element : " +elementSize.getWidth());

        Rectangle rect = element.getRect();
        int xFrom = rect.getX()+ rect.getWidth()/2;
        int yFrom = rect.getY()+rect.getHeight()/2;

        int xTo = xFrom;
        int yTo= yFrom + rect.getHeight();


        TouchAction <?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom,yFrom))
                .moveTo(PointOption.point(xTo,yTo))
                .release()
                .perform();

        return this;
    }

    public DraggableBasicScreen dragUp(int index){
        System.out.println(list.size());
        MobileElement element = list.get(index);

        TouchAction <?> touchAction = new TouchAction<>(driver);

        touchAction.longPress(PointOption.point(90,20))
                .moveTo(PointOption.point(30,50))
                .release()
                .perform();

        return this;
    }

}
