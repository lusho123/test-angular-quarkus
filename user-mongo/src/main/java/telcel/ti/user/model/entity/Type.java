package telcel.ti.user.model.entity;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MongoEntity(collection = "types")
public class Type extends PanacheMongoEntity{

    private String name;
    private String device;
    private String description;
    private ObjectId platform;

}