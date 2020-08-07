package telcel.ti.user.beans.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileVO {

    private String profileName;
    private String profileFlow;
    private List<TypeVO> types;
    
}