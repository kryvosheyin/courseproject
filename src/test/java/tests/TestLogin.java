package tests;

import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.DashboardPage;
import pageobjects.LoginPage;

import static utils.EnvVariables.*;

public class TestLogin extends BaseTest {

    @Test(description = "Test loging with valid credentials")
    public void logInValidData() {
        new LoginPage().logInValid(USER_NAME, USER_PASSWORD).mainSection().shouldBe(Condition.visible);
    }

    @Test(description = "Test loging with invalid credentials")
    public void loginInvalidUserNameTest() {
        new LoginPage().logInInvalidCredentials(INVALID_USER_NAME, USER_PASSWORD)
                .getValidationError()
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text("Bad username or password"));
    }

    @Test(description = "Verifying that user is logged out")
    public void logOutTest() {
        new LoginPage().logInValid(USER_NAME, USER_PASSWORD)
                .mainSection().shouldBe(Condition.visible);
        Assert.assertTrue(new DashboardPage().logOut().getUrl().contains("login"), "User is not on login page");

    }
}



