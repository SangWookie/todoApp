package springboot.SpringPractice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage")
public class AdminController {
    @GetMapping("/test")
    public String adminP(){
        return "manager controller";
    }


}
