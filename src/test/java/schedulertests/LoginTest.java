package schedulertests;

import org.testng.annotations.Test;
import scheduler.SSConfiguration;
import schedulerscreens.SplashScreen;

public class LoginTest extends SSConfiguration {

    @Test
    public void loginSuccessTest(){
        new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillEmail("wick@gmail.com")
                .fillPassword("Ww12345$")
                .clickLoginBtn();

    }

    @Test
    public void loginSuccessTestComplex(){
        new SplashScreen(driver)
                .checkVersion("0.0.3")
                .complexLogin(Auth.builder().build());

    }
}
