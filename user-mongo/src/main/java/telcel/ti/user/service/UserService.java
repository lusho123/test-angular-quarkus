package telcel.ti.user.service;

// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.bson.types.ObjectId;

import telcel.ti.user.beans.Response;
import telcel.ti.user.exceptions.UserNotFoundException;
import telcel.ti.user.model.entity.User;
import telcel.ti.user.model.entity.Profile;
import telcel.ti.user.model.repository.UserRepository;
import telcel.ti.user.model.repository.UserVORepository;
import telcel.ti.user.model.repository.ProfileRepository;
import telcel.ti.user.model.entity.vo.UserVO;
import telcel.ti.user.Utilities.*;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;
    @Inject
    UserVORepository userVORep;
    @Inject
    ProfileRepository profileRepository;
    // @Inject
    // TypeRepository typeRepository;
    @Inject
    Util util;

    public Response<List<UserVO>> findAll() throws UserNotFoundException {
        Response<List<UserVO>> response = util.newResponse("Found users.");
        response.setData(findAllUsers());
        return response;
    }

    public Response<UserVO> findById(ObjectId id, String name) throws UserNotFoundException {
        Response<UserVO> response = util.newResponse("Found user.");
        response.setData(find(id));
        return response;
    }

    public Response<User> createUser(User user) throws UserNotFoundException {
        Response<User> response = util.newResponse("User created.");
        // user.setKeyDate(LocalDate.now());
        user.setKey("key");
        try {
            userRepository.persist(user);
        } catch (Exception ex) {
            throw new UserNotFoundException("Error to create User.");
        }
        response.setData(user);
        return response;
    }

    public Response<String> updateUser(UserVO user) throws UserNotFoundException {
        Response<String> response = util.newResponse("Successfully user update.");
        User updateUser = find(user.id, null);
        updateUser.setName(user.getName());
        updateUser.setUser(user.getUser());
        updateUser.setFirstLastName(user.getFirstLastName());
        updateUser.setSecondLastName(user.getSecondLastName());
        updateUser.setIdProfile(user.getProfile().id);
        updateUser.setEmail(user.getEmail());
        updateUser.setPhone(user.getPhone());
        try {
            userRepository.update(updateUser);
        } catch (Exception ex) {
            throw new UserNotFoundException("error updating user");
        }
        return response;
    }

    public Response<String> deleteUser(ObjectId id) throws UserNotFoundException {
        Response<String> response = util.newResponse("Successfully user delete.");
        userRepository.delete(find(id, null));
        return response;
    }

    public Response<List<Profile>> getProfiles() throws UserNotFoundException {
        Response<List<Profile>> res = util.newResponse("Found profiles");
        List<Profile> profiles = profileRepository.listAll();
        // System.out.println(profiles);
        res.setData(profiles);
        return res;
    }

    /* -------------------------------------------------------------------------- */
    /* Private Me@ApplicationScopedthods */
    /* -------------------------------------------------------------------------- */

    private List<UserVO> findAllUsers() throws UserNotFoundException {
        // List<UserVO> users = new ArrayList<UserVO>();
        List<UserVO> users = userVORep.listAll();
        // for (User user : userRepository.listAll()) {
        // final Profile profile = findProfile(user.getIdProfile());
        // users.add(
        // util.userToVO( user, util.profileToVO(profile) )
        // );
        // }
        if (users.size() < 1)
            throw new UserNotFoundException("Users not Found.");
        return users;
    }

    // private UserVO findUser(ObjectId id) throws UserNotFoundException {
    // UserVO user = find(id, null);
    // UserVO vo = userVORep.findById(id);
    // System.out.println(vo.toString());
    // System.out.println("Encontre usuario "+ user.toString());
    // Profile profile = findProfile(user.getIdProfile());
    // System.out.println("Encontre perfil " + profile.toString());
    // ProfileVO profileVO = util.profileToVO( profile, findTypes(profile) );
    // return util.userToVO(user, profileVO);
    // return vo;
    // }

    private User find(ObjectId id, String name) throws UserNotFoundException {
        User user = null;
        if (id != null)
            user = userRepository.findById(id);
        else
            user = userRepository.findByName(name);
        if (user == null)
            throw new UserNotFoundException("User not Found.");
        return user;
    }

    private UserVO find(ObjectId id) throws UserNotFoundException {
        UserVO user = null;
        if (id != null)
            user = userVORep.findById(id);
        else
        // user = userRepository.findByName(name);
        if (user == null)
            throw new UserNotFoundException("User not Found.");
        return user;
    }

    private Profile findProfile(ObjectId id) throws UserNotFoundException {
        Profile profile = profileRepository.findById(id);
        if (profile == null) {
            throw new UserNotFoundException("Error profile: " + id);
        }
        return profile;
    }

    // private List<TypeVO> findTypes(Profile profile) throws UserNotFoundException
    // {
    // if (profile.getTypes() != null) {
    // List<TypeVO> vo = new ArrayList<TypeVO>();
    // for (ObjectId id : profile.getTypes()) {
    // final Type type = typeRepository.findById(id);
    // vo.add(util.typetoVO(type));
    // }
    // return vo;
    // }
    // return null;
    // }

}
