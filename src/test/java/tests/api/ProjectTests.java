package tests.api;

import api.actions.ProjectActions;
import api.actions.UserActions;
import api.response_bodies.project.ProjectBody;
import dbqueries.DBQueries;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProjectTests {

    private String projectName = "PROJECT_FROM_API";
    private String projectIdentifier = "API0001";
    private String userId;
    private UserActions userActions = new UserActions();
    private ProjectActions projectActions= new ProjectActions();

    @BeforeClass
    public void setUp(){
        userId=userActions.createUser("api_test", "qwe123!@#");
    }

    @Test(description = "Testing creating the project via api request")
    public void createAndRemoveProjectApi(){
        SoftAssert softAssert = new SoftAssert();

        String projectId = projectActions.createProject(projectName, userId, projectIdentifier);

        ProjectBody projectResponse = projectActions.getProjectById(projectId).getResult();

        softAssert.assertEquals(projectResponse.getId().toString(), projectId, "Id received in response is different from provided");
        softAssert.assertEquals(projectResponse.getOwner_id().toString(), userId, "User id received in response is different from provided");
        softAssert.assertEquals(projectResponse.getIdentifier(), projectIdentifier, "Identifier received in the response is different from provided");
        softAssert.assertEquals(DBQueries.getObjectId("projects", "name", projectName), Integer.valueOf(projectId), "Id provided is different from the one found in the database");

        softAssert.assertTrue(projectActions.removeProject(projectId), "project removal request returned false");
        softAssert.assertAll();
    }

    @AfterClass
    public void cleanUp(){
        userActions.deleteUser(userId);
    }


}
