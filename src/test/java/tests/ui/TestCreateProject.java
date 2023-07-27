package tests.ui;

import org.testng.annotations.Test;
import pageobjects.LoginPage;

import static utils.EnvVariables.USER_NAME;
import static utils.EnvVariables.USER_PASSWORD;

public class TestCreateProject extends BaseTest {

    private final String PROJECT_NAME = "Sanity project";
    private final String PROJECT_IDENTIFIER = "UNIQUE001";

    @Test(description = "Testing creating project from UI by the user created from API call")
    public void createProjectTest(){
        new LoginPage().logInValid(USER_NAME, USER_PASSWORD).
                clickCreateProject()
                .submitProjectForm(PROJECT_NAME, PROJECT_IDENTIFIER)
                .assertProjectIsVisible(PROJECT_NAME);
    }

}
