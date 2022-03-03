package advancedtests;

import advanced.ADConfiguration;
import advancedscreens.DragScreen;
import org.testng.annotations.Test;

public class DragTest extends ADConfiguration {

    @Test
    public void dragDownTest(){
        new DragScreen(driver)
                .selectDraggableBasic()
                .dragDownWindow(2);
               // .dragDown(3);
    }
    @Test
    public void dragUpTest(){
        new DragScreen(driver)
                .selectDraggableBasic()
                .dragUp(6,3);
                //.dragUp(4);
    }
}
