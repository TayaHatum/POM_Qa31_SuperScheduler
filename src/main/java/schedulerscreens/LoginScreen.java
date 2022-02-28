package schedulerscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Auth;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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

    @FindBy (xpath ="//*[@resource-id='android:id/message']")
    MobileElement errorMessage;
    @FindBy (xpath ="//*[@resource-id='android:id/button1']")
    MobileElement okBtn;

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
        should(emailEditText,25);
        type (emailEditText,auth.getEmail());
        type(passwordEditText, auth.getPassword());
        hideKeyBoard();
        loginButton.click();

        return new WizardScreen(driver);
    }

    public boolean isLoginButton(){
        return loginButton.isDisplayed();
    }
    public LoginScreen isLoginButtonAssert(){
        should(loginButton,15);
        Assert.assertTrue(loginButton.isDisplayed());

        return this;
    }

    public LoginScreen complexLoginWithErrorMessage(Auth auth){

        should(emailEditText,25);
        type (emailEditText,auth.getEmail());
        type(passwordEditText, auth.getPassword());
        hideKeyBoard();
        loginButton.click();

        return  this;
    }

    public LoginScreen checkErrorMessage(String text){
        shouldHave(errorMessage,text,15);
        return this;
    }
    public LoginScreen confirmErrorMessage(){
        okBtn.click();
        return this;

    }
}
