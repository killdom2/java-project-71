package hexlet.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

class JsonObject {
    private String host;
    private int timeout;
    private String proxy;
    private boolean follow;
    private boolean verbose;
}
