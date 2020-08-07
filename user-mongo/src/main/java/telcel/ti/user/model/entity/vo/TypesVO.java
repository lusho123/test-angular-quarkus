package telcel.ti.user.model.entity.vo;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MongoEntity
class TypesVO extends PanacheMongoEntity{

    private ObjectId _id;
    private String device;
    private String description;
    private String name;

}