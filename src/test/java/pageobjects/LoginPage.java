package pageobjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginPage extends BasePage{

    private final static String logInUrl = "http://localhost/login";


    private final static SelenideElement userNameField = $("#form-username");
    private final static SelenideElement passwordField = $("#form-password");
    private final static SelenideElement submitButton = $("button[type='submit']");

    public DashboardPage logIn(String userName, String password){
        Selenide.open(logInUrl);
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        submitButton.click();
        return new DashboardPage();
    }

}
