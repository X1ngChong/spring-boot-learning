package top.test.excepiton.entity;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;
/**
 * @author JXS
 */
@Data
public class UserLogin {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

}
