package top.hyzhu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhy
 * @Description: TestController
 * @Date: 2024-11-13 19:11
 **/

@RequestMapping
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "Hello Spring Security";
    }
}
