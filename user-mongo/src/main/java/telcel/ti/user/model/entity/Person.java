package telcel.ti.user.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person extends PanacheMongoEntity{

    private String name;
    private String lastName;
    private Integer age;
    private String email;
    
}