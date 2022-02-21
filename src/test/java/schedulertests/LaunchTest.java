package schedulertests;

import org.testng.Assert;
import org.testng.annotations.Test;
import scheduler.SSConfiguration;
import schedulerscreens.SplashScreen;

public class LaunchTest extends SSConfiguration {

    @Test
    public void launchTest(){

        String version = new SplashScreen(driver).getCurrencyVersion();
        Assert.assertEquals(version,"0.0.3");
    }
}
