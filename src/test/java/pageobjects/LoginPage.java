package pageobjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static utils.EnvProperties.API_URI;

public class LoginPage extends BasePage{

    private final static String logInUrl = API_URI+"/login";


    private final static SelenideElement userNameField = $("#form-username");
    private final static SelenideElement passwordField = $("#form-password");
    private final static SelenideElement submitButton = $("button[type='submit']");
    private final static SelenideElement validationError = $(".alert-error");

    @Step("Entering credentials and submitting the Login form")
    public void submitLoginForm(String userName, String password){
        Selenide.open(logInUrl);
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    @Step("Loging in with valid credentials")
    public DashboardPage logInValid(String userName, String password){
        submitLoginForm(userName, password);
        return new DashboardPage();
    }

    @Step("Attempt to log in with invalid credentials")
    public LoginPage logInInvalidCredentials(String userName, String password){
        submitLoginForm(userName, password);
        submitButton.click();
        return this;
    }

    @Step("Verifying that validation error is displayed on the page after login failure")
    public SelenideElement getValidationError(){
        return validationError;
    }




}
