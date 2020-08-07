package telcel.ti.user.model.entity.vo;

import java.util.List;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import telcel.ti.user.model.entity.Type;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MongoEntity
public class ProfilesVO extends PanacheMongoEntity{

    private ObjectId _id;
    private String name;
    private List<Type> types;

}

