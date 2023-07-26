package api.models.args;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class BodyArgs<T> {

    @Builder.Default
    private String jsonrpc="2.0";
    @Builder.Default
    private int id = 145236987;
    private String method;
    private T params;

}
