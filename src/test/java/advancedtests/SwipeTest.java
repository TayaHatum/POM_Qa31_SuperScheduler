package advancedtests;

import advanced.ADConfiguration;
import advancedscreens.DragScreen;
import org.testng.annotations.Test;

public class SwipeTest extends ADConfiguration {


    @Test
    public void swipeTestR_L(){
        new DragScreen(driver)
                .selectSwipe()
                .selectSwipeBasic()
                .swipeFromLeftToRight(2)
                .swipeFromRightToLeft(4);
    }
}
