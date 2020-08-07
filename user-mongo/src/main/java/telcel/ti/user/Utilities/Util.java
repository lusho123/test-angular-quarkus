package telcel.ti.user.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import telcel.ti.user.beans.Response;
import telcel.ti.user.beans.vo.ProfileVO;
import telcel.ti.user.beans.vo.TypeVO;
import telcel.ti.user.beans.vo.UserVO;
import telcel.ti.user.model.entity.Profile;
import telcel.ti.user.model.entity.Type;
import telcel.ti.user.model.entity.User;

@ApplicationScoped
public class Util {

    public Util () {
    }    

    private int defaultCode = 0;
    
    public String getTimestamp() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    }

    public <T> Response<T> newResponse(String message) {
        Response<T> response = new Response<>();
        response.setMessage(message);
        response.setTimestamp(getTimestamp());
        response.setCode(defaultCode);
        return response;
    }
    public <T> Response<T> newResponse(String message, T data) {
        Response<T> response = new Response<>();
        response.setMessage(message);
        response.setTimestamp(getTimestamp());
        response.setCode(defaultCode);
        response.setData(data);
        return response;
    }

    public UserVO userToVO(User user, ProfileVO profile) {
        UserVO vo = new UserVO();
        vo.setId(user.id.toString());
        vo.setUserName(user.getUser());
        vo.setName(user.getName());
        vo.setFatherLastName(user.getFirstLastName());
        vo.setMotherLastName(user.getSecondLastName());
        vo.setProfile(profile);
        return vo;
    }

    public UserVO userToVO(User user) {
        UserVO vo = new UserVO();
        vo.setId(user.id.toString());
        vo.setUserName(user.getUser());
        vo.setName(user.getName());
        vo.setFatherLastName(user.getFirstLastName());
        vo.setMotherLastName(user.getSecondLastName());
        return vo;
    }

    /**
     * Create new ProfileVo without list of Types
     * @param profile
     * @return ProfileVO
     */
    public ProfileVO profileToVO(Profile profile) {
        ProfileVO vo = new ProfileVO();
        vo.setProfileName(profile.getName());
        vo.setProfileFlow(profile.getFlow());
        vo.setTypes(null);
        return vo;
    }

    public ProfileVO profileToVO(Profile profile, List<TypeVO> types) {
        ProfileVO vo = new ProfileVO();
        vo.setProfileName(profile.getName());
        vo.setProfileFlow(profile.getFlow());
        vo.setTypes(types);
        return vo;
    }

    public TypeVO typetoVO(Type type){
        return new TypeVO(
            type.getName(),
            type.getDescription()
        );
    }


}