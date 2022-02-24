package schedulertests;

import models.Auth;
import org.testng.Assert;
import org.testng.annotations.Test;
import scheduler.SSConfiguration;
import schedulerscreens.HomeScreen;
import schedulerscreens.LoginScreen;
import schedulerscreens.SplashScreen;

public class LoginTest extends SSConfiguration {

    @Test
    public void loginSuccessTest(){
//        boolean isLoginBottonPresent = new SplashScreen(driver)
//                .checkVersion("0.0.3")

        boolean isFabBottonPresent = new LoginScreen(driver)
                .fillEmail("wick@gmail.com")
                .fillPassword("Ww12345$")
                .clickLoginBtn()
                .skipWizard()
                .isFabButtonPresent();

        Assert.assertTrue(isFabBottonPresent);

             boolean isLoginButtonPresent=  new HomeScreen(driver)
                .openMenu()
                .logOut()
                .isLoginButton();
        Assert.assertTrue(isLoginButtonPresent);

    }

    @Test
    public void registrationSuccessTest(){

        int index = (int)(System.currentTimeMillis()/1000)%3600;

//        boolean isLogBTNPresent = new SplashScreen(driver)
//                .checkVersion("0.0.3")





        boolean isLoginBottonPresent = new LoginScreen(driver)
                .complexLogin(Auth.builder().email("wick"+index+"@gmail.com").password("Ww12345$").build())
                .skipWizard()
                        .openMenu()
                                .logOut()
                                        .isLoginButton();

        Assert.assertTrue(isLoginBottonPresent);


    }

    @Test
    public void loginSuccessTestComplex(){
//        boolean isLogBTNPresent = new SplashScreen(driver)
//                .checkVersion("0.0.3")

        boolean isLoginBottonPresent = new LoginScreen(driver)
                .complexLogin(Auth.builder().email("wick@gmail.com").password("Ww12345$").build())
                .skipWizard()
                .openMenu()
                .logOut()
                .isLoginButton();

        Assert.assertTrue(isLoginBottonPresent);

    }


    /// wick@gmail.com Ww54321$
}
