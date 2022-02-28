package advancedtests;

import advanced.ADConfiguration;
import advancedscreens.DragScreen;
import org.testng.annotations.Test;

public class DragTest extends ADConfiguration {

    @Test
    public void dragDownTest(){
        new DragScreen(driver)
                .selectDraggableBasic()
                .dragDown(3);
    }
}
