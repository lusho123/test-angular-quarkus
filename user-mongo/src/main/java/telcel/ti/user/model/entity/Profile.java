package telcel.ti.user.model.entity;

import java.util.List;

import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MongoEntity(collection = "profiles")
public class Profile extends PanacheMongoEntity{

    private String name;
    private String flow;
    // @BsonIgnore
    private List<ObjectId> types;

}

@Data
@AllArgsConstructor
@NoArgsConstructor
@MongoEntity
class ObjectID {

    String idType;

}

