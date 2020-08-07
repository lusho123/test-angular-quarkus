package telcel.ti.user.model.entity.vo;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MongoEntity(collection = "userView")
public class UserVO extends PanacheMongoEntity{

    private String name;
    private String firstLastName;
    private String secondLastName;
    private String user;
    private ProfilesVO profile;
    private Integer idStatus;
    private String email;
    private String phone;

}





