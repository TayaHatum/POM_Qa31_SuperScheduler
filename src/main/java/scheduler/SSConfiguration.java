package scheduler;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

//{
//        "deviceName": "Nex",
//        "platformName": "Android",
//        "platformVersion": "8.0",
//        "appPackage": "com.example.svetlana.scheduler",
//        "appActivity": ".presentation.splashScreen.SplashScreenActivity"
//        }
public class SSConfiguration {
    protected  static AppiumDriver<MobileElement> driver;
    protected Logger logger = LoggerFactory.getLogger(SSConfiguration.class);

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities= new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Nex");
        logger.info("\"deviceName\", \"Nex\"");
        capabilities.setCapability("platformName", "Android");
        logger.info("\"platformName\", \"Android\"");
        capabilities.setCapability("platformVersion", "8.0");
        logger.info("\"platformVersion\", \"8.0\"");
        capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity", ".presentation.splashScreen.SplashScreenActivity");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("app","/Users/tayahatum/Tools/apk/v.0.0.3.apk");
        logger.info("Link to apk --> /Users/tayahatum/Tools/apk/v.0.0.3.apk" );

        driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver= EventFiringWebDriverFactory.getEventFiringWebDriver(driver,new MyListener());

    }


    @AfterSuite
    public void tearDown(){
        //driver.quit();
    }
}
