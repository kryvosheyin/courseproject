package tests;

import api.actions.ProjectActions;
import api.actions.UserActions;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;

import static utils.EnvVariables.*;


public class BaseTest {

    private String userId;
    private String projectId;

    UserActions userAction = new UserActions();
    ProjectActions projectAction = new ProjectActions();


    @BeforeTest
    public void setUp(){
        Configuration.browser = "chrome";
        userId = userAction.createUser(USER_NAME, USER_PASSWORD);
        System.out.println("NEWLY CREATED USER ===>>>> "+ userId);
        projectId = projectAction.createProject(PROJECT_API, userId, API_IDENTIFIER);
        projectAction.addProjectUser(projectId, userId);
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }

    @AfterTest
    public void cleanUp(){
        userAction.deleteUser(userId);
        projectAction.removeProject(projectId);
    }
}
