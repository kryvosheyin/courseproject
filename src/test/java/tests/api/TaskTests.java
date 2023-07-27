package tests.api;

import api.actions.ProjectActions;
import api.actions.TaskActions;
import api.actions.UserActions;
import api.response_bodies.task.TaskBody;
import dbqueries.DBQueries;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static utils.EnvVariables.*;
import static utils.EnvVariables.API_IDENTIFIER;

public class TaskTests {

    private UserActions userActions = new UserActions();
    private ProjectActions projectActions = new ProjectActions();
    private TaskActions taskActions = new TaskActions();
    private SoftAssert softAssert = new SoftAssert();
    private String taskName = "API Task Test";
    private String taskDescription = "Description test via api";
    private String userId;
    private String projectId;
    private Integer taskId;

    @BeforeClass
    public void setUp(){
        userId = userActions.createUser("userapi", "qwe123!@#");
        projectId = projectActions.createProject("projectapi", userId, "APIIdent");
        projectActions.addProjectUser(projectId, userId);
    }

    @Test(description = "Test creating the task via api")
    public void createAndRemoveTask(){
        taskId = taskActions.createTask(projectId, taskName, taskDescription, userId);
        TaskBody task = taskActions.getTaskById(taskId).getResult();
        softAssert.assertEquals(task.getId(), taskId, "The id provided and received in response do not match");
        softAssert.assertEquals(task.getOwner_id(), Integer.valueOf(userId), "Owner id received in response does not match user_id that was created and assigned the task");
        softAssert.assertEquals(DBQueries.getObjectId("tasks", "title", taskName), taskId, "Task id in response does not match id in the database");

        softAssert.assertTrue(taskActions.removeTask(taskId), "Result received false for remove task request");
        softAssert.assertAll();
    }

    @AfterClass
    public void cleanUp(){
        userActions.deleteUser(userId);
        projectActions.removeProject(projectId);
    }
}
