package springboot.SpringPractice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import springboot.SpringPractice.DTO.TodoDTO;
import springboot.SpringPractice.VO.UserVO;
import springboot.SpringPractice.entity.TodoEntity;
import springboot.SpringPractice.service.TodoService;
import springboot.SpringPractice.service.UserServiceImpl;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
//@RequestMapping("/auth")
public class RestController {

    private final UserServiceImpl userService;
    private final TodoService todoService;

    public RestController(UserServiceImpl userService, TodoService todoService) {
        this.userService = userService;
        this.todoService = todoService;
    }

    @GetMapping("/hello")
    public String test() {
        return "Hello world";
    }

    @PostMapping("/signup")
    public String signup(@RequestBody UserVO userVO) {
        return userService.save(userVO).toString();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserVO userVO) {
        return null;
    }

    @GetMapping("/")
    public String mainPage() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return email;
    }

    @GetMapping("/todo")
    public ResponseEntity<List<TodoDTO>> getTodo(@RequestBody String email) {
        return new ResponseEntity<>(userService.findTodoByEmail(email), HttpStatus.ACCEPTED);
    }

    @PostMapping("/todo")
    public String saveTodo(@RequestBody TodoDTO todoDTO) {
//        System.out.println(todoDTO.toString());
        TodoEntity todo = userService.saveTodo(todoDTO);
        if (todo != null)
            return "saved todo";
        else
            return "not saved";
    }

    @DeleteMapping("/todo")
    public String deleteTodo(Long id) {
        boolean result = todoService.deleteTodo(id);
        if (result) {
            return "delete successful";
        } else {
            return "unable to delete";
        }
    }

    @GetMapping("/alive")
    public ResponseEntity<String> alive() {
        return new ResponseEntity<>(HttpStatus.PARTIAL_CONTENT);    //status 206
    }
}
