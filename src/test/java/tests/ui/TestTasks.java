package tests.ui;

import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.ProjectPage;

import static utils.EnvVariables.*;

public class TestTasks extends BaseTest {

    private String taskName = "Test Task";
    private String taskDescription = "Test Task Description";
    private String taskComment = "This comment was added by automation";

    @Test(description = "Test that user can create task")
    public void createTask() {
        new LoginPage().logInValid(USER_NAME, USER_PASSWORD)
                .assertProjectIsVisible(PROJECT_API)
                .accessProjectPage(PROJECT_API)
                .addNewTask(taskName, taskDescription)
                .assertTaskIsVisible(taskName);
    }

    @Test(description = "Test that user can close the task")
    public void closeTask() {
        ProjectPage project = new LoginPage().logInValid(USER_NAME, USER_PASSWORD)
                .accessProjectPage(PROJECT_API);
        if (!project.taskExists(taskName)) {
            project.addNewTask(taskName, taskDescription);
        }
        project.assertTaskIsVisible(taskName)
                .accessTaskPage(taskName)
                .assertTaskSummaryDisplayed()
                .closeTask();
    }

    @Test(description = "Test that user can add a comment to the task")
    public void addCommentToTask() {
        ProjectPage project = new LoginPage().logInValid(USER_NAME, USER_PASSWORD)
                .accessProjectPage(PROJECT_API);
        if (!project.taskExists(taskName)) {
            project.addNewTask(taskName, taskDescription);
        }
        project.assertTaskIsVisible(taskName)
                .accessTaskPage(taskName)
                .assertTaskSummaryDisplayed()
                .addComment(taskComment)
                .assertCommentVisible(taskComment);
    }
}
