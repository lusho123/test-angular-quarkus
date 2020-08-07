package telcel.ti.user.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {

    private String message;
    private String timestamp;
    private int code;
    private T data;

    @Override
    public String toString() {
      return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
    
}