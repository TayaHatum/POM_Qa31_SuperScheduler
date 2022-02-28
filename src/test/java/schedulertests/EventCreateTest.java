package schedulertests;

import models.Auth;
import models.Event;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import scheduler.SSConfiguration;
import schedulerscreens.HomeScreen;
import schedulerscreens.LoginScreen;

public class EventCreateTest extends SSConfiguration {

    @BeforeMethod
    public void preCondition(){
        new LoginScreen(driver)
                .complexLogin(Auth.builder().email("wick@gmail.com").password("Ww12345$").build());
    }


    @Test
    public void createNewEventTest(){
        boolean isEventCreated =  new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(Event.builder()
                        .title("Event")
                        .type("WWW")
                        .breaks(2)
                        .wage(80).build())
                .isFabButtonPresent();

        Assert.assertTrue(isEventCreated);


    }

    @Test
    public void createNewEventTestAssert(){
        Event event = Event.builder().title("Party").type("b_day").breaks(1).wage(50).build();
       /// logger.info( event.toString());

        new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(event)
                .isFabButtonPresentAssert()
                .openMenu()
                .logOut()
                .isLoginButtonAssert();



    }

}
