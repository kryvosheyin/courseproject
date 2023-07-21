package tests;

import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

public class TestLogin extends BaseTest {

    private final static String userName = "alex";
    private final static String password = "qwe123!@#";


    @Test
    public void logInValidData() {
//       Assert.assertTrue(new LoginPage().logIn(userName, password).getUrl().contains("dashboard"), "The user was not able to access dashboard");
       new LoginPage().logIn(userName, password).getPageHeader().shouldBe(Condition.visible);
    }

    @Test
    public void loginInvalidData() {
//        Assert.assertFalse(new LoginPage().logIn("test", "test").getUrl().contains("dashboard"), "The user was able to access the dashbord");
        new LoginPage().logIn("userName", "password").getPageHeader().shouldBe(Condition.visible);

    }

}



