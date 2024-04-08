package top.test.excepiton.controller;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.test.excepiton.entity.User;
import top.test.excepiton.entity.UserLogin;
import top.test.excepiton.result.Result;

/**
 * @author JXS
 */
@RestController
public class UserController {
    @PostMapping("/user/add")
     public Result addUser(@Valid @RequestBody User user, BindingResult bindingResult){
        //校验未通过
        if (bindingResult.hasErrors()){
        return Result.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }

        return Result.ok(user);
     }

    @PostMapping("/user/login")
    public Result login(@Valid @RequestBody UserLogin user, BindingResult bindingResult){

        //校验未通过
        if (bindingResult.hasErrors()){
            return Result.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return Result.ok(user);
    }

}
