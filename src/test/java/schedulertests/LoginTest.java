package schedulertests;

import models.Auth;
import org.testng.Assert;
import org.testng.annotations.Test;
import scheduler.SSConfiguration;
import schedulerscreens.HomeScreen;
import schedulerscreens.LoginScreen;

public class LoginTest extends SSConfiguration {

    @Test
    public void loginSuccessTest() {
//        boolean isLoginBottonPresent = new SplashScreen(driver)
//                .checkVersion("0.0.3")
        logger.info("Login with data wick@gmail.com + Ww12345$");

        boolean isFabBottonPresent = new LoginScreen(driver)
                .fillEmail("wick@gmail.com")
                .fillPassword("Ww12345$")
                .clickLoginBtn()
                .skipWizard()
                .isFabButtonPresent();

        Assert.assertTrue(isFabBottonPresent);

        boolean isLoginButtonPresent = new HomeScreen(driver)
                .openMenu()
                .logOut()
                .isLoginButton();
        Assert.assertTrue(isLoginButtonPresent);

    }

    @Test
    public void registrationSuccessTest() {

        int index = (int) (System.currentTimeMillis() / 1000) % 3600;

//        boolean isLogBTNPresent = new SplashScreen(driver)
//                .checkVersion("0.0.3")
        Auth auth = Auth.builder().email("wick" + index + "@gmail.com").password("Ww12345$").build();
logger.info("Registration with new auth --> "+auth.toString());

        boolean isLoginBottonPresent = new LoginScreen(driver)
                .complexLogin(auth)
                .skipWizard()
                .openMenu()
                .logOut()
                .isLoginButton();

        Assert.assertTrue(isLoginBottonPresent);
logger.info("Asser Login Button Present");

    }

    @Test
    public void loginSuccessTestComplex() {
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

    @Test    /// wick@gmail.com Ww54321$
    public void loginCheckErrorMessage() {
        boolean isLoginBtnPresent = new LoginScreen(driver)
                .complexLoginWithErrorMessage(Auth.builder().email("wick@gmail.com").password("Ww54321$").build())
                .checkErrorMessage("Wrong email or password")
                .confirmErrorMessage()
                .isLoginButton();
        Assert.assertTrue(isLoginBtnPresent);


    }

}
