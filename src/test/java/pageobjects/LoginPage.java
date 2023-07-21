package pageobjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage{

    private final static String logInUrl = "http://localhost/login";


    private final static SelenideElement userNameField = $("#form-username");
    private final static SelenideElement passwordField = $("#form-password");
    private final static SelenideElement submitButton = $("button[type='submit']");
    private final static SelenideElement validationError = $(".alert-error");

    public void submitLoginForm(String userName, String password){
        Selenide.open(logInUrl);
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public DashboardPage logInValid(String userName, String password){
        submitLoginForm(userName, password);
        return new DashboardPage();
    }

    public LoginPage logInInvalidCredentials(String userName, String password){
        submitLoginForm(userName, password);
        submitButton.click();
        return this;
    }

    public SelenideElement getValidationError(){
        return validationError;
    }


}
