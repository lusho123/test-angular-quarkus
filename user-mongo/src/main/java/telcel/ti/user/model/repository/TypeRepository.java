package telcel.ti.user.model.repository;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import telcel.ti.user.model.entity.Type;

@ApplicationScoped
public class TypeRepository implements PanacheMongoRepository<Type> {
    
}