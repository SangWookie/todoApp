package springboot.SpringPractice.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import springboot.SpringPractice.VO.UserVO;
import springboot.SpringPractice.entity.TodoEntity;
import springboot.SpringPractice.service.UserServiceImpl;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
//@RequestMapping("/auth")
public class RestController {

    private final UserServiceImpl userService;

    public RestController(UserServiceImpl userService){
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String test() {
        return "Hello world";
    }

    @PostMapping("/signup")
    public String signup(@RequestBody UserVO userVO) {
        return userService.save(userVO).toString();
    }

    @GetMapping("/")
    public String mainPage(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return email;
    }

//    @GetMapping("/todo")
//    public ResponseEntity<List<TodoEntity>> getTodo(){
//
//    }

    @GetMapping("/alive")
    public ResponseEntity<String> alive(){
        return new ResponseEntity<>(HttpStatus.PARTIAL_CONTENT);    //status 206
    }
}
