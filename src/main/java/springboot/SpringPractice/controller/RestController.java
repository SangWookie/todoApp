package springboot.SpringPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot.SpringPractice.entity.UserEntity;
import springboot.SpringPractice.service.UserService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/auth")
public class RestController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String test() {
        return "Hello world";
    }

    @PostMapping("/signup")
    public String signup(@RequestBody UserEntity userEntity) {
        return userService.save(userEntity).toString();
    }

    @PostMapping("/signin")
    public String signin(@RequestBody UserEntity userEntity){

        return userService.signin(userEntity);
    }
}
