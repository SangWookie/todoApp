package springboot.SpringPractice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/test")
public class RestController {
//    @Autowired
//    private UserDAO userDAO;

    @GetMapping("/hello")
    public String test() {
        return "Hello world";
    }
//
//    @PostMapping("/api/save")
//    public String save() {
//        final UserEntity user = UserEntity.builder()
//                .email("test@gmail.com")
//                .password("1234")
//                .build();
//        return UserDAO.save(user);
//    }
}
