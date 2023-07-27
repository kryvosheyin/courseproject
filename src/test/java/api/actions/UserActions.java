package api.actions;

import api.BaseApiRequest;
import api.models.args.BodyArgs;
import api.models.args.user.UserId;
import api.models.args.user.UserParams;
import api.models.Result;
import api.response_bodies.user.UserBody;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import static api.enums.UserRoles.USER;
import static api.methods.User.*;
import static utils.EnvProperties.*;

//import static utils.EnvProperties.API_TOKEN;
//import static utils.EnvProperties.API_USER;



public class UserActions extends BaseApiRequest {


    public String createUser(String username, String password) {


        UserParams args = new UserParams().builder()
                .name(username)
                .username(username)
                .password(password)
                .email(username+"@my.domain.test")
                .role(USER.getRole())
                .build();

        BodyArgs body = BodyArgs.builder()
                .method(CREATE_USER)
                .params(args)
                .build();

        Response response = postRequest(API_USER, API_TOKEN, body);

        response.then().statusCode(200);
        Result result  = response.as(Result.class);
        return result.getResult().toString();

    }

    public boolean deleteUser(String userId){

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(new UserId(Integer.valueOf(userId)))
                .method(DELETE_USER)
                .build();

        Response response = postRequest(API_USER, API_TOKEN, bodyArgs);
        return (boolean) response.as(Result.class).getResult();

    }

    public Result<UserBody> getUserById(String id){

        BodyArgs body = BodyArgs.builder()
                .method(GET_USER)
                .params(new UserId(Integer.valueOf(id)))
                .build();

        Response response = postRequest(API_USER, API_TOKEN, body);
        return response.as(new TypeRef<Result<UserBody>>() {});
    }

}