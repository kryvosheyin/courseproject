package api;

import api.models.args.BodyArgs;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static utils.EnvProperties.*;

public class BaseApiRequest {

    public Response postRequest(String userName, String token, BodyArgs args){
        return RestAssured.given()
                .auth().basic( userName, token)
                .body(args)
                .when()
                .post(API_URL);
    }
}
