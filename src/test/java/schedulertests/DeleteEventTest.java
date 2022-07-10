package schedulertests;


import models.Auth;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import scheduler.SSConfiguration;
import schedulerscreens.HomeScreen;
import schedulerscreens.LoginScreen;


public class DeleteEventTest extends SSConfiguration {

    @BeforeClass
    public void preCondition(){
        new LoginScreen(driver)
                .complexLogin(Auth.builder().email("wick@gmail.com").password("Ww12345$").build())
                .skipWizard();
    }

    @Test
    public void deleteEvent(){
        boolean isPlusBtnPresent = new HomeScreen(driver)
                .selectFirstEvent()
                .deleteEvent()
                .isPlusButtonPresent();
        Assert.assertTrue(isPlusBtnPresent);
    }

}
