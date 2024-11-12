package top.hyzhu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhy
 * @Date 2024/11/12
 * @Description TestController
 */

@RestController
public class TestController {
    @GetMapping("/test")
    public Object test() {
        return "Hello World!";
    }
}