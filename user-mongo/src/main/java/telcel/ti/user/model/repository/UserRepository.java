package telcel.ti.user.model.repository;


import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import telcel.ti.user.model.entity.User;

@ApplicationScoped
public class UserRepository implements PanacheMongoRepository<User> {

    public User findByName(String name) {
        // if (name.split("-").length > 0) {
        // TODO separar palabras y unir a cadena
        // }
        return find("name", name).firstResult();
    }

}