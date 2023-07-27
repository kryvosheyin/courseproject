package api.actions;

import api.BaseApiRequest;
import api.models.Result;
import api.models.args.BodyArgs;
import api.models.args.project.ProjectId;
import api.models.args.project.ProjectParams;
import api.response_bodies.project.ProjectBody;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import java.util.List;

import static api.methods.Project.*;
import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USER;

public class ProjectActions extends BaseApiRequest {

    public String createProject(String projectName, String userId, String identifier){

        ProjectParams args = new ProjectParams().builder()
                .name(projectName)
                .owner_id(userId)
                .identifier(identifier)
                .build();

        BodyArgs body = BodyArgs.builder()
                .method(CREATE_PROJECT)
                .params(args)
                .build();

        Response response = postRequest(API_USER, API_TOKEN, body);

        Result result = response.as(Result.class);
        return result.getResult().toString();
    }



    public Boolean removeProject(String projectId){

        BodyArgs body = BodyArgs.builder()
                .method(REMOVE_PROJECT)
                .params(new ProjectId(projectId))
                .build();

        Response response = postRequest(API_USER, API_TOKEN, body);
        return (Boolean) response.as(Result.class).getResult();
    }

    public Boolean addProjectUser(String projectId, String userId){

        BodyArgs body = BodyArgs.builder()
                .method(ADD_PROJECT_USER)
                .params(List.of(projectId, userId))
                .build();

        Response response = postRequest(API_USER, API_TOKEN, body);
        response.then().statusCode(200);
        return (Boolean) response.as(Result.class).getResult();

    }

    public Result<ProjectBody> getProjectById(String projectId){

        BodyArgs body = BodyArgs.builder()
                .method(GET_PROJECT_BY_ID)
                .params(new ProjectId(projectId))
                .build();

        Response response = postRequest(API_USER, API_TOKEN, body);
        return response.as(new TypeRef<Result<ProjectBody>>() {});
    }
}
