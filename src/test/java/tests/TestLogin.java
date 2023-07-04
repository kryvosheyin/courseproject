package tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

public class TestLogin extends BaseTest{

    private final static String userName = "admin";
    private final static String password = "admin";


    @Test
    public void logIn(){
        new LoginPage().logIn(userName, password).getUrl().contains("dashboard");
    }
}


