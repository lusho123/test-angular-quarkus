package telcel.ti.user.beans.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

    private String id;
    private String userName;
    private String name;
    private String fatherLastName;
    private String motherLastName;
    private ProfileVO profile;
    private String email;

}