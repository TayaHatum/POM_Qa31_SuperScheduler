package schedulertests;

import models.Auth;
import models.Event;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import scheduler.SSConfiguration;
import schedulerscreens.HomeScreen;
import schedulerscreens.LoginScreen;


public class EventDataActionTest extends SSConfiguration {

    @BeforeMethod
    public void preCondition(){
        new LoginScreen(driver)
                .complexLogin(Auth.builder().email("wick@gmail.com").password("Ww12345$").build());
    }

    @Test
    public void addEventCheckDataFuture(){
        new HomeScreen(driver)
                .initCreationEvent()
                .checkData("28/05/2022")
                .createNewEvent(Event.builder().title("Bday").type("Party").breaks(2).wage(50).build())
                .isPlusButtonPresent();
    }

    @Test
    public void addEventActions(){
        new HomeScreen(driver)
                .initCreationEvent()
                .actionsWithData() /// without data check
                .createNewEvent(Event.builder().title("Title").type("Type").breaks(2).wage(50).build())
                .isPlusButtonPresent();
    }
}
