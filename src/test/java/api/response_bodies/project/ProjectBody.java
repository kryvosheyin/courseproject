package api.response_bodies.project;

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
public class ProjectBody {
    private String id;
    private String name;
    private String is_active;
    private String token;
    private String last_modified;
    private String is_public;
    private String is_private;
    private String start_date;
    private String end_date;
    private String owner_id;
    private String default_swimlane;
    private String show_default_swimlane;
    private String description;
    private String identifier;
    private ProjectUrls url;
}
