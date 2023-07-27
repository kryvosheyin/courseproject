package api.response_bodies.task;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskBody {
    private Integer id;
    private String title;
    private String description;
    private String date_creation;
    private String color_id;
    private String project_id;
    private String column_id;
    private Integer owner_id;
    private String is_active;
    private String date_completed;
    private String score;
    private String date_due;
    private String creator_id;
    private String date_modification;
    private String url;
    private TaskColor color;
}
