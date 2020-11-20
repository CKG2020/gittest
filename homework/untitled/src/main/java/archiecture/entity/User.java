package archiecture.entity;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private  String name;
    private  String  password;
    private  String  id;

}
