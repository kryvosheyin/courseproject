package api.args;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class UserParams {
    private String username;
    private String password;
    private String name;
    private String email;
    private String role;
    private UserId user_id;


}
