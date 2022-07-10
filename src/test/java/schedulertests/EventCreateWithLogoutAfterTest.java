package schedulertests;


import models.Auth;
import models.Event;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import scheduler.SSConfiguration;
import schedulerscreens.HomeScreen;
import schedulerscreens.LoginScreen;


public class EventCreateWithLogoutAfterTest extends SSConfiguration {

    @BeforeMethod
    public void preCondition(){
        new LoginScreen(driver)
                .complexLogin(Auth.builder().email("wick@gmail.com").password("Ww12345$").build());
    }



    @Test
    public void createNewEventTest(){

        boolean plusButtonPresent = new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(Event.builder().title("Title").type("Type").breaks(2).wage(50).build())
                .isPlusButtonPresent();
        Assert.assertTrue(plusButtonPresent);
    }
    @Test
    public void createNewEventTest2(){

        boolean plusButtonPresent = new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(Event.builder().title("Title").type("Type").breaks(2).wage(50).build())
                .isPlusButtonPresent();
        Assert.assertTrue(plusButtonPresent);
    }
@AfterMethod
    public void postCondition(){
        new HomeScreen(driver)
                .openMenu()
                .logOut()
                .loginButtonPresent();
    }

}
