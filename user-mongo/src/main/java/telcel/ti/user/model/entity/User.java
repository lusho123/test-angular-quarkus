package telcel.ti.user.model.entity;

import java.time.LocalDate;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MongoEntity(collection = "users3")
public class User extends PanacheMongoEntity{

    private String name;
    private String firstLastName;
    private String secondLastName;
    private String user;
    private String password;
    private ObjectId idProfile;
    private Integer idStatus;
    private String email;
    private String phone;
    private String keyDate;
    private String key;

}