package top.test.excepiton.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Value;
import top.test.excepiton.annotation.IDCard;
import top.test.excepiton.annotation.Phone;

/**
 * @author JXS
 */
@Data
public class User {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @Max(value=100,message = "年龄不能超过100岁")
    @Min(value=10,message = "年龄不能小于10岁")
    private int age;

    @Phone
    private String phone;

    @IDCard
    private String idCard;

}
