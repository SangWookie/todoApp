package springboot.SpringPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import springboot.SpringPractice.Utils.TokenUtils;
import springboot.SpringPractice.entity.UserEntity;
import springboot.SpringPractice.service.UserService;

import java.util.HashMap;
import java.util.Map;

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

//    @PostMapping("/signin")
//    public ResponseEntity<Map<String, String>> signin(@RequestBody UserEntity userEntity) {
//        if (!userService.signin(userEntity))
//            throw new RuntimeException();
//        String accessToken = TokenUtils.createToken(userEntity.getEmail());
//        String refreshToken = TokenUtils.createRefreshToken(userEntity.getEmail());
//
//        Map<String, String> tokens = new HashMap<>();
//        tokens.put("accessToken", accessToken);
//        tokens.put("refreshToken", refreshToken);
//
//        return ResponseEntity.ok(tokens, HttpStatus.OK);
//    }
}
