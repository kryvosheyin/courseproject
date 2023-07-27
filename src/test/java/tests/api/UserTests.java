package tests.api;

import api.actions.UserActions;
import api.models.Result;
import api.response_bodies.user.UserBody;
import dbqueries.DBQueries;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UserTests {

    private String userName = "api_user";
    private String validPassword = "qwe123!@#";
    private UserActions actions = new UserActions();
    private String userId;
    private SoftAssert softAssert = new SoftAssert();

    @Test(description = "Test creating and deleting user via api")
    public void createAndRemoveUser() {
        userId = actions.createUser(userName, validPassword);
        UserBody user = actions.getUserById(userId).getResult();
        softAssert.assertEquals(user.getId().toString(), userId, "User ID received in the response does not match provided");
        softAssert.assertEquals(user.getName(), userName, "User name received in the response is not matching the provided one");
        softAssert.assertEquals(DBQueries.getObjectId("users", "username", userName), Integer.valueOf(userId), "User id in the database does not match received in response");

        softAssert.assertTrue(actions.deleteUser(userId),"Response returned false for remove user request");
        softAssert.assertAll();
    }
}
