package tests;

import api.actions.UserActions;
import com.codeborne.selenide.Condition;
import org.testng.annotations.*;
import pageobjects.LoginPage;
import pageobjects.PageHeader;

public class TestLogin extends BaseTest {

    private final static String userName = "alex-new";
    private final static String password = "qwe123!@#";

    private String userId;

    UserActions action = new UserActions();

    @BeforeMethod
    public void setUp() {
        userId = action.createUser(userName, password);
    }

    @Test
    public void logInValidData() {
        new LoginPage().logInValid(userName, password).getPageHeader().shouldBe(Condition.visible);
    }



    @Test
    public void loginInvalidData() {
//        Assert.assertFalse(new LoginPage().logIn("test", "test").getUrl().contains("dashboard"), "The user was able to access the dashbord");
        new LoginPage().logInInvalidCredentials("userName", "password")
                .getValidationError()
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text("Bad username or password"));
    }

    @AfterMethod
    public void cleanUp() {
        action.deleteUser(userId);
    }

}



