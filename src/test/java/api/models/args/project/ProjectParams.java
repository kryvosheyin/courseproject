package api.models.args.project;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectParams {
    private String name;
    private String description;
    private String owner_id;
    private String identifier;
    private String start_date;
    private String end_date;

}
