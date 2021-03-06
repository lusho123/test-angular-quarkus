package telcel.ti.user.model.repository;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import telcel.ti.user.model.entity.vo.UserVO;

@ApplicationScoped
public class UserVORepository implements PanacheMongoRepository<UserVO> {
    
}