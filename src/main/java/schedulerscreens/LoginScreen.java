package schedulerscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Auth;
import org.openqa.selenium.support.FindBy;

public class LoginScreen extends BaseScreen{
    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']")
    MobileElement emailEditText;
    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement passwordEditText;

    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginButton;

    public LoginScreen fillEmail(String email){
        //wait + fill email
        should(emailEditText,20);
        type (emailEditText,email);
        return  this;
    }



    public LoginScreen  fillPassword(String password){
        //fill password
        type(passwordEditText,password);
        return this;
    }

    public WizardScreen clickLoginBtn(){
// click
        hideKeyBoard();
        loginButton.click();
        return new WizardScreen(driver);
    }

    public WizardScreen complexLogin(Auth auth){
        should(emailEditText,20);
        type (emailEditText,auth.getEmail());
        type(passwordEditText, auth.getPassword());
        hideKeyBoard();
        loginButton.click();

        return new WizardScreen(driver);
    }

    public boolean isLoginButton(){
        return loginButton.isDisplayed();
    }
}
