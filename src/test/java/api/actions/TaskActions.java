package api.actions;

import api.BaseApiRequest;
import api.models.Result;
import api.models.args.BodyArgs;
import api.models.args.task.TaskId;
import api.models.args.task.TaskParams;
import api.response_bodies.task.TaskBody;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import static api.methods.Task.*;
import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USER;

public class TaskActions extends BaseApiRequest {

    public Integer createTask(String projectId, String taskTitle, String taskDescription, String ownerId){

    TaskParams params = new TaskParams().builder()
            .title(taskTitle)
            .project_id(projectId)
            .description(taskDescription)
            .owner_id(ownerId)
            .build();

        BodyArgs body = BodyArgs.builder()
                .method(CREATE_TASK)
                .params(params)
                .build();

        Response response = postRequest(API_USER, API_TOKEN, body);
        response.then().statusCode(200);
        return (Integer) response.as(Result.class).getResult();
    }

    public boolean removeTask(Integer taskId){

        BodyArgs body = BodyArgs.builder()
                .method(REMOVE_TASK)
                .params(new TaskId(Integer.valueOf(taskId)))
                .build();

        Response response = postRequest(API_USER, API_TOKEN, body);
        response.then().statusCode(200);
        return (Boolean) response.as(Result.class).getResult();
    }

    public Result<TaskBody> getTaskById(int taskId){

        BodyArgs body = BodyArgs.builder()
                .method(GET_TASK)
                .params(new TaskId(taskId))
                .build();

        Response response = postRequest(API_USER, API_TOKEN, body);
        response.then().statusCode(200);
        return response.as(new TypeRef<Result<TaskBody>>() {});
    }



}
