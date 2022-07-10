package schedulerscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class HomeScreen extends BaseScreen {
    public HomeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id ='com.example.svetlana.scheduler:id/fab_main']")
    MobileElement fabAdd;

    @FindBy(xpath = "//*[@resource-id ='com.example.svetlana.scheduler:id/fab_add_event']")
    MobileElement fabAddEvent;

    @FindBy(xpath = "//*[@content-desc='Open']")
    MobileElement burgerMenu;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/nav_fr_logout']")
    MobileElement logout;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/row_root']")
    List<MobileElement> events;

    public boolean isFabButtonPresent() {
        should(fabAdd, 20);
        return fabAdd.isDisplayed();
    }
    public HomeScreen isFabButtonPresentAssert(){
        should(fabAdd, 20);
        Assert.assertTrue(fabAdd.isDisplayed());
        return this;
    }
    public HomeScreen openMenu() {
        should(burgerMenu,20);
        burgerMenu.click();
        return this;
    }

    public LoginScreen logOut() {
        logout.click();
        return new LoginScreen(driver);
    }
    public  EditCreateEventScreen initCreationEvent(){
        should(fabAdd,20);
        fabAdd.click();
        fabAddEvent.click();
        return  new EditCreateEventScreen(driver);
    }
    public EditCreateEventScreen selectFirstEvent(){
        MobileElement firstEvent = events.get(0);
        firstEvent.click();

        return new EditCreateEventScreen(driver);
    }
    public boolean isPlusButtonPresent(){

        should(fabAdd,20);
        return fabAdd.isDisplayed();
    }
}
