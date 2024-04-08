package top.test.excepiton.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.test.excepiton.service.MyService;

/**
 * @author JXS
 */
@RestController
public class ExceptionController {
    @Autowired
    public MyService myService;

    @GetMapping("/user/{id}")
    public void getUser(@PathVariable("id") Integer id){
        if (id ==1){
            myService.unAuthorizedError();
        }else if (id == 2){
            myService.serverError();
        }
        System.out.println("ok");
    }

}
